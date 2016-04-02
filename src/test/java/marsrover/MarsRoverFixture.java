package marsrover;

import location.Direction;
import location.Position;
import location.PositionFixture;

public class MarsRoverFixture {

	public static Position LANDING = PositionFixture.LANDING;

	public static MarsRover facingNorth() {
		return new MarsRover(LANDING, Direction.NORTH);
	}

	public static MarsRover facingEast() {
		return new MarsRover(LANDING, Direction.EAST);
	}

	public static MarsRover facingSouth() {
		return new MarsRover(LANDING, Direction.SOUTH);
	}


	public static MarsRover facingWest() {
		return new MarsRover(LANDING, Direction.WEST);
	}

	public static MarsRover facingEastOnSphericalPlanet(final int planetEquatorSize) {
		return new MarsRover(LANDING, Direction.EAST);
	}
}
