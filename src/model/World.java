package model;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Sprite> sprites = new ArrayList<>();

    public World(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    private void addSprite(Sprite sprite) {
        sprites.add(sprite);
    }

    private void removeSprites(Sprite sprite) {
        sprites.remove(sprite);
    }

    private void update() {

    }

}
