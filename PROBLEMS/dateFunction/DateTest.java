



public class DateTest {
	public static void main(String[] args) {
		System.out.println(" ");
		
		Date d1 = new Date();
		Date d2 = new Date(06,10,1999);
		Date d3 = new Date(02, 23,2002);
		
		
		System.out.println(d1.getMonth());
		System.out.println(d2.getDay());
		System.out.println(d3.getYear());
		
		System.out.println();
		d1.printDate();
		d2.printDate();
		d3.printDate();
		
		
		System.out.println(d1.toString());
		System.out.println(d2.toString());
		System.out.println(d3.toString());
		
		
		
		
		
	}

}
