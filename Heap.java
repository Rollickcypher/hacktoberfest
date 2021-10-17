import java.util.*;

public class Heap {
    public static class heap {

        ArrayList<Long> heap_arr = new ArrayList<Long>();
        int size = 0;

        void insert_maxheap(long key) {
            heap_arr.add(key);
            size++;

            int i = size - 1;
            int j = (i - 1) / 2;

            long ele = heap_arr.get(i);

            while (i > 0 && ele > heap_arr.get(j)) {

                heap_arr.set(i, heap_arr.get(j));
                i = j;
                j = (i - 1) / 2;
            }

            heap_arr.set(i, ele);

        }

        void insert_minheap(long key) {
            heap_arr.add(key);
            size++;

            int i = size - 1;
            int j = (i - 1) / 2;

            long ele = heap_arr.get(i);

            while (i > 0 && ele < heap_arr.get(j)) {

                heap_arr.set(i, heap_arr.get(j));
                i = j;
                j = (i - 1) / 2;
            }

            heap_arr.set(i, ele);

        }

        long del_maxheap() {

            long ele = heap_arr.get(0);
            heap_arr.set(0, heap_arr.get(size - 1));
            // heap_arr.remove(size - 1);
            heap_arr.set(size - 1, ele); // for heap_sort (increasing order)
            size--;

            int i = 0;
            int j = 2 * i + 1;

            while ((j < size && (heap_arr.get(i) < heap_arr.get(j))
                    || (j + 1 < size && heap_arr.get(i) < heap_arr.get(j + 1)))) {
                if (j + 1 < size && heap_arr.get(j) < heap_arr.get(j + 1))
                    j++;

                long temp = heap_arr.get(j);
                heap_arr.set(j, heap_arr.get(i));
                heap_arr.set(i, temp);

                i = j;
                j = 2 * i + 1;

            }

            return ele;

        }

        long del_minheap() {

            long ele = heap_arr.get(0);
            heap_arr.set(0, heap_arr.get(size - 1));
            // heap_arr.remove(size - 1);
            heap_arr.set(size - 1, ele); // for heap_sort (dec order)
            size--;

            int i = 0;
            int j = 2 * i + 1;

            while ((j < size && (heap_arr.get(i) > heap_arr.get(j))
                    || (j + 1 < size && heap_arr.get(i) > heap_arr.get(j + 1)))) {
                if (j + 1 < size && heap_arr.get(j) > heap_arr.get(j + 1))
                    j++;

                long temp = heap_arr.get(j);
                heap_arr.set(j, heap_arr.get(i));
                heap_arr.set(i, temp);

                i = j;
                j = 2 * i + 1;

            }

            return ele;

        }

    }

    public static ArrayList<Long> max_heapify(ArrayList<Long> heap_arr) {

        int size = heap_arr.size();
        int i = size - 1;
        int j = 2 * i + 1;

        while (i >= 0) {
            if (j > size - 1 )
                i--;
            else {
                if (j<size && heap_arr.get(j) < heap_arr.get(j + 1))
                    j++;

                if (heap_arr.get(i) < heap_arr.get(j)) {
                    long temp = heap_arr.get(i);
                    heap_arr.set(i, heap_arr.get(j));
                    heap_arr.set(j, temp);
                    i = j;
                }
                else
                {
                    i--;
                }
            }

            j = 2 * i + 1;
        }

        return heap_arr;
    }

    public static ArrayList<Long> min_heapify(ArrayList<Long> heap_arr) {

        int size = heap_arr.size();
        int i = size - 1;
        int j = 2 * i + 1;

        while (i >= 0) {
            if (j > size - 1 )
                i--;
            else {
                if (j<size && heap_arr.get(j) > heap_arr.get(j + 1))
                    j++;

                if (heap_arr.get(i) > heap_arr.get(j)) {
                    long temp = heap_arr.get(i);
                    heap_arr.set(i, heap_arr.get(j));
                    heap_arr.set(j, temp);
                    i = j;
                }
                else
                {
                    i--;
                }
            }

            j = 2 * i + 1;
        }

        return heap_arr;
    }



    public static void main(String[] args) {
        heap h = new heap();

        ArrayList<Long> arr = new ArrayList<Long>();
        int arr2[] = { 5,10,30,20,35,40,15 };

        for (int i = 0; i < arr2.length; i++) {
            arr.add((long) arr2[i]);
        }

        h.heap_arr = min_heapify(arr);
        /*
         * h.heap_arr.add((long)arr[0]); h.size ++;
         * 
         * for(int i=1;i<arr.length;i++){ h.insert_minheap(arr[i]); }
         * 
         * while(h.size > 0) { h.del_minheap(); }
         */

        for (int i = 0; i < h.heap_arr.size(); i++) {
            System.out.print(h.heap_arr.get(i) + " ");
        }
    }
}
