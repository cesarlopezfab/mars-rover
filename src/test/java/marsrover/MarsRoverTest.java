package marsrover;

import location.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

	private final String startingDirection = "N";
	private final Point startingPoint = new Point(0, 0);
	private final MarsRover rover= new MarsRover(startingPoint, startingDirection);;

	@Test
	public void marsRoverStartsAtPointXYFacingDirection() {
		assertEquals(startingPoint, rover.position);
		assertEquals(startingDirection, rover.direction);
	}

	@Test
	public void marsRoverIsAbleToReceiveCommands() {
		rover.receiveCommands();
	}

	@Test
	public void marsRoverMovesForwardWhenFacingNorth() {
		rover.receiveCommands("f");
		assertEquals(new Point(0, 1), rover.position);
	}


}
