package location;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Direction {
	NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

	private final static Map<Direction, Direction> PREVIOUS = new ConcurrentHashMap<Direction, Direction>();
	private static final Map<Direction, Direction> NEXT = new ConcurrentHashMap<Direction, Direction>();

	static {
		PREVIOUS.put(NORTH, WEST);
		PREVIOUS.put(EAST, NORTH);
		PREVIOUS.put(SOUTH, EAST);
		PREVIOUS.put(WEST, SOUTH);

		NEXT.put(NORTH, EAST);
		NEXT.put(EAST, SOUTH);
		NEXT.put(SOUTH, WEST);
		NEXT.put(WEST, NORTH);
	}


	private final String value;

	Direction(String direction) {
		value = direction;
	}


	/**
	 * Thinking of the direction as seen in a compast:
	 *   N
	 * W   E
	 *   S
	 * Previous returns the next value counter clockwise.
	 *
	 * @return the next value counter clockwise in a compass.
	 */
	public Direction previous() {
		return PREVIOUS.get(this);
	}

	/**
	 * Thinking of the direction as seen in a compast:
	 *   N
	 * W   E
	 *   S
	 * Previous returns the next value counter clockwise.
	 *
	 * @return the next value counter clockwise in a compass.
	 */
	public Direction next() {
		return NEXT.get(this);
	}
}
