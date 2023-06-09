package net.ibukun.ubdrafted.service;

import net.ibukun.ubdrafted.exception.ResourceNotFoundException;
import net.ibukun.ubdrafted.domain.dto.TeamDto;
import net.ibukun.ubdrafted.domain.entity.Team;
import net.ibukun.ubdrafted.mapper.TeamMapper;
import net.ibukun.ubdrafted.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TeamService {
    @Autowired
    private TeamRepository repository;

    @CrossOrigin(origins = "http://localhost:9001")
    public List<TeamDto> getTeams() {
        List<TeamDto> modelList = new ArrayList<>();
        List<Team>  entities = repository.findAll();
        try {
            TeamMapper.mapToModel(modelList, entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelList;
    }
    @CrossOrigin(origins = "http://localhost:9001")
    public int createTeam(TeamDto dto) {
       TeamDto instance =
               this.readTeamByName(dto.getId().toString());
        if(instance == null) {
            throw new IllegalStateException("Team already on file");
        }
        return saveTeam(dto);

    }
    @CrossOrigin(origins = "http://localhost:9001")
    public TeamDto readTeamById(String id) throws ResourceNotFoundException {
        TeamDto model = new TeamDto();

        Team instance = null;
        Optional<Team> entity = repository.findById(Integer.parseInt(id));

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(model, instance);
        }else{
            throw new ResourceNotFoundException("Team", "id", id);
        }
        return model;
    }
    @CrossOrigin(origins = "http://localhost:9001")
    public TeamDto readTeamByName(String name) throws ResourceNotFoundException {
        TeamDto model = new TeamDto();

        Team instance = null;
        List<Team> entityList = repository.findByNameEqualsIgnoreCase(name);

        if(!entityList.isEmpty()) {
            instance = entityList.get(0);
            mapModel(model, instance);
        }else{
            throw new ResourceNotFoundException("Team", "Name", name);
        }
        return model;
    }

    @CrossOrigin(origins = "http://localhost:9001")
    public List<TeamDto> readTeamByConference(String conf) throws ResourceNotFoundException {
        TeamDto model = null;

        List<TeamDto> teamDtoList = new ArrayList<>();
        List<Team> teams        = repository.findByConferenceEqualsIgnoreCase(conf);

        for(Team team : teams) {
            model = new TeamDto();
            mapModel(model,team);
            teamDtoList.add(model);
        }

        return teamDtoList;
    }

    @CrossOrigin(origins = "http://localhost:9001")
    public int updateTeam(TeamDto teamDto) {

        return saveTeam(teamDto);
    }
    @Transactional
    public void deleteTeam(Integer id) {
        boolean exists = repository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Team ID not on file so cannot delete it.");
        }
        repository.deleteById(id);
    }
    @CrossOrigin(origins = "http://localhost:9001")
    @Transactional
    public int saveTeam(TeamDto teamDto) {
        Team instance =  new Team();
        int rc = mapDomain(instance, teamDto);
        repository.save(instance);
        return rc;
    }

    private void mapModel(TeamDto teamDto, Team entity) {
        int rc = -1;
        try {
            TeamMapper.mapToModel(teamDto, entity);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private int mapDomain(Team entity, TeamDto teamDto) {
        int rc = -1;
        try {
            TeamMapper.mapToDomain(entity, teamDto);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
}

