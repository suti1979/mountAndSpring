import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Scenery {
    private int[][] world;
    // private int[][] nextWorld;
    private int size;
    private Map<Integer, Integer> mapTiles = new HashMap<>();

    public Scenery(int n) {
        size = n;
        world = new int[n][n];
        // nextWorld = new int[n][n];
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

    public void runTheSimulation() {
        displayWorld();
        foundSpring();
        floodTheValley();
        floodTheValley();
        floodTheValley();
        floodTheValley();
        floodTheValley();
        floodTheValley();
    }

    private void foundSpring() {
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

    private void floodTheValley() {

        checkEveryNeighboursIsBigger();

        int elevation;
        boolean loop = true;
        boolean change = false;

        while (loop) {
            loop = false;
            System.out.println("norm");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    elevation = world[i][j];

                    change = checkEqualNeighbours(elevation, i, j);
                    if (change)
                        loop = true;

                    if (!change)
                        world[i][j] = elevation;
                } // j
            } // i
            if (loop)
                displayWorld();
        } // while

        incWaterLevel();

    }

    private boolean checkEqualNeighbours(int elevation, int i, int j) {
        boolean check = false;
        int num = 0 - Math.abs(elevation);

        if (i - 1 >= 0 && elevation + world[i - 1][j] == 0) {
            world[i - 1][j] = num;
            world[i][j] = num;
            check = true;
        }

        if (j - 1 >= 0 && elevation == -world[i][j - 1]) {
            world[i][j - 1] = num;
            world[i][j] = num;
            check = true;
        }

        return check;

    }

    private void checkEveryNeighboursIsBigger() {
        boolean check = true;
        int elevation;

        while (check) {
            System.out.println("big");
            check = false;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    elevation = world[i][j];

                    if (elevation < 0) {
                        if (i - 1 >= 0 && Math.abs(elevation) > Math.abs(world[i - 1][j])) {

                            world[i - 1][j] = 0 - Math.abs(world[i - 1][j]) - 1;
                            check = true;
                        }

                        if (j - 1 >= 1 && Math.abs(elevation) > Math.abs(world[i][j - 1])) {

                            world[i][j - 1] = 0 - Math.abs(world[i][j - 1]) - 1;
                            check = true;
                        }
                    } // (elevation < 0)
                } // j
            } // i
            if (check)
                displayWorld();
        } // while

    }

    private void incWaterLevel() {
        System.out.println("inc");
        int elevation;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                elevation = world[i][j];
                if (elevation < 0) {
                    world[i][j] -= 1;
                }
            } // j
        } // i
        displayWorld();
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
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

}

// displayWorld();

// for (int i = 0; i < size; i++) {
// for (int j = 0; j < size; j++) {
// change = false;
// elevation = world[i][j];
// if (elevation < 0) {
// change = checkEveryNeighboursIsBigger(elevation, i, j);
// }
// if (!change)
// nextWorld[i][j] = elevation;
// } // j
// } // i
// world = nextWorld;
// displayWorld();
