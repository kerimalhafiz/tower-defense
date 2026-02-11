package TowerDefence.Balloon;

import TowerDefence.board.Cell;
import TowerDefence.board.Position;
import java.util.ArrayList;

/**
 * Abstract class representing a balloon moving on the board.
 */
public abstract class Balloon {

 protected Cell cell;
 protected float speed; 
 protected int resistance;
 protected float progress; 
// position inside the current cell
 protected boolean frozen; 
// si mon ballon est gele ou pas 
 protected int frozenTicks;
// time rest to ecoul of frozen
 protected int currentPathIndex=0;
 protected String id;
 protected static int points = 0; 
//when start the balloon the point attibuate
 protected float time; //the time 
 public int position=0;
 protected ArrayList<Position> path;
 
 public Balloon(float speed, int resistance,String id) {
 this.speed = speed;
 this.resistance = resistance;
 this.progress = 0;
 this.frozen = false; // au debut aucun ballon n'est gele ou glacer 
 this.frozenTicks = 0;
 this.id=id;
 this.time=0;
 this.cell=null;
 this.path=null;
 }
 public void putPath(ArrayList<Position> p){
   this.path=p;
 }
 public ArrayList<Position> getPath(){
   return this.path;
 }
 public String getId(){
 return this.id;
 }
 public float getSpeed(){
 return this.speed;

 }
 public boolean isFrozen(){
 return this.frozen;
 }
 public void AjoutProgress(){
 this.progress+=this.speed;
 }
 public void enleveProgress(){
 this.progress-=1;
 }
 public void setTime(){
 this.time++;
 }
 public float getTime(){
 return this.time;
 }
 public Cell getCell(){
 return this.cell;
 }
 public void SetCell(Cell c){
 this.cell=c;
 }

 /**
 * Moves the balloon along the given path.
 */
 //public abstract void move(List<Position> path); 

 /**
 * Applies damage to the balloon.
 */
 public void takeDamage(int damage) {
 resistance -= damage;
 if (resistance <0) {
 resistance=0;
 }
 if (resistance == 0) {
 points += 10;
 }
 }

 /**
 * Freezes the balloon for a given number of ticks.
 */
 public void freeze(int ticks) {
 frozen = true;
 frozenTicks = ticks; // gele le ballon 
 }

 /**
 * Updates the frozen state.
 */
 public void updateFrozenState() {
 if (frozen) {
 frozenTicks--;
 if (frozenTicks <= 0) {
 frozen = false;
 }
 }
 }
 /**
 * hi test if the resistance is 0 return True to guid fo player the ballon is push
 * @return True if the resistance=0
 */
 public boolean isDestroyed() {
 return resistance <= 0;
 }
 /**
 * it s the getter return index actuell
 * @return currentPathIndex the index current 
 */
 public int getcurrentPathIndex(){
 return this.currentPathIndex;
 }
 /**
 * the progress actuel 
 * @return progress the progression of the ballon
 */
 public float getprogress(){
 return this.progress;
 }
 public String toString(){
 return "X";
 }
 public int getPosition(){
    return this.position;
 }

 public void setPosition(){
    this.position+=1;
 }

 public Boolean isOut(){
   return this.cell.getPosition()==this.path.get(this.path.size()-1);//derniere cellulle est la cellule cureent
 }
}