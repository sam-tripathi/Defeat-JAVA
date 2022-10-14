package src;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Reader.init(System.in);

        int A = Reader.nextInt();
        int B = Reader.nextInt();
        int C = Reader.nextInt();
        // int data = Reader.nextInt();

        String s = Reader.next();

        int T = Reader.nextInt();

        if (s.equals("Associative")) {
            Associative a = new Associative(A, B, C);

            while (T-- != 0) {
                int X = Reader.nextInt();
                String Address = Reader.next();
                if (X == 0) {
                    int data = Reader.nextInt();
                    a.Load(Address, data);
                } else {
                    a.Search(Address);
                }
            }

        } else if (s.equals("Direct")) {
            Direct D = new Direct(A, B, C);

            while (T-- != 0) {
                int X = Reader.nextInt();
                String Address = Reader.next();
                if (X == 0) {
                    int data = Reader.nextInt();
                    D.Load(Address, data);
                } else {
                    D.search(Address);
                }
            }

        } else {
            Set S = new Set(A, B, C);

            while (T-- != 0) {
                int X = Reader.nextInt();
                String Address = Reader.next();
                if (X == 0) {
                    int data = Reader.nextInt();
                    S.Load(Address, data);
                } else {
                    S.search(Address);
                }
            }
        }

    }

    public static int BoolToInt(String s) {
        int data = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                data += Math.pow(2, i);
            }
        }
        return data;
    }

    public static int Log(int data) {
        if (data == 2) {
            return 1;
        } else {
            return (int) (Math.log(data) / Math.log(2));
        }
    }
}
