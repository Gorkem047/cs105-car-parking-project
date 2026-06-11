package parkingProject;

public class Motorcycle extends Vehicle {
	public Motorcycle(String licensePlateNumber) {
		super(licensePlateNumber);
	}

	@Override
	public String getType() {
		return "Motorcycle";
	}
}
