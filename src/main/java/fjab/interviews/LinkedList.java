package fjab.interviews;

// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class LinkedList {
    public int solution(int[] a) {
        // write your code in Java SE 8
        
        int counter = 1;
        int next=a[0];
        
        while(next!=-1){
            next = a[next];
            counter++;
        }
        
        return counter;
    }
}