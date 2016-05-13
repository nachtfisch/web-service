# Test web service

Includes servers for an 'echo' web service in order to test its functionality.

## How to setup a client

The service will run on port `12345`. Endpoint-url will depend on the host and will be `http://localhost:12345/test/DynamicWebService`

Currently 2 operations are supported. Since both take the same parameter one *has to* specify a soap action which corresponds to
the operation name, respectively `fault` or `echo`.

* `WebServiceResponse echo(WebServiceRequest webServiceRequest)` returns the request as is and sets a byte array as output with content `byte[]{1,2,3}`

## WSDL
* http://localhost:12345/test/DynamicWebService?wsdl

## Create jaxb classes

The necessary jaxb classes can be generated using [this](schema.xsd)
* wsimport http://localhost:12345/test/DynamicWebService?WSDL -keep -B-enableIntrospection (service must be running)


## Definition
* Create index event: https://confluence.innoveo.com/pages/viewpage.action?spaceKey=IS&title=.Create+index+event+v4.32.0
* Transformation: https://confluence.innoveo.com/display/IS10/Transformation