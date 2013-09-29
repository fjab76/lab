package fjab.designpattern.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * The Composite class simply inherits ArrayList in order to gain its containment abilities.
 * 
 * @author fjab
 *
 */
public class Floor extends ArrayList<Room> implements Component {
	
	private int floorNumber;
	
	public Floor(int floorNumber){
		this.floorNumber=floorNumber;
	}

	@Override
	public void switchLightsOn() {
		
		for(Iterator<Room> it=iterator();it.hasNext();){
			it.next().switchLightsOn();
		}

	}

	@Override
	public void switchLightsOff() {
		
		for(Iterator<Room> it=iterator();it.hasNext();){
			it.next().switchLightsOff();
		}

	}

}
