package search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier{

    private int maxNodeInList;
    private int nodeGenerated;
    private long timer;
    public PriorityQueue<Node> frontier;
    private NodeFunction f;

    public BestFirstFrontier(NodeFunction f){
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node s1, Node s2) {
                return s1.value - s2.value;
            }
        };
        frontier = new PriorityQueue<>(comparator);

        this.f = f;
        clear();
    }


    public void clear(){
        frontier.clear();
        maxNodeInList = 0;
        nodeGenerated = 0;
        timer = System.currentTimeMillis();
    }

    public boolean add(Node node){
        node.value += f.cost(node);
        boolean t = this.frontier.add(node);
        if(t) {
//            if(maxNodeInList ==1000) System.out.println("xxxxx");
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