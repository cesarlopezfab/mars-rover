package marsrover;

class ForwardCommand implements Command {

	@Override
	@MovementCommand
	public void execute(final MarsRover marsRover) {
		marsRover.position = marsRover.planet.nextFromGoingIn(marsRover.position, marsRover.direction);
	}

}
