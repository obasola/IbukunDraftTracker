package net.ibukun.ubdrafted.service;

import net.ibukun.ubdrafted.exception.ResourceNotFoundException;
import net.ibukun.ubdrafted.domain.dto.TeamDto;
import net.ibukun.ubdrafted.domain.entity.Team;
import net.ibukun.ubdrafted.mapper.TeamMapper;
import net.ibukun.ubdrafted.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TeamService {
    @Autowired
    private TeamRepository repository;

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
    public int createTeam(TeamDto dto) {
        Optional<TeamDto> modelOptional = Optional.ofNullable(this.readTeamById(dto.getId().toString()));
        if(modelOptional.isPresent()) {
            throw new IllegalStateException("Team already on file");
        }
        return saveTeam(dto);
    }

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

