package com.innoveo.skye.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import java.util.ArrayList;
import java.util.List;

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

        @WebMethod(operationName = "launch", action = "launch")
        public @WebResult(name = "webServiceResponse")
        WebServiceResponse launch(@WebParam(name = "webServiceRequest") WebServiceRequest webServiceRequest) {
            System.out.println("REQUEST: Received launch request. Echoing back with resource object");
            invocationCount++;

            WebServiceResponse launchResponse = createResponseData(webServiceRequest.getIdRepeated());
            launchResponse.setResourceObject(new byte[]{1, 2, 3});

            return launchResponse;
        }

        private WebServiceResponse createResponseData(boolean idRepeated) {
            WebServiceResponse webServiceResponse = new WebServiceResponse();
            webServiceResponse.setCustomerList(createCustomersData(idRepeated));

            return webServiceResponse;
        }

        private List<Customer> createCustomersData(boolean idRepeated) {
            if (idRepeated) {
                return createResponseDataWithRepeatedId();
            }
            return createResponseDataWithUniqueId();
        }

        private List<Customer> createResponseDataWithRepeatedId() {
            List<Customer> customerList = new ArrayList<>();
            customerList.add(createCustomer("id1", "name1", "address1"));
            customerList.add(createCustomer("id1", "name2", "address2"));
            customerList.add(createCustomer("id3", "name3", "address3"));

            return customerList;
        }

        private List<Customer> createResponseDataWithUniqueId() {
            List<Customer> customerList = new ArrayList<>();
            customerList.add(createCustomer("id1", "name1", "address1"));
            customerList.add(createCustomer("id2", "name2", "address2"));
            customerList.add(createCustomer("id3", "name3", "address3"));

            return customerList;
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
