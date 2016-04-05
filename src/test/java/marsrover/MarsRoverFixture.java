package marsrover;

import location.*;

public class MarsRoverFixture {


	public static Position LANDING = PositionFixture.LANDING;

	public static MarsRover facingNorth() {
		return facingNorth(new TwoDimensionsInfinitePlanet());
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
		return buildRover(new CircularPlanet(planetEquatorSize), LANDING, Direction.EAST);
	}

	private static MarsRover buildRover(final Position landing, final Direction direction) {
		return buildRover(new TwoDimensionsInfinitePlanet(), landing, direction);
	}

	private static MarsRover buildRover(final Planet planet, final Position landing, final Direction direction) {
		return new MarsRover(planet, landing, direction);
	}

	public static MarsRover facingNorth(final Planet planet) {
		return new MarsRover(planet, LANDING, Direction.NORTH);
	}
}
