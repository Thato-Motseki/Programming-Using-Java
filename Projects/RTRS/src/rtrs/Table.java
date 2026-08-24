package rtrs;

public class Table {

    private int tableNumber;
    private int capacity;
    private boolean reserved;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.reserved = false;
    }

    public boolean canSeat(int people) {
        return people <= capacity && !reserved;
    }

    public void reserve() {
        reserved = true;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isReserved() {
        return reserved;
    }
}