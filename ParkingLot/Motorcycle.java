public class Motorcycle extends Vehicle {
	
	public Motorcycle() {
		super();
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}

	// check if the spot is a Motorcycle, Compact or large. Does not check num of spots
	public abstract boolean canFitInSpot(ParkingSpot spot) {
		return true;
	}

	public void print() {
		System.out.println("M");
	}
}