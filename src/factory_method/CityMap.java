package factory_method;

public class CityMap extends Map {

    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int choice = rand.nextInt(3); // uses rand from factory_method.Map superclass
        switch (choice) {
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            default: return new BuildingTile();
        }
    }
}
