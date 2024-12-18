package com.nano.leetcode;

/*
706. Design HashMap
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.


Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]


Constraints:

0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.

 */
public class DesignHashMap706 {
    public static void main(String[] args) {
        MyHashMap m = new MyHashMap();
        m.put(1,2);
        m.put(11,22);
         m.put(12,24);

       System.out.println(m.get(1));
         System.out.println(m.get(11));
        System.out.println(m.get(12));
        System.out.println(m.get(22));

        m.remove(12);
        System.out.println(m.get(1));
        System.out.println(m.get(11));
        System.out.println(m.get(12));
    }
}

class MyHashMap {
    private Node[] entries;
    private final int size = 16;
    public MyHashMap() {
        entries = new Node[size];
    }

    public void put(int key, int value) {
        //No hash func is required as only int value are there. Just calc mod%
        int bucket = key%size;
        Node node = entries[bucket];
        if(node == null){
            entries[bucket]=new Node(key, value);
        }
        else{
            Node next = node;
            while(next != null){
                if(key==next.getKey()){
                    next.setValue(value);
                    return;
                }
                next=next.getNext();
            }
            Node newNode = new Node(key, value);
            entries[bucket] = newNode;
            newNode.setNext(node);
        }
    }

    public int get(int key) {
        int bucket = key%size;
        Node node = entries[bucket];
        if(node == null){
            return -1;
        }
        else{
            Node next = node;
            while(next != null){
                if(key==next.getKey()){
                    return next.getValue();
                }
                next=next.getNext();
            }
            return -1;
        }
    }

    /* Better version below: extract common part to remove branch
    public int get(int key) {
        int bucket = key%size;
        Node node = entries[bucket];
        if (node != null) {
            Node next = node;
            while (next != null) {
                if (key == next.getKey()) {
                    return next.getValue();
                }
                next = next.getNext();
            }
        }
        return -1;
    }
     */

    public void remove(int key) {
        int bucket = key%size;
        Node node = entries[bucket];
        if(node == null){
            return;
        }
        else{
            Node next = node;
            Node prev = null;
            while(next != null){
                if(key==next.getKey()){
                    if(prev==null) {//first entry in the bucket is null
                        entries[bucket]=next.getNext();
                        return;
                    }
                    else
                        prev.setNext(next.getNext());
                }
                prev=next;
                next=next.getNext();
            }
        }
    }

    private static class Node{
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }

        public int getKey(){
            return key;
        }

        public int getValue(){
            return value;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next=next;
        }

        public void setValue(int value){
            this.value=value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */