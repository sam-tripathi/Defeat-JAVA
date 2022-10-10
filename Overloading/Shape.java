Calculate the Volume of sphere, cone and box using the concept of overloading.

class Shape {
    void calculateVolume(int r){
        double volume = 4.187*r*r*r;
        System.out.println("Volume of shpere:"+" "+volume);
    }
    void calculateVolume(int r,int h){
        double volume = 1.047*r*r*h;
        System.out.println("Volume of cone:"+" "+volume);
    }
    void calculateVolume(int r,int w,int h){
        double volume = r*w*h;
        System.out.println("Volume of box:"+" "+volume);
    }
    public static void main(String[] args) {
        Shape obj = new Shape();
        obj.calculateVolume(6);
        obj.calculateVolume(2, 6);
        obj.calculateVolume(4, 6, 3);
    }
}
