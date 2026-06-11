
package parkingProject;

public abstract class Vehicle {
	private String licensePlateNumber;

	public Vehicle(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public abstract String getType();
}
