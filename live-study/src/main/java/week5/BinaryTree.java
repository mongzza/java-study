package week5;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;

	public BinaryTree() {
		this.root = null;
	}

	public void insert(int value) {
		root = recursiveInsert(root, value);
	}

	private Node recursiveInsert(Node current, int value) {
		if (null == current) {
			return new Node(value);
		}

		if (current.value > value) {
			current.left = recursiveInsert(current.left, value);
		} else if (current.value < value) {
			current.right = recursiveInsert(current.right, value);
		}

		return current;
	}

	public Node find(int value) {
		return recursiveFind(root, value);
	}

	private Node recursiveFind(Node current, int value) {
		if (null == current) {
			throw new IllegalArgumentException("이진 트리에 저장되어있지 않은 노드값입니다.");
		}

		if (current.value == value) {
			return current;
		}

		return current.value > value ?
				recursiveFind(current.left, value) : recursiveFind(current.right, value);
	}

	public void dfs(Node node) {
		if (null == node) {
			return;
		}

		dfs(node.left);
		System.out.println(node.value);
		dfs(node.right);
	}

	public void bfs(Node node) {
		if (null == node) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();

		queue.add(node);
		while (!queue.isEmpty()) {
			if (null != node.left) {
				queue.add(node.left);
			}
			if (null != node.right) {
				queue.add(node.right);
			}

			if (null != queue.peek()) {
				System.out.println(queue.poll().value);
				node = queue.peek();
			}
		}
	}
}
