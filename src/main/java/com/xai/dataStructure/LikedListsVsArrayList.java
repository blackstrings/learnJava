package com.xai.dataStructure;

/**
 * <p>http://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist</p>
 *<p>
 * For LinkedList<E>
 * Basically use to go forward and backward, but finding an inbetween element takes O(n)
	get(int index) is O(n)
	add(E element) is O(1)
	add(int index, E element) is O(n)
	remove(int index) is O(n)
	Iterator.remove() is O(1) <--- main benefit of LinkedList<E>
	ListIterator.add(E element) is O(1) <--- main benefit of LinkedList<E>
	</p>
	
	
	<p>
	For ArrayList<E>
	Bottom line, arrayList is usually faster in most case, so go with arrayList vs linked list and vector
	Good for write once and read, multiple writes in front back and in between in a very large list will be O(n) = slow
	Basically allows fast random access to any element O(1) but adding or removing anywhere takes time
	Inserting over the size limit will create a new array 1.5x the original size and copy over the old one to new O(n)
	get(int index) is O(1) <--- main benefit of ArrayList<E>
	add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
	add(int index, E element) is O(n - index) amortized, but O(n) worst-case (as above)
	remove(int index) is O(n - index) (i.e. removing last is O(1))
	Iterator.remove() is O(n - index)
	ListIterator.add(E element) is O(n - index)
	</p>
 *
 */
public class LikedListsVsArrayList {

	public static void main(String [] args){
		
		
		
	}
}
