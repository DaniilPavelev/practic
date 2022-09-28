import java.util.ArrayList;
import java.util.Scanner;

public class razdelenieDolgoe {



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        ArrayList<figure1> figures = new ArrayList<>();
        for(int i=0;i<=count;i++){
            String[] strings = s.nextLine().split(" ");
            if(strings[0].equals("0")){
                figures.add(new figure1(strings));
            }
            else{
                figures.add(new figure1(strings));
            }
        }
        if (figures.size()==1)
            System.out.println("Yes");
        else if(ChekLine(figures))
            System.out.println("Yes");
        else System.out.println("No");

    }

    public static boolean ChekLine(ArrayList<figure1> figures){
        boolean flag = true;
        double k = (figures.get(1).y-figures.get(0).y)/(figures.get(1).x-figures.get(0).x);
        double b = figures.get(0).y-figures.get(0).x*(figures.get(1).y-figures.get(0).y)/(figures.get(1).x-figures.get(0).x);
        for(int i =2; i<figures.size();i++){
            double a = figures.get(i).y-k*figures.get(i).x-b;
            if (!(a<0.01&&a>-0.01)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}


class figure1 {
    double x,y;

    public figure1(String[] strings) {
        if (strings[0].equals("0")){
            this.setXYCircle(strings);
        }
        if(strings[0].equals("1")){
            this.setXYSquare(strings);
        }
    }

    public void setXYCircle(String[] strings) {
        x = Integer.valueOf(strings[2]);
        y = Integer.valueOf(strings[3]);
    }
    public void setXYSquare(String[] strings) {
        x = (Double.valueOf(strings[1])+Double.valueOf(strings[5]))/2;
        y = (Double.valueOf(strings[2])+Double.valueOf(strings[6]))/2;
    }
}
