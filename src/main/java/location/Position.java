package location;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Position {

	public final Integer x;
	public final Integer y;

	Position(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public int hashCode() {
		final HashCodeBuilder b = new HashCodeBuilder();
		b.append(x);
		b.append(y);
		return b.toHashCode();
	}

	public boolean equals(Object other) {
		final Position o = (Position) other;
		final EqualsBuilder b = new EqualsBuilder();
		b.append(x, o.x);
		b.append(y, o.y);
		return b.isEquals();
	}

}