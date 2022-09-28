import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class razdelenieDolgoe {



    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner s = new Scanner(file);
        int count = Integer.valueOf(s.nextLine());
        figure1[] figures = new figure1[count];
        for(int i=0;i<count;i++){
            StringBuilder strings = new StringBuilder(s.nextLine());
            figures[i]=(new figure1(strings));
        }
        if (figures.length==1)
            System.out.println("Yes");
        else if(ChekLine(figures))
            System.out.println("Yes");
        else System.out.println("No");
    }

    public static boolean ChekLine(figure1[] figures){
        boolean flag = true;
        float k,b;
        int i =0;
        while (true) {
            if(!(figures[i].equals(figures[i+1]))){
            k = (figures[1].y - figures[0].y) / (figures[1].x - figures[0].x);
            b = figures[0].y - figures[0].x * (figures[1].y - figures[0].y) / (figures[1].x - figures[0].x);
            break;
            }
            else {
                i++;
                    if (i==figures.length-1) {
                        return true;
                    }
            }
        }
        for (int j = 0; j < i; j++){
            float a = figures[j].y - k * figures[j].x - b;
            if (!(a==0)) {
                flag = false;
                break;
            }
        }
            for (int j = i+2; j < figures.length; j++){
                float a = figures[j].y - k * figures[j].x - b;
                if (!(a==0)) {
                    flag = false;
                    break;
                }
            }
        return flag;
    }
}
class figure1{
    float x,y;
    public figure1(StringBuilder strings) {
        if (strings.substring(0,strings.indexOf(" ")).equals("0")){
            this.setXYCircle(strings);
        }
        else{
            this.setXYSquare(strings);
        }
    }

    public void setXYCircle(StringBuilder strings) {
        strings.delete(0,strings.indexOf(" ")+1).delete(0,strings.indexOf(" ")+1);
        x = Integer.valueOf(strings.substring(0,strings.indexOf(" ")));
        strings.delete(0,strings.indexOf(" ")+1);
        y = Integer.valueOf(strings.substring(0));
    }
    public void setXYSquare(StringBuilder strings) {
        strings.delete(0,strings.indexOf(" ")+1);
        x = Float.valueOf(strings.substring(0,strings.indexOf(" ")));
        strings.delete(0,strings.indexOf(" ")+1);
        y = Float.valueOf(strings.substring(0,strings.indexOf(" ")));
        strings.delete(0,strings.indexOf(" ")+1).delete(0,strings.indexOf(" ")+1);
        x+=Float.valueOf(strings.substring(0,strings.indexOf(" ")));
        x/=2;
        strings.delete(0,strings.indexOf(" ")+1);
        y+=Float.valueOf(strings.substring(0,strings.indexOf(" ")));
        y/=2;
    }


    public boolean equals(figure1 other) {
        return this.x==other.x&&this.y==other.y;
    }
}

