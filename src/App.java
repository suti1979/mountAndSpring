public class App {
    public static void main(String[] args) {
        Scenery scenery = new Scenery(6);
        scenery.runTheSimulation();
        new WindowApp(scenery.worlds);
    }
}
