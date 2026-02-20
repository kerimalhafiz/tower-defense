package TowerDefence.tower;
import TowerDefence.board.Board;
import TowerDefence.board.Position;

public class SingeTireurElite extends Tour{
    public SingeTireurElite(Position position){
        super(new Projectile(4),integer.MAX_VALUE,2000,500,position);
    }
    public void augmenterCadence(){
        this.cadence *= 0.75;
    }
    public void augmenterPuissance() {
        this.projectile = new Projectile(this.projectile.getDamage()+2);
        
    }
    public void cibler(Board board){};
    public void tirer(Board b){};
    public void augmenterPortee(){};
  
}