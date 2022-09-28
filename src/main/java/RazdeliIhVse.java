//Перед тем как начать стрельбу, Оля и Толя хотят убедиться, что они смогут однозначно идентифицировать результаты своих
//выстрелов. Для этого они договорились провести прямую, которая поделит плоскость с мишенями на две части. Однако, чтобы
//никому не было обидно, они хотят провести прямую таким образом, чтобы каждая мишень была поделена ровно пополам, то
//есть для каждого круга и каждого прямоугольника должно быть верно, что прямая делит его на две фигуры равной площади.
//Когда Оля и Толя наконец закончили прорабатывать все условия разделения мишеней на две части, они начали сомневаться,
//что провести такую прямую вообще возможно, и просят вас ответить на этот вопрос.


import java.util.ArrayList;
import java.util.Scanner;

public class RazdeliIhVse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean yesOrNotCrk=false;
        boolean yesOrNotSq = false;
        int count = s.nextInt();
        ArrayList<double[]> circules = new ArrayList<>();
        ArrayList<double[]> squares = new ArrayList<>();
        for(int i=0;i<=count;i++){
            String[] strings = s.nextLine().split(" ");
            if(strings[0].equals("0")){
                circules.add(setXYCircle(strings));
            }
            if(strings[0].equals("1")){
                squares.add(setXYSquare(strings));
            }
        }
        for (int i =0; i<1;i++){
            if(squares.size()==1&&circules.size()==0){
                System.out.println("Yes");
                break;
            }
            else if(circules.size()==1&&squares.size()==0){
                System.out.println("Yes");
                break;
            }
            else if(squares.size()==1&&circules.size()==1){
                System.out.println("Yes");
                break;
            }
            else if((circules.size()>1&&!ChekLine(circules))){
                System.out.println("No");
                break;
            }
            else if(squares.size()==0){
                System.out.println("Yes");
            }
            else if(squares.size()>1&&!ChekLine((squares))){
                System.out.println("No");
                break;
            }
            else if(circules.size()==0){
                System.out.println("Yes");
                break;
            }
            else if(squares.size()==1&&circules.size()>1){
                if(funk1(circules.get(0),circules.get(1),squares.get(0)))
                    System.out.println("Yes");
                else System.out.println("No");
            }
            else if(circules.size()==1&&squares.size()>1){
                if(funk1(squares.get(0),squares.get(1),circules.get(0)))
                    System.out.println("Yes");
                else System.out.println("No");
            }
            else if(squares.size()>=2&&circules.size()>=2) {
                if (funk(circules.get(0), circules.get(1), squares.get(0), squares.get(1))) {
                    System.out.println("Yes");
                }
                else System.out.println("No");
            }
        }


    }

    private static boolean funk(double[] f1, double[] f2, double[] f3, double[] f4) {
        double k1 = (f2[1]-f1[1])/(f2[0]-f1[0]);
        double b1 = f1[1]-f1[0]*(f2[1]-f1[1])/(f2[0]-f1[0]);
        double k2 = (f4[1]-f3[1])/(f4[0]-f3[0]);
        double b2 = f3[1]-f3[0]*(f4[1]-f3[1])/(f4[0]-f3[0]);
        return k1-k2<0.001&&k1-k2>-0.001&&b1-b2<0.001&&b1-b2>-0.001;
    }

    private static boolean funk1(double[] f1, double[] f2, double[] f3){
        double k1 = (f2[1]-f1[1])/(f2[0]-f1[0]);
        double b1 = f1[1]-f1[0]*(f2[1]-f1[1])/(f2[0]-f1[0]);
        double a = f3[1]-k1*f3[0]-b1;
        return (a<0.01&&a>-0.01);
    }

    public static boolean ChekLine(ArrayList<double[]> figures){
        if(figures.isEmpty())
            return true;
        boolean flag = true;
        double k = (figures.get(1)[1]-figures.get(0)[1])/(figures.get(1)[0]-figures.get(0)[0]);
        double b = figures.get(0)[1]-figures.get(0)[0]*(figures.get(1)[1]-figures.get(0)[1])/(figures.get(1)[0]-figures.get(0)[0]);
        for(int i =2; i<figures.size();i++){
            double a = figures.get(i)[1]-k*figures.get(i)[0]-b;
            if (!(a<0.01&&a>-0.01)){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static double[] setXYSquare(String[] strings) {
        double[] XY= new double[2];
        XY[0] = (Double.valueOf(strings[1])+Double.valueOf(strings[5]))/2;
        XY[1] = (Double.valueOf(strings[2])+Double.valueOf(strings[6]))/2;
        return XY;
    }
    public static double[] setXYCircle(String[] strings) {
        double[] XY= new double[2];
        XY[0] = Integer.valueOf(strings[2]);
        XY[1] = Integer.valueOf(strings[3]);
        return XY;
    }
}



