package marsrover;

import location.Position;

class BackwardCommand implements Command{

	@Override
	public void execute(final MarsRover marsRover) {
		Position position = marsRover.planet.previousFromGoingIn(marsRover.position, marsRover.direction);

		if (marsRover.planet.hasNoObstacle(position)) {
			marsRover.position = position;
		}
	}

}
