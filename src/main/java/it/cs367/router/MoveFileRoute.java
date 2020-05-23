package it.cs367.router;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class MoveFileRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:/Users/{{move.file.location}}/Desktop/TestCamelInput?antInclude=*.jpg,noop=true")
                .to("file:/Users/{{move.file.location}}/Desktop/TestCamelOutput");

        from("file:/Users/{{move.file.location}}/Desktop/TestCamelInput?antInclude=*.txt,noop=true")
        .log(LoggingLevel.INFO, "Successfully indexed document id ");

    }

}
