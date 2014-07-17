package fjab.interviews;

// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class AdjacentCoin {
    public int solution(int[] a) {
        // write your code in Java SE 8
        
        int numCoins = a.length;
        boolean reversedCoin = false;
        
        for(int j=1;j<numCoins-1 && !reversedCoin;j++){
            
            if(a[j-1]!=a[j] && a[j]!=a[j+1]){
                reverseCoin(a,j);
                reversedCoin = true;
            }
        }
        
        //Corner cases
        if(!reversedCoin){
            if(a[0]!=a[1]){
                reverseCoin(a,0);
            }
            else if(a[numCoins-2]!=a[numCoins-1]){
                reverseCoin(a,numCoins-1);
            }
        }
        
        return countAdjacency(a);
    }
    
    private void reverseCoin(int[] a,int j){
        if(a[j]==0)
            a[j]=1;
        else
            a[j]=0;
    }
    
    private int countAdjacency(int[] a){
        
        int counter=0;
        for(int j=0;j<a.length-1;j++){
            if(a[j]==a[j+1])
                counter++;
        }
        return counter;
    }
}