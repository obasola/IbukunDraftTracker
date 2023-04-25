package net.ibukun.ubdrafted.domain.entity;



import javax.persistence.*;

@Entity
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "height")
    private Float height;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "hand_size")
    private Float handSize;

    @Column(name = "arm_length")
    private Float armLength;

    @Column(name = "home_city", length = 45)
    private String homeCity;

    @Column(name = "home_state", length = 45)
    private String homeState;

    @Column(name = "university", length = 75)
    private String university;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "selection_id")
    private Pick selection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHandSize() {
        return handSize;
    }

    public void setHandSize(Float handSize) {
        this.handSize = handSize;
    }

    public Float getArmLength() {
        return armLength;
    }

    public void setArmLength(Float armLength) {
        this.armLength = armLength;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Pick getSelection() {
        return selection;
    }

    public void setSelection(Pick selection) {
        this.selection = selection;
    }

}