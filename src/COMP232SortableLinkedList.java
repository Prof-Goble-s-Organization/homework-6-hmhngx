/**
 * A sortable DoublyLinkedList.  The fields and the DLLNode class in the
 * COMP232DoublyLinkedList class are protected fields and can be accessed
 * directly in this class.
 * 
 * @author William Goble
 * @author Dickinson College
 * 
 */
public class COMP232SortableLinkedList<E extends Comparable<E>> extends COMP232DoublyLinkedList<E> {

	/**
	 * Implementation of insertion sort for the LinkedList. The elements of the
	 * list will be sorted according to the order imposed by their compareTo
	 * method.
	 */
	public void insertionSortList() {
		if (head.next == tail || head.next.next == tail) {
			return;  
		}

		DLLNode<E> curr = head.next.next; 

		while(curr != tail) {
			DLLNode<E> keyNode = curr;
			DLLNode<E> compareNode = curr.prev;

			while(compareNode != head && keyNode.element.compareTo(compareNode.element) < 0) {
				E temp = compareNode.element;
				compareNode.element = keyNode.element;
				keyNode.element = temp;

				keyNode = compareNode;
				compareNode = compareNode.prev;
			}
			curr = curr.next;

		}

	}
}
