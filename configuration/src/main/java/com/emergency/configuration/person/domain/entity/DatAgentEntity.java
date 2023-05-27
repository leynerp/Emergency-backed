package com.emergency.configuration.person.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dat_agent", schema = "mod_person", catalog = "db_emergency")
public class DatAgentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idagent", nullable = false, precision = 0)
    private int idagent;
    @Basic
    @Column(name = "iduser", nullable = false, length = 255)
    private String iduser;
    @Basic
    @Column(name = "idperson", nullable = false, precision = 0)
    private int idperson;
    @Basic
    @Column(name = "indentification_number", nullable = true, precision = 0)
    private Integer indentificationNumber;

    public int getIdagent() {
        return idagent;
    }

    public void setIdagent(int idagent) {
        this.idagent = idagent;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public Integer getIndentificationNumber() {
        return indentificationNumber;
    }

    public void setIndentificationNumber(Integer indentificationNumber) {
        this.indentificationNumber = indentificationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatAgentEntity that = (DatAgentEntity) o;
        return idagent == that.idagent && idperson == that.idperson && Objects.equals(iduser, that.iduser) && Objects.equals(indentificationNumber, that.indentificationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idagent, iduser, idperson, indentificationNumber);
    }
}
