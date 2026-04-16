package inputtest;

import java.io.*;
import java.util.*;
import org.junit.*;
import TowerDefence.listchooser.*;
import TowerDefence.listchooser.util.*;


public class testinput {

    private static InputStream systemIn;
    private static InputStream systemOut;
    private InteractiveListChooser <String> interactiveChooser;
    private RandomListChooser <String> randomChooser;

    @BeforeClass
    public static void changeSystemOut(){
        System.out.println("tests begin");
    }


}