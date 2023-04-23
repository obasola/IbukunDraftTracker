package net.ibukun.idraft.combinescore;

import net.ibukun.idraft.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CombineScoreController {

    @Autowired
    CombineScoreService service;
    // Get All CombineScore
    @GetMapping("/scores")
    public  List<CombineScoreDto> getAllCombineScores() {
        return service.getCombineScores();
    }

    // Create a new CombineScore
    @PostMapping("/addScore")
    public CombineScoreDto createCombineScore(@Valid @RequestBody CombineScoreDto score) {
        int scoreId  =  service.saveCombineScore(score);
        return service.readCombineScoreById(Integer.toString(scoreId));
    }
    // Get a Single CombineScore
    @GetMapping("/score/{id}")
    public CombineScoreDto getScoreById(@PathVariable(value = "id") Integer scoreId) throws ResourceNotFoundException {
        return service.readCombineScoreById(scoreId.toString());
    }
    // Update a CombineScore
    @PutMapping("/chgScore/{id}")
    public CombineScoreDto updateCombineScore(@PathVariable(value = "id") Integer scoreId,
                           @Valid @RequestBody CombineScoreDto model)  throws Exception {

       service.saveCombineScore(model);
        return model;
    }
    // Delete a CombineScore
    @DeleteMapping(path = "/delete/{id}")
    public void deleteCombineScore(@PathVariable("id") Integer id) {
       service.deleteCombineScore(id );
    }
}