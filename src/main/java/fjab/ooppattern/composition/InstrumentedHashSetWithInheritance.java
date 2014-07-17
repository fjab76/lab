package fjab.ooppattern.composition;

import java.util.Collection;
import java.util.HashSet;

/*
  This implementation does not work as it can be checked by running the unit test. It does not work because internally, HashSet's addAll 
  method is implemented on top of its add method, although HashSet, quite reasonably, does not document this implementation detail. This makes
  that the addCount attribute is twice the value it should be.
  
  This is a case of WRONG USE OF INHERITANCE and illustrates how inheritance breaks encapsulation as the subclasses are dependent on the
  implementation of the superclass
  
  In this case, it is safer to use Composition
 
*/
public class InstrumentedHashSetWithInheritance extends HashSet {
	
	// The number of attempted element insertions
	private int addCount = 0;
	
	public InstrumentedHashSetWithInheritance() {
	}
	
	public InstrumentedHashSetWithInheritance(Collection c) {
		super(c);
	}
	
	public InstrumentedHashSetWithInheritance(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}
	
	public boolean add(Object o) {
		addCount++;
		return super.add(o);
	}
	
	public boolean addAll(Collection c) {
		addCount += c.size();
		return super.addAll(c);
	}
	
	public int getAddCount() {
		return addCount;
	}

}
