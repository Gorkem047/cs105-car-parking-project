package parkingProject;

import java.util.Comparator;

public class PlateNumberComparator implements Comparator<Vehicle> {
	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		return v1.getLicensePlateNumber().compareTo(v2.getLicensePlateNumber());
	}
}
