package net.ibukun.idraft.pick;

import net.ibukun.idraft.team.Team;

import javax.persistence.*;

@Entity
public class Pick {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "selection_round")
    private Integer selectionRound;

    @Column(name = "selection_number")
    private Integer selectionNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getSelectionRound() {
        return selectionRound;
    }

    public void setSelectionRound(Integer selectionRound) {
        this.selectionRound = selectionRound;
    }

    public Integer getSelectionNumber() {
        return selectionNumber;
    }

    public void setSelectionNumber(Integer selectionNumber) {
        this.selectionNumber = selectionNumber;
    }

}