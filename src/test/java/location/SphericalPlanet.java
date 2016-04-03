package location;

import location.Planet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static location.Direction.*;
import static location.Direction.WEST;

public class SphericalPlanet implements Planet {

	private final int size;

	public SphericalPlanet(final int planetEquatorSize) {
		this.size = planetEquatorSize;
	}
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

	@Override
	public Position nextFromGoingIn(final Position position, Direction direction) {
		return sum(position, INCREMENTS.get(direction));
	}

	@Override
	public Position previousFromGoingIn(final Position position, final Direction direction) {
		return sum(position, DECREMENTS.get(direction));
	}

	private Position sum(final Position position, final Delta delta) {
		int x = position.x + delta.x;
		int y = position.y + delta.y;

		if (x > size) {
			x = x - size;
		}

		if (y > size) {
			y = y - size;
		}
		return new TestablePosition(x, y);
	}

}
