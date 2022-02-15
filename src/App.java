import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        //Scenery scenery = new Scenery(4);
        //scenery.runTheSimulation();

        // testing with dummy data
        int[][] world = { { 1, 2, 2, 3, 4 }, { 2, 3, 4, 4, 1 }, { 3, -1, -2,
        9, 2 }, { 2, -2, 2, 3, 1 },
        { 2, 1, 2, 3, 2 } };
        int[][] world2 = { { 1, 2, 2, 3, 4 }, { 2, 3, 4, 4, 1 }, { 3, -2, -2,
        9, 2 }, { 2, -2, 2, 3, 1 },
        { 2, 1, 2, 3, 2 } };

        ArrayList<int[][]> worlds = new ArrayList<>();
          
            
            worlds.add(world);

            world[0][0] = 9;

            worlds.add(world);

            System.out.println(worlds.get(0)[0][0]);
            System.out.println(worlds.get(1)[0][0]);

        //new WindowApp(worlds);
        
    }
}
