package com.innoveo.skye.test;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

public class SimpleWsServer {

    public static void main(String[] args) {
        System.out.println("Publishing service");
        String url = "http://0.0.0.0:12345/test/DynamicWebService";
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

        @WebMethod(operationName = "launch", action = "launch")
        public @WebResult(name = "webServiceResponse")
        WebServiceResponse launch(@WebParam(name = "webServiceRequest") WebServiceRequest webServiceRequest) {
            System.out.println("REQUEST: Received launch request. Echoing back with resource object");
            invocationCount++;

            WebServiceResponse launchResponse = createResponseData(webServiceRequest);

            launchResponse.setResourceObject(new byte[]{1, 2, 3});
            return launchResponse;
        }

        private WebServiceResponse createResponseData(WebServiceRequest webServiceRequest) {
            WebServiceResponse webServiceResponse = new WebServiceResponse();

            List<Customer> customersData = createCustomersData(webServiceRequest.getNumberOfCustomers());
            webServiceResponse.setCustomerList(customersData);

            return webServiceResponse;
        }

        private List<Customer> createCustomersData(int numberOfCustomers) {
            return IntStream.range(0, numberOfCustomers)
                    .map(i -> i + 1)
                    .mapToObj(i -> createCustomer(
                            "id" + i,
                            "name" + i,
                            "address" + i))
                    .collect(Collectors.toList());
        }

        private Customer createCustomer(String id, String name, String address) {
            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setAddress(address);

            return customer;
        }
    }
}