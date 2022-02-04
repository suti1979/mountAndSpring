import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Scenery {
    private int[][] world;
    private int size;
    private Map<Integer, Integer> mapTiles = new HashMap<>();

    public Scenery(int n) {
        size = n;
        world = new int[n][n];
        int actualTile;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                actualTile = getRandomNumber(1, 4);
                world[i][j] = actualTile;

                if (!mapTiles.containsKey(actualTile)) {
                    mapTiles.put(actualTile, 1);
                } else {
                    mapTiles.put(actualTile, mapTiles.get(actualTile) + 1);
                }

            }
        }
    }

    public void foundSpring() {
        int smallestTerain = Collections.min(mapTiles.keySet());
        int numberOfsmallestTerrain = mapTiles.get(smallestTerain);
        numberOfsmallestTerrain = getRandomNumber(1, numberOfsmallestTerrain);
        // world[0][0] = -world[0][0];
        displayWorld();
    }

    public void floodTheValley() {
        displayWorld();
    }

    public void displayWorld() {
        int geoData;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                geoData = world[i][j];
                if (geoData > 0)
                    System.out.print(" ");
                System.out.print(geoData);
            }
            System.out.println();
        }
        System.out.println();
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
    }

}
