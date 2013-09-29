package fjab.interviews;

class Solution {
    
	public int solution(int[] A) {
		
		int totalSum=0;
		int leftSum=0;
		int rightSum=0;
		
		for(int j=0;j<A.length;j++)
		{
			totalSum += A[j];
		}
		
		//j=0
		rightSum = totalSum-A[0];
		if(rightSum==0){
			return 0;
		}
		
		for(int j=1;j<A.length;j++)
		{
			leftSum += A[j-1];
			rightSum -= A[j];
			
			if(leftSum==rightSum){
				return j;
			}
		}
		
		return -1;
        
    }
	
	
	public String solution(String S) {
		
		StringBuilder sb = new StringBuilder(S);
		sb.reverse();
		return sb.toString();
    }
	
	
	public static int calculateNumCountries(int[][] A) {

		//i=0
		//j=0
		int numCountries=1;
		
		//j=1...N
		for(int j=1;j<A[0].length;j++){
			if(A[0][j]!=A[0][j-1]){
				numCountries++;
			}
		}
		
		
		//i=1...M
		for(int i=1;i<A.length;i++){
			
			//j=0
			if(A[i][0]!=A[i-1][0]){
				
				if(A[i][0]!=A[i][1] || A[i][0]!=A[i-1][1]){
					numCountries++;
				}				
			}
			
			//j=1...N-1
			for(int j=1;j<A[i].length-1;j++){
				if(A[i][j]!=A[i][j-1] && A[i][j]!=A[i-1][j]){
					
					if(A[i][j]!=A[i][j+1] || A[i][j]!=A[i-1][j+1]){
						numCountries++;
					}
				}
			}
			//j=N
			if(A[i][A[i].length-1]!=A[i][A[i].length-1-1] && A[i][A[i].length-1]!=A[i-1][A[i].length-1]){
				numCountries++;
			}
		}
		
		return numCountries;
        
    }
	
	
	public static int prefixSufix(String s) {
		
		int longestLength=0;

		for(int j=0;j<s.length();j++){
			String prefix = s.substring(0,j);
			String sufix = s.substring(s.length()-j,s.length());
			if(prefix.equals(sufix)){
				longestLength=prefix.length();
			}
		}
		
		return longestLength;

    }
	
	public static void main(String args[]){
		System.out.println(prefixSufix("etemetem"));
		
		int countries[][] = {{5,4,4},{4,3,4},{3,2,4},{2,2,2},{3,3,4},{1,4,4},{4,1,1}};
		System.out.println(calculateNumCountries(countries));
		
		int countries2[][] = {{5,3,3,5},{5,1,4,1},{5,2,4,4}};
		System.out.println(calculateNumCountries(countries2));
	}
}