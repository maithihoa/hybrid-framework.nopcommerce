package javaAccessModifier;

public class HoaKhanh {
	
	public static void main(String[] args) {
		Camle camle = new Camle();
		camle.stateSize = "1500";
		System.out.println(camle.getStateSize());
		System.out.println(camle.getStateZipCode());
		
		camle.stateGDP = "";
		camle.getStateGDP();
		
		//camle.stateLocation = "";
	}
}
