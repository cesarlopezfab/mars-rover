package marsrover;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ObstacleDetection {

	@Around(value = "@annotation(annotation)")
	public Object detectObstacle(final ProceedingJoinPoint joinPoint, final MovementCommand annotation) throws Throwable {
		System.out.println("eeyy!!!");
		final MarsRover marsRover = (MarsRover) joinPoint.getArgs()[0];
		if (marsRover.planet.hasNoObstacle(marsRover.position)) {
			final Object retVal = joinPoint.proceed();
		}

		return marsRover;
	}
}
