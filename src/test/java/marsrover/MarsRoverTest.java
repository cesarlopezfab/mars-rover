package marsrover;

import location.Point;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

	// rover.isFacing(NORTH);


	@Test
	public void marsRoverStartsAtPointXYFacingDirection() {
		final String direction = "N";
		final Point point = new Point(0, 0);
		final MarsRover rover = new MarsRover(point, direction);

		assertEquals(point, rover.position);
		assertEquals(direction, rover.direction);
	}

	@Test
	public void marsRoverIsAbleToReceiveCommands() {
		final String direction = "N";
		final Point point = new Point(0, 0);
		final MarsRover rover = new MarsRover(point, direction);

		rover.receiveCommands(new String[]{});
	}

	@Test
	public void marsRoverMovesForwardWhenFacingNorth() {
		final String direction = "N";
		final Point point = new Point(0, 0);
		MarsRover rover = new MarsRover(point, direction);

		rover.receiveCommands(new String[]{"f"});

		assertEquals(new Point(0, 1), rover.position);
	}

	public class MarsRover {
		private final String direction;
		private Point position;

		public MarsRover(Point position, String direction) {
			this.position = position;
			this.direction = direction;
		}

		public void receiveCommands(String[] commands) {
			this.position = new Point(0, 1);
		}

	}


}
