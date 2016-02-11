package fjab.interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alvarezf on 11/02/2016.
 */
public class TurtleCrossing {

	private static final int N = 100_000;

	int move(int[] a) {

		Map<Position,Boolean> positions = new HashMap<>();
		positions.put(new Position(0,0),true);
		Position currentPosition = new Position(0,0);


		for(int j=0; j<a.length; j++) {
			if(j%4==0){
				//recording intermediate positions
				for(int i=1;i<=a[j];i++){
					if(positions.put(new Position(currentPosition.x,currentPosition.y+i),true)!=null){
						return j+1;
					}
				}
				currentPosition.y += a[j];
			}
			else if(j%4==1){
				//recording intermediate positions
				for(int i=1;i<=a[j];i++){
					if(positions.put(new Position(currentPosition.x+i,currentPosition.y),true)!=null){
						return j+1;
					}
				}
				currentPosition.x += a[j];
			}
			else if(j%4==2){
				//recording intermediate positions
				for(int i=1;i<=a[j];i++){
					if(positions.put(new Position(currentPosition.x,currentPosition.y-i),true)!=null){
						return j+1;
					}
				}
				currentPosition.y -= a[j];
			}
			else {
				//recording intermediate positions
				for(int i=1;i<=a[j];i++){
					if(positions.put(new Position(currentPosition.x-i,currentPosition.y),true)!=null){
						return j+1;
					}
				}
				currentPosition.x -= a[j];
			}
		}

		return 0;
	}

	private class Position {

		private int x;
		private int y;

		Position(int x, int y){
			this.x=x;
			this.y=y;
		}


		@Override
		public String toString() {
			return x+","+y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Position position = (Position) o;

			if (x != position.x) return false;
			return y == position.y;

		}

		@Override
		public int hashCode() {
			int result = x;
			result = 31 * result + y;
			return result;
		}
	}
}
