package lab.bucket;

public class TableCrud {

    public static void main(String[] args) {

//        createTable();
//        putItems();
//        queryItem();
        deleteItems();
        deleteTable();


    }

    private static void deleteTable() {
        String[] arr = new String[1];
        arr[0] = "AbhijitTable";
        DeleteTable.main(arr);
    }

    private static void queryItem() {
        String[] arr = new String[3];
        arr[0] = "AbhijitTable";
        arr[1] = "Name";
        arr[2] = "Neha";
        Query.main(arr);
    }

    private static void deleteItems() {
        String[] arr = new String[2];
        arr[0] = "AbhijitTable";
        arr[1] = "Neha";
        DeleteItem.main(arr);
        arr[1] = "Geeti";
        DeleteItem.main(arr);
        arr[1] = "Abhijit";
        DeleteItem.main(arr);
        arr[1] = "Renu";
        DeleteItem.main(arr);
        arr[1] = "Ashok";
        DeleteItem.main(arr);
    }

    private static void createTable() {
        String[] arr = new String[1];
        arr[0] = "AbhijitTable";
        CreateTable.main(arr);
    }

    private static void putItems() {
        String[] arr = new String[2];
        arr[0] = "AbhijitTable";
        arr[1] = "Neha";
        PutItem.main(arr);
        arr[1] = "Geeti";
        PutItem.main(arr);
        arr[1] = "Abhijit";
        PutItem.main(arr);
        arr[1] = "Renu";
        PutItem.main(arr);
        arr[1] = "Ashok";
        PutItem.main(arr);
    }
}
