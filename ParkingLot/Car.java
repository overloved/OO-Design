public class Car extends Vehicle {
	
	public Car() {
		super();
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}

	// check if the spot is a Compact or Large. Does not check num of spots
	public abstract boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSpotSize() == VehicleSize.Large || spot.getSpotSize() == VehicleSize.Compact;
	}

	public void print() {
		System.out.println("C");
	}
}