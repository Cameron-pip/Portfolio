package hw7;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class HW7Test {
	
	//@Rule
    //public Timeout globalTimeout = Timeout.seconds(1);
	
	@Test
	public void test05indexOfEmpty() {
		IntList list = new IntList();
		for(int i = 0; i < 20; i++)
			assertEquals(-1, list.indexOf(i));
	}
	
	@Test
	public void test05indexOfSingleton() {
		IntList list = new IntList();
		list.insertAtFront(7);
		for(int i = 6; i > 0; i--)
			assertEquals(-1, list.indexOf(i));
		assertEquals(0, list.indexOf(7));
		assertEquals(-1, list.indexOf(0));		
	}
	
	@Test
	public void test05indexOfLarge() {
		int[] data = {21, 43, 52, 0, -1};
		IntList list = new IntList(data);
		assertEquals(-1, list.indexOf(25));
		assertEquals(2, list.indexOf(52));
		assertEquals(1, list.indexOf(43));
		assertEquals(-1, list.indexOf(2));
		assertEquals(0, list.indexOf(21));
		assertEquals(4, list.indexOf(-1));
		assertEquals(-1, list.indexOf(100));
		assertEquals(3, list.indexOf(0));		
	}
	
	@Test
	public void test05indexOfREmpty() {
		IntList list = new IntList();
		for(int i = 0; i < 20; i++)
			assertEquals(-1, list.indexOfR(i));
	}
	
	@Test
	public void test05indexOfRSingleton() {
		IntList list = new IntList();
		list.insertAtFront(7);
		for(int i = 6; i > 0; i--)
			assertEquals(-1, list.indexOfR(i));
		assertEquals(0, list.indexOfR(7));
		assertEquals(-1, list.indexOfR(0));		
	}
	
	
	
	@Test
	public void test05indexOfRLarge() {
		int[] data = {21, 43, 52, 0, -1};
		IntList list = new IntList(data);
		assertEquals(-1, list.indexOfR(25));
		assertEquals(2, list.indexOfR(52));
		assertEquals(1, list.indexOfR(43));
		assertEquals(-1, list.indexOfR(2));
		assertEquals(0, list.indexOfR(21));
		assertEquals(4, list.indexOfR(-1));
		assertEquals(-1, list.indexOfR(100));
		assertEquals(3, list.indexOfR(0));		
	}
	
	@Test
	public void test05insertAtBackEmpty() {
		IntList list = new IntList();
		list.insertAtBack(4);
		assertFalse(list.contains(-4));
		assertFalse(list.contains(0));
		assertTrue(list.contains(4));
		assertFalse(list.contains(1));
		assertEquals("4", list.toString());
	}
	
	@Test
	public void test05insertAtBackSingleton() {
		IntList list = new IntList();
		list.insertAtFront(4);
		list.insertAtBack(1);
		assertFalse(list.contains(-4));
		assertFalse(list.contains(0));
		assertTrue(list.contains(4));
		assertTrue(list.contains(1));
		assertEquals("4, 1", list.toString());
	}
	
	@Test
	public void test05insertAtBackLarge() {
		int[] data = {4, -1, 2};
		IntList list = new IntList(data);
		list.insertAtBack(7);
		assertEquals("4, -1, 2, 7", list.toString());
		list.insertAtBack(-1);
		assertEquals("4, -1, 2, 7, -1", list.toString());
		list.insertAtBack(0);
		assertEquals("4, -1, 2, 7, -1, 0", list.toString());
	}
	
	@Test
	public void test05insertAtBackREmpty() {
		IntList list = new IntList();
		list.insertAtBackR(4);
		assertFalse(list.contains(-4));
		assertFalse(list.contains(0));
		assertTrue(list.contains(4));
		assertFalse(list.contains(1));
		assertEquals("4", list.toString());
	}
	
	@Test
	public void test05insertAtBackRSingleton() {
		IntList list = new IntList();
		list.insertAtFront(4);
		list.insertAtBackR(1);
		assertFalse(list.contains(-4));
		assertFalse(list.contains(0));
		assertTrue(list.contains(4));
		assertTrue(list.contains(1));
		assertEquals("4, 1", list.toString());
	}
	
	@Test
	public void test05insertAtBackRLarge() {
		int[] data = {4, -1, 2};
		IntList list = new IntList(data);
		list.insertAtBackR(7);
		assertEquals("4, -1, 2, 7", list.toString());
		list.insertAtBackR(-1);
		assertEquals("4, -1, 2, 7, -1", list.toString());
		list.insertAtBackR(0);
		assertEquals("4, -1, 2, 7, -1, 0", list.toString());
	}
	
	
	@Test
	public void test05deleteFromPositionMissing() {
		IntList list0 = new IntList();
		int[] data1 = {4};
		IntList list1 = new IntList(data1);
		int[] data5 = {4, 2, 1, 9, 0};
		IntList list5 = new IntList(data5);
		try {
			list0.deleteFromPosition(-1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list0.deleteFromPosition(0);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list0.deleteFromPosition(1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list1.deleteFromPosition(-1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list1.deleteFromPosition(1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list1.deleteFromPosition(2);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list5.deleteFromPosition(-1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list5.deleteFromPosition(5);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list5.deleteFromPosition(15);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
	}
	
	@Test
	public void test05deleteFromPositionSingleton() {
		IntList list1 = new IntList();
		IntList list2 = new IntList();
		list1.insertAtFront(3);
		list2.insertAtFront(-2);
		list1.deleteFromPosition(0);
		assertEquals("", list1.toString());
		assertEquals("-2", list2.toString());
		list2.deleteFromPosition(0);
		assertEquals("", list1.toString());
		assertEquals("", list2.toString());
	}
	
	@Test
	public void test05deleteFromPositionLarge() {
		int[] data = {42, 1, 93, -4, 0, 22, 9, 1};
		IntList list1 = new IntList(data);
		IntList list2 = new IntList(data);
		list1.deleteFromPosition(0);
		assertEquals("1, 93, -4, 0, 22, 9, 1", list1.toString());
		assertEquals("42, 1, 93, -4, 0, 22, 9, 1", list2.toString());
		list1.deleteFromPosition(6);
		assertEquals("1, 93, -4, 0, 22, 9", list1.toString());
		assertEquals("42, 1, 93, -4, 0, 22, 9, 1", list2.toString());
		list1.deleteFromPosition(2);
		assertEquals("1, 93, 0, 22, 9", list1.toString());
		assertEquals("42, 1, 93, -4, 0, 22, 9, 1", list2.toString());
		list2.deleteFromPosition(6);
		assertEquals("1, 93, 0, 22, 9", list1.toString());
		assertEquals("42, 1, 93, -4, 0, 22, 1", list2.toString());
	}
	
	
	@Test
	public void test05deleteFromPositionRMissing() {
		IntList list0 = new IntList();
		int[] data1 = {4};
		IntList list1 = new IntList(data1);
		int[] data5 = {4, 2, 1, 9, 0};
		IntList list5 = new IntList(data5);
		try {
			list0.deleteFromPositionR(-1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list0.deleteFromPositionR(0);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list0.deleteFromPositionR(1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list1.deleteFromPositionR(-1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list1.deleteFromPositionR(1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list1.deleteFromPositionR(2);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list5.deleteFromPositionR(-1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list5.deleteFromPositionR(5);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		try {
			list5.deleteFromPositionR(15);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
	}
	
	@Test
	public void test05deleteFromPositionRSingleton() {
		IntList list1 = new IntList();
		IntList list2 = new IntList();
		list1.insertAtFront(3);
		list2.insertAtFront(-2);
		list1.deleteFromPositionR(0);
		assertEquals("", list1.toString());
		assertEquals("-2", list2.toString());
		list2.deleteFromPositionR(0);
		assertEquals("", list1.toString());
		assertEquals("", list2.toString());
	}
	
	@Test
	public void test05deleteFromPositionRLarge() {
		int[] data = {42, 1, 93, -4, 0, 22, 9, 1};
		IntList list1 = new IntList(data);
		IntList list2 = new IntList(data);
		list1.deleteFromPositionR(0);
		assertEquals("1, 93, -4, 0, 22, 9, 1", list1.toString());
		assertEquals("42, 1, 93, -4, 0, 22, 9, 1", list2.toString());
		list1.deleteFromPositionR(6);
		assertEquals("1, 93, -4, 0, 22, 9", list1.toString());
		assertEquals("42, 1, 93, -4, 0, 22, 9, 1", list2.toString());
		list1.deleteFromPositionR(2);
		assertEquals("1, 93, 0, 22, 9", list1.toString());
		assertEquals("42, 1, 93, -4, 0, 22, 9, 1", list2.toString());
		list2.deleteFromPositionR(6);
		assertEquals("1, 93, 0, 22, 9", list1.toString());
		assertEquals("42, 1, 93, -4, 0, 22, 1", list2.toString());
	}
	
	@Test
	public void test05MixedSequence() {
		int[] data = {89, -4, 0, 2, -4, 9};
		IntList list = new IntList(data);
		assertEquals(2, list.indexOf(0));
		list.insertAtBack(0);
		assertEquals(2, list.indexOf(0));
		list.deleteFromPosition(2);
		assertEquals(5, list.indexOf(0));
		try {
			list.deleteFromPosition(10);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		assertEquals(5, list.indexOf(0));
		list.deleteFromPosition(5);
		assertEquals(-1, list.indexOf(0));
	}
	
	@Test
	public void test05MixedSequenceR() {
		int[] data = {89, -4, 0, 2, -4, 9};
		IntList list = new IntList(data);
		assertEquals(2, list.indexOfR(0));
		list.insertAtBackR(0);
		assertEquals(2, list.indexOfR(0));
		list.deleteFromPositionR(2);
		assertEquals(5, list.indexOfR(0));
		try {
			list.deleteFromPositionR(10);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {}
		assertEquals(5, list.indexOfR(0));
		list.deleteFromPositionR(5);
		assertEquals(-1, list.indexOfR(0));
	}
}

