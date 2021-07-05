package prelab;

public class StudentInfo {
	
	public enum Standing {
    	FIRST_YEAR,
    	SOPHOMORE, 
    	JUNIOR, 
    	SENIOR;
    }
	
	String name;
	String age;
	String age_str;
	String classYear;
	String classYear_str;
	String dorm;
	String job;
	String job_str;
	String dean;

	
	
	public StudentInfo(String name, int age, Standing classYear, 
			String dorm, boolean job, String dean) {
		this.name = name;
		age_str = Integer.toString(age);
		this.age = age_str;
		classYear_str = toString_classYear(classYear);
		this.classYear = classYear_str;
		this.dorm = dorm;
		job_str = toStringYesNo(job);
		this.job = job_str;
		this.dean = dean;
	}
	
	private static String toStringYesNo (boolean job) {
		return toString(job, "Yes", "No");
	} 
	
	
	private static String toString(boolean job2, String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(int newAge) {
		this.age = Integer.toString(newAge);
	}
		
	@Override
	public String toString() {
		return ("Has job on campus or not: " + this.job + " Age: " + this.age);
	}
	
	
	public StudentInfo(String name_str, String age_str, String classYear_str, 
				String dorm_str, String job_str, String dean_str) {
		this.name = name_str;		
		this.age = age_str;
		this.classYear = classYear_str;
		this.dorm = dorm_str;
		this.job = job_str;
		this.dean = dean_str;
	}
	
	
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
	
	
	public static String HelperMethod_Dorm(String dorm_str) {
		return "Dorm: " + dorm_str;
	}
	public static String HelperMethod_ClassYear(String classYear_str) {
		return "Class Year: " + classYear_str;
	}
	

	
//	@Override
//	public boolean equals(StudentInfo student1, StudentInfo student2) {
//		
//	}
	
}