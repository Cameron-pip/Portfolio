package hw4;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class HW4Test {

	//@Rule
	//public Timeout globalTimeout = Timeout.seconds(5);

	@Test
	public void test05AddElementToEmpty() {
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();

		assertTrue(s1.addElement(1));
		assertEquals(1, s1.size());
		assertEquals(0, s2.size());
		assertTrue(s1.contains(1));
		assertFalse(s2.contains(1));

		assertTrue(s2.addElement(1));
		assertEquals(1, s1.size());
		assertEquals(1, s2.size());
		assertTrue(s1.contains(1));
		assertTrue(s2.contains(1));
	}

	@Test
	public void test05AddElementToNonEmpty() {
		// s1 = {1, -1, 0};
		// s2 = {-4, 2, 9};
		LinkedIntSet s1 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		LinkedIntSet s2 = new LinkedIntSet();
		s2.addElement(-4);
		s2.addElement(2);
		s2.addElement(9);

		// Check s1
		assertTrue(s1.addElement(-5));
		assertEquals(4, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(0));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(-5));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(9));
		assertFalse(s1.contains(-4));

		// Check s2
		assertEquals(3, s2.size());
		assertTrue(s2.contains(-4));
		assertTrue(s2.contains(2));
		assertTrue(s2.contains(9));
		assertFalse(s2.contains(-5));
		assertFalse(s2.contains(-1));
		assertFalse(s2.contains(-0));
		assertFalse(s2.contains(1));
	}

	@Test
	public void test05AddElementDuplicate() {
		// s1 = {9, -3, 2, 1, 4};
		LinkedIntSet s1 = new LinkedIntSet();
		assertTrue(s1.addElement(9));
		assertTrue(s1.addElement(-3));
		assertTrue(s1.addElement(2));
		assertTrue(s1.addElement(1));
		assertTrue(s1.addElement(4));
		assertEquals(5, s1.size());

		// try adding 9
		assertFalse(s1.addElement(9));
		assertTrue(s1.contains(9));
		assertTrue(s1.contains(-3));
		assertTrue(s1.contains(2));
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(4));
		assertEquals(5, s1.size());

		// try adding 4
		assertFalse(s1.addElement(4));
		assertTrue(s1.contains(9));
		assertTrue(s1.contains(-3));
		assertTrue(s1.contains(2));
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(4));
		assertEquals(5, s1.size());

		// try adding 2
		assertFalse(s1.addElement(2));
		assertTrue(s1.contains(9));
		assertTrue(s1.contains(-3));
		assertTrue(s1.contains(2));
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(4));
		assertEquals(5, s1.size());
	}

	@Test
	public void test05removeEmpty() {
		LinkedIntSet s1 = new LinkedIntSet();
		assertFalse(s1.removeElement(-4));
		assertEquals(0, s1.size());
		assertFalse(s1.removeElement(1));
		assertEquals(0, s1.size());
		assertFalse(s1.removeElement(0));
		assertEquals(0, s1.size());
	}

	@Test
	public void test05removeSingle() {
		// s1 = {5}
		// s2 = {5}
		LinkedIntSet s1 = new LinkedIntSet();
		s1.addElement(5);
		LinkedIntSet s2 = new LinkedIntSet();
		s2.addElement(5);
		assertTrue(s1.removeElement(5));
		assertEquals(0, s1.size());
		assertEquals(1, s2.size());
		assertFalse(s1.contains(5));
		assertTrue(s2.contains(5));

		assertTrue(s2.removeElement(5));
		assertEquals(0, s1.size());
		assertEquals(0, s2.size());
		assertFalse(s1.contains(5));
		assertFalse(s2.contains(5));
	}

	@Test
	public void test05removeMultiple() {
		// s1 = {1, 3, 5}
		// s2 = {2, 3, 4}
		LinkedIntSet s1 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(3);
		s1.addElement(5);
		LinkedIntSet s2 = new LinkedIntSet();
		s2.addElement(2);
		s2.addElement(3);
		s2.addElement(4);

		assertTrue(s2.removeElement(3));
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertFalse(s1.contains(2));
		assertTrue(s1.contains(3));
		assertFalse(s1.contains(4));
		assertTrue(s1.contains(5));
		assertEquals(2, s2.size());
		assertFalse(s2.contains(1));
		assertTrue(s2.contains(2));
		assertFalse(s2.contains(3));
		assertTrue(s2.contains(4));
		assertFalse(s2.contains(5));

		assertTrue(s1.removeElement(5));
		assertEquals(2, s1.size());
		assertTrue(s1.contains(1));
		assertFalse(s1.contains(2));
		assertTrue(s1.contains(3));
		assertFalse(s1.contains(4));
		assertFalse(s1.contains(5));
		assertFalse(s2.contains(1));
		assertTrue(s2.contains(2));
		assertFalse(s2.contains(3));
		assertTrue(s2.contains(4));
		assertFalse(s2.contains(5));

		assertTrue(s1.removeElement(3));
		assertEquals(1, s1.size());
		assertTrue(s1.contains(1));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(3));
		assertFalse(s1.contains(4));
		assertFalse(s1.contains(5));
		assertFalse(s2.contains(1));
		assertTrue(s2.contains(2));
		assertFalse(s2.contains(3));
		assertTrue(s2.contains(4));
		assertFalse(s2.contains(5));

		assertTrue(s1.removeElement(1));
		assertEquals(0, s1.size());
		assertFalse(s1.contains(1));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(3));
		assertFalse(s1.contains(4));
		assertFalse(s1.contains(5));
		assertFalse(s2.contains(1));
		assertTrue(s2.contains(2));
		assertFalse(s2.contains(3));
		assertTrue(s2.contains(4));
		assertFalse(s2.contains(5));
	}

	@Test
	public void test05removeMissing() {
		// s1 = {1, 3, 5}
		// s2 = {2, 4, 6}
		LinkedIntSet s1 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(3);
		s1.addElement(5);
		LinkedIntSet s2 = new LinkedIntSet();
		s2.addElement(2);
		s2.addElement(4);
		s2.addElement(6);
		
		assertFalse(s2.removeElement(1));
		assertFalse(s1.removeElement(2));
		assertFalse(s2.removeElement(3));
		assertFalse(s1.removeElement(4));
		assertFalse(s2.removeElement(5));
		assertFalse(s1.removeElement(6));
		
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertFalse(s1.contains(2));
		assertTrue(s1.contains(3));
		assertFalse(s1.contains(4));
		assertTrue(s1.contains(5));
		assertFalse(s1.contains(6));
		
		assertEquals(3, s2.size());
		assertFalse(s2.contains(1));
		assertTrue(s2.contains(2));
		assertFalse(s2.contains(3));
		assertTrue(s2.contains(4));
		assertFalse(s2.contains(5));
		assertTrue(s2.contains(6));
	}

	@Test
	public void tes05tUnionEmpty() {
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		s1.union(s2);
		assertEquals(0, s1.size());
		assertEquals(0, s2.size());
	}

	@Test
	public void test05UnionNoDuplicates() {
		// s1 = {1, -1, 0};
		// s2 = {-4, 2, 9};
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(-4);
		s2.addElement(9);
		s2.addElement(2);
		s2.union(s1);

		assertEquals(6, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(-1));
		assertTrue(s2.contains(0));
		assertTrue(s2.contains(-4));
		assertTrue(s2.contains(2));
		assertTrue(s2.contains(9));

		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertFalse(s1.contains(-4));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(9));

		// s1 = {1, -1, 0};
		// s2 = {-4, 2, 9};
		s1 = new LinkedIntSet();
		s2 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(-4);
		s2.addElement(9);
		s2.addElement(2);
		s1.union(s2);

		assertEquals(6, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertTrue(s1.contains(-4));
		assertTrue(s1.contains(2));
		assertTrue(s1.contains(9));

		assertEquals(3, s2.size());
		assertFalse(s2.contains(1));
		assertFalse(s2.contains(-1));
		assertFalse(s2.contains(0));
		assertTrue(s2.contains(-4));
		assertTrue(s2.contains(2));
		assertTrue(s2.contains(9));
	}

	@Test
	public void test05UnionSomeDuplicates() {
		// s1 = {1, -1, 0};
		// s2 = {0, 2, 1};
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(0);
		s2.addElement(2);
		s2.addElement(1);

		s1.union(s2);
		assertEquals(4, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertTrue(s1.contains(2));

		assertEquals(3, s2.size());
		assertTrue(s2.contains(1));
		assertFalse(s2.contains(-1));
		assertTrue(s2.contains(0));
		assertTrue(s2.contains(2));
	}

	@Test
	public void test05UnionEqualSets() {
		// s1 = {1, -1, 0};
		// s1 = {1, -1, 0};
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(1);
		s2.addElement(-1);
		s2.addElement(0);

		s1.union(s2);
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertEquals(3, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(-1));
		assertTrue(s2.contains(0));

		s2.union(s1);
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertEquals(3, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(-1));
		assertTrue(s2.contains(0));
	}

	@Test
	public void test05IntersectEmpty() {
		// s1 = {}
		// s2 = {}
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();

		s1.intersect(s2);
		assertEquals(0, s1.size());
		assertEquals(0, s2.size());

		s2.intersect(s1);
		assertEquals(0, s1.size());
		assertEquals(0, s2.size());
	}

	@Test
	public void test05IntersectNoDuplicates() {
		// s1 = {1, -1, 0};
		// s2 = {-4, 2, 9};
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(-4);
		s2.addElement(9);
		s2.addElement(2);

		s1.intersect(s2);
		assertEquals(0, s1.size());
		assertFalse(s1.contains(1));
		assertFalse(s1.contains(-1));
		assertFalse(s1.contains(0));
		assertFalse(s1.contains(-4));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(9));

		assertEquals(3, s2.size());
		assertFalse(s2.contains(1));
		assertFalse(s2.contains(-1));
		assertFalse(s2.contains(0));
		assertTrue(s2.contains(-4));
		assertTrue(s2.contains(2));
		assertTrue(s2.contains(9));

		// s1 = {1, -1, 0};
		// s2 = {-4, 2, 9};
		s1 = new LinkedIntSet();
		s2 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(-4);
		s2.addElement(9);
		s2.addElement(2);

		s2.intersect(s1);
		assertEquals(0, s2.size());
		assertFalse(s2.contains(1));
		assertFalse(s2.contains(-1));
		assertFalse(s2.contains(0));
		assertFalse(s2.contains(-4));
		assertFalse(s2.contains(2));
		assertFalse(s2.contains(9));

		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertFalse(s1.contains(-4));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(9));
	}

	@Test
	public void test05IntersectSomeDuplicates() {
		// s1= { 1, -1, 0 };
		// s2 = { 0, 2, 1 };
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(0);
		s2.addElement(2);
		s2.addElement(1);

		s1.intersect(s2);
		assertEquals(2, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(0));
		assertFalse(s1.contains(-1));
		assertFalse(s1.contains(2));

		assertEquals(3, s2.size());
		assertFalse(s2.contains(-1));
		assertTrue(s2.contains(0));
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(2));

		// s1= { 1, -1, 0 };
		// s2 = { 0, 2, 1 };
		s1 = new LinkedIntSet();
		s2 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(0);
		s2.addElement(2);
		s2.addElement(1);

		s2.intersect(s1);
		assertEquals(2, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(0));
		assertFalse(s2.contains(-1));
		assertFalse(s2.contains(2));

		assertEquals(3, s1.size());
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertTrue(s1.contains(1));
		assertFalse(s1.contains(2));
	}

	@Test
	public void test05IntersectEqualSets() {
		// s1 = { 1, -1, 0 };
		// s2 = { 1, -1, 0 };
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(-1);
		s2.addElement(0);
		s2.addElement(1);

		s1.intersect(s2);
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));

		assertEquals(3, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(-1));
		assertTrue(s2.contains(0));

		s2.intersect(s1);
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));

		assertEquals(3, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(-1));
		assertTrue(s2.contains(0));
	}

	@Test
	public void test05EqualsEmpty() {
		// s1 = {};
		// s2 = { 5 };
		// s3 = {};
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		LinkedIntSet s3 = new LinkedIntSet();
		s2.addElement(5);
		assertEquals(s1, s3);
		assertNotEquals(s1, s2);
		assertNotEquals(s3, s2);
	}

	@Test
	public void test05EqualsSingleElement() {
		// s1 = s2 = { 5 };
		// s3 = s4 = { 5, 6 };
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		LinkedIntSet s3 = new LinkedIntSet();
		LinkedIntSet s4 = new LinkedIntSet();
		s1.addElement(5);
		s2.addElement(5);
		s3.addElement(5);
		s4.addElement(5);
		s3.addElement(6);
		s4.addElement(6);
		assertEquals(s1, s2);
		assertEquals(s2, s1);
		assertNotEquals(s1, s3);
		assertNotEquals(s3, s1);
		assertNotEquals(s1, s4);
		assertNotEquals(s4, s1);
		assertNotEquals(s2, s3);
		assertNotEquals(s3, s2);
		assertNotEquals(s4, s2);
		assertNotEquals(s2, s4);
		assertEquals(s4, s3);
		assertEquals(s3, s4);
	}

	@Test
	public void test05EqualsMultipleElements() {
		// s1 = { 4, 9, 2, 1 };
		// s2 = { 9, 2, 1, 4 };
		// s3 = { 4, 9 };
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		LinkedIntSet s3 = new LinkedIntSet();
		s1.addElement(4);
		s1.addElement(9);
		s1.addElement(2);
		s1.addElement(1);
		s2.addElement(9);
		s2.addElement(2);
		s2.addElement(1);
		s2.addElement(4);
		s3.addElement(4);
		s3.addElement(9);

		assertEquals(s1, s2);
		assertEquals(s2, s1);
		assertNotEquals(s1, s3);
		assertNotEquals(s2, s3);
		assertNotEquals(s3, s1);
		assertNotEquals(s3, s2);
	}

	@Test
	public void test05EqualsAddingElements() {
		// s1 = s2 = {1, 3, 5};
		LinkedIntSet s1 = new LinkedIntSet();
		LinkedIntSet s2 = new LinkedIntSet();
		s1.addElement(1);
		s1.addElement(3);
		s1.addElement(5);
		s2.addElement(1);
		s2.addElement(3);
		s2.addElement(5);

		assertEquals(s1, s2);
		assertEquals(s2, s1);

		s1.addElement(4);
		assertNotEquals(s1, s2);
		assertNotEquals(s2, s1);
		s2.addElement(8);
		assertNotEquals(s1, s2);
		assertNotEquals(s2, s1);
		s2.addElement(4);
		assertNotEquals(s1, s2);
		assertNotEquals(s2, s1);
		s1.addElement(8);
		assertEquals(s1, s2);
		assertEquals(s2, s1);
	}
	
	@Test
	public void test05AddManyElements() {
		LinkedIntSet s = new LinkedIntSet();
		for(int i = 0; i < 5000; i++)
			assertTrue(s.addElement(i*2));
		
		assertEquals(5000, s.size());
		
		for(int i = 0; i < 5000; i++) {
			assertTrue(s.contains(i*2));
			assertFalse(s.contains(i*2+1));
		}
	}
}