package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address-type", propOrder = {"street"})
public class AddressType {

    @XmlElement(required = true)
    protected String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String value) {
        this.street = value;
    }

}
