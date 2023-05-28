/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package net.ibukun.ubdrafted.builder;

import net.ibukun.ubdrafted.domain.dto.TeamDto;

/**
 *
 * @author dthompson
 */
public class TeamBuilder {

    private Integer id;
    private String name;
    private String city;
    private String conference;

    public TeamBuilder(Integer id, String name, String city, String conference) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.conference = conference;
    }

    public TeamDto build() {
        return new TeamDto(this);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getConference() {
        return conference;
    }

}
