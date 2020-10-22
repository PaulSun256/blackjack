/*
+========================================+
|              Jokes class               |
+========================================+
|          Paul Sun, 2020/10/20          |
+========================================+
|              ICS3U Ms. S               |
+========================================+
| This is the class for jokes. Jokes are |
|   static, meaning that the jokes 'in   |
| stock' are unchanging from instance to |
|   instance. The jokes are read from a  |
|                  file.                 |
+========================================+
*/
import java.util.*;
import java.io.*;

public class Jokes	{
    
    private static ArrayList<String> jokes = new ArrayList<String>();

    public Jokes()  {
        
        // fills the arryalist with hilarious jokes
        getTheFunny();
    }


// methods
// --------------------------------------------------------------------------------------------------------------------------------------------------
    
    // method to read the jokes from a file and shuffle them
    public static void getTheFunny() {
        
        String joke = "";
        Scanner inputFile = null;

        // attempts to read from file
        try {
            
            inputFile = new Scanner(new File("hahafunny.txt"));

            while (inputFile.hasNextLine())  {
                
                joke = inputFile.nextLine();
                jokes.add(joke);
            }
            
            Collections.shuffle(jokes);
            
        } catch (FileNotFoundException notFound)    {

            System.out.println("file was not found: " + notFound);
        } catch (Exception e)   {

            System.out.println("something went wrong: " + e);
        }
    }

    // returns the next joke and removes it
    public static String nextFunny()    {
        
        if (jokes.size() == 0)  getTheFunny();

        return jokes.remove(0);
    }
}