public class CommonElements {
    public static void main(String[] args) {
        String[] array1 = {"Apple", "Banana", "Orange", "Mango", "Pear"};
        String[] array2 = {"Grapes", "Orange", "Banana", "Kiwi", "Pear"};

        System.out.println("Common elements:");

        for (String item1 : array1) {
            for (String item2 : array2) {
                if (item1.equalsIgnoreCase(item2)) {
                    System.out.println(item1);
                }
            }
        }
    }
}
