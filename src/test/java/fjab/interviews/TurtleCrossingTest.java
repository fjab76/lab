package fjab.interviews;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alvarezf on 11/02/2016.
 */
public class TurtleCrossingTest {

	@Test
	public void crossingMoveIs0() {

		//given
		int[] A = {1};

		//when
		int crossingMove = new TurtleCrossing().move(A);

		//then
		Assert.assertEquals(0, crossingMove);
	}

	@Test
	public void crossingMoveIs4() {

		//given
		int[] A = {2,1,1,2};

		//when
		int crossingMove = new TurtleCrossing().move(A);

		//then
		Assert.assertEquals(4, crossingMove);
	}

	@Test
	public void crossingMoveIs7() {

		//given
		int[] A = {1,2,3,4,4,3,3};

		//when
		int crossingMove = new TurtleCrossing().move(A);

		//then
		Assert.assertEquals(7, crossingMove);
	}




}
