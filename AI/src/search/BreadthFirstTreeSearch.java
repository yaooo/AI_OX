package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstTreeSearch {
	public static Node findSolution(State initialConfiguration, GoalTest goalTest) {
		int nodeGenerated = 0;
		int maxNodeStored = 0;

		Queue<Node> fifoQueue = new LinkedList<Node>();
		fifoQueue.add(new Node(null, null, initialConfiguration));
		while (!fifoQueue.isEmpty()) {
			maxNodeStored = Math.max(maxNodeStored, fifoQueue.size());
			Node node = fifoQueue.remove();
			if (goalTest.isGoal(node.state)){
				PrintStats.printStats(maxNodeStored, nodeGenerated);
				return node;
			}else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					fifoQueue.add(new Node(node, action, newState));
					nodeGenerated ++;
				}
			}
		}
		return null;
	}

}
