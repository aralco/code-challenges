import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_11988_BrokenKeyboard {
    //https://github.com/PuzzlesLab/UVA/blob/master/King/11988%20Broken%20Keyboard%20(a.k.a.%20Beiju%20Text).java
    public static void main (String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        try {
            while ((input=bufferedReader.readLine())!=null) {
                LinkedList<Character> resultList=new LinkedList<>();
                int position=0;
                char[] inputArray = input.toCharArray();
                for(int i=0;i<inputArray.length;i++)    {
                    if (inputArray[i]=='[')
                        position=0;
                    else if (inputArray[i]==']')
                        position=resultList.size();
                    else
                        resultList.add(position++,inputArray[i]);
                }

                StringBuilder stringBuilder = new StringBuilder();
                for(char c : resultList) {
                    stringBuilder.append(c);
                }
                System.out.println(stringBuilder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*    public static void main(String[] args)   {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("\\[[A-Za-z_]+");
        String tmp;
        String input;
        StringBuilder baseInput;
        StringBuilder result;

        try {
            while ((input=bufferedReader.readLine())!=null) {
                baseInput = new StringBuilder(input);
                Matcher matcher = pattern.matcher(input);
                result = new StringBuilder();
                while(matcher.find()) {
                    tmp = matcher.group();
                    result.append(tmp);
                    int start = matcher.start();
                    int end = matcher.end();
                    StringBuilder fillSB = new StringBuilder();
                    for(int i=start;i<end;i++)  {
                        fillSB.append(" ");
                    }
                    baseInput.replace(start, end, fillSB.toString());
                }
                result.reverse();
                result.append(baseInput);
                System.out.println(result.toString().replaceAll("[^A-Za-z_]", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
