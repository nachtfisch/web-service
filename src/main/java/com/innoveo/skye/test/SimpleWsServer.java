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
        String url = "http://localhost:12345/test/DynamicWebService";
        Endpoint.publish(url, new DynamicClientModelWebServiceEndpoint());
        System.out.println("Service published under '" + url + "'");
        System.out.println("Waiting for requests...");
    }

    @WebService(targetNamespace = "http://www.example.org/customer")
    @SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public static class DynamicClientModelWebServiceEndpoint {
        public static int invocationCount = 0;

        public DynamicClientModelWebServiceEndpoint() {
            invocationCount = 0;
        }

        @WebMethod(operationName = "echo", action = "echo")
        public @WebResult(name = "webServiceResponse")
        WebServiceResponse echo(@WebParam(name = "webServiceRequest") WebServiceRequest echoRequest) {
            System.out.println("REQUEST: Received echo request. Echoing back with resource object");
            invocationCount++;
            WebServiceResponse echoResponse = new WebServiceResponse();
            echoResponse.setMessage(echoRequest.getMessage());
            echoResponse.setCustomerList(echoRequest.getCustomerList());
            echoResponse.setResourceObject(new byte[] {1,2,3});

            return echoResponse;
        }
    }
}
