package com.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRESIDENT")
public class President implements Serializable {
    @Id
    @GenericGenerator(name="auto" , strategy="increment")
    @GeneratedValue(generator="auto")
    @Column(name = "PRES_ID", unique = true, nullable = false, scale = 0)
    private Long presId;

    @Column(name = "PRES_NAME")
    private String presName;

    @Column(name = "BIRTH_YR")
    private Long birthYr;

    @Column(name = "YRS_SERV")
    private Long yrsServ;

    @Column(name = "DEATH_AGE")
    private Long deatgAge;

    @Column(name = "PARTY")
    private String party;

    @Column(name = "STATE_BORN")
    private String stateBorn;


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "president")
//    private Set<Dept> depts = new HashSet<Dept>(0);

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

    public Long getBirthYr() {
        return birthYr;
    }

    public void setBirthYr(Long birthYr) {
        this.birthYr = birthYr;
    }

    public Long getYrsServ() {
        return yrsServ;
    }

    public void setYrsServ(Long yrsServ) {
        this.yrsServ = yrsServ;
    }

    public Long getDeatgAge() {
        return deatgAge;
    }

    public void setDeatgAge(Long deatgAge) {
        this.deatgAge = deatgAge;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getStateBorn() {
        return stateBorn;
    }

    public void setStateBorn(String stateBorn) {
        this.stateBorn = stateBorn;
    }

//    public Set<Dept> getDepts() {
//        return depts;
//    }
//
//    public void setDepts(Set<Dept> depts) {
//        this.depts = depts;
//    }
}
