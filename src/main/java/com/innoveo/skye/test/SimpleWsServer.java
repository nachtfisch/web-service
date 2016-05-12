package com.innoveo.skye.test;

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
        String url = "http://localhost:8280/ws/echo";
        Endpoint.publish(url, new DynamicClientModelEchoWebServiceEndpoint());
        System.out.println("Service published under '" + url + "'");
        System.out.println("Waiting for requests...");
    }

    @WebService(targetNamespace = "http://www.example.org/customer")
    @SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public static class DynamicClientModelEchoWebServiceEndpoint {
        public static int invocationCount = 0;

        public DynamicClientModelEchoWebServiceEndpoint() {
            invocationCount = 0;
        }

        @WebMethod(operationName = "echo", action = "echo")
        public @WebResult(name = "dynamicEchoResponse")
        DynamicEchoResponse echo(@WebParam(name = "dynamicEchoRequest") DynamicEchoRequest echoRequest) {
            System.out.println("REQUEST: Received echo request. Echoing back with resource object");
            invocationCount++;
            DynamicEchoResponse echoResponse = new DynamicEchoResponse();
            echoResponse.setMessage(echoRequest.getMessage());
            echoResponse.setCustomerList(echoRequest.getCustomerList());
            echoResponse.setResourceObject(new byte[] {1,2,3});

            return echoResponse;
        }

    }
}
