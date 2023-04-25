package net.ibukun.ubdrafted.service;

import net.ibukun.ubdrafted.domain.dto.PickDto;
import net.ibukun.ubdrafted.domain.entity.Pick;
import net.ibukun.ubdrafted.exception.ResourceNotFoundException;
import net.ibukun.ubdrafted.mapper.PickMapper;
import net.ibukun.ubdrafted.repository.PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PickService {
    @Autowired
    private PickRepository repository;

    public List<PickDto> getPicks() {
        List<PickDto> modelList = new ArrayList<>();
        List<Pick>  entities = repository.findAll();
        try {
            PickMapper.mapToModel(modelList, entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelList;
    }
    public int createPick(PickDto dto) {
        Optional<PickDto> modelOptional = Optional.ofNullable(this.readPickById(dto.getId().toString()));
        if(modelOptional.isPresent()) {
            throw new IllegalStateException("Pick already on file");
        }
        return savePick(dto);
    }

    public PickDto readPickById(String id) throws ResourceNotFoundException {
        PickDto model = new PickDto();

        Pick instance = null;
        Optional<Pick> entity = repository.findById(Integer.parseInt(id));

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(model, instance);
        }else{
            throw new ResourceNotFoundException("Pick", "id", id);
        }
        return model;
    }
    public int updatePick(PickDto pickDto) {
        return savePick(pickDto);
    }
   /* @Transactional
    public void deletePick(Integer id) {
        boolean exists = repository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Pick ID not on file so cannot delete it.");
        }
        repository.deleteById(id);
    } */
    /*
    @Transactional
    public void deletePick(PickDto pickDto) {
        boolean exists = repository.existsById(pickDto.getId());
        if(!exists) {
            throw new IllegalStateException("Pick ID not on file so cannot delete it.");
        }Pick entity = new Pick();
        mapDomain(entity, pickDto);
        repository.delete(entity);
    } */
    @Transactional
    public void deletePick(Integer id) {
        boolean exists = repository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("CombineScore ID not on file so cannot delete it.");
        }
        repository.deleteById(id);
    }
    @Transactional
    public int savePick(PickDto pickDto) {
        Pick instance =  new Pick();
        mapDomain(instance, pickDto);
        repository.save(instance);
        return 1;
    }

    private void mapModel(PickDto pickDto, Pick entity) {
        try {
            PickMapper.mapToModel(pickDto, entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void mapDomain(Pick entity, PickDto pickDto) {
        try {
            PickMapper.mapToDomain(entity, pickDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
