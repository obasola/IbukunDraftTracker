package net.ibukun.idraft.combinescore;

import net.ibukun.idraft.exception.ResourceNotFoundException;
import net.ibukun.idraft.player.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CombineScoreService {
    @Autowired
    private CombineScoreRepository repository;

    public List<CombineScoreDto> getCombineScores() {
        List<CombineScoreDto> modelList = new ArrayList<>();
        List<CombineScore>  entities = repository.findAll();
        try {
            CombineScoreMapper.mapToModel(modelList, entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelList;
    }
    public int createCombineScore(CombineScoreDto dto) {
        Optional<CombineScoreDto> modelOptional = Optional.ofNullable(this.readCombineScoreByPlayerId(dto.getPlayerDto()));
        if(modelOptional.isPresent()) {
            throw new IllegalStateException("CombineScore already on file");
        }
        return saveCombineScore(dto);
    }
    public CombineScoreDto readCombineScoreByPlayerId(PlayerDto playerDto) {

        CombineScoreDto score = new CombineScoreDto();
        CombineScore instance = null;
        Optional<CombineScore> entity = Optional.ofNullable(repository.findAllByPlayerId(playerDto.getId()));

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(score, instance);
        }
        return score;
    }

    public CombineScoreDto readCombineScoreById(String id) throws ResourceNotFoundException {
        CombineScoreDto model = new CombineScoreDto();

        CombineScore instance = null;
        Optional<CombineScore> entity = repository.findById(Integer.parseInt(id));

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(model, instance);
        }else{
            throw new ResourceNotFoundException("CombineScore", "id", id);
        }
        return model;
    }
    public int updateCombineScore(CombineScoreDto combineScoreDto) {
        return saveCombineScore(combineScoreDto);
    }
    @Transactional
    public void deleteCombineScore(Integer id) {
        boolean exists = repository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("CombineScore ID not on file so cannot delete it.");
        }
        repository.deleteById(id);
    }
    @Transactional
    public int saveCombineScore(CombineScoreDto combineScoreDto) {
        CombineScore instance =  new CombineScore();
        int rc = mapDomain(instance, combineScoreDto);
        repository.save(instance);
        return rc;
    }

    private void mapModel(CombineScoreDto combineScoreDto, CombineScore entity) {
        int rc = -1;
        try {
            CombineScoreMapper.mapToModel(combineScoreDto, entity);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private int mapDomain(CombineScore entity, CombineScoreDto combineScoreDto) {
        int rc = -1;
        try {
            CombineScoreMapper.mapToDomain(entity, combineScoreDto);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
}
