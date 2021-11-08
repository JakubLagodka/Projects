package com.devskiller.race;

import java.time.*;
import java.util.*;

/**
 * @author Devskiller
 */
class Race {

	private final List<Leg> legs = new ArrayList<>();

	/**
	 * Adds leg to the race
	 *
	 * @param leg to add
	 * @throws IllegalStartPointException when start point of the leg is different than the finish point of the last leg
	 */
	void addLeg(Leg leg) throws IllegalStartPointException {
		throw new UnsupportedOperationException("Please, implement me");
	}

	/**
	 * @return number of legs in the race
	 */
	int getLegsCount() {
		return legs.size();
	}

	Duration getTotalDuration() {
		throw new UnsupportedOperationException("Please, implement me");
	}

	Duration getAverageLegDuration() {
		throw new UnsupportedOperationException("Please, implement me");
	}

	double getTotalDistance() {
		throw new UnsupportedOperationException("Please, implement me");
	}

	double getAverageLegDistance() {
		throw new UnsupportedOperationException("Please, implement me");
	}

}
