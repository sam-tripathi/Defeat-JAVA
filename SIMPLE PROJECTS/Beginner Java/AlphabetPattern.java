import java.util.Scanner;

public class AlphabetPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number row need to pattern");

        int rows = scanner.nextInt();
        System.out.println("---Print Pattern---");

        int alphabet = 65;

        for (int i = 0; i <= rows; i++){
            for(int j = 0; j <= rows - i; j++){
                System.out.println((char)(alphabet + j));
            }
            for (int k = 1; k <= i * 2 - 1; k++){
                System.out.println(" ");
            }
            for (int l = rows - i ; l >= 0; l--){
                if (l != rows)
                    System.out.println((char)(alphabet + l));
            }
            System.out.println();
        }

        for (int i = rows - 1; i >= 0; i--){
            for (int j = 0; j <= rows -i; j++){
                System.out.println((char)(alphabet + j));
            }
            for (int k = 1; k <= i * 2 - 1; k++){
                System.out.println(" ");
            }
            for (int l = rows - i; l >=0; l--){
                if (l != rows)
                    System.out.println((char)(alphabet + l));
            }
            System.out.println();
        }
    }
}
