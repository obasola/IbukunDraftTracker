package net.ibukun.ubdrafted.domain.dto;

import net.ibukun.ubdrafted.builder.ScheduleBuilder;
import net.ibukun.ubdrafted.domain.entity.Schedule;

import java.util.Date;
import java.util.Objects;

public class ScheduleDto {
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
    public ScheduleDto() {}
    public ScheduleDto(ScheduleBuilder builder) {
        this.id = builder.getId();
        this.teamId = builder.getTeamId();
        this.opponentId = builder.getOpponentId();
        this.scheduleWeek = builder.getScheduleWeek();
        this.gameDate = builder.getGameDate();
        this.gameCity = builder.getGameCity();
        this.gameStateProvince = builder.getGameStateProvince();
        this.gameCountry = builder.getGameCountry();
        this.gameLocation = builder.getGameLocation();
        this.opponentConference = builder.getOpponentConference();
        this.opponentDivision = builder.getOpponentDivision();
        this.wonLostFlag = builder.getWonLostFlag();
        this.homeOrAway = builder.getHomeOrAway();
        ;
    }

    public ScheduleDto(Integer teamId, Integer opponentId, Integer scheduleWeek) {
        this.teamId = teamId;
        this.opponentId = opponentId;
        this.scheduleWeek = scheduleWeek;
    }

    public ScheduleDto(Integer id, Integer teamId, Integer opponentId, Integer scheduleWeek, Date gameDate,
                       String gameCity, String gameStateProvince, String gameCountry, String gameLocation,
                       String opponentConference, String opponentDivision, String wonLostFlag, String homeOrAway) {
        this.id = id;
        this.teamId = teamId;
        this.opponentId = opponentId;
        this.scheduleWeek = scheduleWeek;
        this.gameDate = gameDate;
        this.gameCity = gameCity;
        this.gameStateProvince = gameStateProvince;
        this.gameCountry = gameCountry;
        this.gameLocation = gameLocation;
        this.opponentConference = opponentConference;
        this.opponentDivision = opponentDivision;
        this.wonLostFlag = wonLostFlag;
        this.homeOrAway = homeOrAway;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(Integer opponentId) {
        this.opponentId = opponentId;
    }

    public Integer getScheduleWeek() {
        return scheduleWeek;
    }

    public void setScheduleWeek(Integer scheduleWeek) {
        this.scheduleWeek = scheduleWeek;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public String getGameCity() {
        return gameCity;
    }

    public void setGameCity(String gameCity) {
        this.gameCity = gameCity;
    }

    public String getGameStateProvince() {
        return gameStateProvince;
    }

    public void setGameStateProvince(String gameStateProvince) {
        this.gameStateProvince = gameStateProvince;
    }

    public String getGameCountry() {
        return gameCountry;
    }

    public void setGameCountry(String gameCountry) {
        this.gameCountry = gameCountry;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(String gameLocation) {
        this.gameLocation = gameLocation;
    }

    public String getOpponentConference() {
        return opponentConference;
    }

    public void setOpponentConference(String opponentConference) {
        this.opponentConference = opponentConference;
    }

    public String getOpponentDivision() {
        return opponentDivision;
    }

    public void setOpponentDivision(String opponentDivision) {
        this.opponentDivision = opponentDivision;
    }

    public String getWonLostFlag() {
        return wonLostFlag;
    }

    public void setWonLostFlag(String wonLostFlag) {
        this.wonLostFlag = wonLostFlag;
    }

    public String getHomeOrAway() {
        return homeOrAway;
    }

    public void setHomeOrAway(String homeOrAway) {
        this.homeOrAway = homeOrAway;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ScheduleDto that = (ScheduleDto) o;
        return Objects.equals(teamId, that.teamId) && Objects.equals(gameDate, that.gameDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, gameDate);
    }


}
