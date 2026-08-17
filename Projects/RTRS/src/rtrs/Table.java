/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rtrs;

/**
 *
 * @author thato
 */
public class RTRS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    class Table {
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
}
    
}
