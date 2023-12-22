package BagADT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayBag implements Bag {

    private Object[] items;
    private int numItems;

    public ArrayBag(int length)
    {
        items = new Object[length];
        numItems = 0;
    }
    @Override
    public boolean add(Object item) {
        try {
            if (numItems >= items.length)
            {
                Object[] tmpItems = new Object[items.length + 10];
                for (int i = 0; i < items.length; i++) {
                    tmpItems[i] = items[i];
                }
                items = tmpItems;
            }
            items[numItems] = item;
            numItems ++;
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean remove(Object item) {
        boolean checkExist = false;
        int indexRemovedItem = 0;

        for (int i = 0; i < numItems; i++) {
            if (items[i] == item) {
                indexRemovedItem = i;
                items[i] = null;
                checkExist = true;
                break;
            }
        }
        if (checkExist)
        {
            for (int i = indexRemovedItem; i < numItems; i++) {
                items[i] = items[i+1];
            }
            numItems--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object item) {
        for (int i = 0; i < numItems; i++) {
            if (items[i] == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int numItems() {
        return numItems;
    }

    @Override
    public Object grab() {
        Random random = new Random();
        int n = random.nextInt(numItems);
        return items[n];
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[numItems];
        for (int i = 0; i < numItems; i++) {
            array[i] = items[i];
        }
        return array;
    }
}
