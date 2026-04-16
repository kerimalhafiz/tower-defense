package inputtest;

import java.io.*;
import java.util.*;
import org.junit.*;
import TowerDefence.listchooser.*;
import TowerDefence.listchooser.util.*;
import TowerDefence.tower.*;


public class testinput {

    private static InputStream systemIn;
    private static InputStream systemOut;
    private InteractiveListChooser <Tour> interactiveChooser;
    private RandomListChooser <Tour> randomChooser;
    private List<Tour>listes;

    @BeforeClass
    public static void changeSystemOut(){
        System.out.println("tests begin");
        systemIn=System.in;
        systemOut=System.out;
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @AfterClass
    public static void restoreSystemInOut(){
        System.setIn(systemIn);
        System.setOut(systemOut);
        System.out.println("test end");
    }
    @Before
    public  void init(){
        this.interactiveChooser=new InteractiveListChooser<>();
        this.randomChooser=new RandomListChooser<>();
        this.listes=new ArrayList<>();
        listes.add(new SingeFlechettes());
        listes.add(new TourBombe());
        listes.add(new Gorille());
        listes.add(new SingeTireurElite());
        listes.add(new TourelleAiguille());
        listes.add(new TourRballoon(3));
        listes.add(new TourfrozenBalloon(9));

    }

    public void simulateInput(String input){
        InputStream in =new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


    }
    @Test
    public void testInteractive(){
    }
}
