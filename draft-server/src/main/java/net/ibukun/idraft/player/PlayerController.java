package net.ibukun.idraft.player;

import net.ibukun.idraft.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        Player playerInstance  =  service.savePlayer(player);
        PlayerDto model =  new PlayerDto();
        PlayerMapper.mapToModel(model, playerInstance);
        return model;
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
    public void deletePlayer(@PathVariable("id") Integer id) {
        service.deletePlayer(id );
    }
}
