public class Main {
    public static void main(String[] args) {
        MyArray customarray = new MyArray();
        customarray.push(3);
        customarray.push(7);
        customarray.get(0);
        customarray.get(1);
        System.out.println(customarray);
        customarray.pop();
        System.out.println(customarray);

        customarray.push(10);
        customarray.push(12);
        System.out.println(customarray);
        customarray.removeByValue(10);
        System.out.println(customarray);

    }
}
