package com.emergency.configuration.person.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dat_user", schema = "mod_person", catalog = "db_emergency")
public class DatUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iduser", nullable = false, length = 255)
    private String iduser;

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatUserEntity that = (DatUserEntity) o;
        return Objects.equals(iduser, that.iduser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser);
    }
}
