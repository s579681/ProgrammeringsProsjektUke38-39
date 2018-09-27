	 package no.hvl.dat100.prosjekt;

import com.sun.org.apache.bcel.internal.generic.IF_ICMPEQ;

public class GPSComputer {
	
	public GPSComputer(GPSData gpsdata) {

		GPSDataConverter converter = new GPSDataConverter(gpsdata);
		converter.convert();

		this.times = converter.times;
		this.latitudes = converter.latitudes;
		this.longitudes = converter.longitudes;
		this.elevations = converter.elevations;
	}

	// tabeller for GPS datapunkter
	public int[] times;
	public double[] latitudes;
	public double[] longitudes;
	public double[] elevations;
	
	// beregn total distances (i meter)
	public double totalDistance() {
		
		double distance = 0;
	
		// TODO
		// OPPGAVE - START
		
		for (int i = 0; i < latitudes.length; i++) {
			if (i < latitudes.length-1) {
				distance += GPSUtils.distance(latitudes[i], longitudes[i], latitudes[i+1], longitudes[i+1]);
			
			}
		}
		
		// Hint: bruk distance-metoden fra GPSUtils.
		
		// OPPGAVE - SLUTT

		return distance;
	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {
		
		double elevation = 0;
				
		// TODO
		// OPPGAVE - START
		
		for (int i = 1; i < elevations.length; i++) {
			if (elevations[i-1] < elevations[i]) {	
				elevation += elevations[i] - elevations [i-1];
			
			}
	
		}
		
		// OPPGAVE - SLUTT
		return elevation;
	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		
		int totaltime = 0;
		
		// TODO 
		// OPPGAVE START
		for (int i = 0; i < times.length; i++) {
			if (i > 0 ) {
				totaltime += times[i] - times[i-1];
			}	
		}
		
		// OPPGAVE SLUTT
		
		return totaltime;
	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene
	public double[] speeds() {

		double[] speeds = new double[times.length-1];
		
		// TODO
		// OPPGAVE - START
		for (int i = 0; i < speeds.length; i++) {
				speeds[i] = GPSUtils.speed((times[i+1] - times[i]), latitudes[i], longitudes[i], latitudes[i+1], longitudes[i+1]);
			
		}
		
		// OPPGAVE - SLUTT
		return speeds;
	}

	// beregn maximum hastighet km/t
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO
		// OPPGAVE - START
		maxspeed = GPSUtils.findMax(speeds());
				
		// OPPGAVE - SLUTT
		
		return maxspeed;
	}
	
	// beregn gjennomsnittshasitiget for hele turen km/t
	public double averageSpeed() {

		double average = 0;
		
		// TODO
		// OPPGAVE - START
		average = (totalDistance() / totalTime() * 3.6);
				
		// OPPGAVE - SLUTT
		
		return average;
	}


	// conversion factor kph (km/t) to miles per hour (mph)
	public static double MS = 0.62;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal = 0;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;

		// TODO
		// OPPGAVE START
		//h
		
		if (speedmph < 10) {
				met = 4.0;
		} 	if (speedmph >= 10 && speedmph <= 12) {
					met = 6.0;
			}	 if (speedmph >= 12 && speedmph <= 14) {
						met = 8.0;
				}	 if (speedmph >= 14 && speedmph <= 16) {
							met = 10.0;
					}	 if (speedmph >= 16 && speedmph <= 20) {
								met = 12.0;
						} 	else if (speedmph > 20) {
									met = 16.0;
							}
		

		secs = secs / 3600;
	
		kcal = met * weight * secs;
		
		// Energy Expended (kcal) = MET x Body Weight (kg) x Time (h)

		// OPPGAVE SLUTT
		//System.out.println(this.speeds());		
		return kcal;
	}
	public double totalKcal() {

		double totalkcal = 0;

		// TODO
		// OPPGAVE - START
		System.out.println(this.speeds());
					
		
		// Hint: hent hastigheter i speeds tabellen og tider i timestabellen
		// disse er definer i toppen av klassen og lese automatisk inn
		
		// OPPGAVE - SLUTT
		
		return totalkcal;
	}
	
	private static double WEIGHT = 80.0;
	
	// skriv ut statistikk for turen
	public void print() {
		
		// TODO
		// OPPGAVE - START
				
		// OPPGAVE - SLUT
	}
	
	// ekstraoppgaver
	public void climbs() {
		
	}
	
	public void maxClimb() {
		
	}
}
