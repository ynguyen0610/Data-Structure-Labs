package propublica.datadesign;

import java.util.ArrayList;

public class FullCriminalProfile {
	// This variable contains an array list of all criminals' profiles
	private ArrayList<CriminalProfile> allCriminalProfile;

	//Constructor
	public FullCriminalProfile() {
		this.allCriminalProfile = new ArrayList<CriminalProfile>();
	}
	
	/**
	* 
	* @param 
	*/
	public void readAllRows (ArrayList<String[]> allDataRows) {
		try {
			for (String[] row: allDataRows) {
				allCriminalProfile.add(convertRowToCriminalProfile(row));
			} 
		} catch (Exception ex) {
			System.out.println("Invalid data input");
		}
	}
	
	/**
	* 
	* @param 
	* @return 
	*/
	public static CriminalProfile convertRowToCriminalProfile (String[] oneCriminalRow) {
		return new CriminalProfile(oneCriminalRow);
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();		
		for (CriminalProfile criminal: allCriminalProfile) {	
			str.append(criminal.toString());
			str.append("\n");
		}
		return str.toString();
	}

	/**
	 * Getter method for field allCriminalProfile
	 * @return the allStudentInfo of type ArrayList<CriminalProfile>
	 */
	public ArrayList<CriminalProfile> getAllCriminalProfile() {
		return allCriminalProfile;
	}

	/**
	 * Setter method for field allCriminalProfile
	 * @param allCriminalProfile the allCriminalProfile to set
	 */
	public void setAllCriminalProfile(ArrayList<CriminalProfile> allCriminalProfile) {
		this.allCriminalProfile = allCriminalProfile;
	}

	

}
