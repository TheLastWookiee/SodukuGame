
/**
 * Caiden Henn
 * COP 3809 Advanced Topics in Programming
 * 2/5/2024
 *
 * A Soduku game programmed in Java.
 *
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Sudoku.display();
        GenerateBoard generator = new GenerateBoard(9,10);
        generator.fillValues();
        Sudoku.display();





        Scanner in = new Scanner(System.in);
        //loops if there is an invalid input
        boolean noloop=false;
        Sudoku.display();
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
            while (!Sudoku.isSolved()) {
                //get data from user
                System.out.println("Enter Row:");
                int row = Integer.parseInt(in.nextLine());
                System.out.println("Enter Column:");
                int col = Integer.parseInt(in.nextLine());
                System.out.println("Enter Value:");
                int val = Integer.parseInt(in.nextLine());
                //error message for invalid row/col
                if (!Sudoku.isValueValid(row) || !Sudoku.isValueValid(col)) {
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
                }else if(!Sudoku.isValueValid(val)){
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
                    if(Sudoku.isRowColumnValid(row,col)){
                        if(Sudoku.isEntryCorrect(val,row,col)){

                            Sudoku.sudokuBoard[row-1][col-1] = val;
                                System.out.println("Correct!");
                            Sudoku.display();


                        }else{//if value is not correct, prints and displays
                            System.out.println("NOT Correct!");
                            Sudoku.display();
                            //Continue Playiyng?
                            System.out.println("Continue playing(Y/N)?");

                            String userInput1 = in.nextLine();

                            if (userInput1.equals("N")) {
                                System.exit(0);
                            } else if (userInput1.equals("Y")) {
                                continue;
                            }
                        }

                    }else{//Not a valid entry, stops and asks if you want to keep playing
                        System.out.println("Wrong Entry");
                        Sudoku.display();
                        System.out.println("Continue playing(Y/N)?");

                        String userInput1 = in.nextLine();

                        if (userInput1.equals("N")) {
                            System.exit(0);
                        } else if (userInput1.equals("Y")) {
                            continue;
                        }

                    }

                }

            }
            System.out.println("Congratulations, you solved it!");
        }
    }



