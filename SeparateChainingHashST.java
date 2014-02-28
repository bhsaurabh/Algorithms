public class SeparateChainingHashST<Key, Value>
{
	private int M = 97;
	private Node[] st = new Node[M];

	private static class Node
	{
		// generic array creation not allowed
		private Object key;
		private Object val;
		private Node next;

		public Node(Object key, Object val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}

	/* Searching the hashtable */
	public Value get(Key key)
	{
		int i = hash(key);
		for (Node x = st[i]; x != null; x = x.next)
			if (key.equals(x.key))
				return (Value) x.val;
		return null; 
	}

	/* Insertion */
	public void put(Key key, Value val)
	{
		int i = hash(key);
		for (Node x = st[i]; x != null; x = x.next)
			if (key.equals(x.key))
			{
				x.val = val;
				return;
			}
		// insert a new node into the LL
		st[i] = new Node(key, val, st[i]);
	}

	/* Unit tests */
	public static void main(String[] args)
	{
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();

		st.put("One", 1);
		st.put("Two", 2);
		st.put("Three", 3);
		st.put("Four", 4);
		st.put("Five", 5);

		System.out.println("Four: " + st.get("Four"));
		System.out.println("Six: " + st.get("Six"));
		System.out.println("One: " + st.get("One"));	
	}	
}
