package net.ibukun.idraft.combinescore;

import net.ibukun.idraft.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface CombineScoreRepository extends JpaRepository<CombineScore, Integer> {
    @Query("from CombineScore c inner join fetch c where c.player.id = :id")
    CombineScore findByPlayerId(@Param("id") int id);

    CombineScore findAllByPlayerId(Integer playerId);
}
