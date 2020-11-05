package sample.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jsonb.JsonbDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        JsonbDataFormat formatPojo = new JsonbDataFormat(TestPojo.class);

        from("timer:test?period=2000")
                .setBody(constant("{\"name\":\"Sheldon\"}"))
                .marshal(formatPojo)
               .log("${body}");

    }
}
