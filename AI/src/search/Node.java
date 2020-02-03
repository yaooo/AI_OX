package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int depth;
	public int value;
	public int g;

	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
	}

	public Node(Node parent, Action action, State state, int d, int v, int g) {
		this(parent, action, state);
		this.depth = d;
		this.value = v;
		this.g = g;
	}

}
