package src;

import java.util.HashMap;

public class Data {
    static int size;

    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();

    public void insert(int address, int data) {
        map.put(address, data);
    }

    public void insert(String Address, int data) {
        map2.put(Address, data);
    }

    public int find(int address) {
        if (map.containsKey(address)) {
            return map.get(address);
        } else {
            return -1;
        }
    }

    public int find(String address) {
        if (map2.containsKey(address)) {
            return map2.get(address);
        } else {
            return -1;
        }
    }

}
