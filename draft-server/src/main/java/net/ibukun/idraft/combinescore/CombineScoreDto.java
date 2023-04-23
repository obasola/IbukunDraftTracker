package net.ibukun.idraft.combinescore;

import net.ibukun.idraft.player.PlayerDto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link CombineScore} entity
 */
public class CombineScoreDto implements Serializable {
    private Integer id;
    private Float fortyTime;
    private Float tenYardSplit;
    private Float twentyYardShuttle;
    private Float threeCone;
    private Float verticalLeap;
    private Float broadJump;
    private PlayerDto playerDto;

    public CombineScoreDto() {
    }

    public CombineScoreDto(Integer id, Float fortyTime, Float tenYardSplit, Float twentyYardShuttle, Float threeCone, Float verticalLeap, Float broadjump, PlayerDto player) {
        this.id = id;
        this.fortyTime = fortyTime;
        this.tenYardSplit = tenYardSplit;
        this.twentyYardShuttle = twentyYardShuttle;
        this.threeCone = threeCone;
        this.verticalLeap = verticalLeap;
        this.broadJump = broadjump;
        this.playerDto = player;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Float getFortyTime() {
        return fortyTime;
    }

    public Float getTenYardSplit() {
        return tenYardSplit;
    }

    public Float getTwentyYardShuttle() {
        return twentyYardShuttle;
    }

    public Float getThreeCone() {
        return threeCone;
    }

    public Float getVerticalLeap() {
        return verticalLeap;
    }

    public Float getBroadJump() {
        return broadJump;
    }

    public PlayerDto getPlayerDto() {
        return playerDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CombineScoreDto entity = (CombineScoreDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.fortyTime, entity.fortyTime) &&
                Objects.equals(this.tenYardSplit, entity.tenYardSplit) &&
                Objects.equals(this.twentyYardShuttle, entity.twentyYardShuttle) &&
                Objects.equals(this.threeCone, entity.threeCone) &&
                Objects.equals(this.verticalLeap, entity.verticalLeap) &&
                Objects.equals(this.broadJump, entity.broadJump) &&
                Objects.equals(this.playerDto, entity.playerDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fortyTime, tenYardSplit, twentyYardShuttle, threeCone, verticalLeap, broadJump, playerDto);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "fortyTime = " + fortyTime + ", " +
                "tenYardSplit = " + tenYardSplit + ", " +
                "twentyYardShuttle = " + twentyYardShuttle + ", " +
                "threeCone = " + threeCone + ", " +
                "verticalLeap = " + verticalLeap + ", " +
                "broadjump = " + broadJump + ", " +
                "player = " + playerDto + ")";
    }
}