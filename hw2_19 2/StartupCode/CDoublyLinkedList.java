public class CDoublyLinkedList {

	private class Node {
		private Object data;   //Assume data implemented Comparable
		private Node next, prev;
		private Node(Object data, Node pref, Node next)
		{
			this.data = data;
			this.prev = pref;
			this.next = next;
		}
	}

	private Node head;
	private int size;

	public CDoublyLinkedList() {
		this.head = new Node(null, null, null );
		this.head.next = this.head;
		this.head.prev=this.head;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.head == this.head.next;
	} 
	
	// Add Object data to start of this LinkedList
	// Please DO NOT change this addFirst() method.
	// You must keep and include this provided addFirst() method
	//      in your source code.
	public void addFirst(Object data) {
		Node nn = new Node(data, this.head, this.head.next);
		this.head.next.prev = nn;
		this.head.next = nn;
		this.size ++;
	}

	// write a method void addLast(Object data) that will insert 
	// the piece of data at the end of the current list.
	// Note: this list is allowed to store null data element in its list node.
	public void addLast(Object data) {
		Node cur = this.head.next;
		while(cur.next != this.head) {
			cur = cur.next;
		}
		Node nn = new Node(data, cur, cur.next);
		cur.next.prev = nn;
		cur.next = nn;
		this.size++;
	}
	
	// Write the subListOfSmallerValues method.  
	// It should return a CDoublyLinkedList object 
	//     containing data that is smaller than the value passed to the method.
        // If a null data element in this list is encountered, you can skip it.
        // You need to use the CompareTo() method to determine which object is smaller.
        // If list A contains {9, 11, 14, 6, 4, 7} and you call  A.subListOfSmallerValues(10),
        // the method call returns a list that contains data in A that is smaller than 10, the passed-in argument.
        // That is, the returned list contains { 9, 6, 4, 7}.
	public CDoublyLinkedList subListOfSmallerValues(Comparable data) {
		Node cur = this.head.next;
		CDoublyLinkedList newList = new CDoublyLinkedList();
		while(cur != this.head) {
			if (data.compareTo((Comparable)cur.data ) > 0) {
				newList.addLast(cur.data);
			}
			cur = cur.next;
		}
	
		return newList; //change this as needed.
	}
	
	// This method should remove the first occurrence of the data from the list, 
        //      starting at the *BACK* of the list. 
        // It scans the list from back to the front by following the prev links. 
	// The method should return true if successful, false otherwise. 
	// Note that list node may contain null data element. Please handle this edge case.
	public boolean removeStartingAtBack(Object dataToRemove) {

		for (Node cur = this.head.prev; cur != this.head; cur = cur.prev) {

			if (cur.data == null ? dataToRemove == null : cur.data.equals(dataToRemove)){
				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
				this.size--;
				return true;
			}
		}
		return false;//change this as needed.
	}
	
	// Returns the index of the last occurrence of the specified element in this list, 
	//     or -1 if this list does not contain the element. 
	// More formally, returns the highest index i 
	//     such that (o==null ? get(i)==null : o.equals(get(i))), 
	//     or -1 if there is no such index.
	// Note: a list node may store a null data element. Please handle this edge case.
	public int lastIndexOf(Object o) {
		Node cur = this.head.prev;
		int i = this.size -1;
		while(cur != this.head) {
			if (o == null ? cur.data == null : cur.data.equals(o)) {
				return i;
			}
			cur = cur.prev;
			i--;
		}
		return -1;
	}

	public boolean contains(Object other) {

		for(Node cur = this.head.next; cur != this.head; cur = cur.next) {
			if(cur.data == null && other == null) {
				return true;
			}
			else if(other.equals(cur.data)) {
				return true;
			}
		}
		return false;
	}

	
	
	// Removes from this list all of its elements that 
	//    are NOT contained in the specified linkedlist other.
	// If any element has been removed from this list,
	//    returns true. Otherwise returns false.
	// If other list is null, throws NullPointerException.
        // Helper methods are allowed.
	public boolean retainAll(CDoublyLinkedList other) throws NullPointerException {
		if (other == null) {
			throw new NullPointerException("null");
		}
		Node cur = this.head.next;
		boolean ret = false;
		while (cur != this.head) {
			if (!(other.contains(cur.data))) {
				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
				this.size--;
				ret = true;
			}
			cur = cur.next;
		}

	    return ret; //change this as needed.
	}
	

        // Write this method to sort this list using insertion sort algorithm, 
        //      as we have learned in the classroom.
	public void insertionSort() {
		Node ls = this.head.next;
		Node sw;
		Comparable fud;
		while(ls != this.head.prev) {
			fud = (Comparable) ls.next.data;
			for (sw = ls; sw != this.head && ((Comparable) sw.data).compareTo(fud) > 0; sw = sw.prev) {
				sw.next.data = sw.data;
			}
			sw.next.data = fud;
			ls = ls.next;
		}
	}
	
	@Override
	public String toString() {
		String result = "{";
	    for (Node node = this.head.next; node != this.head; node = node.next) {
	    		if(node.next != this.head)
	    			result += node.data + "->"; 
	    		else
	    			result += node.data;
	    }
	    return result + "}";
	  }
}
			