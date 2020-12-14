package week4.dataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week4.dataStructure.ListNode;

import static org.junit.jupiter.api.Assertions.*;

public class ListNodeTest {
	private final ListNode headNode = new ListNode(1);

	@BeforeEach
	public void setUp() {
		for (int i = 2; i <= 5; i++) {
			headNode.add(headNode, new ListNode(i), i);
		}
	}

	@DisplayName("ListNode add 테스트")
	@Test
	public void testAdd() {
		headNode.add(headNode, new ListNode(8), 8);
		headNode.add(headNode, new ListNode(9), 9);

		assertAll("ListNode.add() result",
				() -> assertTrue(headNode.contains(headNode, new ListNode(8))),
				() -> assertTrue(headNode.contains(headNode, new ListNode(9))),
				() -> assertFalse(headNode.contains(headNode, new ListNode(100))));
	}

	@DisplayName("ListNode remove 테스트")
	@Test
	public void testRemove() {
		headNode.remove(headNode, 1);
		headNode.remove(headNode, 3);
		headNode.remove(headNode, 4);

		assertAll("ListNode.remove() result",
				() -> assertFalse(headNode.contains(headNode, new ListNode(1))),
				() -> assertFalse(headNode.contains(headNode, new ListNode(3))),
				() -> assertFalse(headNode.contains(headNode, new ListNode(4))));

	}
}
