package TowerDefence.listchooser;

import java.util.ArrayList;
import java.util.List;

import TowerDefence.Player;
import TowerDefence.board.Board;
import TowerDefence.board.Position;
import TowerDefence.listchooser.util.Input;
import TowerDefence.tower.Tour;

public class AcheterTour implements Choice {
    private final ListChooser c;
    private final ArrayList<Tour> catalogue;

    public AcheterTour(ListChooser c, ArrayList<Tour> catalogue) {
        this.c = c;
        this.catalogue = catalogue;
    }

    @Override
    public void apply(Player p, Board b) {
        Tour t = (Tour) c.choose(
            "Acheter une tour | Crédits : " + p.getCredits(), this.catalogue);
        if (t == null) return;

        if (p.acheter(t)) {
            p.towers.add(t);
            List<Position> positions = b.getAllPositions();
            System.out.println("Il y a " + positions.size()
                + " positions disponibles. Choisissez un numéro (1-"
                + positions.size() + ") :");

            Position pos = null;
            while (pos == null) {
                try {
                    System.out.print("Votre choix : ");
                    int choix = Input.readInt();
                    if (choix >= 1 && choix <= positions.size()) {
                        pos = positions.get(choix - 1);
                    } else {
                        System.out.println("Numéro invalide, choisissez entre 1 et " + positions.size() + ".");
                    }
                } catch (java.io.IOException e) {
                    System.out.println("Entrée invalide, entrez un numéro.");
                }
            }
            b.putTower(t, pos);
        }
    }
    @Override
    public String toString(){
        return "Achater une Tour";
    }
}
