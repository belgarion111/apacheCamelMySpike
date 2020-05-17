package it.cs367.router;

import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("file:/Users/{{move.file.location}}/Desktop/TestCamelInput?noop=true")
                .to("file:/Users/{{move.file.location}}/Desktop/TestCamelOutput");
    }
}
