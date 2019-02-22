public class Main {


    public static void main(String[] args) {

        Map map = new Map(200,8);
        map.initiateCells();
        map.printMap();

        int x = 0;

        while(x<500) {
            map.neighbours();
            map.tick();
            map.printMap();
            x++;
        }


    }
}
