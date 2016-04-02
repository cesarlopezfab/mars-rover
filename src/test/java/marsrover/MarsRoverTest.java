package marsrover;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import location.Direction;
import location.PositionFixture;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(HierarchicalContextRunner.class)
public class MarsRoverTest {


	public class MovesForward {

		@Test
		public void whenFacingNorth() {
			final MarsRover rover = MarsRoverFixture.facingNorth();
			rover.receiveCommands("f");
			assertThat(rover.position, is(PositionFixture.NORTH_OF_LANDING));
		}

		@Test
		public void whenFacingSouth() {
			final MarsRover rover = MarsRoverFixture.facingSouth();
			rover.receiveCommands("f");
			assertThat(rover.position, is(PositionFixture.SOUTH_OF_LANDING));
		}

		@Test
		public void whenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.receiveCommands("f");
			assertThat(rover.position, is(PositionFixture.EAST_OF_LANDING));
		}

		@Test
		public void whenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.receiveCommands("f");
			assertThat(rover.position, is(PositionFixture.WEST_OF_LANDING));
		}

	}

	public class MovesBackward {

		@Test
		public void whenFacingNorth() {
			final MarsRover rover = MarsRoverFixture.facingNorth();
			rover.receiveCommands("b");
			assertThat(rover.position, is(PositionFixture.SOUTH_OF_LANDING));
		}

		@Test
		public void whenFacingSouth() {
			final MarsRover rover = MarsRoverFixture.facingSouth();
			rover.receiveCommands("b");
			assertThat(rover.position, is(PositionFixture.NORTH_OF_LANDING));
		}

		@Test
		public void whenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.receiveCommands("b");
			assertThat(rover.position, is(PositionFixture.WEST_OF_LANDING));
		}

		@Test
		public void whenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.receiveCommands("b");
			assertThat(rover.position, is(PositionFixture.EAST_OF_LANDING));
		}

	}

	public class SeveralCommands {

		@Test
		public void staysInPlaceWhenForwardAndThenBackwardCommands() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.receiveCommands("b", "f");
			assertThat(rover.position, is(PositionFixture.LANDING));
		}
	}

	public class Rotation {

		@Test
		public void facesNorthAfterRotatingLeftWhenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.receiveCommands("l");
			assertThat(rover.direction, is(Direction.NORTH));
		}

		@Test
		public void facesNorthAfterRotatingRightWhenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.receiveCommands("r");
			assertThat(rover.direction, is(Direction.NORTH));
		}
	}

	public class SphericalPlanet {

		@Test
		@Ignore
		public void isAtPosition1WhenMoving5EastThroughEquatorOfSize4Planet() {
			final MarsRover rover = MarsRoverFixture.facingEastOnSphericalPlanet(4);

			rover.receiveCommands("f", "f", "f", "f", "f");

			assertThat(rover.position, is(PositionFixture.EAST_OF_LANDING));
		}
	}

}
