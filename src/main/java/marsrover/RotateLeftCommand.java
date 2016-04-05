package marsrover;

class RotateLeftCommand implements Command {

	@Override
	public void execute(final MarsRover marsRover) {
		marsRover.direction = marsRover.direction.previous();
	}

}
