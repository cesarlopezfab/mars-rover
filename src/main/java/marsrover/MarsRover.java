package marsrover;

import location.Point;

public class MarsRover {

		final String direction;
		Point position;

		public MarsRover(final Point position, final String direction) {
			this.position = position;
			this.direction = direction;
		}

		public void receiveCommands(String... commands) {
			if ("N".equals(direction)) {
				position = new Point(position.x, position.y + 1);
			}

			if ("S".equals(direction)) {
				position = new Point(position.x, position.y - 1);
			}
		}

	}
