package model;

public class Direction {

	private String type = "Direction";
	private int direction;
	
	public Direction(int direction) {
		
		this.direction = direction;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
}
