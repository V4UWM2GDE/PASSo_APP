package com.passo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_gazd_reszletek")
public class GazdalkodasRModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Integer gazdasagid;

    Integer novenyvtervid;

    String feladatok;

    String feladatstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGazdasagid() {
        return gazdasagid;
    }

    public void setGazdasagid(Integer gazdasagid) {
        this.gazdasagid = gazdasagid;
    }

    public Integer getNovenyvtervid() {
        return novenyvtervid;
    }

    public void setNovenyvtervid(Integer novenyvtervid) {
        this.novenyvtervid = novenyvtervid;
    }

    public String getFeladatok() {
        return feladatok;
    }

    public void setFeladatok(String feladatok) {
        this.feladatok = feladatok;
    }

    public String getFeladatstatus() {
        return feladatstatus;
    }

    public void setFeladatstatus(String feladatstatus) {
        this.feladatstatus = feladatstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GazdalkodasRModel that = (GazdalkodasRModel) o;
        return Objects.equals(id, that.id) && Objects.equals(gazdasagid, that.gazdasagid) && Objects.equals(novenyvtervid, that.novenyvtervid) && Objects.equals(feladatok, that.feladatok) && Objects.equals(feladatstatus, that.feladatstatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gazdasagid, novenyvtervid, feladatok, feladatstatus);
    }

    @Override
    public String toString() {
        return "GazdalkodasRModel{" +
                "id=" + id +
                ", gazdasagid=" + gazdasagid +
                ", novenyvtervid=" + novenyvtervid +
                ", feladatok='" + feladatok + '\'' +
                ", feladatstatus=" + feladatstatus +
                '}';
    }
}
