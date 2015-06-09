public class Level {

	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;
	private static final int SPOTS_PER_ROW = 10;

	public level(int floor, int numberSpots) {
		this.floor = floor;
		spots = new ParkingSpot[numberSpots];

		int largeSpots = numberSpots / 4; // 7
		int motorSpots = numberSpots / 4; // 7
		int compactSpots = numberSpots - largeSpots - motorSpots; // 16

		for (int i = 0; i < numberSpots; i++) {
			VehicleSize size = VehicleSize.Motorcycle;
			if (i < largeSpots) {
				size = VehicleSize.Large;
			} else if (i < largeSpots + compactSpots) {
				size = VehicleSize.compact;
			}
			int row = i / SPOTS_PER_ROW;
			spots[i] = new ParkingSpot(this, row, i, size);
		}
	}

	public int availableSpots() {
		return availableSpots;
	}

	// find a place to park vehicle
	public boolean parkVehicle(Vehicle vehicle) {
		if (availableSpots() < vehicle.getSpotsNeeded()) {
			return false;
		}
		int spotNumber = findAvailableSpots(vehicle);
		if (spotnumber < 0) return false;
		return parkStartingAtSpot(spotnumber, vehicle);
	}

	// Park a vehicle starting at the spotnumber, and continuing until vehicle.spotsNeeded
	private boolean parkStartingAtSpot(int spotNumber, Vehicle, vehicle) {
		vehicle.clearSpots();
		boolean success = true;
		for (int i = spotnumber; i < spotnumber + vehicle.getSpotsNeeded(); i++) {
			success &= spots[i].park(vehicle);
		}
		availableSpots -= vehicle.spotsNeeded;
		return success;
	}

	// find a spot to park vehicle, return index of spot, or -1 if failed.
	private int findAvailableSpots(Vehicle vehicle) {
		int spotsNeeded = vehicle.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;

		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (lastRow != spot.getRow()) {
				lastRow = spot.getRow();
				spotsFound = 0;
			}
			if (spot.canFitVehicle(vehicle)) {
				spotsFound++;
			} else {
				spotsFound = 0;
			}

			if (spotsFound == spotsNeeded) {
				return i - (spotsNeeded - 1);
			}
		}
		return -1;
	}

	public void spotFree() {
		availableSpot++;
	}

	public void print() {
		int lastRow = -1;
		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (spot.getRow() != lastRow) {
				System.out.print("  ");
				lastRow = spot.getRow();
			}
			spot.print();
		}
	}
}