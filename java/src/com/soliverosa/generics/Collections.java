package com.soliverosa.generics;

import java.util.*;

public class Collections {

    public static void main (String [] args ) {
        arrayListSample();
        linkedListSample();
        arrayDequeSample();
        priorityQueueSample();
        hashSetSample();
        hashMapSample();
        treeSetSample();
        removeListDuplicates(new ArrayList<Integer>(Arrays.asList(10,30,40,20,50,100,20,10)));
    }

    public static void arrayListSample() {
        List<String> list = new ArrayList<String>();
        list.add("Elemento 1");
        list.add("Elemento 2");
        list.add("Elemento 3");
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            if (it.nextIndex() == 1) {
                System.out.println("Removiendo elemento en posición: " + it.nextIndex());
                it.remove();
                break;
            }
            it.next();
        }
        System.out.println("ARRAY LIST");
        System.out.println(list);
    }

    public static void linkedListSample() {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("Elemento 1");
        list.addFirst("Elemento 2");
        list.addFirst("Elemento 3");
        ListIterator<String> it = list.listIterator(0);
        while (it.hasNext()) {
            if (it.nextIndex() == 1) {
                System.out.println("Removiendo elemento en posición: " + it.nextIndex());
                it.remove();
                break;
            }
            it.next();
        }
        System.out.println("LINKED LIST");
        System.out.println(list);
    }

    public static void arrayDequeSample() {
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Elemento 1");
        deque.add("Elemento 2");
        deque.add("Elemento 3");
        Iterator<String> it = deque.descendingIterator();
        while (it.hasNext()) {
            it.next();
        }
        System.out.println("DEQUE");
        System.out.println(deque);
    }

    public static void priorityQueueSample() {
        Queue<String> queue = new PriorityQueue<String>();
        queue.add("Elemento 1");
        queue.add("Elemento 2");
        queue.add("Elemento 3");
        Iterator<String> it = queue.iterator();
        while (it.hasNext()) {
            it.next();
        }
        System.out.println("QUEUE");
        System.out.println(queue);
    }

    /**
     * NO ACEPTA ELEMNTO DUPLICADOS
     */
    public static void hashSetSample() {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Elemento 2");
        hashSet.add("Elemento 2");
        hashSet.add("Elemento 3");
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            it.next();
        }
        System.out.println("HASHSET");
        System.out.println(hashSet);
    }

    /**
     * CLAVE VALOR. IMPLEMENTA MAP. NO ES COLLECTION.
     */
    public static void hashMapSample() {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("a", "Elemento 1");
        hashMap.put("b", "Elemento 2");
        hashMap.put("c", "Elemento 3");
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            it.next();
        }
        System.out.println("HASHMAP");
        System.out.println(hashMap);
    }

    /**
     * ORDENA ELEMENTOS EN ORDEN ASCENDENTE y NO ADMITE DUPLICADOS
     */
    public static void treeSetSample() {
        SortedSet<String> treeSet = new TreeSet<String>();
        treeSet.add("Elemento 2");
        treeSet.add("Elemento 3");
        treeSet.add("Elemento 3");
        treeSet.add("Elemento 1");
        Iterator<String> it = treeSet.iterator();
        while (it.hasNext()) {
            it.next();
        }
        System.out.println("TREESET");
        System.out.println(treeSet);
    }

    public static List<Integer> removeListDuplicates(List<Integer> list) {
        List<Integer> output = new ArrayList<Integer>();

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int value = it.next();
            if (!output.contains(value))
                output.add(value);
        }
        System.out.println("REMOVE LIST DUPLICATES");
        System.out.println("Received list");
        System.out.println(list);
        System.out.println("Output list");
        System.out.println(output);
        return list;
    }
}
