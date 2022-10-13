public class Publisher {
    String title;
    String authorname;
    String publisher;
    int nop;
    int price; 
   
    
    //Publisher publisher[]=new  Publisher[5];
    //publisher=sc.nextLine();
    Publisher()
    {

    }
  Publisher(String title, String authorname, String publisher,int nop, int price)
    {
      this.title=title;
      this.authorname=authorname;
      this.publisher=publisher;
      this.nop=nop;
      this.price=price;
    }
    void DisplayBook()
    {
        System.out.println("Title:"+title);
        System.out.println("Author name:"+authorname);
        System.out.println("Publisher:"+publisher);
        System.out.println("No of pages:"+nop);
        System.out.println("Price:"+price);
    }
}
