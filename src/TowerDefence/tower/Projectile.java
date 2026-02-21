package TowerDefence.tower;
public class Projectile {

    private int damage;
    private String name;

    public Projectile(String name,int damage) {
        this.damage = damage;
        this.name=name;

    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage){
        this.damage= damage;
    }
    public String getName(){
        return this.name;
    }
}