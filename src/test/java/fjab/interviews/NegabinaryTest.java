package fjab.interviews;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NegabinaryTest {
	
	private NegabinaryConverter converter;

	@Before
	public void setUp() throws Exception {
		converter = new NegabinaryConverter();
	}

	@Test
	public void testDecimal4() {
		
		//given
		int decimalRepresentation = 4;
		
		//when
		Integer[] negabinaryRepresentation = converter.convertDecimalToNegabinary(decimalRepresentation);
		
		//then
		assertArrayEquals(new Integer[]{0,0,1},negabinaryRepresentation);
	}
	
	@Test
	public void testDecimal9() {
		
		//given
		int decimalRepresentation = 9;
		
		//when
		Integer[] negabinaryRepresentation = converter.convertDecimalToNegabinary(decimalRepresentation);
		
		//then
		assertArrayEquals(new Integer[]{1,0,0,1,1},negabinaryRepresentation);
	}
	
	@Test
	public void testDecimalMinus9() {
		
		//given
		int decimalRepresentation = -9;
		
		//when
		Integer[] negabinaryRepresentation = converter.convertDecimalToNegabinary(decimalRepresentation);
		
		//then
		assertArrayEquals(new Integer[]{1,1,0,1},negabinaryRepresentation);
	}
	
	@Test
	public void testNegabinary9() {
		
		//given
		Integer[] negabinaryRepresentation = {1,0,0,1,1};
		
		//when
		int decimalValue = converter.convertNegabinaryToDecimal(negabinaryRepresentation);
		
		//then
		assertEquals(9,decimalValue);
	}
	
	@Test
	public void testNegabinaryMinus9() {
		
		//given
		Integer[] negabinaryRepresentation = {1,1,0,1};
		
		//when
		int decimalValue = converter.convertNegabinaryToDecimal(negabinaryRepresentation);
		
		//then
		assertEquals(-9,decimalValue);
	}
	
	@Test
	public void testCalculateOppositeValueOf9() {
		
		//given
		Integer[] negabinaryRepresentation = {1,0,0,1,1};
		
		//when
		Integer[] negabinaryRepresentationOfOpposite = converter.calculateOppositeValue(negabinaryRepresentation);
		
		//then
		assertArrayEquals(new Integer[]{1,1,0,1},negabinaryRepresentationOfOpposite);
	}
	
	@Test
	public void testCalculateOppositeValueOfMinus23() {
		
		//given
		Integer[] negabinaryRepresentation = {1,0,0,1,1,1};
		
		//when
		Integer[] negabinaryRepresentationOfOpposite = converter.calculateOppositeValue(negabinaryRepresentation);
		
		//then
		assertArrayEquals(new Integer[]{1,1,0,1,0,1,1},negabinaryRepresentationOfOpposite);
	}

}
