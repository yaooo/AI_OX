package npuzzle;
import search.*;

public class MisplacedTiles implements NodeFunction{

    public int cost(Node node) {
        int[] tiles = ((Tiles)node.state).getTiles();
        int res = 0;
        for (int index = 0; index < tiles.length - 1; index++) {
            if (tiles[index] != index + 1)  res++;
        }
        return res;
    }

}