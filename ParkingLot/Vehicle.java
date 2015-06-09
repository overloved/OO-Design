public abstract class Vehicle {

	protected ArrayList<ParkingSpot> parkingSpots;
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize size;

	public Vehicle() {
		parkingSpots = new ArrayList<ParkingSpot>();
	}


	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	public VehicleSize getSize() {
		return size;
	}

	public void parkInSpot(parkingSpot s) {
		parkingSpots.add(s);
	}

	public void clearSpots() {
		for (int i = 0; i < parkingSpots.size(); i++) {
			parkingSpots.get(i).removeVehicle();
		}
		parkingSpots.clear();
	}

	public abstract boolean canFitInSpot(ParkingSpot spot);
	public abstract void print();
}