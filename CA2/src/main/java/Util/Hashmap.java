package Util;

import Classes.Drink;

public class Hashmap<E>{
    private E[] hashTable;

    public Hashmap(int size) {
        hashTable = (E[]) new Object[size];
    }

    public int hash(E item) {
        int total = 0;
        for (int i = 0; i < item.toString().length(); i++) {
            total += item.toString().charAt(i);
        }
        return total % hashTable.length;
    }

    public void insert(E value) {
        int index = hash(value);
        for (int i = 0; i <= hashTable.length; i++) {
            if (hashTable[index] != null) {
                if (index >= hashTable.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
            } else {
                hashTable[index] = value;
                return;
            }
        }
    }

    public void remove(int index){
        hashTable[index]=null;
    }

    public E get(int i){
        return hashTable[i];
    }

    public int search(E value){
        int temp=hash(value);
        for (int i=0;i<hashTable.length;i++){
            if(hashTable[temp]==value){
                return temp;
            }
            else{
                temp++;
                if(temp>=100){
                    temp=0;
                }
            }
        }
        return 0;
    }
}
