package marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

    // rover.isFacing(NORTH);

    @Test
    public void marsRoverStartsAtPointXYFacingDirection() {
        final String direction = "N";
        final Point point = new Point(0, 0);
        MarsRover rover = new MarsRover(point, direction);

        assertEquals(point, rover.position);
        assertEquals(direction, rover.direction);
    }

    public class MarsRover {
        private final String direction;
        private final Point position;

        public MarsRover(Point position, String direction) {
            this.position = position;
            this.direction = direction;

        }
    }

    public class Point {
        final Integer x;
        final Integer y;

        Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }
}
