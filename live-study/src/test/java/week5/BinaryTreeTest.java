package week5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

	private BinaryTree tree;

	@BeforeEach
	void setUp() {
		tree = new BinaryTree();
		int[] values = new int[] {5, 8, 10, 3, 7, 4};
		for (int value : values) {
			tree.insert(value);
		}
	}

	@DisplayName("추가한 노드 확인하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"5:5", "8:8", "10:10"}, delimiter = ':')
	void testFindInBinaryTree(int value, int actual) {
		assertEquals(tree.find(value).value, actual);
	}

	@DisplayName("추가하지 않은 노드 예외처리 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 6, 100})
	void testFindNotInBinaryTree(int value) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> tree.find(value));
		String message = exception.getMessage();
		assertEquals("이진 트리에 저장되어있지 않은 노드값입니다.", message);
	}

	@DisplayName("중위순회 DFS 테스트")
	@Test
	void testDfs() {
		tree.dfs(tree.find(5));
	}

	@DisplayName("BFS 테스트")
	@Test
	void testBfs() {
		tree.bfs(tree.find(5));
	}
}
