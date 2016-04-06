package marsrover;

import location.Position;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ObstacleDetection {

	@Around("execution(@marsrover.MovementCommand * *(..))")
	public Object detectObstacle(final ProceedingJoinPoint joinPoint) throws Throwable {
		final MarsRover marsRover = (MarsRover) joinPoint.getArgs()[0];
		final Position previous = marsRover.position;

		joinPoint.proceed();

		if (marsRover.planet.isObstacleAt(marsRover.position)) {
			marsRover.detectedObstacles.add(marsRover.position);
			marsRover.position = previous;
		}

		return marsRover;
	}

}
