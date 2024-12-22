import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class practical2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int no_input;
        System.out.print("Enter Number of input symbols : ");
        no_input = sc.nextInt();

        char input[] = new char[no_input];
        System.out.print("Enter Input symbols");

        for(int i=0;i<no_input;i++){
            System.out.println("Enter input symbol " + (i+1) + " : ");
            input[i] = sc.next().charAt(0);
        }

        System.out.println();
        System.out.print("Enter no state : ");
        int no_state;
        no_state = sc.nextInt();

        System.out.print("Enter initial state : ");
        int init;
        init = sc.nextInt();
        System.out.println();

        System.out.print("Enter No Accepting state : ");
        int no_accept;
        no_accept = sc.nextInt();

        int accept[] = new int[no_accept];
        for (int i=0;i<no_accept;i++){
            System.out.println("Enter accepting state " + (i+1) + "  : ");
            accept[i] = sc.nextInt();
        }

        System.out.println();

        //Transition Table
        int[][] TT = new int[no_state][no_input];
        System.out.println("  ");
        for(int j=0;j<no_input;j++){
            System.out.print(input[j] + " ");
        }

        System.out.println();

        for(int i=0;i<no_state;i++){
            for(int j=0;j<no_input;j++){
                System.out.println("Enter " + (i+1) + " to " + input[j] + " :");
                TT[i][j] = sc.nextInt();
            }
        }

        //print TT
        for(int i=0;i<TT.length;i++){
            System.out.println((i+1) + "\t" +(TT[i][0]) + "\t" + (TT[i][1]));
        }

        System.out.println("Enter string");
        String str = sc.next();


        int current=init;

        for(int i=0;i<str.length();i++){
            for(int j=0;j<no_input;j++){
                if(str.charAt(i) == input[j]){
                    current = TT[current-1][j];
                }
            }
//            System.out.println(current);
        }

        for(int i=0;i<no_accept;i++){
            if(accept[i]==current){
                System.out.println("Valid String");
                return;
            }
        }

        System.out.println("Invalid String");

    }

}

/*
* 1.
*
*
* */