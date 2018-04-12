package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws.s3.S3Constants;
import org.springframework.stereotype.Component;

@Component
public class S3CamelRoute extends RouteBuilder {

    private final String S3 = "s3";

    public void configure() throws Exception {
        from("{{route.s3.from}}")
                .routeId(S3)
                .convertBodyTo(byte[].class)
                .setHeader(S3Constants.CONTENT_LENGTH, simple("${in.header.CamelFileLength}"))
                .setHeader(S3Constants.KEY,simple("${in.header.CamelFileNameOnly}"))
                .to("{{route.s3.to}}")
                .log("done.");
    }
}
