import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class practical2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int no_input;
        System.out.print("Enter Number of input symbols : ");
        no_input = sc.nextInt();

        char input[] = new char[no_input];
        System.out.println("Enter Input symbols....");

        for(int i=0;i<no_input;i++){
            System.out.print("Enter input symbol " + (i+1) + " : ");
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
            System.out.print("Enter accepting state " + (i+1) + "  : ");
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
                System.out.print("Enter " + (i+1) + " to " + input[j] + " :");
                TT[i][j] = sc.nextInt();
            }
            System.out.println();
        }

        //print TT
        for(int i=0;i<TT.length;i++){
            for(int j=0;j< TT[i].length;j++){
                System.out.print("\t" + TT[i][j]);
            }
            System.out.println();
        }

        int ch;
        do {
            System.out.println("1. For Enter String");
            System.out.println("2. For Exit");
            System.out.print("Enter your choies : ");
            ch = sc.nextInt();

            if(ch == 2) break;

            if(ch != 1 ){
                System.out.println("Invalid Choice.....");
                continue;
            }

            System.out.print("Enter string : ");
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

            boolean valid = false;
            for(int i=0;i<no_accept;i++){
                if(accept[i]==current){
                    System.out.println("\u001B[33mValid String\u001B[0m");

                    valid = true;
                    break;
                }
            }
            if(!valid){
                System.out.println("\u001B[31mInvalid String\u001B[0m");
            }

        }while (true);

        System.out.println("Thank you......");
    }

}

/*
1.

Enter Number of input symbols : 2
Enter Input symbols....
Enter input symbol 1 : 0
Enter input symbol 2 : 1

Enter no state : 5
Enter initial state : 1

Enter No Accepting state : 1
Enter accepting state 1  : 4


0 1
Enter 1 to 0 :2
Enter 1 to 1 :1

Enter 2 to 0 :5
Enter 2 to 1 :3

Enter 3 to 0 :5
Enter 3 to 1 :4

Enter 4 to 0 :2
Enter 4 to 1 :4

Enter 5 to 0 :5
Enter 5 to 1 :5

*/

/*
2.

Enter Number of input symbols : 3
Enter Input symbols....
Enter input symbol 1 : a
Enter input symbol 2 : b
Enter input symbol 3 : c

Enter no state : 7
Enter initial state : 1

Enter No Accepting state : 4
Enter accepting state 1  : 1
Enter accepting state 2  : 2
Enter accepting state 3  : 3
Enter accepting state 4  : 4


a b c
Enter 1 to a :2
Enter 1 to b :3
Enter 1 to c :4

Enter 2 to a :2
Enter 2 to b :5
Enter 2 to c :5

Enter 3 to a :6
Enter 3 to b :3
Enter 3 to c :6

Enter 4 to a :7
Enter 4 to b :7
Enter 4 to c :4

Enter 5 to a :2
Enter 5 to b :5
Enter 5 to c :5

Enter 6 to a :6
Enter 6 to b :3
Enter 6 to c :6

Enter 7 to a :7
Enter 7 to b :7
Enter 7 to c :4
* */
