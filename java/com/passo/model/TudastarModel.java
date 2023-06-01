package com.passo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_tudastar")
public class TudastarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String tudastartipus;

    String tudastarcime;

    String tudastarreszl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTudastartipus() {
        return tudastartipus;
    }

    public void setTudastartipus(String tudastartipus) {
        this.tudastartipus = tudastartipus;
    }

    public String getTudastarcime() {
        return tudastarcime;
    }

    public void setTudastarcime(String tudastarcime) {
        this.tudastarcime = tudastarcime;
    }

    public String getTudastarreszl() {
        return tudastarreszl;
    }

    public void setTudastarreszl(String tudastarreszl) {
        this.tudastarreszl = tudastarreszl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TudastarModel that = (TudastarModel) o;
        return Objects.equals(id, that.id) && Objects.equals(tudastartipus, that.tudastartipus) && Objects.equals(tudastarcime, that.tudastarcime) && Objects.equals(tudastarreszl, that.tudastarreszl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tudastartipus, tudastarcime, tudastarreszl);
    }

    @Override
    public String toString() {
        return "TudastarModel{" +
                "id=" + id +
                ", tudastartipus='" + tudastartipus + '\'' +
                ", tudastarcime='" + tudastarcime + '\'' +
                ", tudastarreszl='" + tudastarreszl + '\'' +
                '}';
    }
}
