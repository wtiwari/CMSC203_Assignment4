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

public class ManagementCompany {
	//fields	
		private int MAX_PROPERTY = 5;
		private  double	mgmFeePer;
		private String name;
		private  Property[]	properties;
		private String taxID;
		private int	MGMT_WIDTH = 10;
		private int	MGMT_DEPTH = 10;
		private Plot plot;
		
		public ManagementCompany() {
			name = "";
			taxID = "";
			plot = new Plot(0,0,10,10);
			properties = new Property[MAX_PROPERTY];
		}
		
		public ManagementCompany(String name, String taxID, double mgmFee) {
			this.name = name;
			this.taxID = taxID;
			this.mgmFeePer = mgmFee;
			plot = new Plot(0,0,10,10);
			properties = new Property[MAX_PROPERTY];
		}
		
		public ManagementCompany(String name, String taxID,
				double mgmFee, int x, int y, int width, int depth) {
			this.name = name;
			this.taxID = taxID;
			this.mgmFeePer = mgmFee;
			plot = new Plot(x, y, width, depth);
			this.properties = new Property[MAX_PROPERTY];
		}
		
		public ManagementCompany(ManagementCompany otherCompany) {
			this.name = otherCompany.name;
			this.taxID = otherCompany.taxID;
			this.mgmFeePer= otherCompany.mgmFeePer;
			this.plot = new Plot(otherCompany.plot);
			this.properties = new Property[MAX_PROPERTY];
			}
		
		public int addProperty(Property property) {
			//create int to store index 
			//for loop to iterate through array 
			for(int i = 0; i < MAX_PROPERTY; i++) {
				//return -3 if the plot encompasses another 
				if (!plot.encompasses(property.getPlot())){
					return -3;
				//return -4 if plots overlap
				}else if (properties[i] == null) {
					properties[i] = new Property(property);
					return i;
				}else if (properties[i].getPlot().overlaps(property.getPlot())) {
					return-4;
				}
			}
			return -1;
			
		}
		
		public int addProperty(String name,String city,double rent,String owner) {
			//create int to store index 
				Property p = new Property (name, city, rent, owner);
					return addProperty (p);
		}
		
		public int addProperty(int x, int y, int width, int depth, String name, String city, double rent, String owner ) {
				//create int to store index 
				Property p = new Property ( name, city, rent, owner,  x,  y,  width,  depth);
					return addProperty (p);
			}
		
		public String displayPropertyAtIndex(int i) {
			return properties[i].toString();
		}
		
		public  int	getMAX_PROPERTY() {
			return MAX_PROPERTY;
		}
		
		public double maxRentProp() {
			double max = 0;
			for (int i = 0; i < MAX_PROPERTY; i++) {
				if (properties[i]!=null) {
					if(max < properties[i].getRent()) {
						max = properties[i].getRent();
					}
				}
			}
			return max;
		}
		
		public int	maxRentPropertyIndex() {
			double max = 0;
			int maxIndex = 0;
			for (int i = 0; i < MAX_PROPERTY; i++) {
				if(properties[i]!=null) {
					if (max < properties[i].getRent()) {
						maxIndex = i;
					}
				}
				
			}
			return maxIndex;
		}
		
		public double totalRent() {
			double totalRent = 0;
			for (int i = 0; i < MAX_PROPERTY; i++) {
				
				if(properties[i]!=null) {
					totalRent += properties[i].getRent();
					}
				}
			return totalRent;
		}

    public String getName(){
      return name;
    }

    public Plot getPlot(){
      return new Plot(plot);
    }
		
		public String toString() {
			String message = "";
			int count = 0;
			for (int i = 0; i < MAX_PROPERTY; i++) {
				if(properties[i]!=null) {
					message += properties[i].toString() + "\n";
					count++;
					
				}
			}
			return message + "\n Total Management Fee: " + mgmFeePer*count;
		}
			
	}
