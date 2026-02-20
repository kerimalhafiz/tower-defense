package TowerDefence.tower;
import TowerDefence.board.Board;
import TowerDefence.board.Position;

public class SingeTireurElite extends Tour{
    private static  final double nb=1.25; 
    private static  final double nv=0.75;
    private static final double val_infinie = 10000;
    public SingeTireurElite(Position position){
        super(new Projectile(4,"singe tireur elite"),val_infinie,2000,500,position);
    }
    public void augmenterCadence(){
        this.cadence *= nv;
    }
    public void augmenterPuissance() {
        this.projectile = new Projectile(this.projectile.getDamage()+2,"singe tireur elite");
        
    }
    public void cibler(Board board){};
    public void tirer(Board b){
        ArrayList<Balloon> ballons_voisin =neighborhood(b);
        if (ballons_voisin == null){
            return;
        }
        for (Balloon ballon : ballons_voisin){
            if (!ballon.isDestroyed() && !ballon.isOut()){
                ballon.takeDamage(this.projectile.getDamage());
            }
        }
    };
    public void augmenterPortee(){};
  
}