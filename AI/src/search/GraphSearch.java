package search;

import java.util.HashSet;
public class GraphSearch implements Search{

    public Frontier frontier;
    private HashSet<State> closedList;
    private String Type;
    public GraphSearch(Frontier f){
        this.frontier = f;
        this.closedList = new HashSet<>();
        this.Type = f.getType() + " Graph Search";
    }

    @Override
    public Node findSol(Node init, GoalTest goalTest) {
        frontier.clear();
        closedList.clear();
        int count = 0;
        frontier.add(init);
        closedList.add(init.state);
        PrintStats.printSearchType(this.Type);
        while(!frontier.isEmpty()){
            Node node = frontier.remove();
            if(goalTest.isGoal(node.state)){
                PrintStats.printStats(maxNodesIntFrontier(), nodeGenerated());
                return node;
            }
            else {
                for(Action action: node.state.getApplicableActions()){
                    State state = node.state.getActionResult(action);

                    if(closedList.add((state))) {
                        Node newNode = new Node(node, action, state, -1, 0, 0);
                        newNode.value += node.g;
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
        return frontier.getMaxNodeInList();
    }

    @Override
    public int nodeGenerated() {
        return frontier.getNodeGenerated();
    }
}
