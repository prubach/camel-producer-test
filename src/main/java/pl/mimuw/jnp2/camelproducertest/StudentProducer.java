package pl.mimuw.jnp2.camelproducertest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class StudentProducer extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/student").produces("application/json")
                .get("/hello/{name}")
                .route().transform().simple("Dzień dobry ${header.name}!")
                .endRest();
    }
}
