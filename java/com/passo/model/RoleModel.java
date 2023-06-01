package com.passo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_roles")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String jogosultsagneve;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJogosultsagneve() {
        return jogosultsagneve;
    }

    public void setJogosultsagneve(String jogosultsagneve) {
        this.jogosultsagneve = jogosultsagneve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleModel roleModel = (RoleModel) o;
        return Objects.equals(id, roleModel.id) && Objects.equals(jogosultsagneve, roleModel.jogosultsagneve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jogosultsagneve);
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "id=" + id +
                ", jogosultsagneve='" + jogosultsagneve + '\'' +
                '}';
    }
}
