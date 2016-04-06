package location;

public interface Planet {

	Position nextFromGoingIn(Position position, Direction direction);

	Position previousFromGoingIn(Position position, Direction direction);

	boolean isObstacleAt(final Position position);
}
