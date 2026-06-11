package parkingProject;

public class ElectricCar extends Car {
	public ElectricCar(String licensePlateNumber) {
		super(licensePlateNumber);
	}

	@Override
	public String getType() {
		return "Electric Car";
	}
}
