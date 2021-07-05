package propublica.datadesign;

import org.junit.Assert;

import propublica.datadesign.SuspectProfile.Race;
import propublica.datadesign.SuspectProfile.RiskLevel;
import propublica.datadesign.SuspectProfile.Sex;

/**
* The main driver program for Lab 1.
*
* This program serves as a preparation to replicate ProPublica’s analysis 
* shown in the table rediction Fails Differently for Black Defendants. It 
* contains testing methods to check constructors in the class SuspectProfile, 
* which store variables that are criteria to categorize criminals.
*
* @author: Linh Tran, Yen Nguyen
* @version: February 28, 2021
*/


public class Main {
	// this should become the "Prediction Fails Differently for Black Defendants" table
	public static PropublicaDataTable racialBiasTable = null;
	
    public static void main( String[] args ) {
        // TODO: eventually set racialBiasTable to a new PropublicaDataTable with correct values.
    	
    	try {
		testConstructor();
    	} catch (Exception IllegalArgumentException){
		System.out.println("Invalid constructor");
    	}
    	
    	try {
		testBools();
    	} catch (Exception IllegalArgumentException){
		System.out.println("Invalid user input");
    	}
    	
    	try {
		testStringArrConstructor();
    	} catch (Exception IllegalArgumentException) {
		System.out.println("Invalid input in constructor array");
    	}
    	
    	
    	// Test equals method after overriding
        SuspectProfile suspect = new SuspectProfile ("Female", "Hispanic", "F", "Aggravated Assault w/Firearm", "1", "Low", "0", "", "");
    	String[] other = new String[] {"Male", "Other", "F", "Aggravated Assault w/Firearm", "1", "Low", "0", "", ""};
    	SuspectProfile otherSuspect = new SuspectProfile(other);
    	
        SuspectProfile suspect1 = new SuspectProfile ("Male", "Other", "F", "Aggravated Assault w/Firearm", "1", "Low", "0", "", "");
    	String[] other1 = new String[] {"Male", "Other", "F", "Aggravated Assault w/Firearm", "1", "Low", "0", "", ""};
    	SuspectProfile otherSuspect1 = new SuspectProfile(other1);
 
    	testEqualObject(suspect, otherSuspect); // should return false
    	testEqualObject(suspect1, otherSuspect1); // should return true
    }
    

    // Test for the first constructor
    public static void testConstructor() {
    SuspectProfile suspect = new SuspectProfile ("Male", "Hispanic", "F", "Felony Battery w/Prior Convict",
    		"8", "High", "0", "", "");
    
    // test the getter method for the sex field
    Assert.assertEquals(Sex.MALE, suspect.getSex());
    
    // test the getter method for the race field
    Assert.assertEquals(Race.HISPANIC, suspect.getRace());
    
    // test the getter method for the c_chargeDegree field
    Assert.assertEquals("F", suspect.getC_chargeDegree());
    
    // test the getter method for the c_chargeDesc field
    Assert.assertEquals("Felony Battery w/Prior Convict", suspect.getC_chargeDesc());
    
    // test the getter method for the decileScore field
    Assert.assertEquals(8, suspect.getDecileScore());
    
    // test the getter method for the riskLevel field
    Assert.assertEquals(RiskLevel.HIGH, suspect.getRiskLevel());
    
    // test the getter method for the two_year_recid field
    Assert.assertEquals(0, suspect.getTwoYearRecid());
    
    // test the getter method for the r_chargeDegree field
	Assert.assertEquals("", suspect.getR_chargeDegree());
	
	// test the getter method for the r_chargeDesc field
	Assert.assertEquals("", suspect.getR_chargeDesc());
    }
    
    
    // Test for 5 methods which 
    public static void testBools() {
        SuspectProfile suspect = new SuspectProfile ("Male", "African American", "F", "Felony Battery w/Prior Convict",
        		"8", "High", "0", "", "");
    	
    	// test the method isWhite
    	Assert.assertEquals(false, suspect.isWhite());
    	
    	// test the method isBlack
    	Assert.assertEquals(true, suspect.isBlack());
    	
    	// test the method hasReoffended
    	Assert.assertEquals(false, suspect.hasReoffended());
    	
    	// test the method isHighRisk
    	Assert.assertEquals(true, suspect.isHighRisk());
    	
    	// test the method isLowRisk
    	Assert.assertEquals(false, suspect.isLowRisk());
    }
    
    
    public static void testStringArrConstructor() {
    	
    	// test for valid values: With all valid input, it will return nothing
    	String[] trueProfile = new String[] {"Male", "Other", "F", "Aggravated Assault w/Firearm", "1", "Low", "0", "", ""};
    	SuspectProfile trueSuspect = new SuspectProfile(trueProfile);
    	
    	// test for invalid values: With some invalid inputs, it will throw exception
    	SuspectProfile falseSuspect = new SuspectProfile(new String[]{"Invalid", "", "F1234", "Very invalid", "1", "Low", "invalid", "", ""});
    	
    	//Additional tests for getter method of each field 
    	Assert.assertEquals(Sex.MALE, trueSuspect.getSex());
    	Assert.assertEquals(Race.OTHER, trueSuspect.getRace());
    	Assert.assertEquals("F", trueSuspect.getC_chargeDegree());
    	Assert.assertEquals("Aggravated Assault w/Firearm", trueSuspect.getC_chargeDesc());
    	Assert.assertEquals(1, trueSuspect.getDecileScore());
    	Assert.assertEquals(RiskLevel.LOW, trueSuspect.getRiskLevel());
    	Assert.assertEquals(0, trueSuspect.getTwoYearRecid());
    	Assert.assertEquals("", trueSuspect.getR_chargeDegree());
    	Assert.assertEquals("", trueSuspect.getR_chargeDesc());
    	
    }
    
    public static void testEqualObject(SuspectProfile suspect1, SuspectProfile suspect2) {
    	System.out.println("2 suspects are the same? " + suspect1.equals(suspect2));
    }
}
