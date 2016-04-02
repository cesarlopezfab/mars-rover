package location;

import static location.Direction.*;

public class PositionFixture {

	static class TestablePosition extends Position {

		TestablePosition(final Integer x, final Integer y) {
			super(x, y);
		}

		public String toString() {
			return "x: " + x + " y: " + y;
		}

	}

	public static final Position LANDING = new TestablePosition(0, 0);

	public static final Position NORTH_OF_LANDING = LANDING.nextPositionIn(NORTH);
	public static final Position SOUTH_OF_LANDING = LANDING.nextPositionIn(SOUTH);
	public static final Position EAST_OF_LANDING = LANDING.nextPositionIn(EAST);
	public static final Position WEST_OF_LANDING = LANDING.nextPositionIn(WEST);
}
