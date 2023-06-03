package net.ibukun.ubdrafted.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Pick")
public class Pick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId")
    private Team team;

    @Column(name = "selectionRound")
    private Integer selectionRound;

    @Column(name = "selectionNumber")
    private Integer selectionNumber;

    @Column(name = "selectionYear")
    private String selectionYear;

    @Column(name = "selectionPickFrom")
    private String selectionPickFrom;

    @Column(name = "selectionPickTo")
    private String selectionPickTo;

    @Column(name = "combineScore")
    private String combineScore;

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

    public String getSelectionYear() {
        return selectionYear;
    }

    public void setSelectionYear(String selectionYear) {
        this.selectionYear = selectionYear;
    }

    public String getSelectionPickFrom() {
        return selectionPickFrom;
    }

    public void setSelectionPickFrom(String selectionPickFrom) {
        this.selectionPickFrom = selectionPickFrom;
    }

    public String getSelectionPickTo() {
        return selectionPickTo;
    }

    public void setSelectionPickTo(String selectionPickTo) {
        this.selectionPickTo = selectionPickTo;
    }
}