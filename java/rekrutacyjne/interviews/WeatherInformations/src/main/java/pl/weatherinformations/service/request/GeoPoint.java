package pl.weatherinformations.service.request;

public record GeoPoint(double latitude, double longitude) {
    public static final GeoPoint
    Warsaw = GeoPoint.of(52.2297,21.0122),
    NewYork = GeoPoint.of(40.7128,-74.0060);

    private static GeoPoint of(double latitude, double longitude) {
        return new GeoPoint(latitude, longitude);
    }
}
