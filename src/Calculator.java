import java.util.*;

public class Calculator {
    static void arabicDigits(char[] final_string){
         String operation = "";
         char tempOperation = ' ';
         String tempString1 = "";
         String tempString2 = "";
         String tempStringDigit1 = "";
         String tempStringDigit2 = "";
         int digit1 = 0;
         int digit2 = 0;

         int counterForDigit1 = 0;
         int counter = 0;
         int counterForDigit2 = 0;

         while (counter < final_string.length-1){
             char i = final_string[counterForDigit1];

             if(Character.isDigit(i)){
                 tempString1 = Character.toString(i);
                 tempStringDigit1 = tempStringDigit1.concat(tempString1);
                 digit1 = Integer.parseInt(tempStringDigit1);
                 counter++;
                 counterForDigit1++;
                 counterForDigit2++;
             }
             else{
                 counterForDigit2++;
                 counter = counterForDigit2;

                 tempOperation = i;
                 operation = Character.toString(tempOperation);

                 char j = final_string[counterForDigit2];
                 if(Character.isDigit(j)){
                     tempString2 = Character.toString(j);
                     tempStringDigit2 = tempStringDigit2.concat(tempString2);
                     digit2 = Integer.parseInt(tempStringDigit2);
                 }
                 else{
                     System.out.println("Введены не арабские цифры или введены дробные числа");
                     System.exit(0);
                 }
             }
         }
         arabicNumbersOperation(digit1, digit2, operation);
     }

    static void romanDigits(char[] final_string){
        String operation = "";
        char tempOperation = ' ';
        String tempString1 = "";
        String tempString2 = "";
        String digit1 = "";
        String digit2 = "";

        int counterForDigit1 = 0;
        int counter = 0;
        int counterForDigit2 = 0;

        while (counter < final_string.length-1){
            char i = final_string[counterForDigit1];

            if(Character.isLetter(i)){
                tempString1 = Character.toString(i);
                digit1 = digit1.concat(tempString1);

                counter++;
                counterForDigit1++;
                counterForDigit2++;
            }
            else{
                counterForDigit2++;
                counter = counterForDigit2;

                tempOperation = i;
                operation = Character.toString(tempOperation);

                char j = final_string[counterForDigit2];

                if(Character.isLetter(j)){
                    tempString2 = Character.toString(j);
                    digit2 = digit2.concat(tempString2);

                }
                else{
                    System.out.println("Введены не римские цифры");
                    System.exit(0);
                }
            }
        }
        convertArabicToRomanAndOutput(convertRomanToArabic(digit1), convertRomanToArabic(digit2), operation);
    }

    static int convertRomanToArabic(String x){
        if (!x.equals("I") && !x.equals("V") && !x.equals("X")&& !x.equals("IX")
                && !x.equals("II")&& !x.equals("III")&& !x.equals("IV")&& !x.equals("VI")&& !x.equals("VII")&& !x.equals("VIII")){
            System.out.println("Числа введены некорректно или Введено число более X (десяти)");
            System.exit(0);
        }
        else {
            switch (x) {
                case "I": return 1;
                case "II": return 2;
                case "III": return 3;
                case "IV": return 4;
                case "V": return 5;
                case "VI": return 6;
                case "VII": return 7;
                case "VIII": return 8;
                case "IX": return 9;
                case "X": return 10;
            }
        }
        throw new RuntimeException();
    }

    static void arabicNumbersOperation(double digit1, double digit2, String operation){
        if(digit1 <= 10 && digit2 <= 10){
            if(operation.equals("+")){
                System.out.println((digit1 + digit2));
            }
            if(operation.equals("-")){
                System.out.println((digit1 - digit2));
            }
            if(operation.equals("*")){
                System.out.println((digit1 * digit2));
            }
            if(digit2 != 0){
                if(operation.equals("/")){
                    System.out.println((digit1 / digit2));
                }
            }
            else{
                System.out.println("Ошибка деления на 0");
            }
            if(!operation.equals("+") && !operation.equals("-") && !operation.equals("*")&&!operation.equals("/")){
                System.out.println("Введена неподходящая операция (деление, умножение, вычитание и сложение)");
            }
        }
        else{
            System.out.println("При работе учитываются только числа до 10 включительно");
            System.exit(0);
        }


    }

    static void convertArabicToRomanAndOutput(int digit1, int digit2, String operation){
        int operationvalue = 0;
        if(digit1 <= 10 && digit2 <= 10){
            if(operation.equals("+")){
                operationvalue = digit1 + digit2;
            }
            if(operation.equals("-")){
                operationvalue = digit1 - digit2;
            }
            if(operation.equals("*")){
                operationvalue = digit1 * digit2;
            }
            if(digit2 != 0){
                if(operation.equals("/")){
                    operationvalue = digit1 / digit2;
                }
            }
            else{
                System.out.println("Ошибка деления на 0");
            }
            if(!operation.equals("+") && !operation.equals("-") && !operation.equals("*")&&!operation.equals("/")){
                System.out.println("Введена неподходящая операция (деление, умножение, вычитание и сложение)");
            }
        }
        else{
            System.out.println("При работе учитываются только числа до 10 включительно");
            System.exit(0);
        }
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");

        if(map.get(operationvalue) != null){
            System.out.println(map.get(operationvalue));
        }
        else{
            System.out.println("Ответ на пример равен больше X (десяти) и не учитывается работой калькулятора");
        }
    }

    public static void main(String[] args){
        System.out.println("Введите пример для решения в строчку:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().toUpperCase();
        String str2 = str.replaceAll(" ",""); // all spaces remove from string;
        char[] final_string = str2.toCharArray();

        if(Character.isDigit(final_string[0])){
            arabicDigits(final_string);
        }
        else{
            romanDigits(final_string);
        }
     }
}

