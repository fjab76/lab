package fjab.interviews;

import java.util.ArrayList;
import java.util.List;

public class NegabinaryConverter {
	
	private final static int NEGABINARY_BASE=-2;
	
	public Integer[] convertDecimalToNegabinary(int decimalNumber) {
		
		int resultWholeDivision = decimalNumber;
		int remainder = 0;
		List<Integer> result = new ArrayList<>();
		
		do{
			remainder = resultWholeDivision%NEGABINARY_BASE;
			resultWholeDivision = resultWholeDivision/NEGABINARY_BASE;			

			/*
			 * a = (-r)c + d = (-r)c + d - r + r = (-r)(c + 1) + (d + r)
			 * Because |d| < r, (d + r) is the positive remainder
			 */
			if(remainder<0){
				remainder -= NEGABINARY_BASE;
				resultWholeDivision++;
			}
			
			result.add(remainder);
			
		}while(resultWholeDivision!=0);

		return result.toArray(new Integer[0]);
	}
	
	public int convertNegabinaryToDecimal(Integer[] negabinaryRepresentation){
		
		int decimalValue = 0;
		for(int j=0; j<negabinaryRepresentation.length; j++){
			decimalValue += negabinaryRepresentation[j]*Math.pow(NEGABINARY_BASE, j);
		}
		return decimalValue;
	}

	public Integer[] calculateOppositeValue(Integer[] negabinaryRepresentation) {
		
		int decimalValue = convertNegabinaryToDecimal(negabinaryRepresentation);
		return convertDecimalToNegabinary(-decimalValue); 
	}

}
