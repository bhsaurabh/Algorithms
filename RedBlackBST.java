public class RedBlackBST<Key extends Comparable<Key>, Value>
{
	/* Implementation of a Red-Black BST */
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
}