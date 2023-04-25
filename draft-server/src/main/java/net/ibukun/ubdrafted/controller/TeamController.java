package net.ibukun.idraft.team;

import net.ibukun.ubdrafted.domain.dto.TeamDto;
import net.ibukun.ubdrafted.domain.entity.Team;
import net.ibukun.ubdrafted.exception.ResourceNotFoundException;
import net.ibukun.ubdrafted.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class TeamController {

    @Autowired
    TeamService service;

    // Get All Team
    @GetMapping("/teams")
    public List<TeamDto> getAllTeams() {
        return service.getTeams();
    }

    // Create a new Team
    @PostMapping("/addTeam")
    public TeamDto createTeam(@Valid @RequestBody TeamDto team) {
        TeamDto teamDto = service.readTeamById(Integer.toString(team.getId()));
        if(teamDto == null) {
            int teamId  =  service.saveTeam(team);
            teamDto = service.readTeamById(Integer.toString(teamId));
        }
        return teamDto;
    }
    // Get a Single Team
    @GetMapping("/team/{id}")
    public TeamDto getTeamById(@PathVariable(value = "id") Integer teamId) throws ResourceNotFoundException {
        return service.readTeamById(teamId.toString());
    }
    // Update a Team
    @PutMapping("/chgTeam/{id}")
    public TeamDto updateTeam(@PathVariable(value = "id") Integer teamId,
                                              @Valid @RequestBody TeamDto model)  throws Exception {

        service.saveTeam(model);
        return model;
    }
    // Delete a Team
    @DeleteMapping(path = "/delete/{id}")
    public void deleteTeam(@PathVariable(value = "id") Integer id) {
        service.deleteTeam(id );
    }
}
