/**
 * Class: CS 501-WS Introduction to JAVA Programming <br />
 * Instructor: M. Jurkat <br />
 * Chapter: 4 <br />
 * Exercise: 3 <br />
 * Description: Hard code four coordinates and use the great circle distance to find the area inclosed <br />
 * Due: 2/8/2016 <br />
 * I pledge by honor that I have abided by the Steven's Honor System. <br />
   <br />
   Signed: Michael Langford <br />

 */

import java.lang.Math;	  //Include Math library for toRadians, sin, cos, and arccos

public class C4E3FourCityArea {
	
	public static final double RADIUS = 6371.01; //Radius of Earth, kept constant
	
	//Returns Great Circle Distance between two points of earth given in degress latitude and longitude
	public static double getDistance(double lat1, double long1, double lat2, double long2)
	{
		double distance;
		//Calculation d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))
		distance = RADIUS * Math.acos(Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) 
						  			+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) 
						  			* Math.cos(Math.toRadians(long1 - long2)));
		return distance;
	}
	
	//Returns area of a triangle given its 3 sides
	public static double getArea(double [] side)
	{
		double area, sideAverage = 0;
		
		for(int i = 0; i < side.length; i++)
			sideAverage += side[i];
		//Divide by 2 to get Final Value for sideAverage
		sideAverage /= 2;
		//Set area to sideAverage for calculating part under square root sign in area equation
		area = sideAverage;	
		//Length display and Area calculation
		for (int i = 0; i < side.length; i++)
			area *= (sideAverage - side[i]); //Calculating part under square root sign one side length at a time.	
		//Taking square root; Final Answer for Area
		area = Math.pow(area, 0.5);
		
		return area;
	}
	
	public static void main(String[] args) {
		
		//Coordinates found at http://www.latlong.net/
		double atlanta_lat = 33.748995, atlanta_long = -84.387982;
		double orlando_lat = 28.538335, orlando_long = -81.379236;
		double savannah_lat = 32.083541, savannah_long = -81.099834;
		double charlotte_lat = 35.227087, charlotte_long = -80.843127;
		double [] sides_one = new double [3];
		double [] sides_two = new double [3];
		double area;
		
		//Sides for first triangle
		sides_one[0] = getDistance(atlanta_lat, atlanta_long, charlotte_lat, charlotte_long); //Atlanta to Charlotte
		sides_one[1] = getDistance(atlanta_lat, atlanta_long, savannah_lat, savannah_long); //Atlanta to Savannah
		sides_one[2] = getDistance(savannah_lat, savannah_long, charlotte_lat, charlotte_long); //Savannah to Charlotte
		
		//Sides for second triangle
		sides_two[0] = getDistance(atlanta_lat, atlanta_long, savannah_lat, savannah_long); //Atlanta to Savannah
		sides_two[1] = getDistance(atlanta_lat, atlanta_long, orlando_lat, orlando_long); //Atlanta to Orlando
		sides_two[2] = getDistance(savannah_lat, savannah_long, orlando_lat, orlando_long); //Savannah to Orlando
		
		//Add area of both triangles to get total area
		area = getArea(sides_one) + getArea(sides_two);	
		
		//Output results
		System.out.println("This program calculates the area between four cities given their latitude and longitude in degrees");
		System.out.println("Coordinates:");
		System.out.println("------------");
		System.out.println("Atlanta:\t ("+ atlanta_lat + ", "+ atlanta_long +")");
		System.out.println("Orlando:\t ("+ orlando_lat + ", "+ orlando_long +")");
		System.out.println("Savannah:\t ("+ savannah_lat + ", "+ savannah_long +")");
		System.out.println("Charlotte:\t ("+ charlotte_lat + ", "+ charlotte_long +")\n");
		
		System.out.println("Distances:");
		System.out.println("----------");
		System.out.println("Atlanta to Charlotte:\t "+ sides_one[0] +" km");
		System.out.println("Atlanta to Savannah:\t "+ sides_one[1] +" km");
		System.out.println("Atlanta to Orlando:\t "+ sides_two[1] +" km");
		System.out.println("Savannah to Charlotte:\t "+ sides_one[2] +" km");
		System.out.println("Savannah to Orlando:\t "+ sides_two[2] +" km\n");
		
		System.out.println("Triangle Areas:");
		System.out.println("---------------");
		System.out.println("Triangle One (Atlanta, Charlotte, Savannah):\t "+ getArea(sides_one) +" km^2");
		System.out.println("Triangle Two (Atlanta, Orlando, Savannah):\t "+ getArea(sides_two) +" km^2\n");
		System.out.println("Total Area = "+ area +" km^2");
		
	}

}
