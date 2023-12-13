
public class Date {
	
		int month, day, year; 
		
		public Date () {
			 month = 1;
			 day = 1;
			 year = 2000;
		}
		
		
		public Date(int givenMonth, int givenDay, int givenYear ) {
			month = givenMonth; 
			day = givenDay;
			year = givenYear; 

		}
		
	
		public int getMonth() {
			return month;
			
		}
		
		
		public int getDay() { 
			return day; 
		
		}
		

		
		public  int getYear() { 
			return year; 
			
		}
		

		
		public void setMonth(int monthG) {
			
			month = monthG;
		}
		

		public void setDay(int dayG) {
			day = dayG; 
		}
		

		
		
		public void setYear(int yearG) {
			
			year = yearG;
		}
		

		
		@Override
		public String toString() {
			return month + "/" + day + "/" + year ;
			
		}
		

		public void printDate() {
			System.out.println (month + "/" + day + "/" + year) ;
		}
		
		
		
}
