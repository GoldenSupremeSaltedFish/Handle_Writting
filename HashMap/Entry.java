class Entry<K, V>{
    K k;
    V v;
    Entry<K,V> next;

    public Entry(K k, V v, Entry<K, V> next){
        this.k = k;
        this.v = v;
        this.next = next;
    }
}