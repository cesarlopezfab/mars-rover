package marsrover;

import location.TestablePlanet;
import location.Direction;
import location.Position;
import location.PositionFixture;

public class MarsRoverFixture {

	public static Position LANDING = PositionFixture.LANDING;

	public static MarsRover facingNorth() {
		final Position landing = LANDING;
		final Direction direction = Direction.NORTH;
		return buildRover(landing, direction);
	}

	public static MarsRover facingEast() {
		return buildRover(LANDING, Direction.EAST);
	}

	public static MarsRover facingSouth() {
		return buildRover(LANDING, Direction.SOUTH);
	}


	public static MarsRover facingWest() {
		return buildRover(LANDING, Direction.WEST);
	}

	public static MarsRover facingEastOnSphericalPlanet(final int planetEquatorSize) {
		return buildRover(LANDING, Direction.EAST);
	}

	private static MarsRover buildRover(final Position landing, final Direction direction) {
		return new MarsRover(new TestablePlanet(), landing, direction);
	}
}
