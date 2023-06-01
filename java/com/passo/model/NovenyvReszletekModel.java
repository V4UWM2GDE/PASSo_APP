package com.passo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_novv_reszl")
public class NovenyvReszletekModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String reszlbejegyzestipusa;

    String reszlbejegyzescime;

    String reszlbejegyzesreszl;

    Integer novenyvtervid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReszlbejegyzestipusa() {
        return reszlbejegyzestipusa;
    }

    public void setReszlbejegyzestipusa(String reszlbejegyzestipusa) {
        this.reszlbejegyzestipusa = reszlbejegyzestipusa;
    }

    public String getReszlbejegyzescime() {
        return reszlbejegyzescime;
    }

    public void setReszlbejegyzescime(String reszlbejegyzescime) {
        this.reszlbejegyzescime = reszlbejegyzescime;
    }

    public String getReszlbejegyzesreszl() {
        return reszlbejegyzesreszl;
    }

    public void setReszlbejegyzesreszl(String reszlbejegyzesreszl) {
        this.reszlbejegyzesreszl = reszlbejegyzesreszl;
    }

    public Integer getNovenyvtervid() {
        return novenyvtervid;
    }

    public void setNovenyvtervid(Integer novenyvtervid) {
        this.novenyvtervid = novenyvtervid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NovenyvReszletekModel that = (NovenyvReszletekModel) o;
        return Objects.equals(id, that.id) && Objects.equals(reszlbejegyzestipusa, that.reszlbejegyzestipusa) && Objects.equals(reszlbejegyzescime, that.reszlbejegyzescime) && Objects.equals(reszlbejegyzesreszl, that.reszlbejegyzesreszl) && Objects.equals(novenyvtervid, that.novenyvtervid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reszlbejegyzestipusa, reszlbejegyzescime, reszlbejegyzesreszl, novenyvtervid);
    }

    @Override
    public String toString() {
        return "NovenyvReszletekModel{" +
                "id=" + id +
                ", reszlbejegyzestipusa='" + reszlbejegyzestipusa + '\'' +
                ", reszlbejegyzescime='" + reszlbejegyzescime + '\'' +
                ", reszlbejegyzesreszl='" + reszlbejegyzesreszl + '\'' +
                ", novenyvtervid=" + novenyvtervid +
                '}';
    }
}
