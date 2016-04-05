package marsrover;

import location.Position;

class ForwardCommand implements Command {

	@Override
	public void execute(final MarsRover marsRover) {

		final Position position = marsRover.planet.nextFromGoingIn(marsRover.position, marsRover.direction);

		if (marsRover.planet.hasNoObstacle(position)) {
			marsRover.position = position;
		}

	}

}
