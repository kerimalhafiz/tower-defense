package TowerDefence.listchooser;

import java.util.ArrayList;

public class AcheterTour implements Choice {
    private final ListChooser c;
    private final ArrayList<Tour> catalogue;

    public AcheterTour(ListChooser c, ArrayList<Tour> catalogue) {
        this.c = c;
        this.catalogue = catalogue;
    }
}
