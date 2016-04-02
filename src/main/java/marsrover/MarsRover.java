package marsrover;

import location.Direction;
import location.Position;

public class MarsRover {

	Direction direction;
	Position position;

	MarsRover(final Position position, final Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public void receiveCommands(String... commands) {

		for (final String command : commands) {

			if ("f".equals(command)) {
				position = position.nextPositionIn(direction);
			}

			if ("b".equals(command)) {
				position = position.previousPositionIn(direction);
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
