import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Scanner;

public class GUI extends Application {

    Stage window;
    Scene inputScene, winScene, scene;
    Label player, titleLabel, namePlayer, jackpotLabel, introLabel, sorryLabel;
    Label numberLabel[] = new Label[6];
    Label final1Label, final2Label, final3Label, final4Label, final5Label, final6Label,
            final7Label, final8Label, final9Label, final10Label, final11Label, final12Label,
            final13Label, final14Label, final15Label, final16Label, final17Label, final18Label;
    Label match1, match2, match3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int[] chosenNumbers = new int[6];
        int i = 0;
        boolean isWorking = true;
        boolean isWrong = true;
        int jackpotMoney = rand.nextInt(2000000) + 50000;
        String[] inputData = new String[6];
        String jackpot = String.valueOf(jackpotMoney);
        String regex = "^[0-9]+$";

        //window title
        window = primaryStage;
        window.setTitle("Tote");

        //making our first "Grid"
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //crating labels,buttons,text boxes
        titleLabel = new Label("Welcome to tote 6/49");//naming a label for the title
        GridPane.setConstraints(titleLabel, 3, 0);//giving the label coordinates

        namePlayer = new Label("What is your name?");//naming a label for the player's name
        GridPane.setConstraints(namePlayer, 3, 5);//giving the label coordinates

        TextField nameOfPlayer = new TextField("Player");//creating a text field
        nameOfPlayer.setPromptText("Enter thy name");
        GridPane.setConstraints(nameOfPlayer, 3, 6);//giving the text field coordinates

        player = new Label();
        player.textProperty().bind(nameOfPlayer.textProperty());//binding the text from rhe text field to a label
        GridPane.setConstraints(player, 5, 5);

        Button inputButton = new Button("Enter");//making an enter button
        GridPane.setConstraints(inputButton, 3, 7);//giving the button coordinates

        grid.getChildren().addAll(inputButton, nameOfPlayer, namePlayer, titleLabel);//adding all buttons,labels and text fields to the "Grid"

        scene = new Scene(grid, 300, 200);//making the window and giving it a size

        //making our second "Grid"
        GridPane inputGrid = new GridPane();
        inputGrid.setPadding(new Insets(10, 10, 10, 10));
        inputGrid.setVgap(8);
        inputGrid.setHgap(10);

        introLabel = new Label("Our jackpot is:");//label for the jackpot
        GridPane.setConstraints(introLabel, 5, 0);//coordinates

        sorryLabel = new Label(jackpot);//label for the jackpot
        GridPane.setConstraints(sorryLabel, 6, 0);//coordinates


        Label subTitle = new Label("Enter your numbers from 1 to 49");//our mission
        GridPane.setConstraints(subTitle, 6, 5);//coordinates


        Button toFinalButton = new Button("Lets see if you have won something");//button that sends us to the final grid
        GridPane.setConstraints(toFinalButton, 8, 11);//you know what this is

        Button enterNumberButton = new Button("Enter number");//button for entering the numbers
        enterNumberButton.setOnAction(e -> inputNumbers(i, isWorking, isWrong, regex));//making the button open a method when it is activated
        GridPane.setConstraints(enterNumberButton, 8, 10);//i wont add anymore comments to coordinate code


        inputGrid.getChildren().addAll(introLabel, sorryLabel,//adding all thing to grid two
                enterNumberButton, toFinalButton, subTitle);

        inputScene = new Scene(inputGrid, 1000, 500);//size of scene 2


        GridPane finalGrid = new GridPane();//final "Grid" WIP
        finalGrid.setPadding(new Insets(10, 10, 10, 10));
        finalGrid.setVgap(8);
        finalGrid.setHgap(10);

        inputButton.setOnAction(e -> window.setScene(inputScene));//button sends us to 2nd scene

        toFinalButton.setOnAction(e -> window.setScene(winScene));//button sends us to 3rd scene


        finalLabel(final1Label, final2Label, final3Label, final4Label, final5Label, final6Label,//a method with a lot of labels in
                final7Label, final8Label, final9Label, final10Label, final11Label, final12Label,
                final13Label, final14Label, final15Label, final16Label, final17Label, final18Label,
                finalGrid, match1, match2, match3);

        winScene = new Scene(finalGrid, 600, 500);//final size

        window.setScene(scene);//with what scene we begin

        window.show();//showing the scene
    }

    public static String finalLabel(Label final1Label, Label final2Label, Label final3Label, Label final4Label, Label final5Label, Label final6Label,
                                    Label final7Label, Label final8Label, Label final9Label, Label final10Label, Label final11Label, Label final12Label,
                                    Label final13Label, Label final14Label, Label final15Label, Label final16Label, Label final17Label, Label final18Label, GridPane finalGrid,
                                    Label match1, Label match2, Label match3) {


        match1 = new Label("Matches for first draw:");
        GridPane.setConstraints(match1, 8, 10);

        final1Label = new Label("num1");
        GridPane.setConstraints(final1Label, 9, 10);
        final2Label = new Label("num2");
        GridPane.setConstraints(final2Label, 10, 10);
        final3Label = new Label("num3");
        GridPane.setConstraints(final3Label, 11, 10);
        final4Label = new Label("num4");
        GridPane.setConstraints(final4Label, 12, 10);
        final5Label = new Label("num5");
        GridPane.setConstraints(final5Label, 13, 10);
        final6Label = new Label("num6");
        GridPane.setConstraints(final6Label, 14, 10);

        match2 = new Label("Matches for second draw:");
        GridPane.setConstraints(match2, 8, 11);

        final7Label = new Label("num7");
        GridPane.setConstraints(final7Label, 9, 11);
        final8Label = new Label("num8");
        GridPane.setConstraints(final8Label, 10, 11);
        final9Label = new Label("num9");
        GridPane.setConstraints(final9Label, 11, 11);
        final10Label = new Label("num10");
        GridPane.setConstraints(final10Label, 12, 11);
        final11Label = new Label("num11");
        GridPane.setConstraints(final11Label, 13, 11);
        final12Label = new Label("num12");
        GridPane.setConstraints(final12Label, 14, 11);

        match3 = new Label("Matches for third draw:");
        GridPane.setConstraints(match3, 8, 12);

        final13Label = new Label("num13");
        GridPane.setConstraints(final13Label, 9, 12);
        final14Label = new Label("num14");
        GridPane.setConstraints(final14Label, 10, 12);
        final15Label = new Label("num15");
        GridPane.setConstraints(final15Label, 11, 12);
        final16Label = new Label("num16");
        GridPane.setConstraints(final16Label, 12, 12);
        final17Label = new Label("num17");
        GridPane.setConstraints(final17Label, 13, 12);
        final18Label = new Label("num18");
        GridPane.setConstraints(final18Label, 14, 12);


        finalGrid.getChildren().addAll(final1Label, final2Label, final3Label, final4Label, final5Label, final6Label,
                final7Label, final8Label, final9Label, final10Label, final11Label, final12Label,
                final13Label, final14Label, final15Label, final16Label, final17Label, final18Label,
                match1, match2, match3);

        return "";
    }

    public static void inputNumbers(int i, boolean isWorking,
                                    boolean isWrong, String regex) {

        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int[] chosenNumbers = new int[6];
        int firstMatches = 0;
        int secondMatches = 0;
        int thirdMatches = 0;
        int jackpotMoney = rand.nextInt(2000000) + 50000;
        String jackpot = String.valueOf(jackpotMoney);
        String[] inputData = new String[6];
        regex = "^[0-9]+$";

        //inputting the numbers we have chosen
        System.out.print("Input 6 numbers [1, 49]: ");
        for (i = 0; i < 6; i++) {
            do {
                inputData[i] = input.nextLine();//inputting from the console
                while (!inputData[i].matches(regex)) {//defence against letters
                    System.out.print("Wrong input! \nInput a correct number[1, 49]: ");//message for wrong input
                    inputData[i].matches(regex);
                    inputData[i] = input.nextLine();
                }

                chosenNumbers[i] = Integer.valueOf(inputData[i]);//converting the string to int

                isWorking = false;
                isWrong = false;
                if (chosenNumbers[i] < 1 || chosenNumbers[i] > 49) {//checking if the number is correct
                    isWorking = true;
                    isWrong = true;
                }
                for (int j = 0; j < i; j++) {//check if the following number is the same as the previous
                    if (i > 0 && chosenNumbers[j] == chosenNumbers[i]) {
                        isWorking = true;
                        isWrong = true;
                    }
                }

                if (isWrong) {//message for wrong or correct input
                    System.out.print("Wrong input. \nInput a correct number[1, 49]: ");
                } else if (!isWrong && i < 5) {
                    System.out.print("Correct input. \nInput " + (5 - i) + " more number/s: ");
                }
            }
            while (isWorking);
        }

        //generating the first draft of numbers
        int[] randomNumbersFirst = new int[6];
        randomNumbersFirst[0] = rand.nextInt(49) + 1;
        for (i = 1; i < randomNumbersFirst.length; i++) {
            do {
                isWorking = false;
                randomNumbersFirst[i] = rand.nextInt(49) + 1;
                for (int j = 0; j < i; j++) {//check if the number is the same and generating new is so
                    if (randomNumbersFirst[i] == randomNumbersFirst[j]) {
                        isWorking = true;
                    }
                }
            }
            while (isWorking);
        }

        //check if the numbers from the draw match with any of the chosen ones
        for (i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (chosenNumbers[i] == randomNumbersFirst[j]) {
                    firstMatches++;
                }
            }
        }

        //generating the second draft of numbers
        int[] randomNumbersSecond = new int[6];
        randomNumbersSecond[0] = rand.nextInt(49) + 1;
        for (i = 1; i < randomNumbersSecond.length; i++) {
            do {
                isWorking = false;
                randomNumbersSecond[i] = rand.nextInt(49) + 1;
                for (int j = 0; j < i; j++) {//check if the number is the same and generating new is so
                    if (randomNumbersSecond[i] == randomNumbersSecond[j]) {
                        isWorking = true;
                    }
                }
            }
            while (isWorking);
        }

        //check if the numbers from the draw match with any of the chosen ones
        for (i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (chosenNumbers[i] == randomNumbersSecond[j]) {
                    secondMatches++;
                }
            }
        }
        //generating the third draft of numbers
        int[] randomNumbersThird = new int[6];
        randomNumbersThird[0] = rand.nextInt(49) + 1;
        for (i = 1; i < randomNumbersThird.length; i++) {
            do {
                isWorking = false;
                randomNumbersThird[i] = rand.nextInt(49) + 1;
                for (int j = 0; j < i; j++) {//check if the number is the same and generating new is so
                    if (randomNumbersThird[i] == randomNumbersThird[j]) {
                        isWorking = true;
                    }
                }
            }
            while (isWorking);
        }

        //check if the numbers from the draw match with any of the chosen ones
        for (i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (chosenNumbers[i] == randomNumbersThird[j]) {
                    thirdMatches++;
                }
            }
        }

        //printing the first numbers in a row
        System.out.println();
        System.out.println("The first generated numbers are: ");
        for (i = 0; i < randomNumbersFirst.length; i++) {
            System.out.print(randomNumbersFirst[i] + " ");
        }
        System.out.print("and your matches are: " + firstMatches);//printing the count of the matches in the first draw
        System.out.println();

        //in irl you only get a prize if you get 3 or more matches
        switch (firstMatches) {
            case 3:
                System.out.println("Your jackpot first draw is: " + jackpotMoney * (1 / 100.0));
                break;
            case 4:
                System.out.println("Your jackpot first draw is: " + jackpotMoney * (5 / 100.0));
                break;
            case 5:
                System.out.println("Your jackpot first draw is: " + jackpotMoney * (20 / 100.0));
                break;
            case 6:
                System.out.println("Your jackpot first draw is: " + jackpotMoney);
                break;
            default:
                System.out.println("You don't win anything in the first draw!");
        }

        //printing the second numbers in a row
        System.out.println();
        System.out.println("The second generated numbers are: ");
        for (i = 0; i < randomNumbersSecond.length; i++) {
            System.out.print(randomNumbersSecond[i] + " ");
        }
        System.out.print("and your matches are: " + secondMatches);//printing the count of the matches in the second draw
        System.out.println();

        //in irl you only get a prize if you get 3 or more matches
        switch (secondMatches) {
            case 3:
                System.out.println("Your jackpot second draw is: " + jackpotMoney * (1 / 100.0));
                break;
            case 4:
                System.out.println("Your jackpot second draw is: " + jackpotMoney * (5 / 100.0));
                break;
            case 5:
                System.out.println("Your jackpot second draw is: " + jackpotMoney * (20 / 100.0));
                break;
            case 6:
                System.out.println("Your jackpot second draw is: " + jackpotMoney);
                break;
            default:
                System.out.println("You don't win anything in the second draw!");
        }

        //printing the first numbers in a row
        System.out.println();
        System.out.println("The third generated numbers are: ");
        for (i = 0; i < randomNumbersThird.length; i++) {
            System.out.print(randomNumbersThird[i] + " ");
        }
        System.out.print("and your matches are: " + thirdMatches);//printing the count of the matches in the third draw
        System.out.println();

        //in irl you only get a prize if you get 3 or more matches
        switch (thirdMatches) {
            case 3:
                System.out.println("Your jackpot third draw is: " + jackpotMoney * (1 / 100.0));
                break;
            case 4:
                System.out.println("Your jackpot third draw is: " + jackpotMoney * (5 / 100.0));
                break;
            case 5:
                System.out.println("Your jackpot third draw is: " + jackpotMoney * (20 / 100.0));
                break;
            case 6:
                System.out.println("Your jackpot third draw is: " + jackpotMoney);
                break;
            default:
                System.out.println("You don't win anything in the third draw!");
        }
    }
}