package parkingProject;

public class ParkingSpot {
	private String spotNumber;
	private boolean ParkedSpot;
	private Vehicle parkedVehicle;

	public ParkingSpot(String spotNumber) {
		this.spotNumber = spotNumber;
		this.ParkedSpot = false;
		this.parkedVehicle = null;
	}

	public String getSpotNumber() {
		return spotNumber;
	}

	public boolean isParkedSpot() {
		return ParkedSpot;
	}

	public void parkVehicle(Vehicle v1) {
		this.parkedVehicle = v1;
		this.ParkedSpot = true;
	}

	public void removeVehicle() {
		this.parkedVehicle = null;
		this.ParkedSpot = false;
	}

	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}
}
