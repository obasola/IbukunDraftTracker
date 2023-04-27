package net.ibukun.idraft.combinescore;

import net.ibukun.ubdrafted.domain.entity.CombineScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CombineScoreRepository extends JpaRepository<CombineScore, Integer> {
    @Query("from CombineScore c inner join fetch c where c.player.id = :id")
    CombineScore findByPlayerId(@Param("id") int id);

    CombineScore findAllByPlayerId(Integer playerId);
}
