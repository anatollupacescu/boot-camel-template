package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HeaderFilterRoute extends RouteBuilder {

    public void configure() {
        from("direct:start")
                .log("Foo header: ${header.foo}")
                .filter(header("foo")
                .isEqualTo("bar")).to("{{out.endpoint}}");
    }
}
