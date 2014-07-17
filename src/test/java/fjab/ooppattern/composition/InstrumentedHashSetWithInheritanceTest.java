package fjab.ooppattern.composition;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InstrumentedHashSetWithInheritanceTest {
	
	private InstrumentedHashSetWithInheritance instrumentedHashSet;
	
	@Before
	public void initialise(){
		instrumentedHashSet = new InstrumentedHashSetWithInheritance();
	}

	@Test
	public void countIs3(){
		
		instrumentedHashSet.addAll(Arrays.asList(new String[] {"Snap","Crackle","Pop"}));
		
		assertEquals(3,instrumentedHashSet.getAddCount());
	}
}
