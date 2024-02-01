// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

Soduku.display();
    System.out.println("Continue playing(Y/N)?");
        String userInput = in.nextLine();
        if(userInput.equals("N")){
            System.exit(0);
        } else if(userInput.equals("Y")){
        int row, column, value;
        while(1!=0){
        System.out.println("Enter Row:");

        try {
            int intValue = Integer.parseInt(in.nextLine());
            if(intValue < 1 || intValue >9){
               Operations.InvalidInput();
            }else{break;}
        } catch (NumberFormatException e) {
            // Handle the case where parsing as an integer fails
            Operations.InvalidInput();
        }}
        while(1!=0){
        System.out.println("Enter Column:");

        try {
            int intValue = Integer.parseInt(in.nextLine());
            if(intValue < 1 || intValue >9){
                Operations.InvalidInput();
            }else{break;}

        } catch (NumberFormatException e) {
            // Handle the case where parsing as an integer fails
            Operations.InvalidInput();
        }}
        while(1!=0){
        System.out.println("Enter Value:");

        try {
            int intValue = Integer.parseInt(in.nextLine());
            if(intValue < 1 || intValue >9){
                Operations.InvalidInput();
            }else{break;}
        } catch (NumberFormatException e) {
            // Handle the case where parsing as an integer fails
            Operations.InvalidInput();
        }}
    }
    }
}