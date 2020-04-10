import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_272_TexQuotes {

    //272 - TEX Quotes
    //https://github.com/PuzzlesLab/UVA/blob/master/King/00272%20TEX%20Quotes.java
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            while((input=bufferedReader.readLine())!=null)    {
                int counter = 1;
                StringBuilder sb = new StringBuilder();
                for(char c:input.toCharArray()) {
                    if(c=='\"') {
                        sb.append(counter % 2 == 0 ? "''" : "``");
                        counter++;
                    }
                    else
                        sb.append(c);
                }
                System.out.println(sb);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        String tmp;
//        while(scanner.hasNextLine()) {
//            tmp = scanner.nextLine();
//            if(tmp!=null && !tmp.isEmpty())
//                sb.append(tmp).append("\n");
//            else {
//                scanner.close();
//                break;
//            }
//        }
//        String text = sb.toString();
//        int counter = 0;
//        while(text.contains("\""))    {
//            counter++;
//            if(counter%2!=0)
//                text = text.replaceFirst("\"", "``");
//            else
//                text = text.replaceFirst("\"", "''");
//        }
//        System.out.println(text);

/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token;
        StringBuilder sb = new StringBuilder();
        try {
            while(true)    {
                token=br.readLine();
                if(token!=null && !token.isEmpty())  {
                    sb.append(token).append("\n");
                } else
                    break;
            }

            String text = sb.toString();
            int counter = 0;
            while(text.contains("\""))    {
                counter++;
                if(counter%2!=0)
                    text = text.replaceFirst("\"", "``");
                else
                    text = text.replaceFirst("\"", "''");
            }
            System.out.println(text);


        } catch (IOException e) {
            e.printStackTrace();
        }
    */}
}
