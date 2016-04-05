package location;

public interface Planet {

	Position nextFromGoingIn(Position position, Direction direction);

	Position previousFromGoingIn(Position position, Direction direction);

	void addObstacle(Position position);

	boolean hasNoObstacle(final Position position);
}
