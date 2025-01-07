import java.util.HashMap;
import java.util.Map;

//How to build an array from scratch
//Teaches the functionality of arrays
//Teaches fundamentals of objected-oriented programming

public class MyArray {
    private int length; //length property
    private HashMap<Integer, Object> data; //data property

    public MyArray() { //Constructor
        this.length = 0; // 0
        this.data = new HashMap<>(); // {}
    }

    public Object get(int index) { //Get element O(1)
        return data.get(index); //{index:element} access element

    }

    public void push(Object item) { //add item O(1)
        //add item at data[length]
        //increment length
        data.put(this.length, item);
        this.length++;
    }

    public void pop() { //remove item O(1)
        //remove item at data[length - 1]
        //decrement length
        data.remove(this.length - 1);
        this.length--;
    }

    public void removeByValue(Object item) { //O(n)

        Integer targetKey = null;
        for(Map.Entry<Integer, Object> entry: data.entrySet()) { //O(n)
            if(entry.getValue().equals(item)) { //check if target exists in map
                targetKey = entry.getKey();
                data.remove(targetKey);
                break;
            }

        }

        if(targetKey !=null) {
            this.length--;
            shiftIndiciesDown(targetKey);
        }
    }

    public String toString() {
        //Make the data representation pretty
        return "length: " + this.length + ", data: " + this.data;
    }

    public void shiftIndiciesDown(int startIndex) {
        //After removal, shift rightward indicies back 1
        Integer keyToNull;
        for(int i = startIndex; i <= this.length; i++) {
            data.put(i, data.get(i+1));
        }
        //Fixes bug where data[length] = null by removing null entry after shift
        if(data.containsValue(null)) {
            for(Map.Entry<Integer, Object> entry: data.entrySet()) {
                if(entry.getValue() == null) {
                    data.remove(entry.getKey(), entry.getValue());
                }
            }
        }

    }


}