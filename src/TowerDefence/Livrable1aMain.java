package TowerDefence;
import TowerDefence.*;
import TowerDefence.listchooser.InteractiveListChooser;
import TowerDefence.tower.Evolution;
import TowerDefence.tower.TourelleAiguille;

import java.util.ArrayList;




/**
 * Main class for Livrable 1a.
 * 
 * This program creates a board with a single random path
 * starting from the left side and ending on the right side.
 */
public class Livrable1aMain {
     /**
      * the  default constructor
      */
    public Livrable1aMain(){} 
    /***
     * it's  the  main run the programme of the create the boardone 
     * @param args args 
     */
    
    public static void main(String[] args) {
        // Check for correct number of arguments
        TourelleAiguille t=new TourelleAiguille();
         InteractiveListChooser<Evolution> m=new InteractiveListChooser<>();
         m.choose("choisir une evolution", t.getEvolutions());

}}
