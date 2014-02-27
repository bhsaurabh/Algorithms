public class BST<Key extends Comparable<Key>, Value>
{
	/* inner class for BST node type
	 * insert keys in random order to avoid worst case */
	private class Node
	{
		private Key key;
		private Value val;
		Node left, right;
		private int count;

		public Node(Key key, Value val)
		{
			this.key = key;
			this.val = val;
		}

		// accessors
		public Key getKey() { return key; }
		public Value getValue() { return val; }
		public int getCount() { return count; }

		// mutators
		public void setKey(Key key) { this.key = key; }
		public void setValue(Value val) { this.val = val; }
		public void setCount(int count) { this.count = count; }
	}

	/* BST is just a reference to the root node */
	private Node root;

	/* insertion */
	public void put(Key key, Value val)
	{
		// use recursion to insert (O(lgN))
		root = put(root, key, val);
	}

	/* insertion recursive helper */
	private Node put(Node x, Key key, Value val)
	{
		if (x == null)	return new Node(key, val);

		int cmp = key.compareTo(x.getKey());
		if (cmp < 0)	x.left = put(x.left, key, val);
		else if (cmp > 0)	x.right = put(x.right, key, val);
		else	x.setValue(val);

		// set the count variable
		x.setCount(1 + size(x.left) + size(x.right));
		return x;
	}

	/* searching the BST */
	public Value get(Key key)
	{
		// O(lgN)
		Node x = root;
		while (x != null)
		{
			int cmp = x.getKey().compareTo(key);
			if (cmp < 0)	x = x.right;
			else if (cmp > 0)	x = x.left;
			else	return x.getValue();
		}
		// not found
		return null;
	}

	/* Ordered operations */
	public Key min()
	{
		// return minimum key
		Node x = root;
		while (x.left != null)
			x = x.left;
		return x.getKey();
	}

	public Key max()
	{
		// return the maximum key
		Node x = root;
		while (x.right != null)
			x = x.right;
		return x.getKey();
	}

	public Key floor(Key key)
	{
		// return the floor of key
		Node x = floor(root, key);
		if (x == null)
			return null;
		return x.getKey();
	}

	/* helper to floor function */
	private Node floor(Node x, Key key)
	{
		if (x == null)	return null;
		int cmp = key.compareTo(x.getKey());
		if (cmp == 0)	return x;
		else if (cmp < 0)	return floor(x.left, key);
		// if key > x.key check right sub tree also
		Node tmp = floor(x.right, key);
		if (tmp == null)	return x;
		else	return tmp;
	}

	public Key ceil(Key key)
	{
		// return the ceiling of key
		Node x = ceil(root, key);
		if (x == null)
			return null;
		return x.getKey();		
	}

	/* helper method for ceil */
	private Node ceil(Node x, Key key)
	{
		if (x == null)	return null;
		int cmp = key.compareTo(x.getKey());
		if (cmp == 0)	return x;
		else if (cmp > 0)	return ceil(x.right, key);
		// if key < x.key check left sub tree also
		Node tmp = ceil(x.left, key);
		if (tmp == null)	return x;
		else	return tmp;
	}

	/* get size of BST */
	public int size()
	{
		return size(root);
	}

	/* helper to get size of node */
	private int size(Node x)
	{
		if (x == null)	return 0;
		return x.getCount();
	}

	/* ranking method */
	public int rank(Key key)
	{
		return rank(root, key);
	}

	/* helper to rank */
	private int rank(Node x, Key key)
	{
		if (x == null)	return 0;
		int cmp = key.compareTo(x.getKey());
		if (cmp == 0)	return size(x.left);
		else if (cmp < 0)	return rank(x.left, key);
		else	return 1 + size(x.left) + rank(x.right, key);
	}

	/* traversals */
	public Iterable<Key> keys()
	{
		Queue<Key> q = new Queue<Key>();
		inorder(root, q);
	}

	private void inorder(Node x, Queue<Key> q)
	{
		if (x == null)	return;
		// traverse left subtree
		inorder(x.left, q);
		// enqueue current node
		q.enqueue(x.getKey());
		// traverse right subtree
		inorder(x.right, q);
	}

	/* nice to have pre-order and post-order implemented */
	private void preorder(Node x, Queue<Key> q)
	{
		if (x == null)	return;
		q.enqueue(x.getKey());
		preorder(x.left, q);
		preorder(x.right, q);
	}
}