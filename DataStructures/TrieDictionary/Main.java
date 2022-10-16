public class Main {
    public static void main(String args[]) {
        Dictionary dict = new Dictionary();
        dict.insert("will");
        dict.insert("water");

        System.out.println(dict.search("water"));
        System.out.println(dict.search("wool"));

    }
}