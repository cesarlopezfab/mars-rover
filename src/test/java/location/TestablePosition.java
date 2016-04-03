package location;

class TestablePosition extends Position {

	TestablePosition(final Integer x, final Integer y) {
		super(x, y);
	}

	public String toString() {
		return "x: " + x + " y: " + y;
	}

}