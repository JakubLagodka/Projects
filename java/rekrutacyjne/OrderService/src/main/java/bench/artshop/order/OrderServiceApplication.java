package bench.artshop.order;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableFeignClients
public class OrderServiceApplication {
    @Autowired
    private EurekaClient eurekaClient;
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}