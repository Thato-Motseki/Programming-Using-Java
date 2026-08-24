package rtrs;

public class RTRS {

    public static void main(String[] args) {

        Table table1 = new Table(1, 2);
        Table table2 = new Table(2, 4);
        Table table3 = new Table(3, 6);

        System.out.println(table1.canSeat(2));
        System.out.println(table2.canSeat(5));

        table2.reserve();

        System.out.println(table2.isReserved());
    }
}