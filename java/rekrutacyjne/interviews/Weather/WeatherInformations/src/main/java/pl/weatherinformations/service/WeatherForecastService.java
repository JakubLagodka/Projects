package pl.weatherinformations.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.weatherinformations.client.OpenMeteoClient;
import pl.weatherinformations.service.request.Hourly;
import pl.weatherinformations.service.request.WeatherForecastRequest;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherForecastService {
    private final OpenMeteoClient openMeteoClient;

    public String weatherForecast( WeatherForecastRequest request ) {
        return openMeteoClient.forecast( request.getLocation().latitude(),
                request.getLocation().longitude(),
                toRequestParam(request.getHourly()),
                toRequestParam(request.getDaily()),
                toRequestParam(request.getMinutely15()));

    }

    private static <E extends Enum<E>> String toRequestParam( Set<E> values ) {
        return values.isEmpty()
                ? null
                : values.stream()
                .map(Enum::name)
                .collect( Collectors.joining(","));
    }
}
