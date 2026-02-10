package pl.weatherinformations.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@Getter
@RequiredArgsConstructor(staticName = "of")
public class WeatherForecastRequest {
    private final GeoPoint location;
    private final Set<Hourly> hourly = new HashSet<>();
    private final Set<Daily> daily = new HashSet<>();
    private final Set<Minutely15>  minutely15 = new HashSet<>();

    public WeatherForecastRequest hourly( Hourly... hourlyList) {
        this.hourly.addAll( Arrays.asList(hourlyList) );
        return this;
    }

    public WeatherForecastRequest daily( Daily... dailyList) {
        this.daily.addAll( Arrays.asList(dailyList) );
        return this;
    }

    public WeatherForecastRequest minutely15( Minutely15... minutely15List) {
        this.minutely15.addAll( Arrays.asList(minutely15List) );
        return this;
    }
}
