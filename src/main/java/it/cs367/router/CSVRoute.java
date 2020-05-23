package it.cs367.router;

import it.cs367.handler.CsvHandler;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;

public class CSVRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        CsvDataFormat csv = new CsvDataFormat();
        csv.setDelimiter(",");
        from("file:/Users/{{move.file.location}}/Desktop/TestCamelInput?fileName=sampleFile.csv&noop=true")
                .unmarshal().csv().bean(new CsvHandler() , "doHandleCsvData");
    }
}
