package TowerDefence.listchooser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomListChooser<T> implements ListChooser<T> {

    private final Random random = new Random();

    /**
     * Chooses randomly among the items in the list, or null ("none").
     *
     * Null is injected as an extra candidate so it can be selected just
     * like any real item.  If the list is empty, null is always returned.
     *
     * @param msg  the question displayed before the choice
     * @param list the list of items to choose from
     * @return a randomly chosen item, or null
     */
    public T choose(String msg, List<? extends T> list) {
        if (list.isEmpty()) {
            return null;
        }

        // Build a candidate list that includes null as option 0
        List<T> candidates = new ArrayList<>();
        candidates.add(null);           // index 0 → "none"
        candidates.addAll((List<T>) list);

        // Display (mirrors InteractiveListChooser layout)
        System.out.println(msg);
        System.out.print("[0 - none");
        int index = 1;
        for (T element : list) {
            System.out.print(", " + (index++) + " - " + element);
        }
        System.out.println("]");

        // Pick uniformly among all candidates including null
        T chosen = candidates.get(random.nextInt(candidates.size()));

        if (chosen == null) {
            System.out.println("  → choix automatique : aucun");
        } else {
            System.out.println("  → choix automatique : " + chosen);
        }

        return chosen;
    }
}
