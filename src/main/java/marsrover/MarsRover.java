package marsrover;

import location.Direction;
import location.Planet;
import location.Position;

public class MarsRover {

	Direction direction;
	Position position;
	final Planet planet;

	MarsRover(final Planet planet, final Position position, final Direction direction) {
		this.position = position;
		this.direction = direction;
		this.planet = planet;
	}

	public void receiveCommands(Command... commands) {

		for (final Command command : commands) {

			if (command instanceof ForwardCommand) {
				position = planet.nextFromGoingIn(position, direction);
			}

			if (command instanceof BackwardCommand) {
				position = planet.previousFromGoingIn(position, direction);
			}

			if (command instanceof RotateLeftCommand) {
				direction = direction.previous();
			}

			if (command instanceof RotateRightCommand) {
				direction = direction.next();
			}
		}

	}

}
