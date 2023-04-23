package net.ibukun.idraft.pick;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PickRepository extends JpaRepository<Pick, Integer>, JpaSpecificationExecutor<Pick> {
}