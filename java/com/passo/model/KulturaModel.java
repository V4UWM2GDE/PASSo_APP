package com.passo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_kultura")
public class KulturaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String kulturaneve;

    Integer teruletid;

    Integer novenyvtervreszlid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKulturaneve() {
        return kulturaneve;
    }

    public void setKulturaneve(String kulturaneve) {
        this.kulturaneve = kulturaneve;
    }

    public Integer getTeruletid() {
        return teruletid;
    }

    public void setTeruletid(Integer teruletid) {
        this.teruletid = teruletid;
    }

    public Integer getNovenyvtervreszlid() {
        return novenyvtervreszlid;
    }

    public void setNovenyvtervreszlid(Integer novenyvtervreszlid) {
        this.novenyvtervreszlid = novenyvtervreszlid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KulturaModel that = (KulturaModel) o;
        return Objects.equals(id, that.id) && Objects.equals(kulturaneve, that.kulturaneve) && Objects.equals(teruletid, that.teruletid) && Objects.equals(novenyvtervreszlid, that.novenyvtervreszlid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kulturaneve, teruletid, novenyvtervreszlid);
    }

    @Override
    public String toString() {
        return "KulturaModel{" +
                "id=" + id +
                ", kulturaneve='" + kulturaneve + '\'' +
                ", teruletid=" + teruletid +
                ", novenyvtervreszlid='" + novenyvtervreszlid + '\'' +
                '}';
    }
}
