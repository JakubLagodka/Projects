package com.devskiller.race;

import java.time.*;

/**
 * @author Devskiller
 */
class Leg {

    private final double distance;
    private final Duration duration;
    private final Location startLocation;
    private final Location finishLocation;

    Leg(Location startLocation, LocalDateTime startLocalTime, Location finishLocation, LocalDateTime finishLocalTime) {
	throw new UnsupportedOperationException("Please, implement me");
    }

    /**
     * @return leg duration. Please notice that start and finish time zones can be different
     */
    Duration getDuration() {
        
        
	return duration;
    }

    /**
     * @return distance between start and finish point (Location.getPoint())
     */
    double getDistance() {
        
       
        
	return distance;
    }

    Location getStartLocation() {
	return startLocation;
    }

    Location getFinishLocation() {
	return finishLocation;
    }
}
