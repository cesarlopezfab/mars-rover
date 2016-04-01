package location;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static location.Direction.*;

public class Point {
	private static final Map<Direction, Delta> INCREMENTS = new ConcurrentHashMap<Direction, Delta>();
	private static final Map<Direction, Delta> DECREMENTS = new ConcurrentHashMap<Direction, Delta>();

	static {
		INCREMENTS.put(NORTH, new Delta(0, 1));
		INCREMENTS.put(EAST, new Delta(1, 0));
		INCREMENTS.put(SOUTH, new Delta(0, -1));
		INCREMENTS.put(WEST, new Delta(-1, 0));

		DECREMENTS.put(NORTH, new Delta(0, -1));
		DECREMENTS.put(EAST, new Delta(-1, 0));
		DECREMENTS.put(SOUTH, new Delta(0, 1));
		DECREMENTS.put(WEST, new Delta(1, 0));
	}

	public final Integer x;
	public final Integer y;

	Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public int hashCode() {
		final HashCodeBuilder b = new HashCodeBuilder();
		b.append(x);
		b.append(y);
		return b.toHashCode();
	}

	public boolean equals(Object other) {
		final Point o = (Point) other;
		final EqualsBuilder b = new EqualsBuilder();
		b.append(x, o.x);
		b.append(y, o.y);
		return b.isEquals();
	}

	public String toString() {
		return "x: " + x + " y: " + y;
	}

	public Point nextPointIn(Direction direction) {
		return sum(INCREMENTS.get(direction));
	}

	public Point previousPointIn(final Direction direction) {
		return sum(DECREMENTS.get(direction));
	}

	private Point sum(final Delta delta) {
		return new Point(x + delta.x, y + delta.y);
	}


}