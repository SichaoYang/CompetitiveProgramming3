////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: 2.3. Non-Linear DS with Built-in Libraries, 2. Data Structures and Libraries,
//         Competitive Programming 3: The New Lower Bound of Programming Contests, pp. 43-45
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Balanced Binary Search Tree: TreeMap (key -> value) / TreeSet (key)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        System.out.println(map.get(1) + ", " + map.get(2) + ", " + map.getOrDefault(2, 0));
        map.put(3, 4);
        System.out.println(map);
        System.out.println(map.firstKey() + ", " + map.lastKey());
        System.out.println(map.lowerKey(3) + ", " + map.higherKey(1));
        System.out.println(map.floorKey(3) + ", " + map.ceilingKey(1));
        System.out.println(map.firstEntry().getKey() + ", " + map.firstEntry().getValue());
        map.subMap(1, 2); map.headMap(2); map.tailMap(1);
        map.replace(1, 1);
        map.remove(1); map.pollFirstEntry(); map.pollLastEntry();
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        System.out.println(set.contains(1));
        set.add(3);
        System.out.println(set);
        System.out.println(set.first() + ", " + set.last());
        System.out.println(set.lower(3) + ", " + set.higher(1));
        System.out.println(set.floor(3) + ", " + set.ceiling(1));
        Integer[] array = set.toArray(new Integer[2]);
        set.subSet(1, 2); set.headSet(2); set.tailSet(1);
        set.remove(1); set.pollFirst(); set.pollLast();
        
        // Heap: PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((i1, i2) -> i1 - i2);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.contains(1);
        System.out.println(priorityQueue.poll() + ", " + priorityQueue.peek());
        
        // Hash Table: HashMap/HashSet/HashTable
        // Useless as O(1) ~ O(k) in contests, expect Direct Addressing Tables (DATs). See 2.2.
    }
}