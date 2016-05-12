package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public DynamicEchoResponse createEchoResponse() {
        return new DynamicEchoResponse();
    }

    public DynamicEchoRequest createEchoRequest() {
        return new DynamicEchoRequest();
    }

}
