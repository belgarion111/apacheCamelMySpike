package it.cs367;

import it.cs367.router.SimpleRouteBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;

@Slf4j
public class StartSamples {
    public static void main(String[] args) {

        log.info("Start Main Class");

        var routeBuilder = new SimpleRouteBuilder();
        var ctx = new DefaultCamelContext();
        PropertiesComponent pc = new PropertiesComponent();
        pc.setLocation("classpath:application.properties");
        ctx.setPropertiesComponent(pc);
        try {
            ctx.addRoutes(routeBuilder);
            ctx.start();
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
