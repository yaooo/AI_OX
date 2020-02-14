package Assignment;

import npuzzle.MisplacedTiles;
import npuzzle.NPuzzlePrinting;
import npuzzle.Tiles;
import npuzzle.TilesGoalTest;
import search.*;
import tour.*;

import java.util.HashSet;

public class Assignment2 {
    public static void main(String[] args){
        puzzle();
        tour();

    }

    private static void tour(){
        /* Tour */
        System.out.println("This is a demonstration of searches on Romania tour\n");
        Cities romania = SetUpRomania.getRomaniaMapSmall();
        City startCity = romania.getState("Bucharest");

        GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
        Node root = new Node(null, null, new TourState(startCity), 0);

        // frontiers
        BestFirstFrontier bestFirst = new BestFirstFrontier(new TourHeuristic((HashSet<City>) romania.getAllCities(),startCity));
        Frontier bfs1 = new BreadthFirstFrontier();
        Frontier dfs = new DepthFirstFrontier();


        // bestfirst
        Search bfsGraph = new GraphSearch(bestFirst);
        Search bfsTree = new TreeSearch(bestFirst);

        // breadthfirst
        Search bfs1Graph = new GraphSearch(bfs1);
        Search bfs1Tree = new TreeSearch(bfs1);

        // dfs
        Search dfsGraph = new GraphSearch(dfs);
        Search dfsTree = new TreeSearch(dfs);

        // iterative dfs
        IterativeDeepeningTreeSearch idfs = new IterativeDeepeningTreeSearch();


        Node sol = bfsGraph.findSol(root, goalTest);
        bfsTree.findSol(root, goalTest);

        bfs1Graph.findSol(root, goalTest);
        bfs1Tree.findSol(root, goalTest);

        idfs.findSol(root, goalTest);
        dfsTree.findSol(root, goalTest);
        dfsGraph.findSol(root, goalTest);

        new TourPrinting().printSolution(sol );
        // force gc, to free some space
        System.gc();

    }


    public static void puzzle(){
        /* Puzzle */
        System.out.println("\n\nThis is a demonstration of searches on 8-puzzle\n");
        Tiles initialConfiguration = new Tiles(new int[][] {
                { 7, 4, 2 },
                { 8, 1, 3 },
                { 5, 0, 6 }
        });

        // frontiers
        BestFirstFrontier bfs = new BestFirstFrontier(new MisplacedTiles());
        Frontier bfs1 = new BreadthFirstFrontier();
        Frontier dfs = new DepthFirstFrontier();


        // bestfirst
        Search bfsGraph = new GraphSearch(bfs);
        Search bfsTree = new TreeSearch(bfs);

        // breadthfirst
        Search bfs1Graph = new GraphSearch(bfs1);
        Search bfs1Tree = new TreeSearch(bfs1);

        // dfs
        Search dfsGraph = new GraphSearch(dfs);
        Search dfsTree = new TreeSearch(dfs);


        GoalTest goalTest1 = new TilesGoalTest();

        Node root1 = new Node(null, null, initialConfiguration, 0, 0, 0);

        Node sol = bfsGraph.findSol(root1, goalTest1);

        bfsTree.findSol(root1, goalTest1);


        bfs1Graph.findSol(root1, goalTest1);
        bfs1Tree.findSol(root1, goalTest1);

        dfsGraph.findSol(root1, goalTest1);

        //dfsTree.findSol(root1, goalTest1);
        // Taking to long
        new NPuzzlePrinting().printSolution(sol);
    }
}
