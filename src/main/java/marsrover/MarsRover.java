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

	public void receiveCommands(String... commands) {

		for (final String command : commands) {

			if ("f".equals(command)) {
				position = planet.nextFromGoingIn(position, direction);
			}

			if ("b".equals(command)) {
				position = planet.previousFromGoingIn(position, direction);
			}

			if ("l".equals(command)) {
				direction = direction.previous();
			}

			if ("r".equals(command)) {
				direction = direction.next();
			}
		}

	}

}
