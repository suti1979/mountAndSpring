import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        //Scenery scenery = new Scenery(6);
        //scenery.runTheSimulation();

        // testing with dummy data
        int[][] world = { { 1, 2, 2, 3, 4 }, { 2, 3, 4, 4, 1 }, { 3, -1, -2,
        9, 2 }, { 2, -2, 2, 3, 1 },
        { 2, 1, 2, 3, 2 } };
        int[][] world2 = { { 1, 2, 2, 3, 4 }, { 2, 3, 4, 4, 1 }, { 3, -2, -2,
        9, 2 }, { 2, -2, 2, 3, 1 },
        { 2, 1, 2, 3, 2 } };

        ArrayList<StoreWorlds> worlds = new ArrayList<>();
            worlds.add(new StoreWorlds(world));
            worlds.add(new StoreWorlds(world2));

        new WindowApp(worlds);
        
    }
}
