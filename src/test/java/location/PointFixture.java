package location;

import static marsrover.Direction.*;

public class PointFixture {


	public static final Point START = new Point(0, 0);

	public static final Point NORTH_OF_START = START.nextPointIn(NORTH);
	public static final Point SOUTH_OF_START = START.nextPointIn(SOUTH);
	public static final Point EAST_OF_START = START.nextPointIn(EAST);
	public static final Point WEST_OF_START = START.nextPointIn(WEST);
}
