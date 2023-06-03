package net.ibukun.ubdrafted.service;

import net.ibukun.ubdrafted.domain.dto.ScheduleDto;
import net.ibukun.ubdrafted.domain.dto.ScheduleDto;
import net.ibukun.ubdrafted.domain.entity.Schedule;
import net.ibukun.ubdrafted.domain.entity.Schedule;
import net.ibukun.ubdrafted.domain.entity.Team;
import net.ibukun.ubdrafted.exception.ResourceNotFoundException;
import net.ibukun.ubdrafted.mapper.ScheduleMapper;
import net.ibukun.ubdrafted.mapper.ScheduleMapper;
import net.ibukun.ubdrafted.repository.ScheduleRepository;
import net.ibukun.ubdrafted.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository repository;

    @Autowired
    private TeamRepository teamRepository;
    @CrossOrigin(origins = "http://localhost:9001")
    public List<ScheduleDto> getSchedules() {
        List<ScheduleDto> modelList = new ArrayList<>();
        List<Schedule>  entities = repository.findAll();
        try {
            ScheduleMapper.mapToModel(modelList, entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelList;
    }
    @CrossOrigin(origins = "http://localhost:9001")
    public int createSchedule(ScheduleDto dto) throws Exception {
        List<Schedule> list = repository.findByTeamId(dto.getTeamId());
        if(list != null && !list.isEmpty()) {
            boolean isfound = false;
            for(Schedule schedule : list) {
                if(schedule.getScheduleWeek().equals(dto.getScheduleWeek())) {
                    throw new Exception("Scueduled week on file");
                }
            }
        }
        List<Schedule> scheduleList = repository.findByTeamId(dto.getOpponentId());
        Optional<Team> teamOptional = teamRepository.findById(dto.getOpponentId());
        Team teamEntity = teamOptional.get();
        if(scheduleList != null && !scheduleList.isEmpty()) {
            for(Schedule schedule : scheduleList) {
                if(schedule.getScheduleWeek() == null) {
                    schedule.setScheduleWeek(dto.getScheduleWeek());
                    schedule.setGameCity(dto.getGameCity());
                    schedule.setGameCountry(dto.getGameCountry());
                    schedule.setOpponentConference(teamEntity.getConference());
                    schedule.setGameLocation(dto.getGameLocation());
                    ScheduleDto modelDto = new ScheduleDto();
                    ScheduleMapper.mapToModel(modelDto,schedule);
                    saveSchedule(modelDto);
                }
            }
        }

        return saveSchedule(dto);
    }
    @CrossOrigin(origins = "http://localhost:9001")
    public ScheduleDto readScheduleById(String id) throws ResourceNotFoundException {
        ScheduleDto model = new ScheduleDto();

        Schedule instance = null;
        Optional<Schedule> entity = repository.findById(Integer.parseInt(id));

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(model, instance);
        }else{
            throw new ResourceNotFoundException("Schedule", "id", id);
        }
        return model;
    }

    @CrossOrigin(origins = "http://localhost:9001")
    public int updateSchedule(ScheduleDto ScheduleDto) {
        return saveSchedule(ScheduleDto);
    }
    @Transactional
    public void deleteSchedule(Integer id) {
        boolean exists = repository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Schedule ID not on file so cannot delete it.");
        }
        repository.deleteById(id);
    }
    @CrossOrigin(origins = "http://localhost:9001")
    @Transactional
    public int saveSchedule(ScheduleDto ScheduleDto) {
        Schedule instance =  new Schedule();
        int rc = mapDomain(instance, ScheduleDto);
        repository.save(instance);
        return rc;
    }

    private void mapModel(ScheduleDto ScheduleDto, Schedule entity) {
        int rc = -1;
        try {
            ScheduleMapper.mapToModel(ScheduleDto, entity);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private int mapDomain(Schedule entity, ScheduleDto ScheduleDto) {
        int rc = -1;
        try {
            ScheduleMapper.mapToDomain(entity, ScheduleDto);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
}
