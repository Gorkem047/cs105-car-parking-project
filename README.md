# CS105 Car Parking Project

A small Java Swing parking lot management application developed as a CS105 course project in December 2024.

This repository is an archived and cleaned-up copy of the original student project. The source files were moved into a standard Java package directory so the project is easier to compile, run, and keep on GitHub.

## Project Context

- Course: CS105
- Original development date: December 2024
- Archived on GitHub: June 2026
- Type: Desktop GUI application
- Language: Java
- UI library: Java Swing
- Package: `parkingProject`

## Features

- Park a vehicle by license plate number
- Support different vehicle types:
  - Car
  - Electric Car
  - Motorcycle
- Exit/remove a parked vehicle
- List parked vehicles
- Sort listed vehicles by:
  - Vehicle type
  - License plate number
  - Parking spot number
- Show available parking spots by vehicle type
- Find a vehicle's parking spot by license plate number

## Project Structure

```text
src/
  parkingProject/
    Car.java
    ElectricCar.java
    Motorcycle.java
    ParkingLot.java
    ParkingSpot.java
    PlateNumberComparator.java
    SpotNumberComparator.java
    TypeComparator.java
    UserInterface.java
    Vehicle.java
```

## How to Compile

From the project root:

```powershell
javac -d out src\parkingProject\*.java
```

## How to Run

```powershell
java -cp out parkingProject.UserInterface
```

## Notes

This project was originally created for coursework and later organized for GitHub. The implementation is intentionally kept close to the original version to preserve the historical student-project context.
