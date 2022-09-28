import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(s.nextLine());
        stringBuilder.delete(0,stringBuilder.indexOf(" ")+1);
        System.out.println(stringBuilder);
    }
}
