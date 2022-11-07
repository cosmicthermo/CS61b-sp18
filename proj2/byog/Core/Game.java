package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

public class Game {
    public class Arena {
        public int x;
        public int y;
        public int w;
        public int h;

        public Arena(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        public Arena() {
            this.x = 0;
            this.y = 0;
            this.w = WIDTH;
            this.h = HEIGHT;
        }

    }

    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;
    private static final int PAD = 3;


    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() {
    }

    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playing
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     *
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] playWithInputString(String input) {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().
        int rdseed = Integer.parseInt(input);
        Random r = new Random(rdseed);
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] finalWorldFrame = new TETile[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i += 1) {
            for (int j = 0; j < HEIGHT; j += 1) {
                finalWorldFrame[i][j] = Tileset.NOTHING;
            }
        }
        Arena ar = new Arena(0, 0, WIDTH / 4, HEIGHT / 2);
//        drawRandomRoom(finalWorldFrame, ar);
        Random rb = new Random();
        int numb = RandomUtils.uniform(rb, 10, 30);
        int i = 0;
        while (i < 3) {
            ar = drawRandomRoom(finalWorldFrame, ar, r);
            i++;
        }


        ter.renderFrame(finalWorldFrame);
        return finalWorldFrame;
    }

    // Next starting pt is within the last rectangle.
    // For the next rectangle--choose the starting pt first and then randomly select
    // Next rectangle until it fits to the frame.

    /**
     * Put in the initial world and arena and output the renew arena
     *
     * @param world
     * @param ar
     */
    private Arena drawRandomRoom(TETile[][] world, Arena ar, Random r) {
//        Random r = new Random();

        int initX = RandomUtils.uniform(r, ar.x, ar.x + ar.w);
        int initY = RandomUtils.uniform(r, ar.y, ar.y + ar.h);
        System.out.println(initX + " " + initY);
        // Initialize the position as the bottom left corner of the rectangle.
//        int initX = ar.x + r.nextInt(ar.w);
//        int initY = ar.y + r.nextInt(ar.h);

        // Update the wh until rectangles legit.
        int wid = WIDTH;
        int ht = HEIGHT;
        while (initX + wid >= WIDTH - PAD || initY + ht >= HEIGHT - PAD) {
            ht = RandomUtils.uniform(r, 3, HEIGHT);
            wid = RandomUtils.uniform(r, 3, WIDTH);
        }
        Arena nwAr = new Arena(initX, initY, wid, ht);

        // Draw two rectangles: first one with well and the second one with grass
        for (int i = initX; i < initX + wid; i += 1) {
            for (int j = initY; j < initY + ht; j++) {
                if (world[i][j] != Tileset.FLOOR) {
                    world[i][j] = Tileset.WALL;
                }
            }
        }
        for (int i = initX + 1; i < initX + wid - 1; i += 1) {
            for (int j = initY + 1; j < initY + ht - 1; j++) {
                world[i][j] = Tileset.FLOOR;
            }
        }
        return nwAr;
    }
}
