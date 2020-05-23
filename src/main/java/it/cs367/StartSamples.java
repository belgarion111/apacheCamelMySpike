package it.cs367;

import it.cs367.router.CSVRoute;
import it.cs367.router.MoveFileRoute;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;

@Slf4j
public class StartSamples {
    public static void main(String[] args) {

        log.info("Start Main Class");
        var csvRoute = new CSVRoute();
        var ctx = new DefaultCamelContext();
        PropertiesComponent pc = new PropertiesComponent();
        pc.setLocation("classpath:application.properties");
 //       ctx.setprosetPropertiesComponent(pc);
        try {
            ctx.addRoutes(csvRoute);
            ctx.start();
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
