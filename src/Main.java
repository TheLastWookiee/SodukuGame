
/**
 * A soduku game programed in Java by Caiden Henn
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //loops if there is an invalid input
        boolean noloop=false;
        Soduku.display();
        while(!noloop){
        System.out.println("Continue playing(Y/N)?");
        String userInput = in.nextLine();

        if (userInput.equals("N")) {
            System.exit(0);
        } else if (userInput.equals("Y")) {
            getInput(in, userInput);
            noloop=true;
        }else{
            System.out.println("Invalid Input");
        }
    }}

    static private void getInput (Scanner in, String userInput){
            boolean valid = false;
            //main loop
            while (!Soduku.isSolved()) {
                //get data from user
                System.out.println("Enter Row:");
                int row = Integer.parseInt(in.nextLine());
                System.out.println("Enter Column:");
                int col = Integer.parseInt(in.nextLine());
                System.out.println("Enter Value:");
                int val = Integer.parseInt(in.nextLine());
                //error message for invalid row/col
                if (!Soduku.isValueValid(row) || !Soduku.isValueValid(col)) {
                    System.out.println("Invalid Row/Column");
                    boolean noloop=false;
                    while(!noloop){
                    System.out.println("Continue playing(Y/N)?");
                    String userInput1 = in.nextLine();

                    if (userInput1.equals("N")) {
                        System.exit(0);
                    } else if (userInput1.equals("Y")) {
                        noloop=true;
                    }else {
                        System.out.println("Invalid Input");

                    }
                }
                    //error message for invalid value
                }else if(!Soduku.isValueValid(val)){
                    System.out.println("Invalid Value");
                    System.out.println("Continue playing(Y/N)?");
                    String userInput1 = in.nextLine();

                    if (userInput1.equals("N")) {
                        System.exit(0);
                    } else if (userInput1.equals("Y")) {
                        valid = false;
                    }
                }



                else {
                    //if value is correct, prints and displays
                    if(Soduku.isRowColumnValid(row,col)){
                        if(Soduku.isEntryCorrect(val,row,col)){

                                Soduku.sudokuBoard[row-1][col-1] = val;
                                System.out.println("Correct!");
                                Soduku.display();


                        }else{//if value is not correct, prints and displays
                            System.out.println("NOT Correct!");
                            Soduku.display();
                            //Continue Playiyng?
                            System.out.println("Continue playing(Y/N)?");

                            String userInput1 = in.nextLine();

                            if (userInput1.equals("N")) {
                                System.exit(0);
                            } else if (userInput1.equals("Y")) {
                                ;
                            }
                        }

                    }else{//Not a valid entry, stops and asks if you want to keep playing
                        System.out.println("Wrong Entry");
                        Soduku.display();
                        System.out.println("Continue playing(Y/N)?");

                        String userInput1 = in.nextLine();

                        if (userInput1.equals("N")) {
                            System.exit(0);
                        } else if (userInput1.equals("Y")) {
                        ;
                        }

                    }

                }

            }
            System.out.println("Congratulations, you solved it!");
        }
    }



