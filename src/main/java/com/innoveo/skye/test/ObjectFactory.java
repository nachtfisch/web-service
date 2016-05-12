package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public WebServiceResponse createEchoResponse() {
        return new WebServiceResponse();
    }

    public WebServiceRequest createEchoRequest() {
        return new WebServiceRequest();
    }

}
