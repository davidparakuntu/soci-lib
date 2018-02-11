package com.dav.soci.model;

import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class Contact {
    private List<String> mobileNumber;
    private List<String> emailIDs;

    public List<String> getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(List<String> mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<String> getEmailIDs() {
        return emailIDs;
    }

    public void setEmailIDs(List<String> emailIDs) {
        this.emailIDs = emailIDs;
    }
}
