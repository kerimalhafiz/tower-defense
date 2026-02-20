public class SingeFlechettes extends Tour{
    public SingeFlechettes(Position position){
        super(new Projectile(1),100,1000,200,position);
    }
    public void augmenterPortee(){
        this.portee = this.portee*1,25;
    }

    public void augmenterCadence(){
        this.cadence = this.cadence * 0,75
    }
    public void augmenterPuissance() {
        this.projectile = new Projectile(this.projectile.getDamage()+1);
    }
}