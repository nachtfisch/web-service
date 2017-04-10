package com.innoveo.skye.test;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"numberOfCustomers",})
@XmlRootElement(name = "webServiceRequest")
public class WebServiceRequest {

    @XmlElement(required = true)
    protected int numberOfCustomers;

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }
}

