package prelab;

import java.util.ArrayList;

public class FullStudentInfo {
	
	// This variable contains an array list of all students' information
	private static ArrayList<StudentInfo> allStudentInfo;

	// TODO: check why have to change from this.allInfo into FullStudentInfo.allInfo
	// Constructor
	public FullStudentInfo() {
		FullStudentInfo.allStudentInfo =  new ArrayList<StudentInfo>();
	}
	
	/**
	* This function populates an ArrayList of String arrays with all rows containing students' information
	* @param readAllStudent The ArrayList of String arrays that holds the information of every row in the dataset
	*/
	public void addAllStudentsToArrList(ArrayList<String[]> readAllStudent) {
		for(int i = 0; i < readAllStudent.size() ; i++) {
			StudentInfo oneStudent = strArrayToStudentInfo(readAllStudent.get(i));
			allStudentInfo.add(oneStudent);
		}
	}
	
	/**
	* This function converts a String array into an object of type StudentInfo
	* @param oneStudentInfo The information of 1 student of type String array
	* @return The an object of type StudentInfo
	*/
	public static StudentInfo strArrayToStudentInfo (String[] oneStudentInfo) {
		StudentInfo oneStudent = new StudentInfo(oneStudentInfo[0], oneStudentInfo[1], oneStudentInfo[2], oneStudentInfo[3],
				oneStudentInfo[4], oneStudentInfo[5]);
		return oneStudent;
	}
	
	
	// TODO: check if this convert ArrayList of StudentInfo to ArrayList of String arrays or String arr of String arr
	
	/**
	**** This function override toString method to convert allStudentInfo into an ArrayList of String arrays
	* @return The an object of type StudentInfo
	*/
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();		
		for (StudentInfo oneStudent: allStudentInfo) {	
			str.append(oneStudent.toString());
			str.append("\n");
		}
		return str.toString();
	}

	/**
	 * Getter method for field allStudentInfo
	 * @return the allStudentInfo of type ArrayList<StudentInfo>
	 */
	public ArrayList<StudentInfo> getAllStudentInfo() {
		return allStudentInfo;
	}

	/**
	 * Setter method for field allStudentInfo
	 * @param allStudentInfo the allStudentInfo to set
	 */
	public static void setAllStudentInfo(ArrayList<StudentInfo> allStudentInfo) {
		FullStudentInfo.allStudentInfo = allStudentInfo;
	}

}