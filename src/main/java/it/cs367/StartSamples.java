package it.cs367;

import it.cs367.connection.DbUtils;
import it.cs367.router.CSVRoute2;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.SimpleRegistry;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class StartSamples {
    public static void main(String[] args) {

        SimpleRegistry registry = new SimpleRegistry();
        registry.bind("h2DataSource",DbUtils.getDataSource());
        var csvRoute = new CSVRoute2();
        var ctx = new DefaultCamelContext(registry);
        PropertiesComponent pc = new PropertiesComponent();
        pc.setLocation("classpath:application.properties");
        ctx.setPropertiesComponent(pc);
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
