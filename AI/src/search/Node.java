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

	public Node(Node parent, Action action, State state, int depth){
		this(parent, action, state);
		this.depth = depth;
	}

	public Node(Node parent, Action action, State state, int depth, int value) {
		this(parent, action, state, depth);
		this.value = value;
	}

	public Node(Node parent, Action action, State state, int depth, int value, int g) {
		this(parent, action, state, depth, value);
		this.g = (parent == null ? 0 : parent.g) + (action == null ? 0 : action.getCost());
	}

}
