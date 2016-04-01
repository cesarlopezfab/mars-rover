package marsrover;

import location.Direction;
import location.Point;

public class MarsRover {

	Direction direction;
	Point position;

	MarsRover(final Point position, final Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public void receiveCommands(String... commands) {

		for (final String command : commands) {

			if ("f".equals(command)) {
				position = position.nextPointIn(direction);
			}

			if ("b".equals(command)) {
				position = position.previousPointIn(direction);
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
