package TowerDefence.tower;
import TowerDefence.board.*;


public class TourelleAiguille extends Tour{ 
    private static  final double nv=0.75; 
    private static  final double nc=1.2; 
    public TourelleAiguille(){
        super(new Projectile("aiguille",1),80,1200,350,position);
    }

    public void augmenterPortee(){
        this.portee *= nc;
    }

    public void augmenterCadence(){
        this.cadence  *= nv;
    }
    //public void cibler(Board board){};
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
            if (ballon.isDestroyed()){
                System.out.println("le ballon"  + ballon.getId() + " a été detruit");
            }
        }
        
    };
   
    public  void augmenterPuissance(){};
}