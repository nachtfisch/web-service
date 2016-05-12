package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebServiceRequest", propOrder = {
        "message",
        "customerList",
})
public class WebServiceRequest {

    @XmlElement(required = true)
    protected String message;
    protected List<Customer> customerList;

    /**
     * Gets the value of the message property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the customerList property.
     *
     * @return
     *     possible object is
     *     {@link Customer }
     *
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Sets the value of the customerList property.
     *
     * @param value
     *     allowed object is
     *     {@link Customer }
     *
     */
    public void setCustomerList(List<Customer> value) {
        this.customerList = value;
    }

}

