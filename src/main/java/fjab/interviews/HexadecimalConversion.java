package fjab.interviews;

public class HexadecimalConversion {

	private final static int HEX_BASE=16;
	private final static String[] HEX_DIGITS = {"A","B","C","D","E","F"};
	
	public String convertDecToHex(int decimalNumber) {
		
		int resultWholeDivision = decimalNumber;
		int remainder = 0;
		StringBuilder result = new StringBuilder();
		
		do{
			
			resultWholeDivision = resultWholeDivision/HEX_BASE;
			remainder = decimalNumber%HEX_BASE;

			result.append(replaceHexDigits(remainder));
			
		}while(resultWholeDivision>=HEX_BASE);
		
		if(resultWholeDivision>0){
			result.append(replaceHexDigits(resultWholeDivision));
		}
		return result.reverse().toString();
	}

	private String replaceHexDigits(int decimalValue) {
		
		switch(decimalValue){
		
		case 10: return HEX_DIGITS[0];
		case 11: return HEX_DIGITS[1];
		case 12: return HEX_DIGITS[2];
		case 13: return HEX_DIGITS[3];
		case 14: return HEX_DIGITS[4];
		case 15: return HEX_DIGITS[5];
		default: return String.valueOf(decimalValue);
		
		}
		
	}
	
	private int replaceHexDigits(String hexValue) {
		
		if(hexValue.equals(HEX_DIGITS[0])){
			return 10;
		}
		else if(hexValue.equals(HEX_DIGITS[1])){
			return 11;
		}
		else if(hexValue.equals(HEX_DIGITS[2])){
			return 12;
		}
		else if(hexValue.equals(HEX_DIGITS[3])){
			return 13;
		}
		else if(hexValue.equals(HEX_DIGITS[4])){
			return 14;
		}
		else if(hexValue.equals(HEX_DIGITS[5])){
			return 15;
		}
		else{			
			return Integer.parseInt(hexValue);		
		}
		
	}

	public int convertHexToDec(String hexNumber) {
		
		int decNumber=0;
		int[] hexNumberArray = convertToArray(hexNumber);
		
		int placeValue=0;
		for(int j=hexNumberArray.length-1;j>=0;j--){
			
			decNumber = (int) (decNumber + hexNumberArray[j]*Math.pow(HEX_BASE, placeValue++));
		}
		
		return decNumber;
	}

	private int[] convertToArray(String hexNumber) {
		
		int[] array = new int[hexNumber.length()];
		for(int j=0;j<hexNumber.length();j++){
			array[j]=replaceHexDigits(hexNumber.substring(j, j+1));
		}
		return array;
	}

}
