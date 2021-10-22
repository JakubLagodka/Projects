package race;

import java.time.*;

class Leg {
    private final double distance;
    private final Duration duration;
    private final Location startLocation;
    private final Location finishLocation;

    Leg(Location startLocation, LocalDateTime startLocalTime, Location finishLocation, LocalDateTime finishLocalTime) {

        this.startLocation = startLocation;
        this.finishLocation = finishLocation;

        this.distance = DistanceCalculator.betweenPoints(startLocation.getPoint(), finishLocation.getPoint());
        this.duration = Duration.between(startLocalTime, finishLocalTime);
    }

    double getDistance() {
        return distance;
    }

    Duration getDuration() {
        return duration;
    }

    Location getStartLocation() {
        return startLocation;
    }

    Location getFinishLocation() {
        return finishLocation;
    }
}
