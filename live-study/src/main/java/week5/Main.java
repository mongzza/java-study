package week5;

public class Main {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int[] values = new int[] {6, 4, 8, 3, 5, 7, 9};
		for (int value : values) {
			binaryTree.insert(value);
		}

		binaryTree.dfs(binaryTree.find(6));
		binaryTree.dfs(binaryTree.find(3));
		//binaryTree.dfs(binaryTree.find(10));

		binaryTree.bfs(binaryTree.find(6));
		binaryTree.bfs(binaryTree.find(3));
		//binaryTree.bfs(binaryTree.find(10));
	}
}
