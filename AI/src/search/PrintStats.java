package search;

class PrintStats {
    static void printStats(int maxNodeStored, int nodeGenerated){
        System.out.println("Total number of nodes generated: " + nodeGenerated);
        System.out.println("Maximum number of nodes stored on the frontier: " + maxNodeStored);
    }

    static void error(String searchType){
        System.out.println("Performed " + searchType + ", failed to find the solution.");
    }

    static void printSearchType(String searchType){
        System.out.println("\nPerformed " + searchType + ":");
    }
}
