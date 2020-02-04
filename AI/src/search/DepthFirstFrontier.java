package search;

public class DepthFirstFrontier extends Frontier{

    public DepthFirstFrontier(){
        super();
        clear();
    }

    public boolean add(Node node) {

        boolean t = this.frontier.add(node);
        if(t) {
            this.seen++;
            this.max = Math.max(max, frontier.size());
        }
        return t;
    }

    public Node remove(){
        return this.frontier.pollLast();
    }

    public String getType(){
        return "DFS";
    }
}