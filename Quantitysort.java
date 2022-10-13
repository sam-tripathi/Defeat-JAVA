import java.util.*;
public class Quantitysort implements Comparator<Item> {
    
    public int compare(Item o1,Item o2)
    {
        if(o1.quantity> o2.quantity)
        return 1;
        else if(o1.quantity < o2.quantity)
        return -1;
        else 
        return 0;
    } 
}
