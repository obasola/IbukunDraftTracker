package net.ibukun.ubdrafted.service;

import net.ibukun.ubdrafted.exception.ResourceNotFoundException;
import net.ibukun.ubdrafted.domain.dto.PlayerDto;
import net.ibukun.ubdrafted.domain.entity.Player;
import net.ibukun.ubdrafted.mapper.PlayerMapper;
import net.ibukun.ubdrafted.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository repository;

    public List<PlayerDto> getPlayers() {
        List<PlayerDto> modelList = new ArrayList<>();
        List<Player>  entities = repository.findAll();
        try {
            PlayerMapper.mapToModel(modelList, entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelList;
    }
    public PlayerDto createPlayer(PlayerDto dto) throws Exception {
        Optional<PlayerDto> modelOptional = Optional.ofNullable(this.readPlayerById(dto.getId().toString()));
        if(modelOptional.isPresent()) {
            throw new IllegalStateException("Player already on file");
        }
        return savePlayer(dto);
    }

    public PlayerDto readPlayerById(String id) throws ResourceNotFoundException {
        PlayerDto model = new PlayerDto();

        Player instance = null;
        Optional<Player> entity = repository.findById(Integer.parseInt(id));

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(model, instance);
        }else{
            throw new ResourceNotFoundException("Player", "id", id);
        }
        return model;
    }
    public PlayerDto updatePlayer(PlayerDto playerDto) throws Exception {
        return savePlayer(playerDto);
    }
    @Transactional
    public void deletePlayer(Integer id) {
        boolean exists = repository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Player ID not on file so cannot delete it.");
        }
        repository.deleteById(id);
    }
    @Transactional
    public PlayerDto savePlayer(PlayerDto playerDto) throws Exception {
        Player instance =  new Player();
       mapDomain(instance, playerDto);
        instance = repository.save(instance);
        PlayerMapper.mapToModel(playerDto, instance);
        return playerDto;
    }

    private void mapModel(PlayerDto playerDto, Player entity) {
        try {
            PlayerMapper.mapToModel(playerDto, entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void mapDomain(Player entity, PlayerDto playerDto) {
        try {
            PlayerMapper.mapToDomain(entity, playerDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
