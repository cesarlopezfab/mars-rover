package location;

public class CircularPlanet extends TwoDimensionsInfinitePlanet {

	private final int size;

	public CircularPlanet(final int planetEquatorSize) {
		size = planetEquatorSize;
	}

	protected Position sum(final Position position, final Delta delta) {
		Position pos = super.sum(position, delta);
		int x = pos.x;
		int y = pos.y;

		if (x > size) {
			x = x - size;
		}

		if (y > size) {
			y = y - size;
		}
		return new TestablePosition(x, y);
	}

}
