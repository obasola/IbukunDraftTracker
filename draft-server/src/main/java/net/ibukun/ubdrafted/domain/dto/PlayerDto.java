package net.ibukun.ubdrafted.domain.dto;


import net.ibukun.ubdrafted.builder.PlayerBuilder;
import net.ibukun.ubdrafted.domain.entity.Player;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Player} entity
 */
public class PlayerDto implements Serializable {
    private  Integer id;
    private  String firstName;
    private  String lastName;
    private  Integer age;
    private  Float height;
    private  Float weight;
    private  Float handSize;
    private  Float armLength;
    private  String homeCity;
    private  String homeState;
    private  String university;
    private String position;
    private  PickDto selection;

    public PlayerDto() {}

    public PlayerDto(PlayerBuilder builder) {
        this.id = builder.getId();
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.age = builder.getAge();
        this.height = builder.getHeight();
        this.weight = builder.getWeight();
        this.handSize = builder.getHandSize();
        this.armLength = builder.getArmLength();
        this.homeCity = builder.getHomeCity();
        this.homeState = builder.getHomeState();
        this.university = builder.getUniversity();
        this.position = builder.getPosition();
        this.selection = builder.getSelection();
    }

    public PlayerDto(Integer id, String firstName, String lastName, Integer age, Float height, Float weight, Float handSize, Float armLength, String homeCity, String homeState, String university, String position,  PickDto selection) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.handSize = handSize;
        this.armLength = armLength;
        this.homeCity = homeCity;
        this.homeState = homeState;
        this.university = university;
        this.position = position;
        this.selection = selection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public PickDto getSelection() {
        return selection;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDto entity = (PlayerDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.age, entity.age) &&
                Objects.equals(this.height, entity.height) &&
                Objects.equals(this.weight, entity.weight) &&
                Objects.equals(this.handSize, entity.handSize) &&
                Objects.equals(this.armLength, entity.armLength) &&
                Objects.equals(this.homeCity, entity.homeCity) &&
                Objects.equals(this.homeState, entity.homeState) &&
                Objects.equals(this.university, entity.university) &&
                Objects.equals(this.position, entity.position) &&
                Objects.equals(this.selection, entity.selection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, height, weight, handSize, armLength, homeCity, homeState, university, selection);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "age = " + age + ", " +
                "height = " + height + ", " +
                "weight = " + weight + ", " +
                "handSize = " + handSize + ", " +
                "armLength = " + armLength + ", " +
                "homeCity = " + homeCity + ", " +
                "homeState = " + homeState + ", " +
                "university = " + university + ", " +
                "position = " + position + ", " +
                "selection = " + selection + ")";
    }
}