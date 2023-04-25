package net.ibukun.ubdrafted.repository;

import net.ibukun.ubdrafted.domain.entity.Pick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PickRepository extends JpaRepository<Pick, Integer>, JpaSpecificationExecutor<Pick> {
}