package com.example.user.testapf.data_structures.hashmap;

import android.support.annotation.Nullable;

import java.util.Arrays;

public class MyMapImpel<T, K>
{
   public int len = 3;
   public Object[][] array;
   public int size = 0;

    class KeyValueObject
    {
        T key;
        K target;
    }

    public MyMapImpel()
    {
        array = new Object[len][len];
    }

    public MyMapImpel(int len)
    {
        this.len = len;
        array = new Object[len][len];
    }

    @Nullable
    public K get(@Nullable Object key)
    {
        int k = 0;
        while (true)
        {
            Object[] a = array[(key.hashCode() % len) + k];

            for (int i = 0; a.length > i; i++)
            {
                if (((KeyValueObject) a[i]).key.equals(key))
                {
                    return ((KeyValueObject) (array[key.hashCode() % len][i])).target;
                }
            }

            k++;
            if ((key.hashCode() % len) + k == len)
                k = -1*(key.hashCode() % len);
        }
    }

    int yyy = 0;

    public K put(T key, K target)
    {
        Object[] a;
        {
            if (size == len*len)
            {

                Object[][] tempArray = Arrays.copyOf(array, this.len);
                this.len = len << 1;
                array = new Object[len][len];
                size = 0;
                yyy = 0;

                for (int i = 0 ; tempArray.length > i ; i++)
                {
                    for (int k = 0 ; tempArray[i].length > k ; k++)
                    {
                        if (tempArray[i][k] != null)
                        {
                            put(((KeyValueObject) tempArray[i][k]).key, ((KeyValueObject) tempArray[i][k]).target);
                        }
                    }
                }
            }

            till:
            while (true)
            {
                a = array[(key.hashCode() % len) + yyy];

                for (int i = 0 ; a.length > i ; i++)
                {
                    if (a[i] == null)
                    {
                        break till;
                    }

                    if (((KeyValueObject) a[i]).key.equals(key))
                    {
                        ((KeyValueObject) a[i]).target = target;
                        return target;
                    }
                }

                yyy++;
                if ((key.hashCode() % len) + yyy == len)
                    yyy = -1*(key.hashCode() % len);


            }

            for (int i = 0 ; a.length > i ; i++)
            {
                if (a[i] == null)
                {
                    KeyValueObject aaa = new KeyValueObject();
                    aaa.key = key;
                    aaa.target = target;

                    array[((key.hashCode() % len) + yyy) % len ][i] = aaa;
                    size++;
                    break;
                }
            }
        }

        return target;
    }

}
