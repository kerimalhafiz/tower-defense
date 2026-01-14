/**
  this. class in
 */
public class Cell{

    private int x;
    private int y;

    public Cell(int x,int y){
        this.x=x;
        this.y=y;
    }
   public int getX(){
     return  this.x;
   }
   public int getY(){
    return this.y;
   }
   public  void setvalueX(int new_x){
      this.x=new_x;
    
   }
   public void setvalueY(int new_y){
       this.y=new_y;
   }
   
   public String toString(){
    return "(x="+ x + ","+ y + ")";
   }
  @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cell))
             {return false;}
        Cell c = (Cell) o;
        return x == c.x && y == c.y;
    }
}