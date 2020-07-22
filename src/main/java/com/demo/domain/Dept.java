package com.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DEPT")
public class Dept implements Serializable {
    @Id
    @GenericGenerator(name="auto" , strategy="increment")
    @GeneratedValue(generator="auto")
    @Column(name = "DEPTNO", unique = true, nullable = false, scale = 0)
    private Long presId;

    @Column(name = "DNAME")
    private String presName;

    @Column(name = "LOC")
    private String loc;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "PRESIDENT")
//    private President president;

//    public President getPresident() {
//        return president;
//    }
//
//    public void setPresident(President president) {
//        this.president = president;
//    }

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

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
