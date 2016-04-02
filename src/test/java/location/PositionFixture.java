package location;

import static location.Direction.*;

public class PositionFixture {


	public static final Position LANDING = new Position(0, 0);

	public static final Position NORTH_OF_LANDING = LANDING.nextPositionIn(NORTH);
	public static final Position SOUTH_OF_LANDING = LANDING.nextPositionIn(SOUTH);
	public static final Position EAST_OF_LANDING = LANDING.nextPositionIn(EAST);
	public static final Position WEST_OF_LANDING = LANDING.nextPositionIn(WEST);
}
