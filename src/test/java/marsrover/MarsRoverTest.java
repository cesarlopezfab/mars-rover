package marsrover;

import location.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

	private final String startingDirection = "N";
	private final Point startingPoint = new Point(0, 0);
	private final MarsRover rover = new MarsRover(startingPoint, startingDirection);

	@Test
	public void startsAtPointXYFacingDirection() {
		assertEquals(startingPoint, rover.position);
		assertEquals(startingDirection, rover.direction);
	}

	@Test
	public void isAbleToReceiveCommands() {
		rover.receiveCommands();
	}

	@Test
	public void movesForwardWhenFacingNorth() {
		rover.receiveCommands("f");
		assertEquals(new Point(0, 1), rover.position);
	}

	@Test
	public void movesForwardWhenFacingSouth() {
		final MarsRover rover = new MarsRover(startingPoint, "S");
		rover.receiveCommands("f");
		assertEquals(new Point(0, -1), rover.position);
	}

}
