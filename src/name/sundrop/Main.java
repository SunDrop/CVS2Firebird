package name.sundrop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @link http://www.javaworkspace.com/connectdatabase/connectFirebird.do
 */
public class Main {
    final static String fileName = "/Users/macbook/test.txt";
    public static final Pattern pattern = Pattern.compile("^([A-Z0-9]+)[ ]+(.*)[ ]+([0-9\\.]+)[ ]+([0-9]+)[ ]*$");
    public static int lineNum = 0;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try {
            readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Program run " + timeSpent/1000 + "." + timeSpent%1000 + " sec.");
    }

    public static void readFile(String fileName) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            line = br.readLine();

            Matcher match;
            while ((line = br.readLine()) != null) {

                match = pattern.matcher(line);

                if (!match.find() || 4 != match.groupCount()) {
                    System.out.println("Error: " + line);
                    System.exit(1);
                }

//                System.out.println(match.group(0));
//                System.out.println(match.group(1));
//                System.out.println(match.group(2));
//                System.out.println(match.group(3));
//                System.out.println(match.group(4));
//                System.out.println("--------");
                lineNum++;
            }
        }
        System.out.println("LineNum: " + lineNum);
    }

}
