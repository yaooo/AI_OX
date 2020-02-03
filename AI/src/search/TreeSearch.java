package search;

public class TreeSearch implements Search{

    private Frontier frontier;
    private String Type;

    public TreeSearch(Frontier f){
        this.frontier = f;
        this.Type = f.getType() + " Tree Search";
    }

    @Override
    public Node findSol(Node init, GoalTest goalTest) {
        frontier.clear();
        frontier.add(init);
        PrintStats.printSearchType(this.Type);
        while(!frontier.isEmpty()){
            Node node = frontier.remove();
            if(goalTest.isGoal(node.state)){
                PrintStats.printStats(frontier.max, frontier.seen);
                return node;
            }
            else {
                for(Action action: node.state.getApplicableActions()){
                    State state = node.state.getActionResult(action);
                    Node newNode = new Node(node, action, state, -1, 0, 0);
                    newNode.g = node.g + action.cost(node, newNode);
                    frontier.add(newNode);
//                    frontier.frontier.sort();
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
