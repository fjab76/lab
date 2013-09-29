package fjab.designpattern.composite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CompositeTest {

	private Building building;
	
	@Before
	public void createBuildingWithLigthsOff(){
		
		building = new Building();
		
		//1st floor
		Floor floor = new Floor(1);
		floor.add(new Room(11));
		floor.add(new Room(12));
		building.add(floor);
		
		//2nd floor
		floor = new Floor(2);
		floor.add(new Room(21));
		floor.add(new Room(22));
		floor.add(new Room(23));
		building.add(floor);
		
		//3rd floor
		floor = new Floor(3);
		floor.add(new Room(31));
		floor.add(new Room(32));
		floor.add(new Room(33));
		building.add(floor);
		
	}
	
	
	@Test
	public void buildingLightsAreOff(){
		
		for(Floor floor : building){
			for(Room room : floor){
				assertEquals(false,room.isLightsOn());
			}
		}
	}
	
	@Test
	public void buildingLightsAreOn(){

		building.switchLightsOn();
		
		for(Floor floor : building){
			for(Room room : floor){
				assertEquals(true,room.isLightsOn());
			}
		}
	}
}
