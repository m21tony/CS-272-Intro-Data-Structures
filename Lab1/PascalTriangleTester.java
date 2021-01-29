/**
	Test harness for PascalTriangle program.
	Big Java, Wiley, 2nd ed. 
*/

import java.util.Scanner;

public class PascalTriangleTester
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter height: ");
        int h = in.nextInt();

        PascalTriangle tri = new PascalTriangle(h);

        System.out.println(tri.toString());
    }
}
