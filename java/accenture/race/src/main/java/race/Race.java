package race;

import java.time.*;
import java.util.*;

class Race {
    private final List<Leg> legs = new ArrayList<>();

    void addLeg(Leg leg) throws IllegalStartPointException {
        // throw new UnsupportedOperationException("Please, implement me");
        if (legs.isEmpty()) {
            legs.add(leg);
            return;
        }

        if (!leg.getStartLocation().getPoint().equals(legs.get(legs.size() - 1).getFinishLocation().getPoint()))
            throw new IllegalStartPointException();
        legs.add(leg);

    }

    int getLegsCount() {
        return legs.size();
    }

    Duration getTotalDuration() {
        //throw new UnsupportedOperationException("Please, implement me");

        Duration duration = Duration.ZERO;
        for (Leg leg : legs) {
            duration = duration.plus(leg.getDuration());
        }
        return duration;

    }

    Duration getAverageLegDuration() {
        //throw new UnsupportedOperationException("Please, implement me");
        Duration duration = getTotalDuration();

        return duration.dividedBy(legs.size());

    }

    double getTotalDistance() {
        //throw new UnsupportedOperationException("Please, implement me");

        double distance = 0.0;
        for (Leg leg : legs) {
            distance += leg.getDistance();
        }
        return distance;

    }

    double getAverageDistance() {
        //throw new UnsupportedOperationException("Please, implement me");

        return getTotalDistance() / legs.size();

    }
}
