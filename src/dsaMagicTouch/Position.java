package dsaMagicTouch;

public abstract class Position {
	public Float xPos, yPos;

	/**
	 * Construct Position
	 * @param xPos
	 * @param yPos
	 */
	public Position(Float xPos, Float yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public Float getxPos() {
		return xPos;
	}

	public Float getyPos() {
		return yPos;
	}

	public void setxPos(Float xPos) {
		this.xPos = xPos;
	}

	public void setyPos(Float yPos) {
		this.yPos = yPos;
	}
}
