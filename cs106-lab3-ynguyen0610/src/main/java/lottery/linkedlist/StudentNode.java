package lottery.linkedlist;

// Made StudentNode Comparable
public class StudentNode implements Comparable<StudentNode> {
	
	// Fields / attributes 
	private String studentName;
	private int classYear;
	private String[] major;
	private String[] minor;
	public enum School { BMC, HC, SWAT };
	private School institution;
	private boolean previousLot;
	
	// Set points field to calculate points 
	private int points;
	
	// prev and next nodes
	private StudentNode prev;
	private StudentNode next;
	
	// Constructor 	
	public StudentNode(String[] studentProfile) {
		studentName = studentProfile[0];
		classYear = Integer.parseInt(studentProfile[1]); 
		major = studentProfile[2].split("/");
		minor = studentProfile[3].split("/");
		institution = convertSchool(studentProfile[4]);
		previousLot = convertLot(studentProfile[5]);
	} 
	 
	// Method to calculate points, which passes information of the course from the CourseInfo class  
	public void calculatePoints(CourseInfo course) {
		points += course.getYearPreference()[classYear - 1];
		for (int i = 0; i < major.length; i++) {
				if (major[i].equals("H")) {
					points += course.getMajorPreference()[0];
				}
				else if (major[i].equals("N")) {
					points += course.getMajorPreference()[1];
				}
				else if (major[i].equals("S")) {
					points += course.getMajorPreference()[2];
				}
				}
		for (int i = 0; i < minor.length; i++) {
				if (minor[i].equals("H")) {
					points += course.getMinorPreference()[0];
				}
				else if (major[i].equals("N")) {
					points += course.getMinorPreference()[1];
				}
				else if (minor[i].equals("S")) {
					points += course.getMinorPreference()[2];
				}
				}
				if (institution.equals(School.BMC) || institution.equals(School.HC)) {
					points += course.getBiCoPreference();
				}
		if (previousLot) {
			points += course.getPreviousPreference();
		}
	}	
	
	// Convert enum to String
	public School convertSchool(String institution) {
		switch (institution) { 
		case "BMC": 
			return School.BMC;
		case "HC":
			return School.HC;
		case "SWAT":
			return School.SWAT;
		default: 
			throw new IllegalArgumentException("Invalid input");
		}
	}
	
	// Convert String to boolean	
	public boolean convertLot(String previousLot) {
		switch (previousLot) {
		case "Yes":
			return true;
		case "No":
			return false;
		default:
			throw new IllegalArgumentException("Invalid input");
		}
	}
	
	// getter methods
	public String getStudentName() { return studentName; }
	public int getClassYear() { return classYear; }
	public String[] getMajor() { return major; }
	public String[] getMinor() { return minor; }
	public School getSchool() { return institution; }
	public boolean getPrevLot() { return previousLot; }
	public StudentNode getNext() { return next; }
	public StudentNode getPrev() { return prev; }
	public int getPoint() { return points; }
	
	// setter methods
	public void setNext(StudentNode nextNode) { next = nextNode; }
	public void setPrev(StudentNode prevNode) { prev = prevNode; }
	
	@Override
	public String toString() {
		return studentName + "'s position in " + classYear + " loterry is " + points;
	}
	
	// Compare method to compare students according to ordering and ties
	@Override   
	public int compareTo(StudentNode other) {
		if (points > other.points) {
			return 1;
		} 
		else if (points < other.points) {
			return -1;
		}
		else {
			if (studentName.compareTo(other.studentName) > 0) {
				return -1;
			}
			else if (studentName.compareTo(other.studentName) < 0) {
				return 1;
			}
			else {
				if (classYear > other.classYear) {
					return -1;
				}
				else if (classYear < other.classYear) {
					return 1;
				}
			}
		}
		return 0;
	} 
}
