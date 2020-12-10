package dataStructure;

public class ListNode {
	private int position;
	private ListNode next;

	public ListNode(int position) {
		this.position = position;
		this.next = null;
	}

	public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
		if (head == null) {
			head = nodeToAdd;
			return head;
		}

		ListNode root = head;
		while (head.next != null) {
			head = head.next;
		}
		nodeToAdd.position = position;
		head.next = nodeToAdd;
		return root;
	}

	public ListNode remove(ListNode head, int positionToRemove) {
		if (head == null) {
			return null;
		}

		if (head.position == positionToRemove) {
			head = head.next;
			return head;
		}

		ListNode root = head;
		ListNode prev = head;
		while (head.next != null) {
			if (head.position == positionToRemove) {
				prev.next = head.next;
				break;
			}
			prev = head;
			head = head.next;
		}
		return root;
	}

	public boolean contains(ListNode head, ListNode nodeTocheck) {
		while (head != null) {
			if (head.equals(nodeTocheck)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ListNode listNode = (ListNode) o;

		return position == listNode.position;
	}

	@Override
	public int hashCode() {
		return position;
	}
}
