package com.example.demo;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws.s3.S3Constants;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.config.TestConfig;

@RunWith(SpringRunner.class)
public class S3Test {

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Test
    public void routeReadsFileFromLocation() throws Exception {
        resultEndpoint.expectedMessageCount(1);
        resultEndpoint.expectedHeaderReceived(S3Constants.KEY, "file.png");
        resultEndpoint.assertIsSatisfied();
    }

    @Configuration
    @Import(TestConfig.class)
    public static class ContextConfig extends SingleRouteCamelConfiguration {

        @Bean
        public RouteBuilder route() {
            return new S3CamelRoute();
        }
    }
}
