package it.cs367.processor;

import it.cs367.bean.Dalton;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
public class CsvProcessor  implements Processor {
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        log.info( "Process Info" + payload);
    }
}
