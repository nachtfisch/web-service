package com.innoveo.skye.test;


import com.innoveo.skye.services.core.integration.model.service.definition.DynamicEchoRequest;
import com.innoveo.skye.services.core.integration.model.service.definition.DynamicEchoResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

public class SimpleWsServer {

    public static void main(String[] args) {
        System.out.println("Publishing service");
//        String url = "http://localhost:8080/ws/echo";
        String url = "http://0.0.0.0:12345/test/DynamicEchoWebService";
        Endpoint.publish(url, new DynamicClientModelEchoWebServiceEndpoint());
        System.out.println("Service published under '" + url + "'");
        System.out.println("Waiting for requests...");
    }

    @WebService(targetNamespace = "http://dynamic.innoveo.com/EchoService")
    @SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public static class DynamicClientModelEchoWebServiceEndpoint {
        public static int invocationCount = 0;

        public DynamicClientModelEchoWebServiceEndpoint() {
            invocationCount = 0;
        }

        @WebMethod(operationName = "fault", action = "fault")
        public
        @WebResult(name = "dynamicEchoResponse")
        DynamicEchoResponse fault(@WebParam(name = "dynamicEchoRequest") DynamicEchoRequest echoRequest) {
            System.out.println("REQUEST: Received fault request. Throwing exception");
            throw new IllegalStateException("illegal state exception");
        }

        @WebMethod(operationName = "echo", action = "echo")
        public @WebResult(name = "dynamicEchoResponse")
        DynamicEchoResponse echo(@WebParam(name = "dynamicEchoRequest") DynamicEchoRequest echoRequest) {
            System.out.println("REQUEST: Received echo request. Echoing back with resource object");
            invocationCount++;
            DynamicEchoResponse echoResponse = new DynamicEchoResponse();
            echoResponse.setMessage(echoRequest.getMessage());
            echoResponse.setMessages(echoRequest.getMessages());
            echoResponse.setComplexObject(echoRequest.getComplexObject());
            echoResponse.setComplexObjects(echoRequest.getComplexObjects());
            echoResponse.setResourceObject(new byte[] {1,2,3});

            return echoResponse;
        }

    }
}
