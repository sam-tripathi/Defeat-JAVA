package JavaCodewars;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    private static String swap(String s, int i, int j) {
      char[] x = s.toCharArray();
      char ch;
      ch = x[i];
      x[i] = x[j];
      x[j] = ch;
      return String.valueOf(x);
    }  
  
    private static void generate(Set<String> permut, String s, int start, int end) {
      if (start == end - 1)
        permut.add(s);
      else {
        for (int i = start; i < end; i++) {
          s = swap(s, start, i);
          generate(permut, s, start + 1, end);
          s = swap(s, start, i);
        }
      }
    }
  
    public static List<String> singlePermutations(String s) {
        // Your code here!
        Set<String> permutation = new HashSet<>();
        // use of Set to avoid duplicate
        generate(permutation, s, 0, s.length());

        return new ArrayList<>(permutation);
        // return List instead of Set
    }
}

