package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private final static int WIDTH = 60;
    private final static int HEIGHT = 90;

    private static final long SEED = 3333;
    private static final Random RANDOM = new Random(SEED);

    public static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Shape {
        public int x;
        public int y;

        public Shape(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
        // Draw number of size Rectangles
        for (int i = 0; i < s; i += 1) {
            Position nwp = new Position(p.x - i, p.y - i);
            Shape sp = new Shape(2 * s - 2 * i, s + 2 * i);
            drawRectangle(world, nwp, sp, t);
        }
    }

    public static void drawRectangle(TETile[][] world, Position p, Shape sp, TETile t) {
        for (int i = p.x; i < p.x + sp.y; i += 1) {
            for (int j = p.y; j > p.y - sp.x; j -= 1) {
                world[i][j] = t;
            }
        }
    }

    public static void addNVerticalHexagon(TETile[][] world, Position p, int n, int size) {
        for (int i = 0; i < n; i += 1) {
            Position nwP = new Position(p.x, p.y - 2 * size * i);
            addHexagon(world, nwP, size, randomTile());
        }
    }

    private static TETile randomTile() {
        Random r = new Random();
        int tileNum = r.nextInt(4);
        switch (tileNum) {
            case 0:
                return Tileset.TREE;
            case 1:
                return Tileset.FLOWER;
            case 2:
                return Tileset.WATER;
            case 3:
                return Tileset.MOUNTAIN;
            default:
                return Tileset.SAND;
        }
    }

    public static void main(String[] args) {
        //Initialize the rendering engine with the size WIDTH and Height.
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        //Initialize the tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i += 1) {
            for (int j = 0; j < HEIGHT; j += 1) {
                world[i][j] = Tileset.NOTHING;
            }
        }

        //Fill the custom shape -- hexagon
        int sizeOfHExagon = 3;
        TETile t = Tileset.TREE;
        // Locate the first column needed to be drawn:
        // The upper left tile is at size away from the top and 4*size away from the left.
        int startLt = 4 * sizeOfHExagon;
        int startUp = HEIGHT - 5 * sizeOfHExagon;
        Position p = new Position(startLt, startUp);
        System.out.println(p.x + "  " + p.y);

//        for (int i = 0; i < 3; i += 1) {
//            p.x += (2 * sizeOfHExagon - 1);
//            p.y += sizeOfHExagon;
//            addNVerticalHexagon(world, p, i + 3, sizeOfHExagon);
//        }
//        System.out.println(p.x + "  " + p.y);
//
//        for (int i = 1; i < 3; i += 1) {
//            p.x += (2 * sizeOfHExagon - 1);
//            p.y -= sizeOfHExagon;
//            addNVerticalHexagon(world, p, 5 - i, sizeOfHExagon);
//        }

        int[] sizeArry = {3, 4, 5, 4, 3};
        int[] signArry = {0, 1, 1, -1, -1};
        for (int i = 0; i < sizeArry.length; i += 1) {
            if (i != 0) {
                p.x += (2 * sizeOfHExagon - 1);
            }
            p.y += sizeOfHExagon * signArry[i];
            addNVerticalHexagon(world, p, sizeArry[i], sizeOfHExagon);
        }

        System.out.println(TETile.toString(world));


        //Rendering the result.
        ter.renderFrame(world);
    }


}
