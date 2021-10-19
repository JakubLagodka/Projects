package race;

import java.time.*;

class Leg {
    private final double distance;
    private final Duration duration;
    private final Location startLocation;
    private final Location finishLocation;
    //private final DistanceCalculator distanceCalculator;

    Leg(Location startLocation, LocalDateTime startLocalTime, Location finishLocation, LocalDateTime finishLocalTime) {
        throw new UnsupportedOperationException("Please, implement me");
        /*
        this.startLocation = startLocation;
        this.finishLocation = finishLocation;

        this.distanceCalculator = new DistanceCalculator();
        this.distance = distanceCalculator.betweenPoints(startLocation.getPoint(), finishLocation.getPoint());
        this.duration = Duration.between(startLocalTime, finishLocalTime);
         */
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
