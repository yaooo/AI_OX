package search;
import java.util.LinkedList;

abstract class Frontier {

    LinkedList<Node> frontier;
    private int maxNodeInList;
    private int nodeGenerated;
    private long timer;

    protected Frontier(){
        frontier = new LinkedList<>();
        maxNodeInList = 0;
        nodeGenerated = 0;
        this.timer = System.currentTimeMillis();
    }


    void clear(){
        frontier.clear();
        maxNodeInList = 0;
        nodeGenerated = 0;
        timer = System.currentTimeMillis();
    }

    String getType(){
        return "No TYPE";
    }

    boolean isEmpty(){
        return frontier.isEmpty();
    }

    boolean ifTimeOut(int seconds){
        return System.currentTimeMillis() - timer > (long)seconds * 1000;
    }

    int getMaxNodeInList(){
        return maxNodeInList;
    }

    int getNodeGenerated(){
        return nodeGenerated;
    }

    void compareAndSetMaxNode(int t){
        this.maxNodeInList = Math.max(t, getMaxNodeInList());
    }

    void increaseNodeGenerated(){
        this.nodeGenerated ++;
    }

    abstract boolean add(Node node);
    abstract Node remove();
}