package fjab.interviews;

// you can also use imports, for example:
import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class PerfectSquare {
    public int solution(int a, int b) {
        // write your code in Java SE 8
        
        int counter = 0;
        int limit = (int) Math.sqrt(b);
        
        for(int j=1; j<=limit; j++){
            
            if(j*j >= a){
                counter++;
            }
        }
        return counter;
    }
}
