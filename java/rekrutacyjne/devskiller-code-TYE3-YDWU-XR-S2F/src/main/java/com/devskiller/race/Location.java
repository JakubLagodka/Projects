package com.devskiller.race;

import java.time.ZoneId;
import java.util.Objects;

import org.locationtech.spatial4j.shape.Point;

/**
 * @author Devskiller
 */
class Location {

	private final Point point;
	private final ZoneId zone;

	Location(Point point, ZoneId zone) {
		this.point = point;
		this.zone = zone;
	}

	Point getPoint() {
		return point;
	}

	ZoneId getZone() {
		return zone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Location location = (Location) o;
		return Objects.equals(point, location.point);
	}

	@Override
	public int hashCode() {
		return Objects.hash(point);
	}
}
