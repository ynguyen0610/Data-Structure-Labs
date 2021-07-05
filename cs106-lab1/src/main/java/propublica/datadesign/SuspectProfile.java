package propublica.datadesign;

public class SuspectProfile {
	
	/*	
	 * @param sex Sex of the individual (Valid values: Female or Male)
	 * @param race Race of the individual (Valid values: African American, Hispanic, Caucasian, Other)
	 * @param c_chargeDegree Charge degree of the individual (Valid values: F or M)
	 * @param c_chargeDesc Description of individual's charge (Valid values: any String)
	 * @param decileScore Decile score of the individual (Valid values: an integer from 1 to 10)
	 * @param RiskLevel Level of risk of the individual (Valid values: Low, Medium, High)  
	 * @param two_year_The recid of the individual (Valid values: either 1 or 0) 
	 * @param r_chargeDesc Description of charge of the individual's recid (Valid values: any String)
	 * @param r_chargeDegree Charge dergee of the individual's recid (Valid values: CO3, F1, F2, F3, F5, F6
	 * 																				F7, M1, M2, MO3)
	 * */
	
	
	private Sex sex;
	private Race race;
	private String c_chargeDegree;
	private String c_chargeDesc;
	private int decileScore;
	private RiskLevel riskLevel;
	private int two_year_recid;
	private String r_chargeDesc;
	private String r_chargeDegree;

	
	public enum Sex{
		FEMALE,
		MALE;
	} 
	
	
	// Convert String suspectSex to type enum Sex
	private static Sex sex (String suspectSex) {
    	switch (suspectSex){ 
    	case "Female":
    		return (Sex.FEMALE);
    	case "Male":
    		return (Sex.MALE);
    	default:
    		throw new IllegalArgumentException("There is no case matched");
    	}
    } 

	
	public enum Race{
		AFRICAN_AMERICAN,
		HISPANIC,
		CAUCASIAN,
		OTHER;
	} 
	
	
	// Convert String suspectRace to type enum Race
	private static Race race (String suspectRace) {
    	switch (suspectRace){ 
    	case "African American":
    		return (Race.AFRICAN_AMERICAN);
    	case "Hispanic":
    		return (Race.HISPANIC);
    	case "Caucasian":
    		return (Race.CAUCASIAN);
    	case "Other":
    		return (Race.OTHER);
    	default:
    		throw new IllegalArgumentException("There is no case matched");
    	}
    } 
	
	
	public enum RiskLevel {
		LOW,
		MEDIUM,
		HIGH;
	}
	
	
	// Convert String suspectRiskLevel to type enum RiskLevel 
	private static RiskLevel riskLevel (String suspectRiskLevel) {
    	switch (suspectRiskLevel){ 
    	case "Low":
    		return (RiskLevel.LOW);
    	case "Medium":
    		return (RiskLevel.MEDIUM);
    	case "High":
    		return (RiskLevel.HIGH);
    	default:
    		throw new IllegalArgumentException("There is no case matched");
    	}
    } 
	
	
	// Constructor 1 that takes in all String parameters 
	public SuspectProfile (String sex, String race, String c_chargeDegree, String c_chargeDesc, 
			String decileScore, String riskLevel, String two_year_recid, String r_chargeDegree,
			String r_chargeDesc) {
		
		// Test validity and initialize field: sex
		if(sex == "Female" || sex == "Male") {
			this.sex = sex(sex); 
		} else {
			throw new IllegalArgumentException("Invalid sex input.");
		}
		
		
		// Test validity and initialize field: race
		if(race == "African American" || race == "Hispanic" || race == "Caucasian" || race == "Other") {
			this.race = race(race);
		} else {
			throw new IllegalArgumentException("Invalid race input.");
		}
		

		// Test validity and initialize field: c_chargeDegree
		if (c_chargeDegree == "F" || c_chargeDegree == "M") {
			this.c_chargeDegree = c_chargeDegree;
		} else {
			throw new IllegalArgumentException("Invalid charge degree input.");
		}
		
		
		// Test validity and initialize field: c_chargeDesc
		if (c_chargeDesc instanceof String) {
			this.c_chargeDesc = c_chargeDesc;
		} else {
			throw new IllegalArgumentException("Invalid charge description input: Charge description must be String");
		}
		
		
		// Test validity and initialize field: decileScore
		if (Integer.parseInt(decileScore) >= 1 && Integer.parseInt(decileScore) <= 10){
			this.decileScore = Integer.parseInt(decileScore);
		} else {
			throw new IllegalArgumentException("Invalid decile score input: Decile score must be in range from 1 to 10");
		}
		
		
		// Test validity and initialize field: riskLevel
		if(riskLevel == "Low" || riskLevel == "Medium" || riskLevel == "High") {
			this.riskLevel = riskLevel(riskLevel);
		} else {
			throw new IllegalArgumentException("Invalid risk level input.");
		}		
		
		
		// Test validity and initialize field: two_year_recid
		if (Integer.parseInt(two_year_recid) == 1 || Integer.parseInt(two_year_recid) == 0){
			this.two_year_recid = Integer.parseInt(two_year_recid);
		} else {
			throw new IllegalArgumentException("Invalid two year recid input: Value must be 0 or 1");
		}
		
		
		// Test validity and initialize field: r_chargeDesc
		if (r_chargeDesc instanceof String) {
			this.r_chargeDesc = r_chargeDesc;
		} else {
			throw new IllegalArgumentException("Invalid charge description input: Charge description must be String");
		}
		
		
		// Test validity and initialize field: r_chargeDegree
		if (r_chargeDegree == "CO3" || r_chargeDegree == "F1" || r_chargeDegree == "F2" || r_chargeDegree == "F3"
				|| r_chargeDegree == "F5" || r_chargeDegree == "F6" || r_chargeDegree == "F7" || r_chargeDegree == "M1"
				|| r_chargeDegree == "M2" || r_chargeDegree == "MO3" || r_chargeDegree == "") {
			this.r_chargeDegree = r_chargeDegree;
		} else {
			throw new IllegalArgumentException("Invalid charge degree input.");
		}
	}

	
	/**
	* Getter method for field sex
	* @return value of sex of the individual
	*/
	public Sex getSex() {
		return sex;
	}


	/**
	 * Setter method for field sex
	 * @param sex  The indivdidual's sex
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}


	/**
	* Getter method for field race
	* @return value of race of the individual
	*/
	public Race getRace() {
		return race;
	}


	/**
	 * Setter method for field race
	 * @param race  The indivdidual's race
	 */
	public void setRace(Race race) {
		this.race = race;
	}
	

	/**
	* Getter method for field c_chargeDegree
	* @return value of c_charge_degree of the individual
	*/
	public String getC_chargeDegree() {
		return c_chargeDegree;
	}


	/**
	 * Setter method for field c_chargeDegree
	 * @param c_chargeDegree  The indivdidual's c_charge_degree
	 */
	public void setC_chargeDegree(String c_chargeDegree) {
		this.c_chargeDegree = c_chargeDegree;
	}


	/**
	* Getter method for field c_chargeDesc
	* @return value of c_charge_desc of the individual
	*/
	public String getC_chargeDesc() {
		return c_chargeDesc;
	}


	/**
	 * Setter method for field c_chargeDesc
	 * @param c_chargeDesc  The indivdidual's c_charge_desc
	 */
	public void setC_chargeDesc(String c_chargeDesc) {
		this.c_chargeDesc = c_chargeDesc;
	}


	/**
	* Getter method for field decileScore
	* @return value of decileScore of the individual
	*/
	public int getDecileScore() {
		return decileScore;
	}


	/**
	 * Setter method for field decileScore
	 * @param decileScore  The individual's decile score
	 */
	public void setDecileScore(int decileScore) {
		this.decileScore = decileScore;
	}

	
	/**
	* Getter method for field riskLevel
	* @return value of risk level of the individual
	*/
	public RiskLevel getRiskLevel() {
		return riskLevel;
	}


	/**
	 * Setter method for field riskLevel
	 * @param riskLevel  The individual's risk level
	 */
	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}
	

	/**
	* Getter method for field two_year_recid
	* @return value of two_year_recid of the individual
	*/
	public int getTwoYearRecid() {
		return two_year_recid;
	}



	/**
	 * Setter method for field two_year_recid
	 * @param two_year_recid  The individual's two_year_recid
	 */
	public void setTwoYearRecid(int two_year_recid) {
		this.two_year_recid = two_year_recid;
	}


	/**
	* Getter method for field r_chargeDesc
	* @return value of r_chargeDesc of the individual
	*/
	public String getR_chargeDesc() {
		return r_chargeDesc;
	}


	/**
	 * Setter method for field r_chargeDesc
	 * @param r_chargeDesc  The indivdidual's r_chargeDesc
	 */
	public void setR_chargeDesc(String r_chargeDesc) {
		this.r_chargeDesc = r_chargeDesc;
	}
	
	
	/**
	* Getter method for field r_chargeDegree
	* @return value of r_chargeDegree of the individual
	*/
	public String getR_chargeDegree() {
		return r_chargeDegree;
	}


	/**
	 * Setter method for field r_chargeDegree
	 * @param c_chargeDegree  The indivdidual's r_charge_degree
	 */
	public void setR_chargeDegree(String r_chargeDegree) {
		this.r_chargeDegree = r_chargeDegree;
	}
	
	

	// Methods to check the person's criteria based on race, two_year_recid and risk level
	
	/**
	* Method to check if the person is white
	* @return true if the person is white, otherwise return false
	*/
	public boolean isWhite() {
		if (race == Race.CAUCASIAN) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	* Method to check if the person is black
	* @return true if the person is black, otherwise return false
	*/
	public boolean isBlack() {
		if (race == Race.AFRICAN_AMERICAN) {
			return true;
		} else {
			return false;
		}
	}
	

	/**
	* Method to check if the person has re-offended
	* @return true if the person is has re-offended, otherwise return false
	*/
	public boolean hasReoffended() {
		if (two_year_recid == 1) {
			return true;
		} else if (two_year_recid == 0){
			return false;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	
	/**
	* Method to check if the person has low risk
	* @return true if the person is has low risk, otherwise return false
	*/
	public boolean isLowRisk() {
		if (riskLevel == RiskLevel.LOW) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	* Method to check if the person has high risk
	* @return true if the person is has high risk, otherwise return false
	*/
	public boolean isHighRisk() {
		if (riskLevel == RiskLevel.HIGH) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// Constructor 2 which passes in a String array as the parameter
	public SuspectProfile (String[] fullProfile) {
		this(fullProfile[0], fullProfile[1], fullProfile[2], fullProfile[3], fullProfile[4], fullProfile[5],
				fullProfile[6], fullProfile[7], fullProfile[8]);
	}
	
	
	// Override toString method
	@Override
	public String toString() {
		return "Sex: " + this.sex + " Race: " + this.race + " Charge Degree: " + this.c_chargeDegree + 
				" Charge Description: " + this.c_chargeDesc + " Decile Score: " + this.decileScore + 
				" Risk Level: " + this.riskLevel + " Has Reoffended: " + this.two_year_recid + 
				" Recid Charge Degree: " + this.r_chargeDegree + " Recid Charge Description: " + 
				this.r_chargeDesc; 
	}
	
	
	// Override equals method 
	@Override
	public boolean equals(Object other) {
		// Type cast object to another object of type SuspectProfile
		SuspectProfile otherSuspect = (SuspectProfile) other;

		// Compare each field of the 2 objects
		if (this.sex.equals(otherSuspect.getSex())
		    && this.race.equals(otherSuspect.getRace())
		    && this.c_chargeDegree.equals(otherSuspect.getC_chargeDegree())
		    && this.c_chargeDesc.equals(otherSuspect.getC_chargeDesc())
		    && this.decileScore == otherSuspect.getDecileScore()	
		    && this.riskLevel.equals(otherSuspect.getRiskLevel())
		    && this.two_year_recid == otherSuspect.getTwoYearRecid() 
		    && this.r_chargeDesc.equals(otherSuspect.getR_chargeDesc())
		    && this.r_chargeDegree.equals(otherSuspect.getR_chargeDegree())) 
		{
		    return true;
	    } 
		
		return false;
	}
	
}
