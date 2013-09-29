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
public class Building extends ArrayList<Floor> implements Component{

	@Override
	public void switchLightsOn() {
		
		for(Iterator<Floor> it=iterator();it.hasNext();){
			it.next().switchLightsOn();
		}

	}

	@Override
	public void switchLightsOff() {
		
		for(Iterator<Floor> it=iterator();it.hasNext();){
			it.next().switchLightsOff();
		}

	}

}
