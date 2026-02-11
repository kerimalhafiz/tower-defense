import TowerDefence.Balloon.Balloon;
import TowerDefence.Balloon.BasicBalloon;
import TowerDefence.board.Board;
import java.util.ArrayList;
import java.util.Random;

public class Game{
    //la methode game qui deroule le jeux tout en deplaçant les ballons dans le board
    Board b;
    int n;
    ArrayList<Balloon>listeBallon;
    public Game(Board b,int nbBallons){
      this.b=b;
      this.n=nbBallons;
    Random rand = new Random();
      for (int i = 1; i <= nbBallons; i++) {
            float speed = 0.5f + rand.nextFloat() * 2.0f; // vitesse aléatoire
            this.listeBallon.add(new BasicBalloon(speed, rand.nextInt(3)+1,"Ballon "+i+":"));
        }

    }

    public void play(){
        this.b.addBalloon(this.listeBallon);
        while(this.b.getBalloons().size()!=0){
            for(Balloon b:this.b.getListeBalloons()){
            this.b.move(b);
            }
        }
        
    }
}