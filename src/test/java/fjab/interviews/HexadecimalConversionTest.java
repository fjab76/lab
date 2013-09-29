package fjab.interviews;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(value = JUnit4.class)
public class HexadecimalConversionTest {

	HexadecimalConversion hexadecimalConversion = new HexadecimalConversion();
	
	@Test
	public void convertDecToHex_LessThan10(){
		
		int decimalNumber1=4;
		int decimalNumber2=9;
		
		String hexNumber1 = hexadecimalConversion.convertDecToHex(decimalNumber1);
		String hexNumber2 = hexadecimalConversion.convertDecToHex(decimalNumber2);
		
		assertEquals("4",hexNumber1);
		assertEquals("9",hexNumber2);
	}
	
	@Test
	public void convertDecToHex_LessThan16(){
		
		//edge value
		int decimalNumber1=10;
		int decimalNumber2=14;
		//edge value
		int decimalNumber3=15;
		
		String hexNumber1 = hexadecimalConversion.convertDecToHex(decimalNumber1);
		String hexNumber2 = hexadecimalConversion.convertDecToHex(decimalNumber2);
		String hexNumber3 = hexadecimalConversion.convertDecToHex(decimalNumber3);
		
		assertEquals("A",hexNumber1);
		assertEquals("E",hexNumber2);
		assertEquals("F",hexNumber3);
	}
	
	@Test
	public void convertDecToHex_LessThan33(){
		
		//edge value
		int decimalNumber1=16;
		int decimalNumber2=20;
		//edge value
		int decimalNumber3=32;
		
		String hexNumber1 = hexadecimalConversion.convertDecToHex(decimalNumber1);
		String hexNumber2 = hexadecimalConversion.convertDecToHex(decimalNumber2);
		String hexNumber3 = hexadecimalConversion.convertDecToHex(decimalNumber3);
		
		assertEquals("10",hexNumber1);
		assertEquals("14",hexNumber2);
		assertEquals("20",hexNumber3);
	}
	
	@Test
	public void convertDecToHex_LessThan257(){
		
		//edge value
		int decimalNumber1=33;
		int decimalNumber2=100;		
		//edge value
		int decimalNumber3=256;
		
		int decimalNumber4=255;
		
		String hexNumber1 = hexadecimalConversion.convertDecToHex(decimalNumber1);
		String hexNumber2 = hexadecimalConversion.convertDecToHex(decimalNumber2);
		String hexNumber3 = hexadecimalConversion.convertDecToHex(decimalNumber3);
		String hexNumber4 = hexadecimalConversion.convertDecToHex(decimalNumber4);
		
		assertEquals("21",hexNumber1);
		assertEquals("64",hexNumber2);
		assertEquals("100",hexNumber3);
		assertEquals("FF",hexNumber4);
	}
	
	@Test
	public void convertHexToDec_LessThan10(){
		
		//edge value
		String hexNumber1="4";
		String hexNumber2="8";
		//edge value
		String hexNumber3="9";
		
		int decNumber1 = hexadecimalConversion.convertHexToDec(hexNumber1);
		int decNumber2 = hexadecimalConversion.convertHexToDec(hexNumber2);
		int decNumber3 = hexadecimalConversion.convertHexToDec(hexNumber3);
		
		assertEquals(4,decNumber1);
		assertEquals(8,decNumber2);
		assertEquals(9,decNumber3);
	}
	
	@Test
	public void convertHexToDec_LessThan16(){
		
		//edge value
		String hexNumber1="A";
		String hexNumber2="C";
		//edge value
		String hexNumber3="F";
		
		int decNumber1 = hexadecimalConversion.convertHexToDec(hexNumber1);
		int decNumber2 = hexadecimalConversion.convertHexToDec(hexNumber2);
		int decNumber3 = hexadecimalConversion.convertHexToDec(hexNumber3);
		
		assertEquals(10,decNumber1);
		assertEquals(12,decNumber2);
		assertEquals(15,decNumber3);
	}
	
	@Test
	public void convertHexToDec_LessThan33(){
		
		//edge value
		String hexNumber1="10";
		String hexNumber2="14";
		//edge value
		String hexNumber3="20";
		
		int decNumber1 = hexadecimalConversion.convertHexToDec(hexNumber1);
		int decNumber2 = hexadecimalConversion.convertHexToDec(hexNumber2);
		int decNumber3 = hexadecimalConversion.convertHexToDec(hexNumber3);
		
		assertEquals(16,decNumber1);
		assertEquals(20,decNumber2);
		assertEquals(32,decNumber3);
	}
	
	@Test
	public void convertHexToDec_LessThan257(){
		
		//edge value
		String hexNumber1="21";
		String hexNumber2="64";
		//edge value
		String hexNumber3="100";
		
		String hexNumber4="FF";
		
		int decNumber1 = hexadecimalConversion.convertHexToDec(hexNumber1);
		int decNumber2 = hexadecimalConversion.convertHexToDec(hexNumber2);
		int decNumber3 = hexadecimalConversion.convertHexToDec(hexNumber3);
		int decNumber4 = hexadecimalConversion.convertHexToDec(hexNumber4);
		
		assertEquals(33,decNumber1);
		assertEquals(100,decNumber2);
		assertEquals(256,decNumber3);
		assertEquals(255,decNumber4);
	}
}
