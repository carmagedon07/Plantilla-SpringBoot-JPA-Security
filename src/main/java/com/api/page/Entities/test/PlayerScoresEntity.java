package com.api.page.Entities.test;

import javax.persistence.*;

@Entity
@Table(name = "player_scores", schema = "public", catalog = "ejercicio_posgres")
public class PlayerScoresEntity {
    private Integer playerNumber;
    private Object roundScores;

    @Id
    @Basic
    @Column(name = "player_number")
    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    @Basic
    @Column(name = "round_scores")
    public Object getRoundScores() {
        return roundScores;
    }

    public void setRoundScores(Object roundScores) {
        this.roundScores = roundScores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerScoresEntity that = (PlayerScoresEntity) o;

        if (playerNumber != null ? !playerNumber.equals(that.playerNumber) : that.playerNumber != null) return false;
        if (roundScores != null ? !roundScores.equals(that.roundScores) : that.roundScores != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playerNumber != null ? playerNumber.hashCode() : 0;
        result = 31 * result + (roundScores != null ? roundScores.hashCode() : 0);
        return result;
    }
}
