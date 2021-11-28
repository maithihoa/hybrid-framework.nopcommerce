package javaFactory;

public class CarFactory {
	public void viewCar(String carName) {
		Car car;
		switch (carName) {
		case "Honda":
			car = new Honda();
			car.viewCar();
		case "Huyndai":
			car = new Huyndai();
			car.viewCar();
		case "Toyota":
			car = new Toyota();
			car.viewCar();
		}
	}

	public void driverCar(String carName) {
		Car car;
		switch (carName) {
		case "Honda":
			car = new Honda();
			car.driverCar();
		case "Huyndai":
			car = new Huyndai();
			car.driverCar();
		case "Toyota":
			car = new Toyota();
			car.driverCar();
		}
	}
	public void driverCar() {
		
	}
}
