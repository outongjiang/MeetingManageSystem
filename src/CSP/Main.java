package CSP;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int y[] = new int[n];
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = sc.nextInt();
            result[i] = sc.nextInt();
        }
        int max=-1;
        int bestValue=-1;
        int t=-1;
        for (int i = 0; i < n; i++) {
            t=0;
            for (int j = 0; j < n; j++) {
                if (result[j] == 0) {
                    if (y[j] < y[i]) {
                        t++;
                    }
                } else {
                    if (y[j] >= y[i]) {
                        t++;
                    }
                }

            }
            if(t>max) {
                max = t;
                bestValue=y[i];
            }else if(t==max&&bestValue<y[i]){
                bestValue=y[i];
            }
        }
        System.out.println(bestValue);
    }
}
class Book implements Comparable<Book> {
    int interst;
    int price;
    int id;
    @Override
    public int compareTo(Book o) {
        if(this.interst>o.interst){
            return -1;
        }else if(this.interst<o.interst){
            return 1;
        }else if(this.price>o.price){
            return 1;
        }else if(this.price<o.price){
            return -1;
        }else if(this.id<o.id){
            return -1;
        }
        return 0;
    }
}