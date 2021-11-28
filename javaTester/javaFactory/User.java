package javaFactory;

public class User {
	public static void main(String[] args) {
		CarFactory carFactory = new CarFactory();
		carFactory.viewCar("Honda");
		carFactory.driverCar("Honda");
		carFactory.viewCar("Toyota");
		carFactory.driverCar("Toyota");
		carFactory.viewCar("Huyndai");
		carFactory.driverCar("Huyndai");
	}

}
