public class DLinkTester {
	public static void main (String args[]){
		
		DList myList = new DList();
		DList myList2 = new DList();
		
		myList.addFirst(new DNode("A", null, null));
		myList.addLast(new DNode("B", myList.getFirst(), null));
		
		myList2.addFirst(new DNode("D", null, myList.getNext(myList.getFirst())));
		myList2.addLast(new DNode("E", myList.getFirst(), myList.getLast()));
		myList2.addLast(new DNode("F", myList.getNext(myList.getFirst()), null));
		
		System.out.println("myList: " + myList.toString() + "\n");
		System.out.println("myList2: " + myList2.toString() + "\n");
		
		
		DLinkTester.swap(myList.getFirst(), myList.getLast());
		
		System.out.println("myList after swap: " + myList.toString() + "\n");
		
		DLinkTester.concat(myList, myList2);
		
		System.out.println("myList && myList2 after concat: " + myList.toString() + "\n");
		
		
		System.out.print("myList after reverse: ");
		
		DLinkTester.reverse(myList);
		
		System.out.println(myList.toString() + "\n");

		DLinkTester.merge(myList, myList2);

		System.out.println("myList && myList2 after merge: " + myList.toString() + "\n");

	}
	//
	//
	//swap Method will swap two nodes, 
	//Precondition:
	// nodes x and y are not next to each other in the list, 
	// node x is the previous node of node y in the list, 
	// node x is the next node after node y in the list, 
	// x and y refer to the same node (in this case they should not be changed). 
	//Postcondition:
	//Nodes x and y will have swapped positions
	//
	public static void swap(DNode x, DNode y) 
	  { 	  
		  DNode previousNode1 = x.getPrev();
		  DNode nextNode1 = x.getNext();
		  
		  DNode previousNode2 = y.getPrev();
		  DNode nextNode2 = y.getNext();
		  
		  if (x.getNext() == y || y.getNext() == x)
		  {
			  previousNode1.setNext(y);
			  y.setPrev(previousNode1);
			  nextNode2.setNext(x);
			  x.setNext(nextNode2);
			  x.setPrev(y);
			  y.setNext(x);
		  }
		  
		  else 
		  {
			  y.setPrev(previousNode1);
			  y.setNext(nextNode1);
			  nextNode1.setPrev(y);
			  previousNode1.setNext(y);
			  x.setPrev(previousNode2);
			  x.setNext(nextNode2);
			  nextNode2.setPrev(x);
			  previousNode2.setNext(x);
		  } 
		  
	  } // end swap
	//
	//
	//concat Method will concatenate two linked lists
	//Precondition: 
	//DList L and DList M must not be empty
	//Postcondition:
	//L and M will have become one single concatenated linked list
	//
	public static DList concat(DList L, DList M){
	      L.addAfter(L.getLast(), M.getFirst());
	      return L;
	}
	//
	//reverse Method will reverse the nodes in a linked list
	//Precondition: DList rev must not be empty
	//Postcondition: DList rev will now be in reverse order
	//
	public static void reverse(DList rev){
		DNode start = rev.getFirst();
		DNode temp = new DNode(null, null, null);
		while(start != null){
			temp = start.getNext();
			start.setNext(start.getPrev());
			start.setPrev(temp);
			if(start.getPrev() == null){
				rev.addFirst(start);
			}
			start = start.getPrev();
		}
		
	}
	//
	//merge Method will merge two linked lists into one mixed linked list
	//Precondition: DList L, M, cannot be empty
	//Postcondition: DList L, M, will be combined as one merged linked list
	//
	public static DList merge(DList L, DList M) 
	{
		DList L2 = new DList();

		DNode next1 = L.getFirst();
		DNode next2 = M.getFirst();

		while (next1 != null && next2 != null) 
		{
			// alternately assign the current node of list2 and list1 to the
			// next node of newList
			L2.addLast(next1);
			L2.addLast(next2);

			next1 = next1.getNext();
			next2 = next2.getNext();
		} // end while

		DList longest = null;
		DNode next = null;

		if (next1 != null) 
		{
			longest = L;
			next = next1;
		}

		else if (next2 != null) 
		{
			longest = M;
			next = next2;
		}

		if (longest != null) 
		{
			while (next != null) 
			{
				L2.addLast(next);

				next.getNext();
			}
		}
		return L2;
	} // end meld

}