package net.ibukun.idraft.player;

import net.ibukun.ubdrafted.domain.dto.PlayerDto;
import net.ibukun.ubdrafted.exception.ResourceNotFoundException;
import net.ibukun.ubdrafted.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    PlayerService service;

    // Get All Player
    @GetMapping("/players")
    public List<PlayerDto> getAllPlayers() {
        return service.getPlayers();
    }

    // Create a new Player
    @PostMapping("/addPlayer")
    public PlayerDto createPlayer(@Valid @RequestBody PlayerDto player) throws Exception {
        return  service.savePlayer(player);
    }
    // Get a Single Player
    @GetMapping("/player/{id}")
    public PlayerDto getPlayerById(@PathVariable(value = "id") Integer playerId) throws ResourceNotFoundException {
        return service.readPlayerById(playerId.toString());
    }
    // Update a Player
    @PutMapping("/chgPlayer/{id}")
    public PlayerDto updatePlayer(@PathVariable(value = "id") Integer playerId,
                              @Valid @RequestBody PlayerDto model)  throws Exception {

        service.savePlayer(model);
        return model;
    }
    // Delete a Player
    @DeleteMapping(path = "/delete/{id}")
    public void deletePlayer(@PathVariable(value = "id") Integer id) {
        service.deletePlayer(id );
    }
}
