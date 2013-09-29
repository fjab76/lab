package fjab.designpattern.singleton;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void singleton(){
		
		SingletonEarlyInstantiation singleton = SingletonEarlyInstantiation.getInstance();
		
		assertThat(singleton, instanceOf(SingletonEarlyInstantiation.class));
	}
}
