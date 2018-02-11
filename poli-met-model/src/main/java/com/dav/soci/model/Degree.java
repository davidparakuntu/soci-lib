package com.dav.soci.model;

import javax.xml.bind.annotation.XmlRootElement;

public class Degree {
    private String name;
    private String years;
    private String university;
    private String colllege;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getColllege() {
        return colllege;
    }

    public void setColllege(String colllege) {
        this.colllege = colllege;
    }
}
