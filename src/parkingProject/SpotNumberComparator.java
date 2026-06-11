package parkingProject;

import java.util.Comparator;

public class SpotNumberComparator implements Comparator<Vehicle> {
	private ParkingLot p1;

	public SpotNumberComparator(ParkingLot p1) {
		this.p1 = p1;
	}

	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		String s1 = p1.findVehicleSpot(v1.getLicensePlateNumber());
		String s2 = p1.findVehicleSpot(v2.getLicensePlateNumber());
		return s1.compareTo(s2);
	}
}
