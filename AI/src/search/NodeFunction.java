package search;

public interface NodeFunction {
    int h(Node src, Node dest);
    int g(Node src, Node dest);
    int f(Node src, Node dest);
}
