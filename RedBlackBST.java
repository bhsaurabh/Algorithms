public class RedBlackBST<Key extends Comparable<Key>, Value> extends BST<Key, Value>
{
	/* Implementation of a Red-Black BST */
	private class Node
	{
		private Key key;
		private Value val;
		Node left, right;
		private int count;
		private boolean color;

		public Node(Key key, Value val, boolean color)
		{
			this.key = key;
			this.val = val;
			this.color = color;
		}

		// accessors
		public Key getKey() { return key; }
		public Value getValue() { return val; }
		public int getCount() { return count; }
		public boolean getColor() { return color; }

		// mutators
		public void setKey(Key key) { this.key = key; }
		public void setValue(Value val) { this.val = val; }
		public void setCount(int count) { this.count = count; }
		public void setColor(boolean color) { this.color = color; }
	}

	private Node root;
	private final boolean RED = true;
	private final boolean BLACK = false;

	/* ------------------- Helpers -------------------*/
	/* Is incoming connection to node RED? */
	private boolean isRed(Node x)
	{
		if (x == null)	return false;
		return x.getColor() == RED;
	}

	/* rotate a right leaning RB-BST to left leaning */
	private Node rotateLeft(Node x)
	{
		assert isRed(x.right);

		Node tmp = x.right;
		x.right = tmp.left;
		tmp.left = x;
		tmp.setColor(x.getColor());
		x.setColor(RED);
		return tmp;
	}

	/* rotate a left leaning RB-BST to right leaning */
	private Node rotateRight(Node x)
	{
		assert isRed(x.left);

		Node tmp = x.left;
		x.left = tmp.right;
		tmp.right = x;
		tmp.setColor(x.getColor());
		x.setColor(RED);
		return tmp;
	}

	private void flipColors(Node x)
	{
		assert isRed(x.left);
		assert isRed(x.right);
		assert !isRed(x);

		x.setColor(RED);
		x.left.setColor(BLACK);
		x.right.setColor(BLACK);
	}

	/* ---------------- RB-BST API calls and associated helpers -------------------- */
	public void put(Key key, Value val)
	{
		root = put(root, key, val);
	}

	/* helper to put */
	private Node put(Node x, Key key, Value val)
	{
		// standard BST insert
		if (x == null)	return new Node(key, val, RED);

		int cmp = key.compareTo(x.getKey());
		if (cmp < 0)	x.left = put(x.left, key, val);
		else if (cmp > 0)	x.right = put(x.right, key, val);
		else	x.setValue(val);

		// make a balanced RB-BST
		if (isRed(x.right) && !isRed(x.left))	x = rotateLeft(x);
		if (isRed(x.left) && isRed(x.left.left))	x = rotateRight(x);
		if (isRed(x.left) && isRed(x.right))	flipColors(x);

		// update the counts
		x.setCount(1 + size(x.left) + size(x.right));
		return x;
	}

	private int size(Node x)
	{
		if (x == null)	return 0;
		return x.getCount();
	}

	/* get size of RB-BST */
	public int size()
	{
		return size(root);
	}

}