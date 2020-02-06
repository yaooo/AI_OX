package search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier{

    private int maxNodeInList;
    private int nodeGenerated;
    private long timer;
    private PriorityQueue<Node> frontier;
    public BestFirstFrontier(){
        frontier = new PriorityQueue<>(1000, new Comparator<Node>() {
            public int compare(Node n1, Node n2){
                return Integer.compare(n1.g, n2.g);
            }

        });
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

    public boolean add(Node node){
        boolean t = this.frontier.add(node);
        if(t) {
            this.increaseNodeGenerated();
            this.compareAndSetMaxNode(frontier.size());
        }
        return t;
    }

    public Node remove(){
        return this.frontier.remove();
    }

    public String getType(){
        return "Best First Search";
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
        this.maxNodeInList = Math.max(t, maxNodeInList);
    }

    public void increaseNodeGenerated(){
        this.nodeGenerated ++;
    }
}