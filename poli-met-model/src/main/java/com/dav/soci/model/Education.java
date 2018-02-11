package com.dav.soci.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class Education {
    private List<Degree> degreeList;
    private List<String> schools;

    public List<Degree> getDegreeList() {
        return degreeList;
    }

    public void setDegreeList(List<Degree> degreeList) {
        this.degreeList = degreeList;
    }

    public List<String> getSchools() {
        return schools;
    }

    public void setSchools(List<String> schools) {
        this.schools = schools;
    }
}
