package test.java.com.mypackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import main.java.com.mypackage.AVLTree;
import main.java.com.mypackage.AVLTree.Node;

public class AVLTreeTest {

	@Test
	public void testFind() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 10, 20, 30, 40, 50, 25 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}
		assertEquals(tree.find(60), null);
	}

	@Test
	public void testFind2() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 11, 22, 33, 44, 55, 26 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}
		assertEquals(tree.find(80), null);
	}

	@Test
	public void testFind3() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 9, 19, 29, 39, 49, 24 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}
		assertNotNull(tree.find(9));

	}

	@Test
	public void testFind4() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 9, 29, 39, 49, 24, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}
		assertNotNull(tree.find(22));

	}

	@Test
	public void testFind5() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 9, 19, 29, 39, 49, 24, 23, 25, 26, 27, 28, 30, 31, 32, 33, 34, 35, 36, 37, 38 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}
		assertEquals(tree.find(90), null);

	}

	@Test
	public void testFind6() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		AVLTree tree = new AVLTree();
		assertEquals(tree.find(9050), null);

	}

	@Test
	public void testRoot() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 100, 200, 300, 400, 500, 250 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}
		assertEquals(tree.getRoot(), tree.find(300));
	}

	@Test
	public void testRoot2() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 1001, 2001, 3001, 4001, 5001, 2501 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}
		assertEquals(tree.getRoot(), tree.find(3001));
	}

	@Test
	public void testTreeHeight() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 1000, 2000, 3000, 4000, 5000, 2500 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}

		assertEquals(tree.height(), 2);
	}

	@Test
	public void testTreeInsert() {

		AVLTree tree = new AVLTree();
		tree.insert(5);

		assertNotNull(tree.find(5));
	}

	@Test
	public void testTreeInsert2() {

		AVLTree tree = new AVLTree();
		tree.insert(5);

		assertEquals(tree.find(10), null);
	}

	@Test
	public void testTreeDelete() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 10, 20, 30, 40, 50, 25 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}
		tree.delete(10);
		assertEquals(tree.find(10), null);
	}

	@Test
	public void testTreeDelete2() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 1032, 2032, 3032, 4032, 5032, 2532 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}
		tree.delete(33);
		assertEquals(tree.find(33), null);
	}

	@Test
	public void testTreeBalance() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 120, 220, 320, 420, 520, 250 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}

		assertEquals(tree.getBalance(tree.find(30)), 0);
	}

	@Test
	public void testTreeBalance2() {
		// this array in this order allows to pass in all branches
		// of the insertion algorithm
		int[] array = { 110, 220, 330, 440, 550, 250 };
		AVLTree tree = new AVLTree();

		for (int i = 0; i < array.length; i++) {
			tree.insert(array[i]);
		}

		assertEquals(tree.getBalance(tree.find(60)), 0);
	}

}

/*
 * public class AVLTreeTests {
 * 
 * @Test public public void testInsertToEmptyTree() { AvlTree t1 = new
 * AvlTree(); t1.insert(1); Assert.assertEquals(1, t1.mRoot.mValue); }
 * 
 * @Test public public void testEqualsItself() { AvlTree t1 = new AvlTree();
 * Assert.assertEquals(t1, t1); }
 * 
 * @Test public public void testNotEqualNotAvlInstance() { AvlTree t1 = new
 * AvlTree(); Object object = new Object(); Assert.assertNotEquals(t1, object);
 * }
 * 
 * @Test public public void testEmptyEqual() { AvlTree t1 = new AvlTree();
 * AvlTree t2 = new AvlTree(); Assert.assertEquals(t1, t2); }
 * 
 * @Test public public void testFirstEmpty() { AvlTree t1 = new AvlTree();
 * AvlTree t2 = new AvlTree(1); Assert.assertNotEquals(t1, t2); }
 * 
 * @Test public public void testSecondEmpty() { AvlTree t1 = new AvlTree(1);
 * AvlTree t2 = new AvlTree(); Assert.assertNotEquals(t1, t2); }
 * 
 * @Test public public void testRootsEqual() { AvlTree t1 = new AvlTree(1);
 * AvlTree t2 = new AvlTree(1); Assert.assertEquals(t1, t2); }
 * 
 * @Test public public void testRootAndLeftEqual() { AvlTree t1 = new
 * AvlTree(10); t1.insert(2); AvlTree t2 = new AvlTree(10); t2.insert(2);
 * Assert.assertEquals(t1, t2); }
 * 
 * @Test public public void testRootAndRightEqual() { AvlTree t1 = new
 * AvlTree(1); t1.insert(2); AvlTree t2 = new AvlTree(1); t2.insert(2);
 * Assert.assertEquals(t1, t2); }
 * 
 * @Test public public void testRootsEqual_LeftsNotEqual() { AvlTree t1 = new
 * AvlTree(10); t1.insert(2); AvlTree t2 = new AvlTree(10); t2.insert(1);
 * Assert.assertNotEquals(t1, t2); }
 * 
 * @Test public public void testRootsEqual_RightsNotEqual() { AvlTree t1 = new
 * AvlTree(1); t1.insert(2); AvlTree t2 = new AvlTree(1); t2.insert(4);
 * Assert.assertNotEquals(t1, t2); }
 * 
 * @Test public public void testEmptyTreeHashCode() { AvlTree t1 = new
 * AvlTree(); Assert.assertEquals(0, t1.hashCode()); }
 * 
 * @Test public public void testEqualTreesEqualHashCodes() { AvlTree t1 = new
 * AvlTree(10); t1.insert(2, 12); AvlTree t2 = new AvlTree(10); t2.insert(2,
 * 12); Assert.assertEquals(t1.hashCode(), t2.hashCode()); }
 * 
 * @Test public public void testToStringEmpty() { AvlTree t1 = new AvlTree();
 * Assert.assertEquals("[]", t1.toString()); }
 * 
 * @Test public public void testToStringSingleNode() { AvlTree t1 = new
 * AvlTree(1); Assert.assertEquals("[1]", t1.toString()); }
 * 
 * @Test public public void testToStringManyNodes() { AvlTree t1 = new
 * AvlTree(1); t1.insert(12, 56, 7, 2, 1);
 * Assert.assertEquals("[1, 1, 2, 7, 12, 56]", t1.toString()); }
 * 
 * @Test public public void testSingleRotateLeft() { AvlTree t1 = new
 * AvlTree(10); t1.insert(14, 56); Assert.assertEquals(t1.mRoot.mValue, 14);
 * Assert.assertEquals(t1.mRoot.mLeft.mValue, 10);
 * Assert.assertEquals(t1.mRoot.mRight.mValue, 56); }
 * 
 * @Test public public void testSingleRotateRight() { AvlTree t1 = new
 * AvlTree(10); t1.insert(2, 1); Assert.assertEquals(t1.mRoot.mValue, 2);
 * Assert.assertEquals(t1.mRoot.mLeft.mValue, 1);
 * Assert.assertEquals(t1.mRoot.mRight.mValue, 10); }
 * 
 * @Test public public void testDoubleRotateLeftRight() { AvlTree t1 = new
 * AvlTree(10); t1.insert(4, 9); Assert.assertEquals(t1.mRoot.mValue, 9);
 * Assert.assertEquals(t1.mRoot.mLeft.mValue, 4);
 * Assert.assertEquals(t1.mRoot.mRight.mValue, 10); }
 * 
 * @Test public public void testDoubleRotateRightLeft() { AvlTree t1 = new
 * AvlTree(10); t1.insert(14, 12); Assert.assertEquals(t1.mRoot.mValue, 12);
 * Assert.assertEquals(t1.mRoot.mLeft.mValue, 10);
 * Assert.assertEquals(t1.mRoot.mRight.mValue, 14); } }
 */
