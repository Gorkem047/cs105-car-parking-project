package parkingProject;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	private List<ParkingSpot> carSpots = new ArrayList<>();
	private List<ParkingSpot> electricCarSpots = new ArrayList<>();
	private List<ParkingSpot> motorcycleSpots = new ArrayList<>();

	public ParkingLot() {
		for (int i = 1; i <= 200; i++) {
			carSpots.add(new ParkingSpot("P" + String.format("%03d", i)));
		}
		for (int i = 1; i <= 10; i++) {
			electricCarSpots.add(new ParkingSpot("E" + String.format("%03d", i)));
		}
		for (int i = 1; i <= 50; i++) {
			motorcycleSpots.add(new ParkingSpot("M" + String.format("%03d", i)));
		}
	}

	private List<ParkingSpot> getVehicleSpots(String type) {
		switch (type) {
		case "Car":
			return carSpots;
		case "Electric Car":
			return electricCarSpots;
		case "Motorcycle":
			return motorcycleSpots;
		default:
			return null;
		}
	}

	private List<ParkingSpot> getAllSpots() {
		List<ParkingSpot> allSpots = new ArrayList<>();
		allSpots.addAll(carSpots);
		allSpots.addAll(electricCarSpots);
		allSpots.addAll(motorcycleSpots);
		return allSpots;
	}

	public boolean isLicensePlateUsed(String licensePlateNumber) {
		for (ParkingSpot spot : getAllSpots()) {
			if (spot.isParkedSpot() && spot.getParkedVehicle().getLicensePlateNumber().equals(licensePlateNumber)) {
				return true;
			}
		}
		return false;
	}

	public boolean parkAVehicle(Vehicle vehicle) {
		List<ParkingSpot> vehicleSpots = getVehicleSpots(vehicle.getType());
		if (vehicleSpots == null)
			return false;

		for (ParkingSpot spot : vehicleSpots) {
			if (!spot.isParkedSpot()) {
				spot.parkVehicle(vehicle);
				return true;
			}
		}
		return false;
	}

	public boolean exitVehicle(String licensePlateNumber) {
		for (ParkingSpot spot : getAllSpots()) {
			if (spot.isParkedSpot() && spot.getParkedVehicle().getLicensePlateNumber().equals(licensePlateNumber)) {
				spot.removeVehicle();
				return true;
			}
		}
		return false;
	}

	public List<Vehicle> listParkedVehicles() {
		List<Vehicle> parkedVehicles = new ArrayList<>();
		for (ParkingSpot spot : getAllSpots()) {
			if (spot.isParkedSpot()) {
				parkedVehicles.add(spot.getParkedVehicle());
			}
		}
		return parkedVehicles;
	}

	public int getAvailableSpots(String type) {
		List<ParkingSpot> vehicleSpots = getVehicleSpots(type);

		int count = 0;
		for (ParkingSpot spot : vehicleSpots) {
			if (!spot.isParkedSpot()) {
				count++;
			}
		}
		return count;
	}

	public String findVehicleSpot(String licensePlateNumber) {
		for (ParkingSpot spot : getAllSpots()) {
			if (spot.isParkedSpot() && spot.getParkedVehicle().getLicensePlateNumber().equals(licensePlateNumber)) {
				return spot.getSpotNumber();
			}
		}
		return "Not Found ";
	}

}
