import java.util.Random;

public class Cell {
    Boolean living ;
    Random random = new Random();
    int neighbours;
    boolean tumor;
    boolean cancer;
    boolean seed;

    public Cell() {
        this.living = false;
        this.random = new Random();
        this.tumor = false;


    }

    public void initiate(){
        if(random.nextBoolean()){
            living = true;
        }else{
            living=false;
        }
    }

    public void death(){
        living = false;
    }

    public void birth(){
        living = true;
    }

    public void neighbourCounter(){
        this.neighbours +=1;

    }

    public int getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(int neighbours) {
        this.neighbours = neighbours;
    }

    public void tick(){
        if(living) {
            if (getNeighbours() < 2) {
                death();
            }
            if (getNeighbours() > 3) {
                death();
            }
//            if (getNeighbours() == 2 || getNeighbours() == 3) {
//                //lives on, maybe add generation counter
//            }
//            if (getNeighbours() == 2 || getNeighbours() == 3) {
//                //lives on, maybe add generation counter
//            }
        }

        if (getNeighbours() == 8) {
            tumor =true;
        }
        if(!living){
            if (getNeighbours() == 3) {
                birth();
            }
        }
        seed();

    }

    public void setCancer(boolean cancer) {
        this.cancer = cancer;
    }

    public void setTumor(boolean tumor) {
        this.tumor = tumor;
    }

    public void seed(){
        if(tumor){
            if(random.nextDouble()*100 <1){
                seed = true;
            }
        }
    }
}
