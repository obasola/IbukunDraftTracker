/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.ibukun.ubdrafted.builder;

import net.ibukun.ubdrafted.domain.dto.PickDto;
import net.ibukun.ubdrafted.domain.dto.TeamDto;

/**
 *
 * @author dthompson
 */
public class PickBuilder {

    private Integer id;
    private TeamDto team;
    private Integer selectionRound;
    private Integer selectionNumber;
    private String selectionYear;
    private String selectionPickFrom;
    private String selectionPickTo;
    private Float combineScore;

    public PickBuilder(Integer id, TeamDto team, Integer selectionRound, Integer selectionNumber,
            String selectionYear, Float combineScore) {
        this.id = id;
        this.team = team;
        this.selectionRound = selectionRound;
        this.selectionNumber = selectionNumber;
        this.selectionYear = selectionYear;
        this.combineScore = combineScore;
    }

    public PickBuilder selectionPickFrom(String from) {
        this.selectionPickFrom = from;
        return this;
    }

    public PickBuilder selectionPickTo(String to) {
        this.selectionPickTo = to;
        return this;
    }

    public PickBuilder combineScore(float score) {
        this.combineScore = score;
        return this;
    }


    public PickDto build() {
        PickDto pick = new PickDto(this);
        return pick;
    }

    public Integer getId() {
        return id;
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

    public String getSelectionYear() {
        return selectionYear;
    }

    public String getSelectionPickFrom() {
        return selectionPickFrom;
    }

    public String getSelectionPickTo() {
        return selectionPickTo;
    }

    public Float getCombineScore() { return combineScore; }
}
