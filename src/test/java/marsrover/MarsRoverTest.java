package marsrover;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import location.Point;
import location.PointFixture;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(HierarchicalContextRunner.class)
public class MarsRoverTest {


	private final Point startingPoint = MarsRoverFixture.STARTING_POINT;


	public class MovesForward {

		@Test
		public void whenFacingNorth() {
			final MarsRover rover = MarsRoverFixture.facingNorth();
			rover.receiveCommands("f");
			assertThat(rover.position, is(PointFixture.NORTH_OF_START));
		}

		@Test
		public void whenFacingSouth() {
			final MarsRover rover = MarsRoverFixture.facingSouth();
			rover.receiveCommands("f");
			assertThat(rover.position, is(PointFixture.SOUTH_OF_START));
		}

		@Test
		public void whenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.receiveCommands("f");
			assertThat(rover.position, is(PointFixture.EAST_OF_START));
		}

		@Test
		public void whenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.receiveCommands("f");
			assertThat(rover.position, is(PointFixture.WEST_OF_START));
		}

	}

	public class MovesBackward {

		@Test
		public void whenFacingNorth() {
			final MarsRover rover = MarsRoverFixture.facingNorth();
			rover.receiveCommands("b");
			assertThat(rover.position, is(PointFixture.SOUTH_OF_START));
		}

		@Test
		public void whenFacingSouth() {
			final MarsRover rover = MarsRoverFixture.facingSouth();
			rover.receiveCommands("b");
			assertThat(rover.position, is(PointFixture.NORTH_OF_START));
		}

		@Test
		public void whenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.receiveCommands("b");
			assertThat(rover.position, is(PointFixture.WEST_OF_START));
		}

		@Test
		public void whenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.receiveCommands("b");
			assertThat(rover.position, is(PointFixture.EAST_OF_START));
		}

	}


}
