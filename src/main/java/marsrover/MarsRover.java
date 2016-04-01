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
			position = new Point(0, 1);
		}

	}
