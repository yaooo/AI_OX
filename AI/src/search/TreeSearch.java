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
            if(frontier.ifTimeOut(30)){
                System.out.println("Time out(30 seconds limit).");
                break;
            }
            Node node = frontier.remove();
            if(goalTest.isGoal(node.state)){
                PrintStats.printStats(maxNodesIntFrontier(), nodeGenerated());
                return node;
            }
            else {
                for(Action action: node.state.getApplicableActions()){
                    State state = node.state.getActionResult(action);
                    Node newNode = new Node(node, action, state, -1, 0, 0);
                    newNode.value += node.g;
                    frontier.add(newNode);
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
