public class Map {

    private int x;
    private int y;
    private Cell[][] map;

    public Map(int x, int y) {
        this.x = x + 2;
        this.y = y + 2;

        this.map = new Cell[x + 2][y + 2];
        for (int i = 0; i < x + 2; i++) {
            for (int j = 0; j < y + 2; j++) {
                map[i][j] = new Cell();
            }
        }
    }

    public void initiateCells() {
        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {
                map[i][j].initiate();
            }
        }
    }

    public void printMap() {
        System.out.println("+++++++++++++++++++++++++++");
        for (int j = 1; j < y - 1; j++) {
            for (int i = 1; i < x - 1; i++) {
                if (map[i][j].cancer) {
                    System.out.print("*");
                    if (i == x - 2) {
                        System.out.println("");
                    }
                }else if (map[i][j].tumor) {
                    System.out.print("#");
                    if (i == x - 2) {
                        System.out.println("");
                    }
                } else if (map[i][j].living) {
                    System.out.print("0");
                    if (i == x - 2) {
                        System.out.println("");
                    }
                } else {
                    System.out.print("\u2022");
                    if (i == x - 2) {
                        System.out.println("");
                    }
                }
            }
        }
    }



    public void neighbours() {

        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {
                map[i][j].setNeighbours(0);
            }
        }

        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {

                if ((map[i - 1][j - 1].living)) {
                    map[i][j].neighbourCounter();
                }

                if ((map[i][j - 1].living)) {
                    map[i][j].neighbourCounter();
                }

                if ((map[i + 1][j - 1].living)) {
                    map[i][j].neighbourCounter();
                }

                if ((map[i - 1][j].living)) {
                    map[i][j].neighbourCounter();
                }

                if ((map[i + 1][j].living)) {
                    map[i][j].neighbourCounter();
                }

                if ((map[i - 1][j + 1].living)) {
                    map[i][j].neighbourCounter();
                }

                if ((map[i][j+1].living)) {
                    map[i][j].neighbourCounter();
                }
                if ((map[i + 1][j + 1].living)) {
                    map[i][j].neighbourCounter();
                }
            }

        }
    }

    public void tick(){
        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {
                map[i][j].tick();
            }
        }

        //cancer addon

        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {

                if(map[i][j].seed){
                    map[i - 1][j - 1].setCancer(true);
                    map[i ][j - 1].setCancer(true);
                    map[i + 1][j - 1].setCancer(true);
                    map[i - 1][j ].setCancer(true);
                    map[i + 1][j ].setCancer(true);
                    map[i - 1][j + 1].setCancer(true);
                    map[i][j + 1].setCancer(true);
                    map[i + 1][j + 1].setCancer(true);

                    map[i - 1][j - 1].setTumor(true);
                    map[i ][j - 1].setTumor(true);
                    map[i + 1][j - 1].setTumor(true);
                    map[i - 1][j ].setTumor(true);
                    map[i + 1][j ].setTumor(true);
                    map[i - 1][j + 1].setTumor(true);
                    map[i][j + 1].setTumor(true);
                    map[i + 1][j + 1].setTumor(true);
                }

            }
        }
    }
}
