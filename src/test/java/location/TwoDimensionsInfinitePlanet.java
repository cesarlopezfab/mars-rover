package location;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static location.Direction.*;

public class TwoDimensionsInfinitePlanet implements TestablePlanet {

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

	private Set<Position> obstacles = new HashSet<Position>();

	@Override
	public Position nextFromGoingIn(final Position position, Direction direction) {
		return sum(position, INCREMENTS.get(direction));
	}

	@Override
	public Position previousFromGoingIn(final Position position, final Direction direction) {
		return sum(position, DECREMENTS.get(direction));
	}

	@Override
	public void addObstacle(final Position position) {
		obstacles.add(position);
	}

	@Override
	public boolean hasNoObstacle(final Position position) {
		return !obstacles.contains(position);
	}

	protected Position sum(final Position position, final Delta delta) {
		return new TestablePosition(position.x + delta.x, position.y + delta.y);
	}
}
