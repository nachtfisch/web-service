package com.innoveo.skye.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.innoveo.skye.test.ws.generic.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

public class GenericXmlServer {

    public static final Logger LOG = LoggerFactory.getLogger("GENERIC-WS");

    public static void main(String[] args) {

        String port = "12345";
        if (args.length > 0) {
            if (!NumberUtils.isDigits(args[0])) {
                throw new IllegalArgumentException("optional first argument has to be valid port number containing only digits");
            }
            port = args[0];
        }

        String url = "http://0.0.0.0:" + port + "/test/generic-ws";
        LOG.info("Publishing service under '" + url + "'");
        Endpoint.publish(url, new GenericXmlEndpoint());
        LOG.info("Waiting for requests...");
    }

    @WebService(targetNamespace = "http://skye.innoveo.com/ws/generic-ws")
    @SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public static class GenericXmlEndpoint {
        public static int invocationCount = 0;

        public GenericXmlEndpoint() {
            invocationCount = 0;
        }

        @WebMethod
        public
        @WebResult(name = "HandleImplementationResponse")
        HandleImplementationResponse handleImplementationRequest(@WebParam(name = "HandleImplementationRequest") HandleImplementationRequest request) {
            HandleImplementationResponse response = new ObjectFactory().createHandleImplementationResponse();
            response.setResult(200);

            String toString;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                toString = objectMapper.writeValueAsString(request);
            } catch (JsonProcessingException e) {
                toString = "could not be parsed to JSON: " + e.getMessage();
            }
            LOG.info("RECEIVED MESSAGE: content=\n" + toString + "\n----------------\n");

            return response;
        }

    }
}
