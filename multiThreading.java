class Addition
{
    public synchronized void print_sum(int n)
    {
        int sum = 0;
        for(int i=1;i<=n;i++) {
            System.out.println(Thread.currentThread().getName()+" i : "+i);
            sum+=i;
        }
        System.out.println(Thread.currentThread().getName()+" sum : "+sum);
    }
}

class Thread1 extends Thread{
    Addition s1;
    public Thread1(Addition obj){
        s1 = obj;
    }
    @Override
    public void run() {
        s1.print_sum(5);
    }
}

class Thread2 extends Thread{
    Addition s2;
    public Thread2(Addition obj){
        s2 = obj;
    }
    @Override
    public void run() {
        s2.print_sum(10);
    }
}
public class prog5 {
    public static void main(String[] args) {
        Addition obj = new Addition();
        Thread1 t1= new Thread1(obj);
        Thread2 t2= new Thread2(obj);
        t1.start();
        t2.start();
    }
}