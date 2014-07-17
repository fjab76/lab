package fjab.ooppattern.composition;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Wrapper class, uses Composition in place of Inheritance
public class InstrumentedSetWithComposition implements Set {
	
	// The number of attempted element insertions
	private int addCount = 0;
	
	//It is possible to inject different implementations of Set (HashSet, TreeSet) during run time and therefore, change the behaviour
	private final Set set;
	
	public InstrumentedSetWithComposition(Set set) {
		this.set = set;
	}
	
	
	public int getAddCount() {
		return addCount;
	}
	
	//====== OVERRIDDEN METHODS
	//Overriding some methods to add extra functionality
	@Override
	public boolean add(Object o) {
		addCount++;
		return set.add(o);
	}
	
	@Override
	public boolean addAll(Collection c) {
		addCount += c.size();
		return set.addAll(c);
	}
	
	//======= FORWARDING METHODS
	/*
		Each instance method in the class invokes the corresponding method on
		the contained instance and returns the results. This is known as
		forwarding, and the methods in the new class are known as forwarding methods		
	 */

	@Override
	public int size() {
		return set.size();
	}



	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}



	@Override
	public boolean contains(Object o) {
		return set.contains(o);
	}



	@Override
	public Iterator iterator() {
		return set.iterator();
	}



	@Override
	public Object[] toArray() {
		return set.toArray();
	}



	@Override
	public Object[] toArray(Object[] a) {
		return set.toArray(a);
	}



	@Override
	public boolean remove(Object o) {
		return set.remove(o);
	}



	@Override
	public boolean containsAll(Collection c) {
		return set.containsAll(c);
	}



	@Override
	public boolean retainAll(Collection c) {
		return set.retainAll(c);
	}



	@Override
	public boolean removeAll(Collection c) {
		return set.removeAll(c);
	}



	@Override
	public void clear() {
		set.clear();
		
	}

}
