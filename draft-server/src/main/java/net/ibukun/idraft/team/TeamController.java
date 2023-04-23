package net.ibukun.idraft.team;

import net.ibukun.idraft.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        int teamId  =  service.saveTeam(team);
        return service.readTeamById(Integer.toString(teamId));
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
    public void deleteTeam(@PathVariable("id") Integer id) {
        service.deleteTeam(id );
    }
}
