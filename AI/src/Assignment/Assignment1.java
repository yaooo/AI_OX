package Assignment;

import npuzzle.NPuzzlePrinting;
import npuzzle.Tiles;
import npuzzle.TilesGoalTest;
import search.*;
import tour.*;

public class Assignment1 {
    public static void main(String[] args){

        /* Tour */
        System.out.println("This is a demonstration of searches on Romania tour\n");
        Cities romania = SetUpRomania.getRomaniaMapSmall();
        City startCity = romania.getState("Bucharest");

        GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
        Node root = new Node(null, null, new TourState(startCity), 0);
        Frontier bfs = new BreadthFirstFrontier();
        Frontier dfs = new DepthFirstFrontier();
        Search bfsGraph = new GraphSearch(bfs);
        Search dfsGraph = new GraphSearch(dfs);
        Search bfsTree = new TreeSearch(bfs);
        Search dfsTree = new TreeSearch(dfs);
        IterativeDeepeningTreeSearch idfs = new IterativeDeepeningTreeSearch();

        bfsGraph.findSol(root, goalTest);
        dfsGraph.findSol(root, goalTest);
        bfsTree.findSol(root, goalTest);
        idfs.findSol(root, goalTest);
        dfsTree.findSol(root, goalTest);

        // force gc, to free some space
        System.gc();

        /* Puzzle */
        System.out.println("\n\nThis is a demonstration of searches on 8-puzzle\n");
        Tiles initialConfiguration = new Tiles(new int[][] {
                { 7, 4, 2 },
                { 8, 1, 3 },
                { 5, 0, 6 }
        });

        GoalTest goalTest1 = new TilesGoalTest();

        Node root1 = new Node(null, null, initialConfiguration, 0);
        Node sol = bfsGraph.findSol(root1, goalTest1);
        dfsGraph.findSol(root1, goalTest1);
        bfsTree.findSol(root1, goalTest1);
        idfs.findSol(root1, goalTest1);
        dfsTree.findSol(root1, goalTest1);
        new NPuzzlePrinting().printSolution(sol);
    }
}
