/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.ibukun.ubdrafted.builder;

import java.util.Date;

import net.ibukun.ubdrafted.domain.dto.ScheduleDto;

/**
 *
 * @author dthompson
 */
public class ScheduleBuilder {
    private Integer id;
    private Integer teamId;
    private Integer opponentId;
    private Integer scheduleWeek;
    private Date gameDate;
    private String gameCity;
    private String gameStateProvince;
    private String gameCountry;
    private String gameLocation;
    private String opponentConference;
    private String opponentDivision;
    private String wonLostFlag;
    private String homeOrAway;

    public ScheduleBuilder(Integer teamId, Integer opponentId, String gameCity, Date gameDate) {
        this.teamId = teamId;
        this.opponentId = opponentId;
        this.gameDate = gameDate;
        this.gameCity = gameCity;
    }

    public ScheduleBuilder gameStateProvince(String stateOrProvince) {
        this.gameStateProvince = stateOrProvince;
        return this;
    }

    public ScheduleBuilder gameCountry(String country) {
        this.gameCountry = country;
        return this;
    }

    public ScheduleBuilder gameLocation(String location) {
        this.gameLocation = location;
        return this;
    }

    public ScheduleBuilder opponentConference(String conf) {
        this.opponentConference = conf;
        return this;
    }

    public ScheduleBuilder opponentDivision(String div) {
        this.opponentDivision = div;
        return this;
    }

    public ScheduleBuilder wonLostFlag(String flag) {
        this.wonLostFlag = flag;
        return this;
    }

    public ScheduleBuilder homeOrAway(String flag) {
        this.homeOrAway = flag;
        return this;
    }

    public ScheduleDto build() {
        ScheduleDto sched = new ScheduleDto(this);
        return sched;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public Integer getOpponentId() {
        return opponentId;
    }

    public Integer getScheduleWeek() {
        return scheduleWeek;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public String getGameCity() {
        return gameCity;
    }

    public String getGameStateProvince() {
        return gameStateProvince;
    }

    public String getGameCountry() {
        return gameCountry;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public String getOpponentConference() {
        return opponentConference;
    }

    public String getOpponentDivision() {
        return opponentDivision;
    }

    public String getWonLostFlag() {
        return wonLostFlag;
    }

    public String getHomeOrAway() {
        return homeOrAway;
    }

}
