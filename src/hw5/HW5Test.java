package hw5;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class HW5Test {
	
	//@Rule
    //public Timeout globalTimeout = Timeout.seconds(5);
	
	
	@Test
	public void test05NewQueue() {
		StringQueue q = new StringQueue();
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
	}
	
	@Test
	public void test05AddSingleItem() {
		StringQueue q = new StringQueue();
		q.enqueue("apple");
		assertFalse(q.isEmpty());
		assertEquals(1, q.size());
	}
	
	@Test
	public void test10RemoveSingleItem() {
		StringQueue q = new StringQueue();
		q.enqueue("box");
		assertFalse(q.isEmpty());
		assertEquals(1, q.size());
		assertEquals("box", q.dequeue());
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
	}
	
	@Test
	public void test10EnterRemoveEnterRemove() {
		StringQueue q = new StringQueue();
		q.enqueue("box");
		assertFalse(q.isEmpty());
		assertEquals(1, q.size());
		assertEquals("box", q.dequeue());
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
		q.enqueue("apple");
		assertFalse(q.isEmpty());
		assertEquals(1, q.size());
		assertEquals("apple", q.dequeue());
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
	}
	
	@Test
	public void test10EnterEnterRemoveRemove() {
		StringQueue q = new StringQueue();
		q.enqueue("box");
		assertFalse(q.isEmpty());
		assertEquals(1, q.size());
		q.enqueue("apple");
		assertFalse(q.isEmpty());
		assertEquals(2, q.size());
		assertEquals("box", q.dequeue());
		assertFalse(q.isEmpty());
		assertEquals(1, q.size());
		assertEquals("apple", q.dequeue());
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
	}
	
	@Test
	public void test10EnqueuesThenDequeues() {
		String[] array = {"box", "apple", "dog", "zoo", "car", "boat"};
		StringQueue q = new StringQueue();
		
		for (int i = 0; i < array.length; i++) {
			q.enqueue(array[i]);
			assertEquals(i+1, q.size());
			assertFalse(q.isEmpty());
		}
		
		for (int i = 0; i < array.length; i++) {
			assertFalse(q.isEmpty());
			assertEquals(array[i], q.dequeue());
			assertEquals(array.length - 1 - i, q.size());
		}
		
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
	}
	
	@Test
	public void test10MixedOperations() {
		StringQueue q = new StringQueue();
		q.enqueue("car");
		q.enqueue("apple");
		q.dequeue();
		q.dequeue();
		q.enqueue("zoo");
		assertEquals(1, q.size());
		q.enqueue("stop");
		assertEquals(2, q.size());
		q.enqueue("go");
		assertEquals(3, q.size());
		assertEquals("zoo", q.dequeue());
		assertEquals(2, q.size());
		q.enqueue("book");
		assertEquals(3, q.size());
		assertEquals("stop", q.dequeue());
		assertEquals(2, q.size());
		assertEquals("go", q.dequeue());
		assertEquals(1, q.size());
		q.enqueue("fox");
		assertEquals(2, q.size());
		assertEquals("book", q.dequeue());
		assertEquals(1, q.size());
		assertEquals("fox", q.dequeue());
		assertEquals(0, q.size());
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void test10MultipleQueues() {
		StringQueue q1 = new StringQueue();
		StringQueue q2 = new StringQueue();
		q1.enqueue("apple");
		assertTrue(q2.isEmpty());
		assertEquals(0, q2.size());
		
		q1.enqueue("box");
		assertTrue(q2.isEmpty());
		assertEquals(0, q2.size());
		
		q2.enqueue("zoo");
		assertEquals(2, q1.size());
		assertEquals(1, q2.size());
		q2.enqueue("yellow");
		assertEquals(2, q1.size());
		assertEquals(2, q2.size());
		
		assertEquals("apple", q1.dequeue());
		assertEquals(1, q1.size());
		assertEquals(2, q2.size());
		
		assertEquals("zoo", q2.dequeue());
		assertEquals(1, q1.size());
		assertEquals(1, q2.size());
		
		assertEquals("yellow", q2.dequeue());
		assertEquals(1, q1.size());
		assertEquals(0, q2.size());
		assertTrue(q2.isEmpty());
		
		assertEquals("box", q1.dequeue());
		assertEquals(0, q1.size());
		assertEquals(0, q2.size());
		assertTrue(q1.isEmpty());
		assertTrue(q2.isEmpty());
	}
	
	@Test
	public void test10Underflow() {
		StringQueue q1 = new StringQueue();
		StringQueue q2 = new StringQueue();
		try {
			q1.dequeue();
			fail("Missed Exception");
		} catch(NoSuchElementException e) {
		}
		q1.enqueue("hello");
		try {
			q2.dequeue();
			fail("Missed Exception");
		} catch (NoSuchElementException e) {
		}
		assertEquals("hello", q1.dequeue());
		try {
			q1.dequeue();
			fail("Missed Exception");
		} catch(NoSuchElementException e) {
		}
		try {
			q2.dequeue();
			fail("Missed Exception");
		} catch (NoSuchElementException e) {
		}
	}
	
	@Test
	public void test20Timing() {
		final int SIZE = 100000;
		String[] data = new String[SIZE];
		for(int i = 0; i < SIZE; i++)
			data[i] = "" + i;
		StringQueue q = new StringQueue();
		for(int i = 0; i < SIZE; i++)
			q.enqueue(data[i]);
		long start = System.currentTimeMillis();
		for(int i = 0; i < SIZE; i++) {
			String s = q.dequeue();
			q.enqueue(s);
		}
		long finish = System.currentTimeMillis();
		long small = finish - start;
		
		q = new StringQueue();
		for(int i = 0; i < SIZE; i++)
			q.enqueue(data[i]);
		for(int i = 0; i < SIZE; i++)
			q.enqueue(data[i]);
		start = System.currentTimeMillis();
		for(int i = 0; i < SIZE; i++) {
			String s = q.dequeue();
			q.enqueue(s);
		}
		finish = System.currentTimeMillis();
		long big = finish - start;
		assertTrue(big < 1.5 * small);			
	}
}
