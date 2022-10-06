import java.util.ArrayList;
import java.util.*;

/**
 * TodoList
 */
public class TodoList {
    static ArrayList<String> todo = new ArrayList<String>();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Your choice");
            System.out.println("1. add work");
            System.out.println("2. delete work");
            System.out.println("3. show works");

            while (true) {
                System.out.println("Enter your choice");
                int x = sc.nextInt();
                switch (x) {
                    case 1:
                        Scanner wk = new Scanner(System.in);
                        System.out.println("Enter your Work");
                        String temp = wk.nextLine();
                        todo.add(temp);
                        break;
                    case 2:
                        Scanner rw = new Scanner(System.in);
                        System.out.println(" ⚠ Index start from 0");
                        System.out.println(" Enter number of works");
                        int no = rw.nextInt();
                        todo.remove(no);
                        break;
                    case 3:
                        for (int i = 0; i < todo.size(); i++) {
                            System.out.println(todo.get(i));
                            System.out.println();

                        }
                        break;
                    default:
                        System.out.println("Please Enter correct choice");
                        break;
                }

            }
        }
    }
}
