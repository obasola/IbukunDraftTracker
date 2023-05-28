package net.ibukun.ubdrafted.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import net.ibukun.ubdrafted.builder.TeamBuilder;

/**
 * A DTO for the entity
 */
public class TeamDto implements Serializable {
    private Integer id;
    private String name;
    private String conference;
    private String city;
    private String state;

    public TeamDto() {
    }

    public TeamDto(TeamBuilder builder) {
        this.id = builder.getId();
        this.name = builder.getName();
        this.city = builder.getCity();
        this.conference = builder.getConference();
    }

    public TeamDto(Integer id, String name, String conference, String city, String state) {
        this.id = id;
        this.name = name;
        this.conference = conference;
        this.city = city;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getConference() {
        return conference;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TeamDto entity = (TeamDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.conference, entity.conference) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.state, entity.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, conference, city, state);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "conference = " + conference + ", " +
                "city = " + city + ", " +
                "state = " + state + ")";
    }
}