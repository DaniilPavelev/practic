//Аркадий — большой фанат использования машинного обучения в любой задаче. Он верит в безграничную силу волшебства этой
//популярной молодой науки. Именно поэтому Аркадий постоянно постоянно придумывает всё новые и новые факторы, которые можно
//вычислить для различных объектов.
//Напомним, палиндромом называется строка, которая одинаково читается от начала к концу и от конца к началу.
// Для каждой строки в своей базе данных Аркадий хочет найти самую короткую её подстроку, состоящую хотя бы из двух
// символов и являющуюся палиндромом. Если таких подстрок несколько, Аркадий хочет выбрать лексикографически минимальную.


import java.util.ArrayList;
import java.util.Scanner;

public class FactorPolindroma {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder line = new StringBuilder(s.nextLine());
        ArrayList<String> arrPolin = new ArrayList<>();
            int i=1;
            while(i<line.length()) {
                if (line.charAt(i-1) == line.charAt(i))
                    arrPolin.add(line.substring(i-1, i+1));
                i++;
            }
            if(arrPolin.isEmpty()) {
                i = 1;
                while (i < line.length() - 1) {
                    if (line.charAt(i - 1) == line.charAt(i + 1))
                        arrPolin.add(line.substring(i - 1, i + 2));
                    i++;
                }
            }
        arrPolin.sort((String str1, String str2)-> {
            if(str1.length()-str2.length()==0)
            return str1.compareTo(str2);
            return str1.length()-str2.length();
        });

        if(arrPolin.isEmpty()){
            System.out.println(-1);
        }
        else System.out.println(arrPolin.get(0));
    }
}
