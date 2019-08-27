package com.example.user.testapf.data_structures.hashmap;

import java.util.Arrays;

public class MyMapImpl2<K, V>
{

    interface Node<K, V>
    {
        int getHash();
        Node next();
        K getKey();
        V getValue();
        void setNext(Node next);
        void setValue(V value);
    }

    class MyNode<K, V> implements Node<K, V>
    {
        K key;
        V value;
        Node next;

        MyNode(K key, V value)
        {
            this.key = key;
            this.value= value;
        }

        @Override
        public int getHash()
        {
            return key.hashCode();
        }

        @Override
        public void setNext(Node next)
        {
            this.next = next;
        }

        @Override
        public void setValue(V value)
        {
            this.value = value;
        }

        @Override
        public Node next()
        {
            return next;
        }

        @Override
        public K getKey()
        {
            return key;
        }

        @Override
        public V getValue()
        {
            return value;
        }
    }

    private static final int INITIAL_CAPACITY = 1 << 2; // 16
    private Node<K, V>[] buckets;
    private int size = 0;

    public MyMapImpl2() {
        this(INITIAL_CAPACITY);
    }

    public MyMapImpl2(int capacity) {
        this.buckets = new MyNode[capacity];
    }

    public void put(K key, V value)
    {
        if (size > buckets.length*0.75)
        {
            Node<K, V>[] tempBuckets = Arrays.copyOf(buckets, buckets.length);
            int newCapacity = buckets.length;
            newCapacity = newCapacity << 1;
            this.buckets = new MyNode[newCapacity];
            size = 0;


            for (Node<K, V> tempBucket : tempBuckets)
            {
                while (tempBucket != null)
                {
                    put(tempBucket.getKey(), tempBucket.getValue());
                    tempBucket = tempBucket.next();
                }
            }


        }
        MyNode node = new MyNode(key, value);
        int bucket = key.hashCode() % buckets.length;

        Node existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = node;
            size++;
        } else {
            // compare the keys see if key already exists
            while (existing.next() != null) {
                if (existing.getKey().equals(key)) {
                    existing.setValue(value);
                    return;
                }
                existing = existing.next();
            }
            if (existing.getKey().equals(key)) {
                existing.setValue(value);
            } else {
                existing.setNext(node);
                size++;
            }
        }
    }

    public V get(K key) {
        Node bucket = buckets[key.hashCode() % buckets.length];
        while (bucket != null) {
            if (bucket.getKey().equals(key)) {
                return (V) bucket.getValue();
            }
            bucket = bucket.next();
        }
        return null;
    }

    public boolean remove(K key)
    {
        Node bucket = buckets[key.hashCode() % buckets.length];
        if (bucket.next() == null)
        {
            buckets[key.hashCode() % buckets.length] = null;
            return true;
        }

        Node lastBucket;
        while (bucket != null) {
            lastBucket = bucket;
            if (bucket.getKey().equals(key)) {
                lastBucket.setNext(bucket.next());
                return true;
            }
            bucket = bucket.next();
        }

        return false;
    }

}
