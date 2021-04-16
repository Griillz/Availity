import java.io.*;
import java.util.*;

public class Main {

    public boolean testParenMatch(String filepath) {
        Stack<Integer> parenStack = new Stack<Integer>();
        try {
            File testFile = new File(filepath);
            Scanner fileReader = new Scanner(testFile);
            String current = "";
            while (fileReader.hasNext()) {
                current = fileReader.next();
                for (int i = 0; i < current.length(); i++) {
                    if (current.charAt(i) == '(') {
                        parenStack.push(1);
                    }
                    else if(current.charAt(i) == ')') {
                        if(parenStack.empty()) {
                            System.out.println("false");
                            return false;
                        }
                        else {
                            parenStack.pop();
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }

        if(!parenStack.empty()) {
            System.out.println("false");
            return false;
        }
        System.out.println("true");
        return true;
    }

    public static void main(String args[]) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path of the file you would like to test.\n");
        String filepath = scanner.next();
        main.testParenMatch(filepath);
    }
}