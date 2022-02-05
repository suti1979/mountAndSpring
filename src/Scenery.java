import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Scenery {
    private int[][] world;
    private int[][] nextWorld;
    private int size;
    private Map<Integer, Integer> mapTiles = new HashMap<>();

    public Scenery(int n) {
        size = n;
        world = new int[n][n];
        nextWorld = new int[n][n];
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
        displayWorld();
    }

    public void foundSpring() {
        int smallestTerain = Collections.min(mapTiles.keySet());
        int numberOfsmallestTerrain = mapTiles.get(smallestTerain);
        int actualSpringNumber = getRandomNumber(0, numberOfsmallestTerrain);
        int count = 0;

        leak: for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (world[i][j] == smallestTerain) {
                    count++;
                    if (count >= actualSpringNumber) {
                        world[i][j] = -world[i][j];
                        break leak;
                    }
                }
            } // j
        } // i

        displayWorld();
    }

    public void floodTheValley() {
        int elevation;
        boolean change;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                change = false;
                elevation = world[i][j];
                if (elevation < 0) {
                    // change = checkEveryNeighboursIsBigger(elevation, i, j);
                    // if (!change) {
                    change = checkEqualNeighbours(elevation, i, j);
                    // }
                    // TODÚÚÚ if STILL (!change) than OVERFLOW
                }
                if (!change)
                    nextWorld[i][j] = elevation;
            } // j
        } // i
        world = nextWorld;
        displayWorld();
    }

    private boolean checkEqualNeighbours(int elevation, int i, int j) {
        boolean check = false;

        if (i - 1 >= 0 && elevation == -world[i - 1][j]) {

            nextWorld[i - 1][j] = elevation;
            check = true;
        }

        if (j + 1 < size && elevation == -world[i][j + 1]) {

            nextWorld[i][j + 1] = elevation;

            check = true;
        }

        if (i + 1 < size && elevation == -world[i + 1][j]) {

            nextWorld[i + 1][j] = elevation;
            check = true;
        }

        if (j - 1 >= 0 && elevation == -world[i][j - 1]) {

            nextWorld[i][j - 1] = elevation;
            check = true;
        }

        return check;
    }

    private boolean checkEveryNeighboursIsBigger(int elevation, int i, int j) {
        boolean check = true;

        if (i - 1 >= 0 && Math.abs(elevation) >= Math.abs(world[i - 1][j]))
            check = false;

        if (j + 1 < size && Math.abs(elevation) >= Math.abs(world[i][j + 1]))
            check = false;

        if (i + 1 < size && Math.abs(elevation) >= Math.abs(world[i + 1][j]))
            check = false;

        if (j - 1 >= 0 && Math.abs(elevation) >= Math.abs(world[i][j - 1]))
            check = false;

        if (check)
            nextWorld[i][j] = world[i][j] - 1;

        return check;
    }

    private void displayWorld() {
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

/*
 * bug
 * 2 2 1 1 1 1
 * 2 2 2 1 1 1
 * 1 1 1 1-1 1
 * 1 1 2 3 4 5
 * 4 3 3 3 2 2
 * 3 3 4 5 5 6
 * 
 * 2 2 1 1 1 1
 * 2 2 2 1-1 1
 * 1 1 1-10 1
 * 1 1 2 3 4 5
 * 4 3 3 3 2 2
 * 3 3 4 5 5 6
 */