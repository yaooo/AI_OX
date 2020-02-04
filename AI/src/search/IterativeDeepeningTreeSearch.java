package search;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeDeepeningTreeSearch implements Search{

	private DepthFirstFrontier frontier;
	private String Type;
	private int depth;
	public IterativeDeepeningTreeSearch(){
		this.frontier = new DepthFirstFrontier();
		this.depth = -1;
		this.Type = "Iterative Deepening Tree Search";
	}

	@Override
	public Node findSol(Node init, GoalTest goalTest) {
		PrintStats.printSearchType(this.Type);


		while (true) {

			frontier.clear();
			frontier.add(init);
			this.depth ++; // increase the threshold

			if (frontier.ifTimeOut(120)) {
				System.out.println("Time out(120 seconds limit).");
				break;
			}

			while (!frontier.isEmpty()) {

				Node node = frontier.remove();

				// reach the depth limit
				if(node.depth > depth) continue;

				if (goalTest.isGoal(node.state)) {
					PrintStats.printStats(maxNodesIntFrontier(), nodeGenerated());
					return node;
				} else {
					for (Action action : node.state.getApplicableActions()) {
						State state = node.state.getActionResult(action);
						int d = node.depth;
						Node newNode = new Node(node, action, state, d + 1, 0, 0);
						newNode.g = node.g + action.cost(node, newNode);
						frontier.add(newNode);
					}
				}
			}
		}
		PrintStats.error(this.Type);
		return null;
	}

	@Override
	public int maxNodesIntFrontier() {
		return frontier.max;
	}

	@Override
	public int nodeGenerated() {
		return frontier.seen;
	}
}
