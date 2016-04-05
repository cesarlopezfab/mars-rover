package marsrover;

class BackwardCommand implements Command {

	@Override
	@MovementCommand
	public void execute(final MarsRover marsRover) {
		marsRover.position = marsRover.planet.previousFromGoingIn(marsRover.position, marsRover.direction);
	}

}
