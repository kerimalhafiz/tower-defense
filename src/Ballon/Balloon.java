package Ballon;

import path.Path;
public abstract class Ballon {
 protected  float speed;
 protected int x,y;
 protected int resistance;
 protected static int point=0;

 public Ballon(int x,int y,float speed,int resistance){
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.resistance=resistance;
 }

public boolean isDestroyed() {
    if (resistance <= 0) {
        points += 10;
        return true;
    }
    return false;
}

public abstract void move(Path direcPath);

public abstract void is_icy(int speed, int x,int y)
}
    

