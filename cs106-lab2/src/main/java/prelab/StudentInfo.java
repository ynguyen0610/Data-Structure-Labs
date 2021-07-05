package prelab;

public class StudentInfo {	
	String name; // Student's name
	int age; // Student's age
	Standing classYear; // Student's class year
	String dorm; // Student's dorm
	boolean job; // Student's information about whether the student has on campus job or not
	String dean; // Student's dean's name
	
	public enum Standing {
    	FIRST_YEAR,
    	SOPHOMORE, 
    	JUNIOR, 
    	SENIOR;
    }	
	
	public static Standing classYear (String classYear) {
		switch(classYear) {
		case "First Year":
			return (Standing.FIRST_YEAR);
		case "Sophomore":
			return (Standing.SOPHOMORE);
		case "Junior":
			return (Standing.JUNIOR);
		case "Senior":
			return (Standing.SENIOR);
    	default:
    		throw new IllegalArgumentException("There is no case matched");
		}
	}
	
	// Constructor 1
	public StudentInfo(String name, int age, Standing classYear, 
			String dorm, boolean job, String dean) {
		this.name = name;
		this.age = age;
		this.classYear = classYear;
		this.dorm = dorm;
		this.job = job;
		this.dean = dean;
	}
	
	/**
	* Getter and setter methods for all fields
	*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Standing getClassYear() {
		return classYear;
	}

	public void setClassYear(Standing classYear) {
		this.classYear = classYear;
	}

	public String getDorm() {
		return dorm;
	}

	public void setDorm(String dorm) {
		this.dorm = dorm;
	}

	public boolean getJob() {
		return job;
	}

	public void setJob(boolean job) {
		this.job = job;
	}

	public String getDean() {
		return dean;
	}

	public void setDean(String dean) {
		this.dean = dean;
	}
		
	@Override
	public String toString() {
		return (this.getName() + ", " + Integer.toString(this.getAge()) + ", " +
				toString_classYear(this.getClassYear()) +", " + this.getDorm() + ", " +
				jobToString(this.getJob()) +", " + this.getDean());
	}
		
	// Constructor 2
	public StudentInfo(String name_str, String age_str, String classYear_str, 
				String dorm_str, String job_str, String dean_str) {
		this.name = name_str;		
		this.age = Integer.parseInt(age_str);
		this.classYear = classYear(classYear_str);
		this.dorm = dorm_str;
		this.job = jobToBool(job_str);
		this.dean = dean_str;
	}
	
	/**
	* This function converts a String value of field job to a boolean value
	* @param job_str The String value of field job 
	* @return The boolean value of field job
	*/
	private static boolean jobToBool (String job_str) {
		if (job_str.equals("Yes")) {
			return true;
		} else if (job_str.equals("No")) {
			return false;
		} else {
			throw new IllegalArgumentException("Invalid String value of field: job");
		}
	}
	
	/**
	* This function converts a boolean value of field job to a String value
	* @param job The boolean of field job 
	* @return The String value of field job
	*/
	public static String jobToString (boolean job) {
		if (job == true) {
			return "Yes";
		} else if (job == false) {
			return "No";
		} else {
			throw new IllegalArgumentException("Invalid bool value of field: job");
		}
	}
	
	/**
	* This function converts value of field classYear from an enum to String
	* @param classYear The value of field classYear of type enum Standing 
	* @return The String value of field classYear
	*/
	public static String toString_classYear (Standing classYear) {
		switch(classYear) {
    	case FIRST_YEAR:
    		return ("First Year");
    	case SOPHOMORE:
    		return ("Sophomore");
    	case JUNIOR:
    		return ("Junior");
    	case SENIOR:
    		return ("Senior");
		}
		return null;
	}
	
	/**
	* Override equals method to compare 2 objects
	* @param other The other object being compared to 
	* @return The boolean value of the comparison of 2 objects
	*/
	@Override
	public boolean equals(Object other) {
		// Type cast object to another object of type StudentInfo
		StudentInfo otherStudent = (StudentInfo) other;
		return (this.name == otherStudent.getName()
				&& this.age == otherStudent.getAge()
				&& this.classYear == otherStudent.getClassYear()
				&& this.job == otherStudent.getJob()
				&& this.dorm == otherStudent.getDorm()
				&& this.dean == otherStudent.getDean());
	}
	
}