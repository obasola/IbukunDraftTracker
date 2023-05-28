package net.ibukun.ubdrafted.controller;

import net.ibukun.ubdrafted.domain.dto.ScheduleDto;
import net.ibukun.ubdrafted.exception.ResourceNotFoundException;
import net.ibukun.ubdrafted.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ScheduleController {

    @Autowired
    ScheduleService service;
    @CrossOrigin(origins = "http://localhost:9001")
    // Get All Schedule
    @GetMapping("/Schedules")
    public List<ScheduleDto> getAllSchedules() {
        return service.getSchedules();
    }

    // Create a new Schedule
    @PostMapping("/addSchedule")
    public ScheduleDto createSchedule(@Valid @RequestBody ScheduleDto Schedule) {
        ScheduleDto ScheduleDto = service.readScheduleById(Integer.toString(Schedule.getId()));
        if(ScheduleDto == null) {
            int ScheduleId  =  service.saveSchedule(Schedule);
            ScheduleDto = service.readScheduleById(Integer.toString(ScheduleId));
        }
        return ScheduleDto;
    }
    // Get a Single Schedule
    @GetMapping("/Schedule/{id}")
    public ScheduleDto getScheduleById(@PathVariable(value = "id") Integer ScheduleId) throws ResourceNotFoundException {
        return service.readScheduleById(ScheduleId.toString());
    }
    // Update a Schedule
    @PutMapping("/chgSchedule/{id}")
    public ScheduleDto updateSchedule(@PathVariable(value = "id") Integer ScheduleId,
                              @Valid @RequestBody ScheduleDto model)  throws Exception {

        service.saveSchedule(model);
        return model;
    }

}
