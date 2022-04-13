package main.java.com.mypackage;

public class AVLTree {

	// Done
	public class Node {
		int key;
		int height;
		Node left;
		Node right;

		Node(int key) {
			this.key = key;
		}

		public int getKey() {
			return key;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}
	}

	// Done
	private Node root;

	// Done
	public Node find(int key) {
		Node current = root;
		while (current != null) {
			if (current.getKey() == key) {
				break;
			}
			current = current.getKey() < key ? current.getRight() : current.getLeft();
		}
		return current;
	}

	// DONE
	public void insert(int key) {
		root = insert(root, key);
	}

	// DONE
	public void delete(int key) {
		root = delete(root, key);
	}

	// DONE
	public Node getRoot() {
		return root;
	}

	public int height() {
		return root == null ? -1 : root.height;
	}

	// Done
	private Node insert(Node node, int key) {
		if (node == null) {
			return new Node(key);
		} else if (node.getKey() > key) {
			node.left = insert(node.getLeft(), key);
		} else if (node.getKey() < key) {
			node.right = insert(node.getRight(), key);
		} else {
			throw new RuntimeException("duplicate Key!");
		}
		return rebalance(node);
	}

	// Done
	private Node delete(Node node, int key) {
		if (node == null) {
			return node;
		} else if (node.getKey() > key) {
			node.left = delete(node.getLeft(), key);
		} else if (node.getKey() < key) {
			node.right = delete(node.getRight(), key);
		} else {
			if (node.getLeft() == null) {
				node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
			} else {
				Node mostLeftChild = mostLeftChild(node.getRight());
				node.key = mostLeftChild.getKey();
				node.right = delete(node.getRight(), node.getKey());
			}
		}
		if (node != null) {
			node = rebalance(node);
		}
		return node;
	}

	private Node mostLeftChild(Node node) {
		Node current = node;
		/* loop down to find the leftmost leaf */
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	private Node rebalance(Node z) {
		updateHeight(z);
		int balance = getBalance(z);
		if (balance > 1) {
			if (height(z.getRight().getRight()) > height(z.getRight().getLeft())) {
				z = rotateLeft(z);
			} else {
				z.right = rotateRight(z.getRight());
				z = rotateLeft(z);
			}
		} else if (balance < -1) {
			if (height(z.getLeft().getLeft()) > height(z.getLeft().getRight())) {
				z = rotateRight(z);
			} else {
				z.left = rotateLeft(z.getLeft());
				z = rotateRight(z);
			}
		}
		return z;
	}

	private Node rotateRight(Node y) {
		Node x = y.getLeft();
		Node z = x.getRight();
		x.right = y;
		y.left = z;
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	private Node rotateLeft(Node y) {
		Node x = y.getRight();
		Node z = x.getLeft();
		x.left = y;
		y.right = z;
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	private void updateHeight(Node n) {
		n.height = 1 + Math.max(height(n.getLeft()), height(n.getRight()));
	}

	private int height(Node n) {
		return n == null ? -1 : n.height;
	}

	public int getBalance(Node n) {
		return (n == null) ? 0 : height(n.getRight()) - height(n.getLeft());
	}
}