package net.ibukun.ubdrafted.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "Combine_Score")
public class CombineScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fortyTime")
    private Float fortyTime;

    @Column(name = "tenYardSplit")
    private Float tenYardSplit;

    @Column(name = "twentyYardShuttle")
    private Float twentyYardShuttle;

    @Column(name = "threeCone")
    private Float threeCone;

    @Column(name = "verticalLeap")
    private Float verticalLeap;

    @Column(name = "broadJump")
    private Float broadjump;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playerId")
    private Player player;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getFortyTime() {
        return fortyTime;
    }

    public void setFortyTime(Float fortyTime) {
        this.fortyTime = fortyTime;
    }

    public Float getTenYardSplit() {
        return tenYardSplit;
    }

    public void setTenYardSplit(Float tenYardSplit) {
        this.tenYardSplit = tenYardSplit;
    }

    public Float getTwentyYardShuttle() {
        return twentyYardShuttle;
    }

    public void setTwentyYardShuttle(Float twentyYardShuttle) {
        this.twentyYardShuttle = twentyYardShuttle;
    }

    public Float getThreeCone() {
        return threeCone;
    }

    public void setThreeCone(Float threeCone) {
        this.threeCone = threeCone;
    }

    public Float getVerticalLeap() {
        return verticalLeap;
    }

    public void setVerticalLeap(Float verticalLeap) {
        this.verticalLeap = verticalLeap;
    }

    public Float getBroadjump() {
        return broadjump;
    }

    public void setBroadjump(Float broadjump) {
        this.broadjump = broadjump;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}