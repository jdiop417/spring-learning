package org.learning.spring.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

public class Demo {

    @Test
    public void test() {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 5, 0.01D);
        filter.put(1);
        filter.put(2);
        filter.put(3);

        Assert.assertFalse(filter.mightContain(4));

    }

}
