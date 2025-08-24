package factory_method;

public class WildernessMap extends Map {

    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int choice = rand.nextInt(3); // uses rand from factory_method.Map superclass
        switch (choice) {
            case 0: return new SwampTile();
            case 1: return new WaterTile();
            default: return new ForestTile();
        }
    }
}
