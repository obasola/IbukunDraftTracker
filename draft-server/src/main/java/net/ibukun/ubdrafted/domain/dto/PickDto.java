package net.ibukun.ubdrafted.domain.dto;


import net.ibukun.ubdrafted.domain.entity.Pick;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Pick} entity
 */
public class PickDto implements Serializable {
    private  Integer id;
    private  TeamDto team;
    private  Integer selectionRound;
    private  Integer selectionNumber;

    public PickDto(){}

    public PickDto(Integer id, TeamDto team, Integer selectionRound, Integer selectionNumber) {
        this.id = id;
        this.team = team;
        this.selectionRound = selectionRound;
        this.selectionNumber = selectionNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TeamDto getTeam() {
        return team;
    }

    public Integer getSelectionRound() {
        return selectionRound;
    }

    public Integer getSelectionNumber() {
        return selectionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PickDto entity = (PickDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.team, entity.team) &&
                Objects.equals(this.selectionRound, entity.selectionRound) &&
                Objects.equals(this.selectionNumber, entity.selectionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, team, selectionRound, selectionNumber);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "team = " + team + ", " +
                "selectionRound = " + selectionRound + ", " +
                "selectionNumber = " + selectionNumber + ")";
    }
}