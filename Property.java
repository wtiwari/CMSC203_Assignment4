	/*
	 * Class: CMSC203 
	 * Instructor: Dr. Grinberg
	 * Description: Build an application that acts as aproperty management company manages individual properties they will build to rent, and charges them a management fee as the percentages of the monthly rental amount. The properties cannot overlap each other, and each property must be within the limits of the management company’s plot.  Write an application that lets the user create a management company and add the properties managed by the company to its list. Assume the maximum number of properties handled by the company is 5.  
	 * Due: 4/07/2022
	 * Platform/compiler: eclipse/repl.it
	 * I pledge that I have completed the programming assignment independently.
	   I have not copied the code from a student or any source.
	   I have not given my code to any student.
	   William Tiwari
	*/

package replit;

public class Property {
	//fields 
		private String city;
		private String owner;
		private String propertyName;
		private double rent; 
		private Plot p;
		
		/*
		 * No-arg Constructor, creates a new object with default values of empty strings, 
		 * 0 for rent amount, and default Plot (sets the x, y values to zero, depth and width to 1)
		 */
		public Property() {
			city = "";
			owner = "";
			propertyName = "";
			rent = 0;
			p = new Plot();
		}
		/*
		 *  Copy Constructor, creates a new object using the information of the object passed to it.
		 */
		public Property(Property p) {
			this.city = p.city;
			this.owner = p.owner;
			this.propertyName = p.propertyName;
			this.rent = p.rent;
			this.p = new Plot(p.p);
		}
		/*
		 *    Parameterized Constructor, no Plot information provided
		 */
		public Property(String propertyName, String city, double rentAmount, String owner) {
			this.propertyName = propertyName;
			this.city = city;
			this.rent = rentAmount;
			this.owner = owner;
			this.p = new Plot();
		}
		/*
		 * Constructor, Parameterized constructor
		 */
		public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
			this.propertyName = propertyName;
			this.city = city;
			this.rent = rentAmount;
			this.owner = owner;
			p = new Plot(x,y,width,depth);
		}
		//	getters and setters 
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getOwner() {
			return owner;
		}
		public void setOwner(String owner) {
			this.owner = owner;
		}
		public String getPropertyName() {
			return propertyName;
		}
		public void setName(String propertyName) {
			this.propertyName = propertyName;
		}
		public double getRent() {
			return rent;
		}
		public void setRent(double rent) {
			this.rent = rent;
		}
		public Plot getPlot() {
			return p;
		}
		public void setPlot(Plot p) {
			this.p = new Plot(p);
		}
		//toString Method
		@Override
		public String toString() {
			return "Property Name: "+ propertyName + "\n " 
		+ "Located in " + city + "\n "
				+ "Belonging to: "+ owner + "\n" + 
		"Rent amount: " + rent;
		}
		
}
