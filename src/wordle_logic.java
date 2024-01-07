import java.util.ArrayList;

public class wordle_logic {

     static int wordSize;
   static ArrayList<String> answer = new ArrayList<>();
    wordle_logic()
    {
        answer.add("f");
        answer.add("a");
        answer.add("r");
        answer.add("m");

        wordSize=answer.size();
    }

     static boolean matchExactLetter(int i)
    {
         if(  wordle.tf.get(i).getText().equals(answer.get(i)))
         {
             return true;
         }
         return false;
    }

    static boolean containsLetter(int i)
    {
         if(answer.contains((wordle.tf.get(i).getText())))
         {
             return true;
         }
         return false;
    }
}
