package net.ibukun.ubdrafted.repository;

import net.ibukun.ubdrafted.domain.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}