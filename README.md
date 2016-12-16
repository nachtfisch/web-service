# Test web service

Includes servers for an 'echo' web service in order to test its functionality.

## How to setup a client

The service will run on port `12345`. Endpoint-url will depend on the host and will be `http://localhost:12345/test/DynamicWebService`

One operation is supported, which can be executed through the soap action 'launch':

* `WebServiceResponse launch(WebServiceRequest webServiceRequest)` returns a response with a generated list of customers
which size is specified via parameter numberOfCustomers
and sets a byte array as output with content `byte[]{1,2,3}`

## WSDL
* http://localhost:12345/test/DynamicWebService?wsdl

## Create jaxb classes

The necessary jaxb classes can be generated using [this](schema.xsd)
* wsimport http://localhost:12345/test/DynamicWebService?WSDL -keep -B-enableIntrospection (service must be running)


## Definition
* Create index event: https://confluence.innoveo.com/pages/viewpage.action?spaceKey=IS&title=.Create+index+event+v4.32.0
* Transformation: https://confluence.innoveo.com/display/IS10/Transformation