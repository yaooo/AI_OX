package search;

import java.util.LinkedList;

public class DepthFirstFrontier implements Frontier{

    LinkedList<Node> frontier;
    private int maxNodeInList;
    private int nodeGenerated;
    private long timer;

    public DepthFirstFrontier(){
        frontier = new LinkedList<>();
        maxNodeInList = 0;
        nodeGenerated = 0;
        this.timer = System.currentTimeMillis();
    }


    public void clear(){
        frontier.clear();
        maxNodeInList = 0;
        nodeGenerated = 0;
        timer = System.currentTimeMillis();
    }

    public boolean add(Node node) {

        boolean t = this.frontier.add(node);
        if(t) {
            this.increaseNodeGenerated();
            this.compareAndSetMaxNode(frontier.size());
        }
        return t;
    }

    public Node remove(){
        return this.frontier.pollLast();
    }

    public String getType(){
        return "DFS";
    }

    public boolean isEmpty(){
        return frontier.isEmpty();
    }

    public boolean ifTimeOut(int seconds){
        return System.currentTimeMillis() - timer > (long)seconds * 1000;
    }

    public int getMaxNodeInList(){
        return maxNodeInList;
    }

    public int getNodeGenerated(){
        return nodeGenerated;
    }

    public void compareAndSetMaxNode(int t){
        this.maxNodeInList = Math.max(t, getMaxNodeInList());
    }

    public void increaseNodeGenerated(){
        this.nodeGenerated ++;
    }

}