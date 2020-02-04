package search;
import java.util.LinkedList;

abstract class Frontier {

    LinkedList<Node> frontier;
    int max;
    int seen;
    long timer;

    public Frontier(){
        frontier = new LinkedList<>();
        max = 0;
        seen = 0;
        this.timer = System.currentTimeMillis();
    }


    void clear(){
        frontier.clear();
        max = 0;
        seen = 0;
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
    abstract boolean add(Node node);
    abstract Node remove();
}