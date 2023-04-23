package net.ibukun.idraft.pick;

import net.ibukun.idraft.exception.ResourceNotFoundException;
import net.ibukun.idraft.pick.PickDto;
import net.ibukun.idraft.pick.PickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PickController {

    @Autowired
    PickService service;

    // Get All Pick
    @GetMapping("/picks")
    public List<PickDto> getAllPicks() {
        return service.getPicks();
    }

    // Create a new Pick
    @PostMapping("/addPick")
    public PickDto createPick(@Valid @RequestBody PickDto pick) {
        int pickId  =  service.savePick(pick);
        return service.readPickById(Integer.toString(pickId));
    }
    // Get a Single Pick
    @GetMapping("/pick/{id}")
    public PickDto getPickById(@PathVariable(value = "id") Integer pickId) throws ResourceNotFoundException {
        return service.readPickById(pickId.toString());
    }
    // Update a Pick
    @PutMapping("/chgPick/{id}")
    public PickDto updatePick(@PathVariable(value = "id") Integer pickId,
                                  @Valid @RequestBody PickDto model)  throws Exception {

        service.savePick(model);
        return model;
    }
    // Delete a Pick
    @DeleteMapping(path = "/delete/{id}")
    public void deletePick(@PathVariable("id") Integer id) {
        service.deletePick(id );
    }
}

