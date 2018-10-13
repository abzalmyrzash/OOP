import java.util.Scanner;

public class Main {

    static String Num999IW(int num)
    {
        if(num == 0) return "";


        String[] ones = {"", "one", "two", "three", "four", "five",
                            "six", "seven", "eight", "nine", "ten",
                    "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                        "sixteen", "seventeen", "eighteen", "nineteen"};

        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty",
                            "sixty", "seventy", "eighty", "ninety"};

        String s = "";
        if()
        {
            s += tens[num / 10 % 10];
            if(num % 10 != 0) s += "-";
            s += ones[num % 10];
        }
        if(num > 100)
        {
            s += ones[num/100] + " hundred";
            if (num % 100 != 0) s += " [and] ";
        }

        if(num % 100 < 20) s += ones[num%100];
        else
        {
            s += tens[num / 10 % 10];
            if(num % 10 != 0) s += "-";
            s += ones[num % 10];
        }

        return s;
    }

    static String inWords(int num)
    {
        if(num == 0) return "zero";


        String s = "";

        if(num < 0)
        {
            s += "minus ";
            num = Math.abs(num);
        }

        int billions = num/1000000000;
        int millions = num/1000000%1000;
        int thousands = num/1000%1000;
        int units = num%1000;

        if(billions != 0) s += Num999IW(billions) + " billion ";
        if(millions != 0) s += Num999IW(millions) + " million ";
        if(thousands != 0) s += Num999IW(thousands) + " thousand ";
        if(units != 0) s += Num999IW(units);


        return s;
    }

    public static void main(String[] args) {
        while(true)
        {
            Scanner s = new Scanner(System.in);
            String str = s.next();
            if(str.equals("stop")) break;
            else System.out.println(inWords(Integer.parseInt(str)));
        }
    }
}
