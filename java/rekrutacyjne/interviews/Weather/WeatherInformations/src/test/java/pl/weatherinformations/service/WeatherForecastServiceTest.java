package pl.weatherinformations.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.weatherinformations.service.request.Daily;
import pl.weatherinformations.service.request.GeoPoint;
import pl.weatherinformations.service.request.Hourly;
import pl.weatherinformations.service.request.Minutely15;
import pl.weatherinformations.service.request.WeatherForecastRequest;

@Slf4j
@ExtendWith ( SpringExtension.class )
@SpringBootTest ( webEnvironment = SpringBootTest.WebEnvironment.NONE )
@ActiveProfiles ( "WeatherForecastServiceTest" )
public class WeatherForecastServiceTest {

    @Autowired
    private WeatherForecastService weatherForecastService;

    @Test
    public void weatherForecastTest() {
//        WeatherForecastRequest request = WeatherForecastRequest.of( GeoPoint.Warsaw )
//                .hourly( Hourly.APPARENT_TEMPERATURE, Hourly.DEW_POINT_2M )
//                .daily( Daily.APPARENT_TEMPERATURE_MIN, Daily.DAYLIGHT_DURATION )
//                .minutely15( Minutely15.APPARENT_TEMPERATURE, Minutely15.DEW_POINT_2M );
        WeatherForecastRequest request = WeatherForecastRequest.of( GeoPoint.Warsaw );
//                .hourly( Hourly.APPARENT_TEMPERATURE, Hourly.DEW_POINT_2M )
//                .daily( Daily.APPARENT_TEMPERATURE_MIN, Daily.DAYLIGHT_DURATION )
//                .minutely15( Minutely15.APPARENT_TEMPERATURE, Minutely15.DEW_POINT_2M );
        String result = weatherForecastService.weatherForecast( request );
        log.info( result );
    }

}