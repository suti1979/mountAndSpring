public class Scenery {
    private int[][] world;
    private int size;

    public Scenery(int n) {
        size = n;
        world = new int[n][n];

        // int previousCell = getRandomNumber(1, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                world[i][j] = getRandomNumber(1, size);

            }
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
    }

    public void displayWorld() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(world[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void foundSpring() {
        world[0][0] = -world[0][0];
        displayWorld();
    }

}
