package ir.mahdiyehrezaei.springcloudapigatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringCloudApiGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApiGatewayZuulApplication.class, args);
    }

}
