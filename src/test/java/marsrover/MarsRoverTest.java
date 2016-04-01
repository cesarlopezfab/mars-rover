package marsrover;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import location.Point;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
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

	public class MovesForward {

		@Test
		public void whenFacingNorth() {
			rover.receiveCommands("f");
			assertEquals(new Point(0, 1), rover.position);
		}

		@Test
		public void whenFacingSouth() {
			final MarsRover rover = new MarsRover(startingPoint, "S");
			rover.receiveCommands("f");
			assertEquals(new Point(0, -1), rover.position);
		}

		@Test
		public void whenFacingEast() {
			final MarsRover rover = new MarsRover(startingPoint, "E");
			rover.receiveCommands("f");
			assertEquals(new Point(1, 0), rover.position);
		}

		@Test
		public void whenFacingWest() {
			final MarsRover rover = new MarsRover(startingPoint, "W");
			rover.receiveCommands("f");
			assertEquals(new Point(-1, 0), rover.position);
		}

	}



}
