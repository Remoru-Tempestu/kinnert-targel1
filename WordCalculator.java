/*name : ali telawi
  ID: 323829119
*

*
* */
import java.util.Scanner;
public class WordCalculator {
    public static void main(String[] args) {
        boolean a = true;
        String[] ary=new String[0];
        String Verbal_expression1 = "";
        String Verbal_expression2 = "";
        while (a) {
            a = false;
            Scanner input = new Scanner(System.in);
            System.out.println(" pls Enter expression:");
            Verbal_expression1 = input.nextLine();
            Verbal_expression2=Verbal_expression1.replaceAll("divided by","divided.by");
            Verbal_expression2=Verbal_expression2.replaceAll("\\s+"," ");
            Verbal_expression2=Verbal_expression2.toLowerCase();

            ary = Verbal_expression2.split(" ");
            for (int i = 0; i < ary.length; i++) {
                if (i % 2 == 0) {
                    if (Translation_of_numbers(ary[i]) == -1) {
                        System.out.println("error");
                        a = true;
                    }
                }
                if (i % 2 == 1) {
                    if (Convert_to_calculations(ary[i]) == 0) {
                        System.out.println("error");
                        a = true;
                    }
                }

                if(Convert_to_calculations(ary[i])=='/' && Translation_of_numbers(ary[i+1])==0)
                {System.out.println("error");
                    a = true;}


            }}


        System.out.println("The value of expression '" + Verbal_expression1 + "' is: " + Calculate_the_input_value( ary));
    }
    public static int Calculate_the_input_value(String[] ary) { int value;
        int[] numbers = new int[(ary.length + 1) / 2];
        char[] operators = new char[ary.length / 2];
        for (int i = 0, j = 0, g = 0; i < ary.length; i++) {
            if (i % 2 == 0) {
                numbers[j++] = Translation_of_numbers(ary[i]);
            } else {
                operators[g++] = Convert_to_calculations(ary[i]);
            }
        }


        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == '*' || operators[i] == '/') {
                if (operators[i] == '*') {
                    numbers[i] = numbers[i] * numbers[i + 1];
                } else {
                    numbers[i] = numbers[i] / numbers[i + 1];
                }

                for (int j = i + 1; j < numbers.length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                for (int j = i; j < operators.length - 1; j++) {
                    operators[j] = operators[j + 1];
                }
                i--;
                numbers[numbers.length - 1] = 0;
                operators[operators.length - 1] = 0;
            }
        }
        value = numbers[0];
        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == '+') {
                value += numbers[i + 1];
            } else if (operators[i] == '-') {
                value -= numbers[i + 1];
            }
        }
        return value;}
    public static char Convert_to_calculations(String b){
        return switch (b) {
            case "plus" -> '+';
            case "minus" -> '-';
            case "times" -> '*';
            case "divided.by" -> '/';
            default -> 0;
        };
    }
    public static int Translation_of_numbers(String a) {
        return switch (a) {
            case "zero" -> 0;
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            case "ten" -> 10;
            default -> -1;
        };
    }}


/*
* C:\Java\jdk-20.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2\lib\idea_rt.jar=50815:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\819\IdeaProjects\WordCalculator4\out\production\WordCalculator4 WordCalculator4
 pls Enter expression:
eight divided by two plus seven plus two times three minus one
The value of expression 'eight divided by two plus seven plus two times three minus one' is: 16

Process finished with exit code 0

* */
