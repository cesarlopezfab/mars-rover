package marsrover;

import location.Point;

public class MarsRoverFixture {

	public static Point STARTING_POINT = new Point(0, 0);

	public static MarsRover facingNorth() {
		return new MarsRover(STARTING_POINT, "N");
	}

	public static MarsRover facingEast() {
		return new MarsRover(STARTING_POINT, "E");
	}

	public static MarsRover facingSouth() {
		return new MarsRover(STARTING_POINT, "S");
	}


	public static MarsRover facingWest() {
		return new MarsRover(STARTING_POINT, "W");
	}

}
