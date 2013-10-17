package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import daten.Person;
import daten.Student;

public class StudentTest {

	@Before
	public void setUp() throws Exception {
	}

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	/*@Test
	public void testToString() {
		Date d = new Date(88, 0, 18);
		Student student = new Student("KlausWer", "UngerWer", false, d);
		
		student.toString();
		
	}*/
	@Test//excpected Exception...
	public void testCompare() {
		Date dEins = new Date(87, 1, 17);
		Student studentEins = new Student("Fenster", "Bett", false, dEins);
		Student studentZwei = new Student("Fenster", "Tisch", false, dEins);
		
		if(studentEins.compareTo(studentZwei)==0){
			fail("Last Name failed!");
		}
	}
	@Test
	public void testCompareZero() {
		Student studentTwo = new Student("Paul", "Raul", false, new Date(1998,2,3));
		Student studentThree = new Student("Paul", "Raul", false, new Date(1998,2,5));
		
		if(studentTwo.compareTo(studentThree)>0){
			fail("Date False");
		}
		
	}
}
