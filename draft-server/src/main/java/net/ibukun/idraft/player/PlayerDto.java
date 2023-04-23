package net.ibukun.idraft.player;

import net.ibukun.idraft.pick.PickDto;

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
    private  PickDto selection;

    public PlayerDto() {}
    public PlayerDto(Integer id, String firstName, String lastName, Integer age, Float height, Float weight, Float handSize, Float armLength, String homeCity, String homeState, String university, PickDto selection) {
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
                "selection = " + selection + ")";
    }
}