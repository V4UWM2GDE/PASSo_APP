package com.passo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "t_users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String login;

    String ftipus;

    String fnev;

    String fcim;

    String email;

    String gazdtipusa;

    Integer gazdasagid;

    String password;

    Integer froleid;

    public String getFtipus() {
        return ftipus;
    }

    public void setFtipus(String ftipus) {
        this.ftipus = ftipus;
    }

    public String getFnev() {
        return fnev;
    }

    public void setFnev(String fnev) {
        this.fnev = fnev;
    }

    public String getFcim() {
        return fcim;
    }

    public void setFcim(String fcim) {
        this.fcim = fcim;
    }

    public String getGazdtipusa() {
        return gazdtipusa;
    }

    public void setGazdtipusa(String gazdtipusa) {
        this.gazdtipusa = gazdtipusa;
    }

    public Integer getGazdasagid() {
        return gazdasagid;
    }

    public void setGazdasagid(Integer gazdasagid) {
        this.gazdasagid = gazdasagid;
    }

    public Integer getFroleid() {
        return froleid;
    }

    public void setFroleid(Integer froleid) {
        this.froleid = froleid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(login, userModel.login) && Objects.equals(password, userModel.password) && Objects.equals(email, userModel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
