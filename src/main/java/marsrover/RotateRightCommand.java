package marsrover;

class RotateRightCommand implements Command {

	@Override
	public void execute(final MarsRover marsRover) {
		marsRover.direction = marsRover.direction.next();
	}

}
