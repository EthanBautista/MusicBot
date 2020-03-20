/*
 * Copyright 2018 John Grosh <john.a.grosh@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jagrosh.jmusicbot;

import com.jagrosh.jmusicbot.queue.FairQueue;
import com.jagrosh.jmusicbot.queue.Queueable;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John Grosh (john.a.grosh@gmail.com)
 */
public class FairQueueTest
{
    @Test
    public void differentIdentifierSize()
    {
        FairQueue<Q> queue = new FairQueue<>();
        int size = 100;
        for(int i=0; i<size; i++)
            queue.add(new Q(i));
        assertEquals(queue.size(), size);
    }
    
    @Test
    public void sameIdentifierSize()
    {
        FairQueue<Q> queue = new FairQueue<>();
        int size = 100;
        for(int i=0; i<size; i++)
            queue.add(new Q(0));
        assertEquals(queue.size(), size);
    }
    
    @Test
    public void addTest()
    {
        FairQueue<Q> queue = new FairQueue<>();
        Q expected = new Q(0);
        queue.add(expected);
        
        assertEquals(queue.get(0), expected);
    }
    
    @Test
    public void addAtTest()
    {
        FairQueue<Q> queue = new FairQueue<>();
        
        for(int i=0; i<10; i++)
            queue.add(new Q(0));
        
        Q expected = new Q(0);
        queue.addAt(5, expected);
   
        assertEquals(queue.get(5), expected);
    }
    
    @Test
    public void pullTest()
    {
        FairQueue<Q> queue = new FairQueue<>();
        Q expected = new Q(0);
        queue.add(expected);
        
        for(int i=0; i<10; i++)
            queue.add(new Q(0));
   
        assertEquals(queue.pull(), expected);
    }
    
    @Test
    public void isEmptyTest()
    {
        FairQueue<Q> queue = new FairQueue<>();
        boolean expected = true;
        boolean result = queue.isEmpty();
        assertEquals(result, expected);
    }
    
    @Test
    public void getListTest()
    {
        FairQueue<Q> queue = new FairQueue<>();
        List<Q> list = new ArrayList<>();
        Q item = new Q(0);
        queue.add(item);
        list.add(0, item);
        
        List<Q> result = queue.getList();
        
        assertEquals(result, list);
    }
    
    
    @Test
    public void getTest()
    {
        FairQueue<Q> queue = new FairQueue<>();
        Q item = new Q(0);
        Q expected = new Q(0);
        
        queue.add(item);
        queue.add(expected);
        
        Q result = queue.get(1);
        
        assertEquals(result, expected);
    }
    
    @Test
    public void removeTest() {
        FairQueue<Q> queue = new FairQueue<>();
        FairQueue<Q> expected = queue;
        Q item = new Q(0);
        Q item1 = new Q(0);
        Q item2 = new Q(0);
        
        queue.add(item);
        queue.add(item1);
        queue.add(item2);
        
        expected.add(item1);
        expected.add(item2);
        
        Q result = queue.remove(0);
        
        assertEquals(queue, expected);
        assertEquals(result, item);
    }
    
    @Test
    public void removeAllTest() {
        FairQueue<Q> queue = new FairQueue<>();

        Q item = new Q(0);
        Q item1 = new Q(0);
        Q item2 = new Q(0);
        
        queue.add(item);
        queue.add(item1);
        queue.add(item2);
        
        
        int expected = 3;
        long identifier = 0;
        int result = queue.removeAll(identifier);
        
        assertEquals(result, expected);
        assertEquals(queue.isEmpty(), true);
    }
    
    @Test
    public void clearTest() {
        FairQueue<Q> queue = new FairQueue<>();

        Q item = new Q(0);
        Q item1 = new Q(0);
        Q item2 = new Q(0);
        
        queue.add(item);
        queue.add(item1);
        queue.add(item2);
    
        queue.clear();

        assertEquals(queue.isEmpty(), true);
    }
    
    @Test
    public void skipTest() {
        FairQueue<Q> queue = new FairQueue<>();
        Q item = new Q(0);      
        
        for(int i=0; i<5; i++)
            queue.add(new Q(0));
        
        queue.add(item);
        
        for(int i=0; i<5; i++)
            queue.add(new Q(0));

        queue.skip(5);
        Q result = queue.get(0);
        
        assertEquals(result, item);

    }
    
    @Test
    public void moveItemTest() {
        FairQueue<Q> queue = new FairQueue<>();
        Q item = new Q(0);
      
        queue.add(item);
        
        for(int i=0; i<10; i++)
            queue.add(new Q(0));
        

        Q result = queue.moveItem(0, 5);
        Q result1 = queue.get(5);
        
        assertEquals(result, item);
        assertEquals(result1, item);

    }
    
    private class Q implements Queueable
    {
        private final long identifier;
        
        private Q(long identifier)
        {
            this.identifier = identifier;
        }
        
        @Override
        public long getIdentifier()
        {
            return identifier;
        }
    }
}
