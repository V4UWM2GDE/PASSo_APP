package com.passo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_novv_terv")
public class NovenyvTervModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String bejegyzestipusa;

    String bejegyzescime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBejegyzestipusa() {
        return bejegyzestipusa;
    }

    public void setBejegyzestipusa(String bejegyzestipusa) {
        this.bejegyzestipusa = bejegyzestipusa;
    }

    public String getBejegyzescime() {
        return bejegyzescime;
    }

    public void setBejegyzescime(String bejegyzescime) {
        this.bejegyzescime = bejegyzescime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NovenyvTervModel that = (NovenyvTervModel) o;
        return Objects.equals(id, that.id) && Objects.equals(bejegyzestipusa, that.bejegyzestipusa) && Objects.equals(bejegyzescime, that.bejegyzescime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bejegyzestipusa, bejegyzescime);
    }

    @Override
    public String toString() {
        return "NovenyvTervModel{" +
                "id=" + id +
                ", bejegyzestipusa='" + bejegyzestipusa + '\'' +
                ", bejegyzescime='" + bejegyzescime + '\'' +
                '}';
    }
}
