package search;

 public interface Frontier{
    void clear();

    String getType();
    boolean isEmpty();
    boolean ifTimeOut(int seconds);
    int getMaxNodeInList();
    int getNodeGenerated();
    void compareAndSetMaxNode(int t);
    void increaseNodeGenerated();
    boolean add(Node node);
    Node remove();
}