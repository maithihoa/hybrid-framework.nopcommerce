package javaModifierACC;

import javaAccessModifier.Camle;

	public class LienChieu {
		public static void main(String[] args) {
			Camle camle = new Camle();
			camle.stateSize = "1500";
			System.out.println(camle.getStateSize());
			
			//Don't access
			//camle.stateZipCode ="";
			//camle.getStateZipcode();
			
			//Don't access
			//camle.getStateGDP();
			//camle.stateGDP="";
			
			//camle.stateLocation = "";
	}
}
