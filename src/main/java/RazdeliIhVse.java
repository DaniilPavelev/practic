//Перед тем как начать стрельбу, Оля и Толя хотят убедиться, что они смогут однозначно идентифицировать результаты своих
//выстрелов. Для этого они договорились провести прямую, которая поделит плоскость с мишенями на две части. Однако, чтобы
//никому не было обидно, они хотят провести прямую таким образом, чтобы каждая мишень была поделена ровно пополам, то
//есть для каждого круга и каждого прямоугольника должно быть верно, что прямая делит его на две фигуры равной площади.
//Когда Оля и Толя наконец закончили прорабатывать все условия разделения мишеней на две части, они начали сомневаться,
//что провести такую прямую вообще возможно, и просят вас ответить на этот вопрос.


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class RazdeliIhVse {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner s = new Scanner(file);
        int count = Integer.valueOf(s.nextLine());
        int countI=2;
        double[] coord1 = new double[2];
        double[] coord2 = new double[2];
        boolean flag=true;
        boolean isDiffirent=true;
        if(count==1||count==2){
            System.out.println("Yes");
        }
        else {
            StringBuilder str1 = new StringBuilder(s.nextLine());
            coord1 = giveCenter(str1);
            StringBuilder str2 = new StringBuilder(s.nextLine());
            coord2 = giveCenter(str2);
            while (equality(coord1,coord2)) {
                coord2 = giveCenter(new StringBuilder(s.nextLine()));
                    countI++;
                    if (countI == count) {
                        System.out.println("Yes");
                        isDiffirent = false;
                        break;
                    }
                }
            }
            if (isDiffirent&&count>2){
                for (int i = countI; i < count; i++) {
                    if (!ChekLine(coord1[0], coord1[1],coord2[0], coord2[1] , new StringBuilder(s.nextLine()))) {
                        System.out.println("No");
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println("Yes");

            }
    }

    public static boolean equality(double[] f1, double[] f2){
        return (f1[0]-f2[0])<0.001&&(f1[0]-f2[0])>-0.001&&(f1[1]-f2[1])<0.001&&(f1[1]-f2[1])>-0.001;
    }
    public static boolean ChekLine(double x1, double y1,double x2, double y2, StringBuilder str){
        double [] coord = giveCenter(str);
        double[] coordV1 = giveCoordVector(x2,y2,x1,y1);
        double[] coordV2 = giveCoordVector(coord[0],coord[1],x1,y1);
        double[] coordVector = giveUmnoh(coordV1, coordV2);
        double L = coordVector[2];
        return L==0;
    }

    private static double[] giveUmnoh(double[] b, double[] a) {
        double[] coord = new double[3];
        coord[0] = 0;
        coord[1] = 0;
        coord[2] = a[0]*b[1]-a[1]*b[0];
        return  coord;
    }

    private static double[] giveCoordVector(double x1, double y1, double x2, double y2) {
        double[] coord = new double[3];
        coord[0] = x2-x1;
        coord[1] = y2-y1;
        coord[2] = 0;
        return coord;
    }

    public static double[] giveCenter(StringBuilder strings) {
        if (strings.substring(0,strings.indexOf(" ")).equals("0")){
           return setXYCircle(strings);
        }
        else{
            return setXYSquare(strings);
        }
    }
    public static double[] setXYCircle(StringBuilder strings) {
        double[] coord = new double[2];
        strings.delete(0,strings.indexOf(" ")+1).delete(0,strings.indexOf(" ")+1);
        coord[0] = Double.valueOf(strings.substring(0,strings.indexOf(" ")));
        strings.delete(0,strings.indexOf(" ")+1);
        coord[1] = Double.valueOf(strings.substring(0));
        return coord;
    }
    public static double[] setXYSquare(StringBuilder strings) {
        double[] coord = new double[2];
        strings.delete(0,strings.indexOf(" ")+1);
        coord[0] = Double.valueOf(strings.substring(0,strings.indexOf(" ")));
        strings.delete(0,strings.indexOf(" ")+1);
        coord[1] = Double.valueOf(strings.substring(0,strings.indexOf(" ")));
        strings.delete(0,strings.indexOf(" ")+1).delete(0,strings.indexOf(" ")+1);
        coord[0]+=Double.valueOf(strings.substring(0,strings.indexOf(" ")));
        coord[0]/=2;
        strings.delete(0,strings.indexOf(" ")+1);
        coord[1]+=Double.valueOf(strings.substring(0,strings.indexOf(" ")));
        coord[1]/=2;
        return coord;
    }
}



