package parkingProject;

import java.util.Comparator;

public class TypeComparator implements Comparator<Vehicle> {
	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		return v1.getType().compareTo(v2.getType());
	}
}
