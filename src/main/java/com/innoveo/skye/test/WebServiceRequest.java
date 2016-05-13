package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "idRepeated",
})
@XmlRootElement(name = "webServiceRequest")
public class WebServiceRequest {

    @XmlElement(required = true)
    protected boolean idRepeated;

    /**
     * Gets the value of the idRepeated property.
     *
     * @return
     *     possible object is
     *     {@link Customer }
     *
     */
    public boolean getIdRepeated() {
        return idRepeated;
    }

    /**
     * Sets the value of the idRepeated property.
     *
     * @param value
     *     allowed object is
     *     {@link Customer }
     *
     */
    public void setIdRepeated(boolean value) {
        this.idRepeated = value;
    }

}

