package CSP;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int N=sc.nextInt();
        int sum=0;

        int A[]=new int [n+1];
        A[0]=0;
        for(int i=1 ;i<n+1;i++){
            A[i]=sc.nextInt();
        }
        sum+=(N-A[n])*n;
        for(int i=0;i<n+1;i++){
            for(int j=1;i<=A[i+1]-A[i];j++){
                sum+=i;
            }
        }
        System.out.println(sum);


    }

}
