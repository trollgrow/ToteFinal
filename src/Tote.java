import java.util.Random;
import java.util.Scanner;


public class Tote {
    public static void main(String[] args) {
        //our jackpot
        int jackpotMoney = 1;
        int generatedJackpot = jackpot(jackpotMoney);
        System.out.println("The big jackpot is " + generatedJackpot + " leva");

        //initialization
        Scanner input = new Scanner(System.in);
        int[] chosenNumbers = new int[6];
        int i = 0;
        boolean isWorking;
        boolean isWrong;
        int firstMatches = 0;
        int secondMatches = 0;
        int thirdMatches = 0;
        String[] inputData = new String[6];
        String regex = "^[0-9]+$";

        //input the numbers we have chosen
        System.out.print("Input 6 numbers [1, 49]: ");
        for (i = 0; i < 6; i++) {
            do {
                inputData[i] = input.nextLine();//inputting from the console
                while (!inputData[i].matches(regex)) {//letters defence
                    System.out.print("Wrong input! \nInput a correct number[1, 49]: ");//message for wrong input
                    inputData[i].matches(regex);
                    inputData[i] = input.nextLine();
                }

                chosenNumbers[i] = Integer.valueOf(inputData[i]);//the string is converted to int

                isWorking = false;
                isWrong = false;
                if (chosenNumbers[i] < 1 || chosenNumbers[i] > 49) {//checking if the numbers are correct
                    isWorking = true;
                    isWrong = true;
                }
                for (int j = 0; j < i; j++) {//check if the following number is the same as the previous
                    if (i > 0 && chosenNumbers[j] == chosenNumbers[i]) {
                        isWorking = true;
                        isWrong = true;
                    }
                }

                if (isWrong) {//message for correct or wrong input
                    System.out.print("Wrong input. \nInput a correct number[1, 49]: ");
                } else if (!isWrong && i < 5) {
                    System.out.print("Correct input. \nInput " + (5 - i) + " more number/s: ");
                }
            }
            while (isWorking);
        }

        //generating the first draft of numbers
        int[] randomNumbersFirst = new int[6];
        Random rand = new Random();
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

        //check if the drawn numbers match with any of the ours
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

        //check if the drawn numbers match with any of the ours
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

        //check if the drawn numbers match with any of the ours
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
                System.out.println("Your jackpot first draw is: " + generatedJackpot * (1 / 100.0));
                break;
            case 4:
                System.out.println("Your jackpot first draw is: " + generatedJackpot * (5 / 100.0));
                break;
            case 5:
                System.out.println("Your jackpot first draw is: " + generatedJackpot * (20 / 100.0));
                break;
            case 6:
                System.out.println("Your jackpot first draw is: " + generatedJackpot);
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
                System.out.println("Your jackpot second draw is: " + generatedJackpot * (1 / 100.0));
                break;
            case 4:
                System.out.println("Your jackpot second draw is: " + generatedJackpot * (5 / 100.0));
                break;
            case 5:
                System.out.println("Your jackpot second draw is: " + generatedJackpot * (20 / 100.0));
                break;
            case 6:
                System.out.println("Your jackpot second draw is: " + generatedJackpot);
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
                System.out.println("Your jackpot third draw is: " + generatedJackpot * (1 / 100.0));
                break;
            case 4:
                System.out.println("Your jackpot third draw is: " + generatedJackpot * (5 / 100.0));
                break;
            case 5:
                System.out.println("Your jackpot third draw is: " + generatedJackpot * (20 / 100.0));
                break;
            case 6:
                System.out.println("Your jackpot third draw is: " + generatedJackpot);
                break;
            default:
                System.out.println("You don't win anything in the third draw!");
        }
    }

    //method for the generating random jackpot [50000, 2000000]
    public static int jackpot(int jackpotMoney) {
        Random rand = new Random();
        jackpotMoney = rand.nextInt(2000000) + 50000;
        return jackpotMoney;
    }
}