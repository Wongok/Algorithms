package Sort;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ComparatorHR {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if(str1==null||str2==null) return 0;
                //Java's BigDecimal class can handle arbitrary-precision signed decimal numbers.
                return new BigDecimal(str2).compareTo(new BigDecimal(str1));
            }
        });

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}