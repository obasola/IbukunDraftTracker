package net.ibukun.ubdrafted.repository;

import net.ibukun.ubdrafted.domain.dto.ScheduleDto;
import net.ibukun.ubdrafted.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    public List<Schedule> findByTeamId(Integer teamId);
}