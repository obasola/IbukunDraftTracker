package net.ibukun.ubdrafted.repository;

import net.ibukun.ubdrafted.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}