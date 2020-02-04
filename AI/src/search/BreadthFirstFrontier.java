package search;

public class BreadthFirstFrontier extends Frontier{

    public BreadthFirstFrontier(){
        super();
        clear();
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
        return this.frontier.poll();
    }

    public String getType(){
        return "BFS";
    }
}