package com.innoveo.skye.test;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebServiceResponse", propOrder = {
        "request",
        "message",
        "customerList",
        "resourceObject"
})
public class WebServiceResponse {

    @XmlElement(required = true)
    protected String request;
    protected String message;
    protected List<Customer> customerList;
    protected byte[] resourceObject;

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
     * Gets the value of the customer property.
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
     * Sets the value of the customer property.
     *
     * @param value
     *     allowed object is
     *     {@link Customer }
     *
     */
    public void setCustomerList(List<Customer> value) {
        this.customerList = value;
    }

    /**
     * Gets the value of the resourceObject property.
     *
     * @return
     *     possible object is
     *     {@link byte[] }
     *
     */
    public byte[] getResourceObject() {
        return resourceObject;
    }

    /**
     * Sets the value of the resourceObject property.
     *
     * @param value
     *     allowed object is
     *     {@link byte[] }
     *
     */
    public void setResourceObject(byte[] value) {
        this.resourceObject = value;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

}

