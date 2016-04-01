package marsrover;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import location.Point;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class MarsRoverTest {


	private final Point startingPoint = MarsRoverFixture.STARTING_POINT;


	public class MovesForward {

		@Test
		public void whenFacingNorth() {
			final MarsRover rover = MarsRoverFixture.facingNorth();
			rover.receiveCommands("f");
			assertEquals(new Point(0, 1), rover.position);
		}

		@Test
		public void whenFacingSouth() {
			final MarsRover rover = MarsRoverFixture.facingSouth();
			rover.receiveCommands("f");
			assertEquals(new Point(0, -1), rover.position);
		}

		@Test
		public void whenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.receiveCommands("f");
			assertEquals(new Point(1, 0), rover.position);
		}

		@Test
		public void whenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.receiveCommands("f");
			assertEquals(new Point(-1, 0), rover.position);
		}

	}



}
