package search;

public interface Search {
    Node findSol(Node initState, GoalTest goal);

    int maxNodesIntFrontier();

    int nodeGenerated();
}
