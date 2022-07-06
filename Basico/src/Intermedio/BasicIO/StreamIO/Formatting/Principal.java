package Intermedio.BasicIO.StreamIO.Formatting;

public class Principal {
    public static void main(String[] args) {

        //print y println
        int i = 2;
        double r = Math.sqrt(i);

        System.out.print("The square root of ");
        System.out.print(i);
        System.out.print(" is ");
        System.out.print(r);
        System.out.println(".");

        i = 5;
        r = Math.sqrt(i);
        System.out.println("The square root of " + i + " is " + r + ".");

        System.out.println();
        System.out.println();

        //Formatting
        int f = 2;
        double z = Math.sqrt(f);

        System.out.format("The square root of %d is %f.%n", f, z);

    }
    /*
    Like the three used in this example, all format specifiers begin with a % and end with a 1- or 2-character conversion
    that specifies the kind of formatted output being generated.
    The three conversions used here are:
        d formats an integer value as a decimal value.
        f formats a floating point value as a decimal value.
        n outputs a platform-specific line terminator.

        Here are some other conversions:
        x formats an integer as a hexadecimal value.
        s formats any value as a string.
        tB formats an integer as a locale-specific month name.
    */

}
