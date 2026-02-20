package TowerDefence;
import TowerDefence.Balloon.Balloon;
import TowerDefence.Balloon.BasicBalloon;
import TowerDefence.board.Board;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the main game engine.
 * 
 * The Game class is responsible for:
 * - Creating balloons
 * - Adding them to the board
 * - Managing the game loop
 * - Moving balloons at each tick
 * - Detecting when balloons leave the board
 * 
 * The game stops automatically when all balloons have exited the board.
 */
public class Game{
    /** The game board */
    private Board b;
    /** Number of balloons to generate */
    protected int n;
    /** List of balloons currently in the game */
    ArrayList<Balloon>listeBallon;
    /**
     * Constructs a Game with a given board and number of balloons.
     * 
     * Balloons are created with:
     * - Random speed
     * - Random resistance between 1 and 3
     * - Unique identifier
     *
     * @param b the board on which the game runs
     * @param nbBallons number of balloons to generate
     */
    public Game(Board b,int nbBallons){
      this.b=b;
      this.n=nbBallons;
      this.listeBallon = new ArrayList<>();

    Random rand = new Random();
      for (int i = 1; i <= nbBallons; i++) {
            float speed = 0.5f + rand.nextFloat() * 2.0f; // vitesse aléatoire
            this.listeBallon.add(new BasicBalloon(speed, rand.nextInt(3)+1,"Ballon "+i+":"));
        }

    }
      /**
     * Starts and runs the game loop.
     * 
     * The method:
     * 1. Adds all balloons to the board.
     * 2. Repeatedly moves each balloon.
     * 3. Removes balloons that reach the end of the path.
     * 4. Displays when a balloon exits the board and at what time.
     * 
     * The loop stops when no balloons remain on the board.
     */
    public void play(){
        // Add all balloons to the board
        this.b.addBalloon(this.listeBallon);
        while(this.b.getBalloons().size()!=0){
        // Iterate backwards to safely remove balloons
            for (int i = listeBallon.size() - 1; i >= 0; i--) {
                Balloon b = listeBallon.get(i);
            // Move the balloon  
            this.b.move(b);
            // If balloon reached the end of the path
            if (b.isOut()){
                    this.b.getBalloons().remove(i);
                    System.out.println("Le "+b.getId()+"de vitesse "+b.getSpeed()+" est sortie au temps t ="+b.getTime());
                    this.b.removeBalloon(b);
                    this.b.affiche();
                }
            if(b.isDestroyed()){
                System.out.println("Le "+b.getId()+"de vitesse "+b.getSpeed()+" a été detruit au temps t ="+b.getTime());
                this.b.removeBalloon(b);
                this.b.affiche();
            
            }
            }
        }
        
    }
}