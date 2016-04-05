package marsrover;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import location.Direction;
import location.PositionFixture;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(HierarchicalContextRunner.class)
public class MarsRoverTest {

	private final ForwardCommand forward = new ForwardCommand();
	private final BackwardCommand backward = new BackwardCommand();

	public class MovesForward {

		@Test
		public void whenFacingNorth() {
			final MarsRover rover = MarsRoverFixture.facingNorth();
			rover.executeCommands(forward);
			assertThat(rover.position, is(PositionFixture.NORTH_OF_LANDING));
		}

		@Test
		public void whenFacingSouth() {
			final MarsRover rover = MarsRoverFixture.facingSouth();
			rover.executeCommands(forward);
			assertThat(rover.position, is(PositionFixture.SOUTH_OF_LANDING));
		}

		@Test
		public void whenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.executeCommands(forward);
			assertThat(rover.position, is(PositionFixture.EAST_OF_LANDING));
		}

		@Test
		public void whenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.executeCommands(forward);
			assertThat(rover.position, is(PositionFixture.WEST_OF_LANDING));
		}

	}

	public class MovesBackward {

		@Test
		public void whenFacingNorth() {
			final MarsRover rover = MarsRoverFixture.facingNorth();
			rover.executeCommands(backward);
			assertThat(rover.position, is(PositionFixture.SOUTH_OF_LANDING));
		}

		@Test
		public void whenFacingSouth() {
			final MarsRover rover = MarsRoverFixture.facingSouth();
			rover.executeCommands(backward);
			assertThat(rover.position, is(PositionFixture.NORTH_OF_LANDING));
		}

		@Test
		public void whenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.executeCommands(backward);
			assertThat(rover.position, is(PositionFixture.WEST_OF_LANDING));
		}

		@Test
		public void whenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.executeCommands(backward);
			assertThat(rover.position, is(PositionFixture.EAST_OF_LANDING));
		}

	}

	public class SeveralCommands {

		@Test
		public void staysInPlaceWhenForwardAndThenBackwardCommands() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.executeCommands(backward, forward);
			assertThat(rover.position, is(PositionFixture.LANDING));
		}
	}

	public class Rotation {

		@Test
		public void facesNorthAfterRotatingLeftWhenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.executeCommands(new RotateLeftCommand());
			assertThat(rover.direction, is(Direction.NORTH));
		}

		@Test
		public void facesNorthAfterRotatingRightWhenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.executeCommands(new RotateRightCommand());
			assertThat(rover.direction, is(Direction.NORTH));
		}
	}

	public class SphericalPlanet {

		@Test
		public void isAtPosition1WhenMoving5EastThroughEquatorOfSize4Planet() {
			final MarsRover rover = MarsRoverFixture.facingEastOnSphericalPlanet(4);

			rover.executeCommands(forward, forward, forward, forward, forward);

			assertThat(rover.position, is(PositionFixture.EAST_OF_LANDING));
		}
	}

	public class ObstacleDetection {

		final MarsRover rover = MarsRoverFixture.facingNorth();

		@Test
		public void stopsWhenObstacleDetectedMovingForward() {
			rover.planet.addObstacle(PositionFixture.NORTH_OF_LANDING);
			rover.executeCommands(forward);
			assertThat(rover.position, is(PositionFixture.LANDING));
		}


		@Test
		public void stopsWhenObstacleDetectedMovingBackward() {
			rover.planet.addObstacle(PositionFixture.SOUTH_OF_LANDING);
			rover.executeCommands(backward);
			assertThat(rover.position, is(PositionFixture.LANDING));
		}

		@Test
		public void continuesMovingAfterRotation() {
			rover.planet.addObstacle(PositionFixture.SOUTH_OF_LANDING);
			rover.executeCommands(backward, new RotateLeftCommand(), forward);
			assertThat(rover.position, is(PositionFixture.WEST_OF_LANDING));
		}
	}

}
