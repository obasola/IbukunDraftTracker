/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.ibukun.ubdrafted.builder;

import net.ibukun.ubdrafted.domain.dto.PickDto;
import net.ibukun.ubdrafted.domain.dto.PlayerDto;

/**
 *
 * @author dthompson
 */
public class PlayerBuilder {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Float height;
    private Float weight;
    private Float handSize;
    private Float armLength;
    private String homeCity;
    private String homeState;
    private String university;
    private String position;
    private PickDto selection;

    public PlayerBuilder(String firstName, String lastName, Integer age, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
    }

    public PlayerBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public PlayerBuilder height(Float height) {
        this.height = height;
        return this;
    }

    public PlayerBuilder weight(Float weight) {
        this.weight = weight;
        return this;
    }

    public PlayerBuilder handSize(Float handSize) {
        this.handSize = handSize;
        return this;
    }

    public PlayerBuilder armLength(Float armLength) {
        this.armLength = armLength;
        return this;
    }

    public PlayerBuilder age(Integer age) {
        this.age = age;
        return this;
    }

    public PlayerBuilder homeCity(String homeCity) {
        this.homeCity = homeCity;
        return this;
    }

    public PlayerBuilder homeState(String homeState) {
        this.homeState = homeState;
        return this;
    }

    public PlayerBuilder university(String university) {
        this.university = university;
        return this;
    }

    public PlayerBuilder selection(PickDto pick) {
        this.selection = pick;
        return this;
    }

    public PlayerDto build() {
        PlayerDto player = new PlayerDto(this);
        return player;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Float getHeight() {
        return height;
    }

    public Float getWeight() {
        return weight;
    }

    public Float getHandSize() {
        return handSize;
    }

    public Float getArmLength() {
        return armLength;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public String getHomeState() {
        return homeState;
    }

    public String getUniversity() {
        return university;
    }

    public String getPosition() {
        return position;
    }

    public PickDto getSelection() {
        return selection;
    }

}
