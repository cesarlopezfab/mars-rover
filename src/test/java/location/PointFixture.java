package location;

public class PointFixture {


	public static final Point START = new Point(0, 0);

	public static final Point NORTH_OF_START = START.increaseY();
	public static final Point SOUTH_OF_START = START.decreaseY();
	public static final Point EAST_OF_START = START.increaseX();
	public static final Point WEST_OF_START = START.decreaseX();
}
