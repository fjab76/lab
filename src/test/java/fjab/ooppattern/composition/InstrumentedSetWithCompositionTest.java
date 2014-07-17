package fjab.ooppattern.composition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentedSetWithCompositionTest {
	
	private InstrumentedSetWithComposition instrumentedSet;
	
	@Before
	public void initialise(){
		Set s = new HashSet();
		instrumentedSet = new InstrumentedSetWithComposition(s);
	}

	@Test
	public void countIs3(){
		
		instrumentedSet.addAll(Arrays.asList(new String[] {"Snap","Crackle","Pop"}));
		
		assertEquals(3,instrumentedSet.getAddCount());
	}
}
