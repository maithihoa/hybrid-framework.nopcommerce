package javaAccessModifier;

public class Camle {
	
	//thuoc tinh public, default, protected
	public String stateSize;
	String stateZipcode = "562000";
	protected String stateGDP = "5000";
	private String stateLocation = "North";
	
	//Ham default
	String getStateZipCode() {
		return this.getStateZipCode();
	}
	
	// H�m public
	public String getStateSize() {
		return stateSize;
	}
	
	// H�m protected
		protected String getStateGDP() {
			return stateGDP;
		}
	// H�m private
		private String getStateLocation() {
			return stateLocation;
		}
	//Nested class
	class HoaPhat{
		public void showStateSize() {
			System.out.println(stateSize);
			getStateZipCode();
			getStateLocation();
		}
	}
	
}
