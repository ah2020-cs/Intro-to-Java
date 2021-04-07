package PartII;

import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Set<E> intersection(Set<E> set2) {
		
		MathSet<E> ans = new MathSet<E>();
		for (E item : set2) {
			if (this.contains(item)) {
				ans.add(item);
			}
		}
		return ans;
	
	}
	
	public Set<E> union(Set<E> set2) {
		
		MathSet<E> ans = new MathSet<E>();
		
		for (E item : this) {
			ans.add(item);
		}
		for (E item : set2) {
			ans.add(item);
		}
		return ans;

	}
	
	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> set2) {
		
		Set<Pair<E, T>> ans = new MathSet<Pair<E, T>>();
		
		this.forEach(item1 -> {
			set2.forEach(item2 -> {
				ans.add(new Pair<E, T>(item1, item2));
			});
		});
		return ans;

	}
	
	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		
		MathSet<Integer> set1 = new MathSet<Integer>();
		set1.add(1);
		set1.add(3);
		set1.add(5);
		set1.add(7);

		MathSet<Integer> set2 = new MathSet<Integer>();
		set2.add(3);
		set2.add(5);
		set2.add(7);
		set2.add(9);
		
		System.out.println(set1.intersection(set2));
		System.out.println(set1.union(set2));
		
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		
		MathSet<Pair<Integer, String>> set3 = new MathSet<Pair<Integer, String>>();
		set3.add(new Pair<Integer, String>(1, "abc"));
		set3.add(new Pair<Integer, String>(2, "hello"));
		set3.add(new Pair<Integer, String>(3, "world"));
		set3.add(new Pair<Integer, String>(4, "pair"));
		
		System.out.println(set1.cartesianProduct(set3));
		
	}
}
