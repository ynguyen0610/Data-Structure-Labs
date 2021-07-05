package prelab;

/*
 * You should use this package for Pre-Lab 2 and Pre-Lab 3 Exercises.
 * Make sure you don't have errors in this package, since it will cause issues
 * with the autograder if there are any compilation issues.
 */

import org.junit.Assert;

import prelab.StudentInfo.Standing;

public class Main {
	public static void main(String[] args) {
		testConstructors();
	
	} 
	
	public static void testConstructors() {
		StudentInfo student1 = new StudentInfo("Will",20, Standing.SOPHOMORE,"Barclay",true,"Michael Elias");
		StudentInfo student2 = new StudentInfo("Will","20","Sophomore","Barclay", "Yes", "Michael Elias");
		Assert.assertEquals(student1.getName(),student2.getName());
		Assert.assertEquals(student1.getAge(),student2.getAge());
//		Assert.assertFalse((student1).equals(student2));
		Assert.assertTrue(student1.getName() == student2.getName());
//		Assert.assertTrue(student1.getAge() == student2.getAge());
	}

}
