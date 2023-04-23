package net.ibukun.idraft.combinescore;

import net.ibukun.idraft.player.Player;

import javax.persistence.*;

@Entity
@Table(name = "Combine_Score")
public class CombineScore {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "forty_time")
    private Float fortyTime;

    @Column(name = "ten_yard_split")
    private Float tenYardSplit;

    @Column(name = "twenty_yard_shuttle")
    private Float twentyYardShuttle;

    @Column(name = "three_cone")
    private Float threeCone;

    @Column(name = "vertical_leap")
    private Float verticalLeap;

    @Column(name = "broadjump")
    private Float broadjump;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
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