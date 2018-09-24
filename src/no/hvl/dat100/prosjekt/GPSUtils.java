package no.hvl.dat100.prosjekt;

import static java.lang.Math.*;

import java.util.Locale;

public class GPSUtils {

	public GPSUtils() {
	
	}
	
	// konverter sekunder til string på formen hh:mm:ss
	public static String printTime(int secs) {
		
		String timestr = "";
		String TIMESEP = ":";
		
		// TODO
		// OPPGAVE - START
		int hours = secs / 3600;
		int restMin = hours % 3600;
		
		int minutes = restMin / 60;
		int restSecs = restMin % 60;
		
		System.out.println(hours);
		System.out.println(minutes);
		System.out.println(restSecs);
		
		//String secsString = Integer.toString(secs);
		//timestr = secsString;
		
		//timestr = String.format(secs);	
		
		
				
		// OPPGAVE - SLUTT
		return timestr;
	}
	
	// beregn maximum av en tabell av doubles med minnst et element
	public static double findMax(double[] da) {

		double max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	// beregn minimum av en tabell av doubles med minnst et element
	public static double findMin(double[] da) {

		// fjern = "0.0" når metoden implementeres for ikke få forkert minimum
		//double min = 0.0; 

		// TODO
		// OPPGAVE - START
		double min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
			
		}

		// OPPGAVE - SLUT
		return min;
	}

	
	private static int R = 6371000; // jordens radius
	
	// Beregn avstand mellom to gps punkter ved bruk av Haversine formlen
	public static double distance(double latitude1, double longitude1, double latitude2, double longitude2) {

		double a,c,d; // fjern = 1.0
		
		// TODO:
		// OPPGAVE - START
		latitude1 = Math.toRadians(latitude1);
		latitude2 = Math.toRadians(latitude2);
		double deltaLatitude = latitude2 - latitude1;
		longitude1 = Math.toRadians(longitude1);
		longitude2 = Math.toRadians(longitude2);
		double deltaLongitude = longitude2 - longitude1;
		a = (pow(Math.sin((deltaLatitude)/(2.0)), 2.0)) + (Math.cos(latitude1))*(Math.cos(latitude2))*(pow(Math.sin((deltaLongitude)/(2)),2));
		c = 2*(Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
		d = R*c;
				
		// OPPGAVE - SLUTT

		return d;
	}
	
	// beregn gjennomsnits hastighet i km/t mellom to gps punkter
	public static double speed(int secs, double latitude1, double longitude1, double latitude2, double longitude2) {

		double speed = 0.0;

		// TODO:
		// OPPGAVE - START
		
		double distance = distance(latitude1,longitude1,latitude2,longitude2);
		
		speed = (distance / secs) * 3.6;
		
		// OPPGAVE - SLUTT

		return speed;
	}
	
	private static int TEXTWIDTH = 10;
	
	// konverter double til string med 2 decimaler og streng lengde 10
	// eks. 1.346 konverteres til "      1.35" og enhet til slutt
	// Hint: se på String.format metoden
	
	public static String printDouble(double d) {
		
		String str = "";
		
		// TODO
		// OPPGAVE - START
		str = Double.toString(d);
		str = String.format(Locale.US, "%.2f", d);
		
		if (str.length() < TEXTWIDTH) {
			int spaceDiff = 0;
			spaceDiff = TEXTWIDTH - str.length();
			for(int i = 0; i < spaceDiff; i++) {			
				str = " " + str;
						
			}
		 
			
		}
		
		
		// OPPGAVE - SLUTT
		
		return str;
	}
}
