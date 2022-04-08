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

public class Plot {
	//fields
	private int x;
	private int y;
	private int width;
	private int depth;

	// No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
		public Plot() {
			x = 0;
			y = 0;
			width = 1;
			depth = 1;
		}
	//Copy Constructor, creates a new object using the information of the object passed to it.
		public Plot(Plot p) {
			x = p.x;
			y = p.y;
			width = p.width;
			depth = p.depth;
		}
	// Parameterized Constructor
		public Plot(int x, int y, int width, int depth) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.depth = depth;
		}

	/*if the bottom left of the plot passed to the fuction is less than the 
	  * top right of the current ploit then the plots overlap. 
	  */

		public boolean overlaps(Plot p) {
			boolean overlaps = false;
			if (p.getX() <=this.x + this.width && this.x <= p.getX() + p.getWidth()) {
				overlaps = true;
			} if( this.y < p.getY() + p.getDepth() && this.y + this.depth > p.getY()) {
				if(p.getX()<= this.x + this.width) {
					if(this.x <= p.getX() + p.getWidth()){
						overlaps = true; 
					}
				}
			} else {
				overlaps = false;
			}
		
			return overlaps; 
		}

		/*
		 * If the lower left corner of the current plot is smaller than the plot passed to the method 
		 * and the upper right is greater than that of the plot passed to the method, then the current plot 
		 * encompasses the one passed to the method and encomasses is initialized to true 
		 */
		public boolean encompasses(Plot plot) {
			boolean encompasses;
		
			if(this.x <= plot.x && this.y <= plot.y && this.width+x >= plot.width+plot.x && this.depth+this.y >= plot.depth+plot.y) {
			
				encompasses = true;
				
			}else {
				
				encompasses = false;
			}
			
			return encompasses;
		}
		
		// Getter and Setter Methods 
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
			}

		public void setY(int y) {
			this.y = y;
		}

		public int getWidth() {
			return width;
		}
		
		public void setWidth(int width) {
			this.width = width;
		}
		public int getDepth() {
			return depth;
		}
		
		public void setDepth(int depth) {
			this.depth = depth;
		}
		@Override
		//ToString Method
		public String toString() {
			return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
		}
		
}

