package net.ibukun.ubdrafted.repository;

import net.ibukun.ubdrafted.domain.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.awt.print.Book;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}