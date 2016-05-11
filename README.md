# Test web service

Includes servers for 2 web services in order to test their functionality. First service is a echo service, second is a server for dynamic web service

## Build and run from source

For the echo service simply use:

    > mvn clean package
    > java -jar target/simple-ws-service-<VERSION>.jar

For the generic web service use (with optional port number argument):

    > mvn clean package
    > java -cp target/simple-ws-service-1.3-SNAPSHOT.jar com.innoveo.skye.test.GenericXmlServer 12346



## How to setup a client

The service will run on port `12345`. Endpoint-url will depend on the host and will be `http://<HOST>:12345/test/DynamicEchoWebService`

Currently 2 operations are supported. Since both take the same parameter one *has to* specify a soap action which corresponds to
the operation name, respectively `fault` or `echo`.

* `DynamicEchoResponse fault(DynamicEchoRequest echoRequest)` throws an exception with reason 'illegal state exception'
* `DynamicEchoResponse echo(DynamicEchoRequest echoRequest)` returns the request as is and sets a byte array as output with content `byte[]{1,2,3}`

## What goes in the definition?

A sample transformation definition and a respective product to trigger the service can be found
[here](https://git.innoveo.com/projects/SKYE/repos/skye/browse/skye-client/skye-client-integration/src/test/resources/com/innoveo/skye/services/core/integration/ExternalServiceInvokerServiceDelegateIntegrationTest-DynamicModelTransformation.zip)
and [here](https://git.innoveo.com/projects/SKYE/repos/skye/browse/skye-client/skye-client-integration/src/test/resources/com/innoveo/skye/services/core/integration/ExternalServiceInvokerServiceDelegateIntegrationTest-Entity.zip).

The first one is a transformation. The necessary jaxb classes are inside this definition. Alternatively
you can download them [here](https://git.innoveo.com/projects/SKYE/repos/test-services/browse/etc/dynamic.jar)
or generate them again using [this](https://git.innoveo.com/projects/SKYE/repos/skye/browse/skye-client/skye-client-integration/src/test/resources/com/innoveo/skye/services/core/integration/ExternalServiceInvokerServiceDelegateIntegrationTest-schema.xsd)
schema (beware of addtional [bindings](https://git.innoveo.com/projects/SKYE/repos/skye/browse/skye-client/skye-client-integration/src/test/resources/wsdl/binding.xml)). Additionally you _have to_ change the definitions:

* attribute `@EndpointUrl` has to be changed to ``http://<HOST>:12345/test/DynamicEchoWebService`
* attribute `@Operation` has to be created and set to either `fault` or `echo`

The second definition `Entity` contains a web service invoker attribute
`InvokeUsingDynamicModelTransformation.WebServiceInvoker`. Set it to `true` to fire the
service. *You should* check that it uses the service delgate you wish to invoke.


Change