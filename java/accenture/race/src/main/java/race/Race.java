package race;

import java.time.*;
import java.util.*;

class Race {
    private final List<Leg> legs = new ArrayList<>();

    void addLeg(Leg leg) throws IllegalStartPointException {
        throw new UnsupportedOperationException("Please, implement me");
        /*  if (leg.getStartLocation() != legs.get(legs.size() - 1).getFinishLocation())
        throw new IllegalStartPointException();
        this.legs.add(leg);
         */
    }

    int getLegsCount() {
        return legs.size();
    }

    Duration getTotalDuration() {
        throw new UnsupportedOperationException("Please, implement me");
           /*
        Duration duration = new Duration();
        for(Leg leg:legs){
            duration += getDuration();
        }
        return duration;
         */
    }

    Duration getAverageLegDuration() {
        throw new UnsupportedOperationException("Please, implement me");
              /*
        Duration duration = new Duration();
        for(Leg leg:legs){
            duration += getDuration();
        }
        return duration;
         */
    }

    double getTotalDistance() {
        throw new UnsupportedOperationException("Please, implement me");
        /*
         double distance = 0.0;
        for(Leg leg:legs){
            distance += getDistance();
        }
        return distance;
         */
    }

    double getAverageDistance() {
        throw new UnsupportedOperationException("Please, implement me");

        /*
         double distance = 0.0;
        for(Leg leg:legs){
            distance += getDistance();
        }
        return distance;
         */
    }
}
