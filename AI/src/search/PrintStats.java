package search;

public class PrintStats {
    public static void printStats(int maxNodeStored, int nodeGenerated){
        System.out.println("Total number of nodes generated: " + nodeGenerated);
        System.out.println("Maximum number of nodes stored on the frontier: " + maxNodeStored);
    }

    public static void error(String searchType){
        System.out.println("Performed " + searchType + ", failed to find the solution.");
    }

    public static void printSearchType(String searchType){
        System.out.println("\nPerformed " + searchType + ":");
    }
}
