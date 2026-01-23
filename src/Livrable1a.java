import java.util.ArrayList;
public class Livrable1a {
    public static void main(String[] args) {
        int height = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        Board board = new Board(height, width);
        Path path = new PathOne();
        ArrayList<Cell> chemin = path.findPath(board);

        board.printWithPath(chemin); 
        System.out.println("Path cells:");
        for (Cell c : chemin) {
            System.out.println(c);
        }
    }
}
