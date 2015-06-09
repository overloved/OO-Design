public class Bus extends Vehicle {

	public Bus() {
		super();
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}

	// check if the spot is a large. Does not check num of spots
	public abstract boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSpotSize() == VehicleSize.Large;
	}

	public void print() {
		System.out.println("B");
	}
}