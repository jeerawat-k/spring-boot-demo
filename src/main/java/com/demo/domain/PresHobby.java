package com.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRES_HOBBY")
public class PresHobby implements Serializable {
    @Id
    @GenericGenerator(name="auto" , strategy="increment")
    @GeneratedValue(generator="auto")
    @Column(name = "PRES_ID", unique = true, nullable = false, scale = 0)
    private Long presId;

    @Column(name = "PRES_NAME")
    private String presName;

    @Column(name = "HOBBY")
    private String birthYr;


    public Long getPresId() {
        return presId;
    }

    public void setPresId(Long presId) {
        this.presId = presId;
    }

    public String getPresName() {
        return presName;
    }

    public void setPresName(String presName) {
        this.presName = presName;
    }

    public String getBirthYr() {
        return birthYr;
    }

    public void setBirthYr(String birthYr) {
        this.birthYr = birthYr;
    }
}
