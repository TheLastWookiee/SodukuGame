import java.util.Scanner;

public class Operations {
    public static void InvalidInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("Continue playing(Y/N)?\n");
        String userInput = in.nextLine();
        if(userInput.equals("N")){
            System.exit(0);
        } else if(userInput.equals("Y")){
            return;
        }
    }
}
