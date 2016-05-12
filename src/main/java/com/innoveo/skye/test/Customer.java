package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",
        propOrder = {"billingAddress","shippingAddress"})
@XmlRootElement(name = "customer")
public class Customer {

    @XmlElement(name = "billing-address", required = true)
    protected AddressType billingAddress;

    @XmlElement(name = "shipping-address", required = true)
    protected AddressType shippingAddress;

    public AddressType getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressType value) {
        this.billingAddress = value;
    }

    public AddressType getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressType value) {
        this.shippingAddress = value;
    }
}
