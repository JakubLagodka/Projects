package pl.weatherinformations.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.weatherinformations.config.OpenFeignConfig;

@FeignClient(name = "openMeteoClient",
url = "https://api.open-meteo.com",
configuration = OpenFeignConfig.class)
public interface OpenMeteoClient {

    @GetMapping("/v1/forecast")
    String forecast( @RequestParam double latitude, @RequestParam double longitude,  @RequestParam(required = false) String hourly, @RequestParam(required = false) String daily,@RequestParam(required = false) String minutely15);
}
