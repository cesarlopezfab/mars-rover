package marsrover;

import location.Point;
import location.PointFixture;

public class MarsRoverFixture {

	public static Point STARTING_POINT = PointFixture.START;

	public static MarsRover facingNorth() {
		return new MarsRover(STARTING_POINT, Direction.NORTH);
	}

	public static MarsRover facingEast() {
		return new MarsRover(STARTING_POINT, Direction.EAST);
	}

	public static MarsRover facingSouth() {
		return new MarsRover(STARTING_POINT, Direction.SOUTH);
	}


	public static MarsRover facingWest() {
		return new MarsRover(STARTING_POINT, Direction.WEST);
	}

}
