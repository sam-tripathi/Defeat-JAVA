// Class Declaration
public class Cat {

    String name;
    String breed;
    int age;
    String color;

    public Cat(String name, String breed,
            int age, String color) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    // method 1
    public String getName() {
        return name;
    }

    // method 2
    public String getBreed() {
        return breed;
    }

    // method 3
    public int getAge() {
        return age;
    }

    // method 4
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return ("Hi this is " + this.getName() +
                ".\nIt's breed,age and color are " +
                this.getBreed() + "," + this.getAge() +
                "," + this.getColor());
    }

    public static void main(String[] args) {
        Cat kitty = new Cat("kitty", "Maine Coon\n", 5, "white\n");
        System.out.println(kitty.toString());
    }
}
