package parkingProject;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;

public class UserInterface {

	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot();
		JFrame frame = new JFrame("Parking Lot Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setLayout(null);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setLayout(null);

		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setLayout(null);

		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.WHITE);
		panel4.setLayout(null);

		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.WHITE);
		panel5.setLayout(null);

		JButton button1 = new JButton("Park");
		button1.setBounds(150, 80, 200, 100);

		JButton button2 = new JButton("Exit");
		button2.setBounds(450, 80, 200, 100);

		JButton button3 = new JButton("List Parked Vehicles");
		button3.setBounds(50, 220, 200, 80);

		JButton button4 = new JButton("Show Available Spots");
		button4.setBounds(300, 220, 200, 80);

		JButton button5 = new JButton("Find a Vehicle's Parking Spot");
		button5.setBounds(550, 220, 200, 80);

		button1.setBackground(Color.CYAN);
		button2.setBackground(Color.CYAN);
		button3.setBackground(Color.CYAN);
		button4.setBackground(Color.CYAN);
		button5.setBackground(Color.CYAN);

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);

		frame.add(panel);
		frame.setVisible(true);

		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.remove(panel);
				frame.add(panel1);
				frame.repaint();
				frame.revalidate();
			}

		});

		JLabel vehicleTypeLabel = new JLabel("Vehicle Type");
		vehicleTypeLabel.setBounds(50, 50, 100, 25);
		panel1.add(vehicleTypeLabel);

		String[] vehicleTypes = { "Car", "Electric Car", "Motorcycle" };
		JComboBox<String> vehicleTypeComboBox = new JComboBox<>(vehicleTypes);
		vehicleTypeComboBox.setBounds(150, 50, 150, 25);
		panel1.add(vehicleTypeComboBox);

		JButton checkButton = new JButton("Check Availability");
		checkButton.setBounds(350, 50, 150, 30);
		checkButton.setBackground(Color.CYAN);
		panel1.add(checkButton);

		JLabel licenseLabel = new JLabel("License Plate Number");
		licenseLabel.setBounds(50, 120, 150, 25);
		panel1.add(licenseLabel);

		JTextField licenseField = new JTextField();
		licenseField.setBounds(200, 120, 150, 25);
		panel1.add(licenseField);

		JButton returnButton = new JButton("Return Home");
		returnButton.setBounds(350, 250, 150, 30);
		returnButton.setBackground(Color.CYAN);
		panel1.add(returnButton);

		JLabel statusLabel = new JLabel(" ");
		statusLabel.setBounds(50, 150, 500, 25);
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(statusLabel);

		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedVehicleType = (String) vehicleTypeComboBox.getSelectedItem();
				String licensePlate = licenseField.getText();

				if (licensePlate.isEmpty()) {
					statusLabel.setText("Please enter a license plate number!");
					return;

				}
				if (parkingLot.isLicensePlateUsed(licensePlate)) {
					statusLabel.setText("This Vehicle Has Already Parked !");
					return;
				}
				Vehicle vehicle;
				switch (selectedVehicleType) {
				case "Car":
					vehicle = new Car(licensePlate);
					break;
				case "Electric Car":
					vehicle = new ElectricCar(licensePlate);
					break;
				case "Motorcycle":
					vehicle = new Motorcycle(licensePlate);
					break;
				default:
					statusLabel.setText("Invalid vehicle type!");
					return;
				}

				boolean parked = parkingLot.parkAVehicle(vehicle);
				if (parked) {
					String spotNumber = parkingLot.findVehicleSpot(licensePlate);
					statusLabel.setText("Vehicle parked successfully Your Spot Number: " + spotNumber);
				} else {
					statusLabel.setText("No available spots for " + selectedVehicleType + "!");
				}
			}

		});

		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				frame.remove(panel1);
				frame.add(panel);
				frame.repaint();
				frame.revalidate();
			}

		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				frame.add(panel2);
				frame.repaint();
				frame.revalidate();
			}
		});

		JLabel exitLabel = new JLabel("Exit");
		exitLabel.setBounds(370, 30, 100, 25);
		exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(exitLabel);

		JLabel licenseExitLabel = new JLabel("License Plate Number");
		licenseExitLabel.setBounds(150, 100, 150, 25);
		panel2.add(licenseExitLabel);

		JTextField licenseExitField = new JTextField();
		licenseExitField.setBounds(300, 100, 200, 25);
		panel2.add(licenseExitField);

		JButton findButton = new JButton("Find");
		findButton.setBounds(520, 100, 100, 25);
		findButton.setBackground(Color.CYAN);
		panel2.add(findButton);

		JLabel exitInfoLabel = new JLabel("You can exit from parking lot");
		exitInfoLabel.setBounds(300, 180, 300, 25);
		panel2.add(exitInfoLabel);

		JButton returnHomeButton1 = new JButton("Return Home");
		returnHomeButton1.setBounds(320, 250, 150, 30);
		returnHomeButton1.setBackground(Color.CYAN);
		panel2.add(returnHomeButton1);

		JLabel exitStatusLabel = new JLabel(" ");
		exitStatusLabel.setBounds(150, 220, 500, 25);
		exitStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(exitStatusLabel);

		findButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String licensePlate = licenseExitField.getText();

				if (licensePlate.isEmpty()) {
					exitStatusLabel.setText("Please enter a valid license plate number.");
					return;
				}

				boolean exited = parkingLot.exitVehicle(licensePlate);
				if (exited) {
					exitStatusLabel.setText("Vehicle with license plate " + licensePlate + " has exited.");
				} else {
					exitStatusLabel.setText("No vehicle found with license plate " + licensePlate + ".");
				}
			}
		});
		returnHomeButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel2);
				frame.add(panel);
				frame.repaint();
				frame.revalidate();
			}
		});

		JButton returnHomeButton2 = new JButton("Return Home");
		returnHomeButton2.setBounds(650, 300, 120, 30);
		returnHomeButton2.setBackground(Color.CYAN);
		panel3.add(returnHomeButton2);

		returnHomeButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel3);
				frame.add(panel);
				frame.repaint();
				frame.revalidate();
			}
		});
		JLabel titleLabel = new JLabel("Parked Vehicles");
		titleLabel.setBounds(350, 20, 200, 25);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		String[] sortOptions = { "Type", "Plate Number", "Spot Number" };
		JComboBox<String> sortSelector = new JComboBox<>(sortOptions);
		sortSelector.setBounds(50, 50, 150, 30);
		panel3.add(sortSelector);

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Vehicle> parkedVehicles = parkingLot.listParkedVehicles();
				Comparator<Vehicle> comparator = new TypeComparator();
				parkedVehicles.sort(comparator);

				JPanel gridPanel = new JPanel();
				gridPanel.setLayout(new GridLayout(parkedVehicles.size() + 1, 3, 10, 10));
				gridPanel.setBounds(50, 100, 700, parkedVehicles.size() * 30 + 30);

				gridPanel.add(new JLabel("Type", SwingConstants.CENTER));
				gridPanel.add(new JLabel("Plate Number", SwingConstants.CENTER));
				gridPanel.add(new JLabel("Spot Number", SwingConstants.CENTER));

				for (Vehicle vehicle : parkedVehicles) {
					gridPanel.add(new JLabel(vehicle.getType(), SwingConstants.CENTER));
					gridPanel.add(new JLabel(vehicle.getLicensePlateNumber(), SwingConstants.CENTER));
					gridPanel.add(new JLabel(parkingLot.findVehicleSpot(vehicle.getLicensePlateNumber()),
							SwingConstants.CENTER));
				}

				panel3.add(gridPanel);
				panel3.add(sortSelector);
				panel3.add(titleLabel);
				frame.remove(panel);
				frame.add(panel3);
				panel3.add(returnHomeButton2);
				frame.repaint();
				frame.revalidate();
			}
		});

		sortSelector.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Vehicle> parkedVehicles = parkingLot.listParkedVehicles();

				String selectedOption = (String) sortSelector.getSelectedItem();

				Comparator<Vehicle> comparator = null;

				if ("Type".equals(selectedOption)) {
					comparator = new TypeComparator();
				} else if ("Plate Number".equals(selectedOption)) {
					comparator = new PlateNumberComparator();
				} else if ("Spot Number".equals(selectedOption)) {
					comparator = new SpotNumberComparator(parkingLot);
				}

				if (comparator != null) {
					parkedVehicles.sort(comparator);
				}

				panel3.removeAll();
				panel3.add(sortSelector);

				JPanel gridPanel = new JPanel();
				gridPanel.setLayout(new GridLayout(parkedVehicles.size() + 1, 3, 10, 10));
				gridPanel.setBounds(50, 100, 700, parkedVehicles.size() * 30 + 30);

				gridPanel.add(new JLabel("Type", SwingConstants.CENTER));
				gridPanel.add(new JLabel("Plate Number", SwingConstants.CENTER));
				gridPanel.add(new JLabel("Spot Number", SwingConstants.CENTER));

				for (Vehicle vehicle : parkedVehicles) {
					gridPanel.add(new JLabel(vehicle.getType(), SwingConstants.CENTER));
					gridPanel.add(new JLabel(vehicle.getLicensePlateNumber(), SwingConstants.CENTER));
					gridPanel.add(new JLabel(parkingLot.findVehicleSpot(vehicle.getLicensePlateNumber()),
							SwingConstants.CENTER));
				}
				panel3.add(titleLabel);
				panel3.add(gridPanel);
				panel3.add(returnHomeButton2);
				panel3.revalidate();
				panel3.repaint();

			}
		});

		JLabel availableSpotsTitle = new JLabel("Available Spots");
		availableSpotsTitle.setBounds(350, 20, 200, 25);
		availableSpotsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel4.add(availableSpotsTitle);

		JLabel carLabel4 = new JLabel("Car");
		carLabel4.setBounds(100, 80, 100, 25);
		panel4.add(carLabel4);

		JTextField carSpotsField4 = new JTextField();
		carSpotsField4.setBounds(200, 80, 200, 25);
		carSpotsField4.setEditable(false);
		panel4.add(carSpotsField4);

		JLabel motorcycleLabel4 = new JLabel("Motorcycle");
		motorcycleLabel4.setBounds(100, 120, 100, 25);
		panel4.add(motorcycleLabel4);

		JTextField motorcycleSpotsField4 = new JTextField();
		motorcycleSpotsField4.setBounds(200, 120, 200, 25);
		motorcycleSpotsField4.setEditable(false);
		panel4.add(motorcycleSpotsField4);

		JLabel electricCarLabel4 = new JLabel("Electric Car");
		electricCarLabel4.setBounds(100, 160, 100, 25);
		panel4.add(electricCarLabel4);

		JTextField electricCarSpotsField4 = new JTextField();
		electricCarSpotsField4.setBounds(200, 160, 200, 25);
		electricCarSpotsField4.setEditable(false);
		panel4.add(electricCarSpotsField4);

		JButton returnHomeButton3 = new JButton("Return Home");
		returnHomeButton3.setBounds(600, 300, 150, 30);
		returnHomeButton3.setBackground(Color.CYAN);
		panel4.add(returnHomeButton3);

		returnHomeButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel4);
				frame.add(panel);
				frame.repaint();
				frame.revalidate();
			}
		});

		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				carSpotsField4.setText(parkingLot.getAvailableSpots("Car") + " spots available");
				motorcycleSpotsField4.setText(parkingLot.getAvailableSpots("Motorcycle") + " spots available");
				electricCarSpotsField4.setText(parkingLot.getAvailableSpots("Electric Car") + " spots available");

				frame.remove(panel);
				frame.add(panel4);
				frame.repaint();
				frame.revalidate();
			}
		});

		JLabel findSpotTitle = new JLabel("Find a Vehicle's Spot");
		findSpotTitle.setBounds(300, 20, 200, 25);

		findSpotTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel5.add(findSpotTitle);

		JLabel licensePlateLabel5 = new JLabel("License Plate Number");
		licensePlateLabel5.setBounds(150, 100, 150, 25);
		panel5.add(licensePlateLabel5);

		JTextField licensePlateField5 = new JTextField("31 CS 105");
		licensePlateField5.setBounds(320, 100, 150, 25);
		panel5.add(licensePlateField5);

		JButton findButton5 = new JButton("Find");
		findButton5.setBounds(500, 100, 100, 25);
		findButton5.setBackground(Color.CYAN);
		panel5.add(findButton5);

		JLabel findStatusLabel = new JLabel(" ");
		findStatusLabel.setBounds(150, 200, 500, 25);
		findStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel5.add(findStatusLabel);

		findButton5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String licensePlate = licensePlateField5.getText();

				if (licensePlate.isEmpty()) {
					findStatusLabel.setText("Please enter a valid license plate number.");
					return;
				}

				String spotNumber = parkingLot.findVehicleSpot(licensePlate);

				if (!spotNumber.equals("Not Found")) {
					findStatusLabel.setText("Spot Number: " + spotNumber);
				} else {
					findStatusLabel.setText("Vehicle not found for license plate: " + licensePlate);
				}
			}
		});

		JButton returnHomeButton4 = new JButton("Return Home");
		returnHomeButton4.setBounds(320, 250, 150, 30);
		returnHomeButton4.setBackground(Color.CYAN);
		panel5.add(returnHomeButton4);

		returnHomeButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel5);
				frame.add(panel);
				frame.repaint();
				frame.revalidate();
			}
		});

		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				frame.add(panel5);
				frame.repaint();
				frame.revalidate();
			}
		});
	}
}
