package marsrover;

class BackwardCommand implements Command{

	@Override
	public void execute(final MarsRover marsRover) {
		marsRover.position = marsRover.planet.previousFromGoingIn(marsRover.position, marsRover.direction);
	}

}
