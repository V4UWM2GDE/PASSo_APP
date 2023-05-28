package com.passo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_terulet")
public class TeruletModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String teruletneve;

    String teruletgis;

    Integer gazdasagid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeruletneve() {
        return teruletneve;
    }

    public void setTeruletneve(String teruletneve) {
        this.teruletneve = teruletneve;
    }

    public String getTeruletgis() {
        return teruletgis;
    }

    public void setTeruletgis(String teruletgis) {
        this.teruletgis = teruletgis;
    }

    public Integer getGazdasagid() {
        return gazdasagid;
    }

    public void setGazdasagid(Integer gazdasagid) {
        this.gazdasagid = gazdasagid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeruletModel that = (TeruletModel) o;
        return Objects.equals(id, that.id) && Objects.equals(teruletneve, that.teruletneve) && Objects.equals(teruletgis, that.teruletgis) && Objects.equals(gazdasagid, that.gazdasagid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teruletneve, teruletgis, gazdasagid);
    }

    @Override
    public String toString() {
        return "TeruletModel{" +
                "id=" + id +
                ", teruletneve='" + teruletneve + '\'' +
                ", teruletgis='" + teruletgis + '\'' +
                ", gazdasagid=" + gazdasagid +
                '}';
    }
}
