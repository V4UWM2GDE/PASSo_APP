package com.passo.model;

import jakarta.persistence.*;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_gazd")
public class GazdasagModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String gazdasagneve;

    String gazdasagcime;

    String gazdasaghrsz;

    Integer novenyvtervid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGazdasagneve() {
        return gazdasagneve;
    }

    public void setGazdasagneve(String gazdasagneve) {
        this.gazdasagneve = gazdasagneve;
    }

    public String getGazdasagcime() {
        return gazdasagcime;
    }

    public void setGazdasagcime(String gazdasagcime) {
        this.gazdasagcime = gazdasagcime;
    }

    public String getGazdasaghrsz() {
        return gazdasaghrsz;
    }

    public void setGazdasaghrsz(String gazdasaghrsz) {
        this.gazdasaghrsz = gazdasaghrsz;
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
        GazdasagModel that = (GazdasagModel) o;
        return Objects.equals(id, that.id) && Objects.equals(gazdasagneve, that.gazdasagneve) && Objects.equals(gazdasagcime, that.gazdasagcime) && Objects.equals(gazdasaghrsz, that.gazdasaghrsz) && Objects.equals(novenyvtervid, that.novenyvtervid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gazdasagneve, gazdasagcime, gazdasaghrsz, novenyvtervid);
    }

    @Override
    public String toString() {
        return "GazdasagModel{" +
                "id=" + id +
                ", gazdasagneve='" + gazdasagneve + '\'' +
                ", gazdasagcime='" + gazdasagcime + '\'' +
                ", gazdasaghrsz='" + gazdasaghrsz + '\'' +
                ", novenyvtervid=" + novenyvtervid +
                '}';
    }
}

