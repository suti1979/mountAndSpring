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
        int elevation = n / 2;
        int random;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                random = getRandomNumber(-2, 1);

                elevation += random;
                if (elevation < 1)
                    elevation = 1;

                if (elevation > n)
                    elevation = n;

                world[i][j] = elevation;

                if (!mapTiles.containsKey(elevation)) {
                    mapTiles.put(elevation, 1);
                } else {
                    mapTiles.put(elevation, mapTiles.get(elevation) + 1);
                }

            } // j
        } // i
    }

    public void foundSpring() {
        int smallestTerain = Collections.min(mapTiles.keySet());
        int numberOfsmallestTerrain = mapTiles.get(smallestTerain);
        int actualSpringNumber = getRandomNumber(0, numberOfsmallestTerrain);
        int count = 0;
        System.out.println(smallestTerain + " " + numberOfsmallestTerrain + " " + actualSpringNumber);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (world[i][j] == smallestTerain) {
                    count++;
                    if (count >= actualSpringNumber) {
                        world[i][j] = -world[i][j];
                        break;
                    }
                }
            } // j
        } // i

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
            } // j
            System.out.println();
        } // i
        System.out.println();
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
    }

}
