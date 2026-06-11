package parkingProject;

public class Car extends Vehicle {
	public Car(String licensePlateNumber) {
		super(licensePlateNumber);
	}

	@Override
	public String getType() {
		return "Car";
	}
}
