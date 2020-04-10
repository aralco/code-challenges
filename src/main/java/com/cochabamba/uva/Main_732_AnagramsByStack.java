import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://github.com/izharishaksa/UVa-Solution/blob/master/src/datastructures/builtin/Problem732YES.java
//https://www.redgreencode.com/implementing-a-fast-solution-to-uva-732/
//https://saicheems.wordpress.com/2013/08/26/uva-732-anagrams-by-stack/
public class Main_732_AnagramsByStack {
    public static void main(String[] args)  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputs = new ArrayList<>();
        String input;
        try {
            while((input = bufferedReader.readLine())!=null)    {
                inputs.add(input);
                inputs.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<inputs.size();i=i+2)    {
            if(isAnagram(inputs.get(i),inputs.get(i+1)))    {
                System.out.println("[");
                depthFirstSearch(new StringBuilder(inputs.get(i)), inputs.get(i+1), new StringBuilder(), new StringBuilder(), new StringBuilder(), 0);

                System.out.println("]");
            } else
                System.out.println("[\n]");
        }
    }
    public static void depthFirstSearch(StringBuilder input, String target, StringBuilder cur, StringBuilder stack, StringBuilder path, int n) {
        if (cur.toString().equals(target)) {
            System.out.println(path.toString().trim());
        } else {
            if (input.length() > 0) {
                char c = input.charAt(0);
                String x = path.toString();
                depthFirstSearch(input.deleteCharAt(0), target, cur, stack.insert(0, c), path.append("i "), n + 1);
                input.insert(0, c);
                stack.deleteCharAt(0);
                path = new StringBuilder(x);
            }
            if (stack.length() > 0 && stack.charAt(0) == target.charAt(cur.length())) {
                char c = stack.charAt(0);
                String x = path.toString();
                depthFirstSearch(input, target, cur.append(c), stack.deleteCharAt(0), path.append("o "), n + 1);
                cur.deleteCharAt(cur.length() - 1);
                stack.insert(0, c);
                path = new StringBuilder(x);
            }
        }
    }
    public static boolean isAnagram(String s1, String s2)  {
        char[] s1array = s1.toLowerCase().toCharArray();
        char[] s2array = s2.toLowerCase().toCharArray();
        Arrays.sort(s1array);
        Arrays.sort(s2array);
        return Arrays.equals(s1array,s2array);
    }
}
