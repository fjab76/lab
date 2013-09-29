package fjab.designpattern.composite;

public class Room implements Component {

	private boolean lightsOn = false;
	private int roomNumber;
	
	public Room(int roomNumber){
		this.roomNumber=roomNumber;
	}
	
	@Override
	public void switchLightsOn() {
		setLightsOn(true);

	}

	@Override
	public void switchLightsOff() {
		setLightsOn(false);

	}

	public boolean isLightsOn() {
		return lightsOn;
	}

	public void setLightsOn(boolean on) {
		this.lightsOn = on;
	}

}
