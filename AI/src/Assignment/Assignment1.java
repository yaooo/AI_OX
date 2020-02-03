package Assignment;

import search.*;
import tour.*;

public class Assignment1 {
    public static void main(String[] args){
        System.out.println("This is a demonstration of searches on Romania tour\n");

        Cities romania = SetUpRomania.getRomaniaMapSmall();
        City startCity = romania.getState("Bucharest");

        GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);



        BreadthFirstFrontier bfs = new BreadthFirstFrontier();
        DepthFirstFrontier dfs = new DepthFirstFrontier();

        Node root = new Node(null, null, new TourState(startCity), 0, 0, 0);
        Search bfsGraph = new GraphSearch(bfs);
        Search dfsGraph = new GraphSearch(dfs);
        Search bfsTree = new TreeSearch(bfs);
        Search dfsTree = new TreeSearch(dfs);

        bfsGraph.findSol(root, goalTest);
        dfsGraph.findSol(root, goalTest);
        bfsTree.findSol(root, goalTest);
//        dfsTree.findSol(root, goalTest);
    }
}
