//Display the Large Number from given two numbers.

class DisplayLargeNum{  
    void largeNum(long a,long b){System.out.println(Math.max(a, b));}  
    
    void largeNum(Double a,Double b){System.out.println(Math.max(a, b));}  
    
    public static void main(String args[]){  
      DisplayLargeNum obj=new DisplayLargeNum();  
    obj.largeNum(2474,2277);//now second int literal will be promoted to long  
    obj.largeNum(20,20);
    obj.largeNum(20.5,22.8);    
    
    }  
  }  
