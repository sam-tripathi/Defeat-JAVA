public class AttendanceGenerator 
{
static void displaymonthwiseAttendance(Employee1 e)
  {
    System.out.println("Print month-wise attendance of employee:"+e.name+"\n");
    for(int i=0;i<2;i++)
    {
        int count=0;
        System.out.println("Attendance for the month:"+e.Attendance[i][0].d.month);
      for(int j=0;j<10;j++)
      {
          if(e.Attendance[i][j].present==1)
          {
          System.out.println("Date:"+e.Attendance[i][j].d.day+"/"+e.Attendance[i][j].d.month+"/"+e.Attendance[i][j].d.year+" <---PRESENT---> from time "+e.Attendance[i][j].timein+"am to "+e.Attendance[i][j].timeout+"pm"); 
          count++;
          }
          else
          {
          System.out.println("Date:"+e.Attendance[i][j].d.day+"/"+e.Attendance[i][j].d.month+"/"+e.Attendance[i][j].d.year+" <---Absent--->");
          }
      }
      System.out.println("\nTotal Number of days "+e.name+ " was Present in month "+ e.Attendance[i][0].d.month+" is "+ count+" out of 10\n"); 
    }
  }

  static void workingHrs(Employee1 e, Date d)
  {
  System.out.println("Printing total Woking hours of Employee "+e.name+" with given date");
  for(int i=0; i<2; i++)
  {
  for(int j=0; j<10; j++)
  {
  if(e.Attendance[i][j].d.day==d.day && e.Attendance[i][j].d.month==d.month && e.Attendance[i][j].d.year==d.year)
  {
  System.out.println("Day:"+d.day+" Month:"+d.month+" Year:"+d.year);
  System.out.println("Total Working hours for the day is "+(e.Attendance[i][j].timeout-e.Attendance[i][j].timein)+"hrs\n");
  break;
  }
  }
  }
 } 
  static void workingdaysofemployee(Employee1 e )
  {   
      int count=0;
      for(int i=0;i<2;i++)
      {
          for(int j=0;j<10;j++)
          {
              if(e.Attendance[i][j].present==1)
              {
                count++;
              }
          }
      }
      System.out.println("Total No of Working Days for an Employee "+e.name +" is "+count+" days out of 20 days"); //2 months
  }

}
