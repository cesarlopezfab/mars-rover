package marsrover;

public enum Direction {
	NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

	private final String value;

	Direction(String direction) {
		this.value = direction;
	}

}
