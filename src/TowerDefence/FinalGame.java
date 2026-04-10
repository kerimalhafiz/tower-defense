package TowerDefence;

import TowerDefence.board.Board;
import TowerDefence.board.Position;
import TowerDefence.listchooser.*;
import TowerDefence.tower.*;
import java.util.ArrayList;
import java.util.Random;



public class FinalGame extends Game{
    ListChooser c;
      ArrayList<Tour> catalogue;
          private int manche;
        ArrayList <Choice> actions;
    public FinalGame(Board b,int n,ListChooser c){
        super(b, n);
        this.c = c;
        this.manche = 1;
        
       
    
    
        this.catalogue = new ArrayList<>();
        this.catalogue.add(new SingeFlechettes());
        this.catalogue.add(new SingeTireurElite());
        this.catalogue.add(new TourelleAiguille());
        this.catalogue.add(new TourBombe());
        this.catalogue.add(new Gorille());
        this.catalogue.add(new TourfrozenBalloon(4));
        this.catalogue.add(new TourRballoon(3));

        this.actions = new ArrayList<>();
        this.actions.add(new AcheterTour(c, this.catalogue));
        this.actions.add(new VendreTour(c));
        this.actions.add(new AcheterEvolution(c));
        this.actions.add(new VendreEvolution(c));
        this.actions.add(new Jouer());
    }



private void phaseAchat(Player p, Board b) {
    Choice choix = (Choice) this.c.choose(
            "Que voulez-vous faire ? | Crédits : " + p.getCredits(),
            this.actions);

    while (!(choix instanceof Jouer)) {

        choix.apply(p, b);
        choix = (Choice) this.c.choose(
                "Autre action ? | Crédits : " + p.getCredits(),
                this.actions);
    }
}
    

private void achatManche1(int n){
    if (n==1){
    for (Tour t : this.catalogue) {
        for(int i=1;i<2;i++){
            this.p.acheter(t);
            Random rand = new Random();
            int x = rand.nextInt(this.b.getNbLigne());
            int y = rand.nextInt(this.b.getNbColonne());
            Position p=new Position(x,y);
            this.b.putTower(t, p);
        }

        
    }

}
    return ;
}

private void mancheUnCinq(int n){
    if (n<6){
        ArrayList <Tour> liste=this.p.towers;
        ArrayList <Tour> listeEvo = new ArrayList<>();
        for (Tour t : liste) {
            if (t.getEvolutions().size()!=0){
                listeEvo.add(t);
            }
        }
        Random rand = new Random();
        int choice = rand.nextInt(listeEvo.size());
        Tour t=listeEvo.get(choice);
        ArrayList <Evolution> evolutions =t.getEvolutions();
        int choiceEvo = rand.nextInt(evolutions.size());
        Evolution e=evolutions.get(choiceEvo);
        this.p.acheterEvolution(t, e);   
        System.out.println("L evolution: "+e.toString() +" de la tour "+ t.toString()+" a été acheté à la manche "+n);
}}    
    
private void mancheSixDix(int n){
    if(n>10 &n<11){

       ArrayList <Tour> liste=this.p.towers;
        ArrayList <Tour> listeEvo = new ArrayList<>();
        for (Tour t : liste) {
            
            if (t.getEvolutions().size()!=0){
                 ArrayList<Evolution> evolutions=t.getEvolutions();
                 for (Evolution e : evolutions) {
                    if(e.isbuy()){
                        liste.add(t);
                    } 
                 }
            }
        }
        /*Choix de la tour */
        Random rand = new Random();
        int choice = rand.nextInt(listeEvo.size());
        Tour t=listeEvo.get(choice);
        ArrayList <Evolution> evolutionsT =t.getEvolutions();
        ArrayList<Evolution> disponibles = new ArrayList<>();
        for (Evolution e : evolutionsT) {
            if (e.isbuy()) disponibles.add(e);
        }
        int choiceEvo=rand.nextInt(disponibles.size());
        Evolution e=disponibles.get(choiceEvo);
        this.p.vendreEvolution(t, e);
        System.out.println("L evolution: "+e.toString() +" de la tour "+ t.toString()+" a été vencdu à la manche "+n);
}}

public void play() {
    
    
    System.out.println(this.p);

    while (this.p.isAlive() && this.manche<=10) {

        System.out.println("\n--- Phase d'achat — Manche " + this.manche + " ---");
        this.achatManche1(this.manche);
        this.mancheUnCinq(manche);
        this.mancheSixDix(manche);
        super.play();
        this.manche++;
    }

    System.out.println("\n=== Game Over — Plus de vies ! Tu as perdu hahahaha ===");
}




}
