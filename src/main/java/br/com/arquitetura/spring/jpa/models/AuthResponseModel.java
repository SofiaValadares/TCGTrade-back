package br.com.arquitetura.spring.jpa.models;

import br.com.arquitetura.spring.jpa.enums.RoleNameEnum;

public class AuthResponseModel {
    private String jwt;
    private Boolean isOk;
    private RoleNameEnum role;

    public AuthResponseModel(String jwt, Boolean isOk, RoleNameEnum role) {
        this.jwt = jwt;
        this.isOk = isOk;
        this.role = role;
    }


    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Boolean getOk() {
        return isOk;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public RoleNameEnum getRole() {
        return role;
    }

    public void setRole(RoleNameEnum role) {
        this.role = role;
    }
}
