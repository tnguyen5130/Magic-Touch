package application;

public abstract class Position {
	public Double xPos, yPos;

	/**
	 * Construct Position
	 * @param xPos
	 * @param yPos
	 */
	public Position(Double xPos, Double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public Double getxPos() {
		return xPos;
	}

	public Double getyPos() {
		return yPos;
	}

	public void setxPos(Double xPos) {
		this.xPos = xPos;
	}

	public void setyPos(Double yPos) {
		this.yPos = yPos;
	}
}
