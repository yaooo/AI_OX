package npuzzle;

import search.Node;

public class MisplacedTilesHeuristicFunction {
    public static int h(Node node) {
        int h = 0;
        Tiles state = (Tiles)node.state;


        for (int i = 0; i < state.tiles.length; i++) {
            if (state.tiles[i] != Tiles.EMPTY_TILE && state.tiles[i] != (i + 1))
                h += 1;
        }
        return h;
    }
}