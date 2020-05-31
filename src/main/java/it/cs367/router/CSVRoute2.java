package it.cs367.router;

import it.cs367.bean.Dalton;
import it.cs367.processor.CsvProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;

public class CSVRoute2 extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        CsvDataFormat csv = new CsvDataFormat();
        csv.setDelimiter(",");
        from("file:/Users/{{move.file.location}}/Desktop/TestCamelInput?fileName=sampleFile.csv&noop=true")
                .unmarshal().csv()
                .split(body())
                .bean(new Dalton(), "creatDalton")
                .setBody(simple("insert into dalton values(${body[1]},'${body[0]}', '${body[2]}')"))
                .to("jdbc:h2DataSource");
    }
}
