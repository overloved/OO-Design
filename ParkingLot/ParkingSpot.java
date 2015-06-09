public class ParkingSpot {

	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;

	public ParkingSpot(Level lvl, int row, int num, VehicleSize size) {
		this.level = lvl;
		this.row = row;
		this.spotNumber = num;
		this.spotSize = size;
	}

	public boolean isAvailable() {
		return vehicle == null;
	}

	public boolean canFitVehicle(Vehicle vehicle) {
		return isAvailable() && vehicle.canFitInSpot(this);
	}

	public boolean park(Vehicle vehicle) {
		if (!canFitVehicle(vehicle)) {
			return false;
		}
		vehicle.parkInSpot(this);
		return true;
	}

	public int getRow() {
		return row;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public int getSpotSize() {
		return spotSize;
	}

	public void removeVehicle() {
		level.spotFree();
		vehicle = null;
	}

	public void print() {
		if (vehicle == null) {
			if (spotSize == VehicleSize.Compact) {
				System.out.println("c");
			} else if (spotSize == VehicleSize.Large) {
				System.out.println("l");
			} else if (spotSize == VehicleSize.Motorcycle) {
				System.out.println("m");
			}
		} else {
			vehicle.print();
		}
	}
}