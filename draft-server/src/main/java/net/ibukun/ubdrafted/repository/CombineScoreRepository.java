package net.ibukun.ubdrafted.repository;

import net.ibukun.ubdrafted.domain.entity.CombineScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombineScoreRepository extends JpaRepository<CombineScore, Integer> {
    /*
    @Query("from CombineScore c inner join fetch c where c.player.id = :id")
    CombineScore findByPlayerId(@Param("id") int id);
*/
    CombineScore findAllByPlayerId(Integer playerId);
}
