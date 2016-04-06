package marsrover;

import location.Direction;
import location.Planet;
import location.Position;

import java.util.HashSet;
import java.util.Set;

public class MarsRover {

	Direction direction;
	Position position;
	final Planet planet;
	final Set<Position> detectedObstacles = new HashSet<Position>();

	MarsRover(final Planet planet, final Position position, final Direction direction) {
		this.position = position;
		this.direction = direction;
		this.planet = planet;
	}

	public void executeCommands(final Command... commands) {

		for (final Command command : commands) {
			command.execute(this);
		}

	}

}
