import java.util.Scanner;

class MathApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer a = Integer.valueOf(12);
        Integer b = Integer.valueOf("15");
        Integer c = Integer.valueOf(in.nextLine());
        String op = in.nextLine();

        if(op.equals("+"))
            System.out.println(a+b+c);
        else if (op.equals("-"))
            System.out.println(a-b-c);
        else
            System.out.println(a*b*c);
    }
}