import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap<K,V>implements MyHashMapImpl<K,V> {
    final static int DEFAULT_CAPACITY = 16;
    final static float DEFAULT_LOAD_FACTOR = 0.75f;

    int capacity=DEFAULT_CAPACITY;//默认的容量
    float loadFactor=DEFAULT_LOAD_FACTOR;//负载因子
    int size = 0;
    int Thread =16;
    Entry<K,V>[] table;


    public MyHashMap(int capacity,float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table=new Entry[capacity];

    }

    @Override
    public V put(K key, V value) {
        int index;
        if(null == value)
        {
           index=0;
        }
        else
        {
             index = key.hashCode() % capacity;
        }
        Entry<K,V> entry=table[index];
        if(entry==null)//该哈希槽为空
        {
            table[index]=new Entry<K, V>(key,value,table[index]);
            size++;
            return null;
        }
        else
        {
            if (entry.k==key)
            {
                V before=entry.v;
                table[index].v=value;
                return before;
            }
        }
        return null;
    }

    @Override
    public V get(K k) {
        int index = k.hashCode() % table.length;
        Entry<K, V> current = table[index];
        // 遍历链表
        while(current != null){
            if(current.k == k){
                return current.v;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public V remove(K key) {
        if(table[key.hashCode()%capacity]==null)
        {
            return null;
        }
        else {
            if(table[key.hashCode()%capacity].next==null)
            {
                table[key.hashCode()%capacity]=null;
            }
            else{
                while (table[key.hashCode()%capacity].next!=null)
                {
                    table[key.hashCode()%capacity].next=table[key.hashCode()%capacity].next.next;
                    table[key.hashCode()%capacity]=null;
                    size--;
                }
                table[key.hashCode()%capacity].next=null;
                size--;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if(size==0)
            return false;
        else
            return true;
    }

    @Override
    public void clear() {
        

    }
}
