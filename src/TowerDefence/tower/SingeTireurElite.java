package TowerDefence.tower;
import TowerDefence.board.Board;
import TowerDefence.board.Position;

public class SingeTireurElite extends Tour{
    private static  final double nb=1.25; 
    private static  final double nv=0.75;
    private static final double val_infinie = 10000;
    public SingeTireurElite(Position position){
        super(new Projectile("singe tireur elite",4),val_infinie,2000,500,position);
    }
    public void augmenterCadence(){
        this.cadence *= nv;
    }
    public void augmenterPuissance() {
        this.projectile.setDamage(this.projectile.getDamage()+2);
        
    }
    public void cibler(Board board){};
    public void tirer(Board b){
        ArrayList<Balloon> ballons_voisin =neighborhood(b);
        if (ballons_voisin isempty()){
            return;
        }
        Balloon b_proche = null;
        for (Balloon ballon : ballons_voisin){
            if (ballon == null || ballon isDestroyed() || ballon isOut()){
                continue;
            }
            if (cible == null || b.getPosition() > cible.getPosition()){
                b_proche = ballon;
            }
        }
        if (b_proche != null){
            b_proche.takeDamage(this.projectile.getDamage())
            
        }
        
    };
    public void augmenterPortee(){};
  
}