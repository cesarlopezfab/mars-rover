package marsrover;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import loader.AspectjLoader;
import location.Direction;
import location.PositionFixture;
import location.TwoDimensionsInfinitePlanet;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class MarsRoverTest {

	@BeforeClass
	public static void before() {
		AspectjLoader.load();
	}

	public class MovesForward {

		@Test
		public void whenFacingNorth() {
			final MarsRover rover = MarsRoverFixture.facingNorth();
			rover.executeCommands(new ForwardCommand());
			assertThat(rover.position, is(PositionFixture.NORTH_OF_LANDING));
		}

		@Test
		public void whenFacingSouth() {
			final MarsRover rover = MarsRoverFixture.facingSouth();
			rover.executeCommands(new ForwardCommand());
			assertThat(rover.position, is(PositionFixture.SOUTH_OF_LANDING));
		}

		@Test
		public void whenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.executeCommands(new ForwardCommand());
			assertThat(rover.position, is(PositionFixture.EAST_OF_LANDING));
		}

		@Test
		public void whenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.executeCommands(new ForwardCommand());
			assertThat(rover.position, is(PositionFixture.WEST_OF_LANDING));
		}

	}

	public class MovesBackward {

		@Test
		public void whenFacingNorth() {
			final MarsRover rover = MarsRoverFixture.facingNorth();
			rover.executeCommands(new BackwardCommand());
			assertThat(rover.position, is(PositionFixture.SOUTH_OF_LANDING));
		}

		@Test
		public void whenFacingSouth() {
			final MarsRover rover = MarsRoverFixture.facingSouth();
			rover.executeCommands(new BackwardCommand());
			assertThat(rover.position, is(PositionFixture.NORTH_OF_LANDING));
		}

		@Test
		public void whenFacingEast() {
			final MarsRover rover = MarsRoverFixture.facingEast();
			rover.executeCommands(new BackwardCommand());
			assertThat(rover.position, is(PositionFixture.WEST_OF_LANDING));
		}

		@Test
		public void whenFacingWest() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.executeCommands(new BackwardCommand());
			assertThat(rover.position, is(PositionFixture.EAST_OF_LANDING));
		}

	}

	public class SeveralCommands {

		@Test
		public void staysInPlaceWhenForwardAndThenBackwardCommands() {
			final MarsRover rover = MarsRoverFixture.facingWest();
			rover.executeCommands(new BackwardCommand(), new ForwardCommand());
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

			rover.executeCommands(new ForwardCommand(), new ForwardCommand(), new ForwardCommand(), new ForwardCommand(), new ForwardCommand());

			assertThat(rover.position, is(PositionFixture.EAST_OF_LANDING));
		}
	}

	public class ObstacleDetection {


		final TwoDimensionsInfinitePlanet planet = new TwoDimensionsInfinitePlanet();
		final MarsRover rover = MarsRoverFixture.facingNorth(planet);

		@Test
		public void stopsWhenObstacleDetectedMovingForward() {
			planet.addObstacle(PositionFixture.NORTH_OF_LANDING);

			rover.executeCommands(new ForwardCommand());

			assertThat(rover.position, is(PositionFixture.LANDING));
			assertTrue(rover.detectedObstacles.contains(PositionFixture.NORTH_OF_LANDING));
			assertThat(rover.notifications(), is("obstacle"));
		}


		@Test
		public void stopsWhenObstacleDetectedMovingBackward() {
			planet.addObstacle(PositionFixture.SOUTH_OF_LANDING);

			rover.executeCommands(new BackwardCommand());

			assertThat(rover.position, is(PositionFixture.LANDING));
			assertTrue(rover.detectedObstacles.contains(PositionFixture.SOUTH_OF_LANDING));
			assertThat(rover.notifications(), is("obstacle"));
		}

		@Test
		public void continuesMovingAfterRotation() {
			planet.addObstacle(PositionFixture.SOUTH_OF_LANDING);

			rover.executeCommands(new BackwardCommand(), new RotateLeftCommand(), new ForwardCommand());

			assertThat(rover.position, is(PositionFixture.WEST_OF_LANDING));
			assertTrue(rover.detectedObstacles.contains(PositionFixture.SOUTH_OF_LANDING));
			assertThat(rover.notifications(), is("obstacle"));
		}

		@Test
		public void itDoesntReportObstacle() {
			rover.executeCommands(new BackwardCommand(), new RotateLeftCommand(), new ForwardCommand());

			assertThat(rover.notifications(), is(""));
		}
	}

}
