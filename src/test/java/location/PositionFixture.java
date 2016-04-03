package location;

import static location.Direction.*;

public class PositionFixture {

	public static final Planet PLANET = new TwoDimensionsInfinitePlanet();

	public static final Position LANDING = new TestablePosition(0, 0);

	public static final Position NORTH_OF_LANDING = PLANET.nextFromGoingIn(LANDING, NORTH);
	public static final Position SOUTH_OF_LANDING = PLANET.nextFromGoingIn(LANDING, SOUTH);
	public static final Position EAST_OF_LANDING = PLANET.nextFromGoingIn(LANDING, EAST);
	public static final Position WEST_OF_LANDING = PLANET.nextFromGoingIn(LANDING, WEST);
}
