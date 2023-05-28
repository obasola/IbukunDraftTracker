package net.ibukun.ubdrafted.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teamId", nullable = false)
    private Team team;

    @NotNull
    @Column(name = "opponentId", nullable = false)
    private Integer opponentId;

    @Column(name = "scheduleWeek")
    private Integer scheduleWeek;

    @Column(name = "gameDate")
    private LocalDate gameDate;

    @Size(max = 45)
    @Column(name = "gameCity", length = 45)
    private String gameCity;

    @Size(max = 45)
    @Column(name = "gameStateProvince", length = 45)
    private String gameStateProvince;

    @Size(max = 45)
    @Column(name = "gameCountry", length = 45)
    private String gameCountry;

    @Size(max = 75)
    @Column(name = "gameLocation", length = 75)
    private String gameLocation;

    @Size(max = 45)
    @Column(name = "opponentConference", length = 45)
    private String opponentConference;

    @Size(max = 45)
    @Column(name = "opponentDivision", length = 45)
    private String opponentDivision;

    @Size(max = 1)
    @Column(name = "wonLostFlag", length = 1)
    private String wonLostFlag;

    @Size(max = 1)
    @Column(name = "homeOrAway", length = 1)
    private String homeOrAway;

    public String getHomeOrAway() {
        return homeOrAway;
    }

    public void setHomeOrAway(String homeOrAway) {
        this.homeOrAway = homeOrAway;
    }

    public String getWonLostFlag() {
        return wonLostFlag;
    }

    public void setWonLostFlag(String wonLostFlag) {
        this.wonLostFlag = wonLostFlag;
    }

    public String getOpponentDivision() {
        return opponentDivision;
    }

    public void setOpponentDivision(String opponentDivision) {
        this.opponentDivision = opponentDivision;
    }

    public String getOpponentConference() {
        return opponentConference;
    }

    public void setOpponentConference(String opponentConference) {
        this.opponentConference = opponentConference;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(String gameLocation) {
        this.gameLocation = gameLocation;
    }

    public String getGameCountry() {
        return gameCountry;
    }

    public void setGameCountry(String gameCountry) {
        this.gameCountry = gameCountry;
    }

    public String getGameStateProvince() {
        return gameStateProvince;
    }

    public void setGameStateProvince(String gameStateProvince) {
        this.gameStateProvince = gameStateProvince;
    }

    public String getGameCity() {
        return gameCity;
    }

    public void setGameCity(String gameCity) {
        this.gameCity = gameCity;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public Integer getScheduleWeek() {
        return scheduleWeek;
    }

    public void setScheduleWeek(Integer scheduleWeek) {
        this.scheduleWeek = scheduleWeek;
    }

    public Integer getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(Integer opponentId) {
        this.opponentId = opponentId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Schedule() {
    }

    public Schedule(Integer id, Team team, Integer opponentId, Integer scheduleWeek, LocalDate gameDate, String gameCity, String gameStateProvince, String gameCountry, String gameLocation, String opponentConference, String opponentDivision, String wonLostFlag, String homeOrAway) {
        this.id = id;
        this.team = team;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(team, schedule.team) && Objects.equals(opponentId, schedule.opponentId) && Objects.equals(scheduleWeek, schedule.scheduleWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team, opponentId, scheduleWeek);
    }
}