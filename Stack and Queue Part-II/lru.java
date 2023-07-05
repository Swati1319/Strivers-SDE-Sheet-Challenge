import java.util.*;

public class LRUCache
{
    private final LinkedHashMap<Integer,Integer> lruMap;
    private int CAPACITY;
    LRUCache(int capacity)
    {
        CAPACITY = capacity;
        lruMap = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            protected boolean removeEldestEntry(Map.Entry eldest){
                    return size() > CAPACITY;
            }
        };
    }

    public int get(int key)
    {
        return lruMap.getOrDefault(key,-1);
    }

    public void put(int key, int value)
    {
      lruMap.put(key,value);
    }
}
