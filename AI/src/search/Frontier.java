package search;
import java.util.LinkedList;

abstract class Frontier {

    LinkedList<Node> frontier;
    int max;
    int seen;

    public Frontier(){
        frontier = new LinkedList<>();
        max = 0;
        seen = 0;
    }


    void clear(){
        frontier.clear();
        max = 0;
        seen = 0;
    }

    String getType(){
        return "No TYPE";
    }

    boolean isEmpty(){
        return frontier.isEmpty();
    }

    abstract boolean add(Node node);
    abstract Node remove();
}