package lottery.linkedlist;
import java.util.ArrayList; 

// This is the LinkedList class 
public class LotteryResults {
	
	// Declaring variables for the class
	private StudentNode head;
	private StudentNode tail;
	private int size;
	private CourseInfo course; // Instance variable of type CourseInfo to store the course's information
	private StudentNode studentInfo; // Instance variable of type StudentNode to store the student's information
	
	// Constructor to initialize the attributes
	public LotteryResults(CourseInfo classInfo) {
		String[] empty = {"", "0", "", "", "HC", "Yes"};
		head = new StudentNode(empty);
		tail = new StudentNode(empty);
		head.setNext(tail);
		tail.setPrev(head);		
		course = classInfo;
		size = 0; 
	}
	// Method to add Students to the LinkedList 
	public void addStudents(StudentNode nodeStudent) {
		nodeStudent.calculatePoints(course);
		if (sizeIsEmpty()) {
			nodeStudent.setPrev(head);
			nodeStudent.setNext(tail);
			head.setNext(nodeStudent);
			tail.setPrev(nodeStudent);
			size++;
		} 
		else {
			StudentNode temp = head.getNext();
			while (temp != null) {
				if (nodeStudent.compareTo(temp) > 0) {
					nodeStudent.setNext(temp);
					nodeStudent.setPrev(temp.getPrev());
					temp.getPrev().setNext(nodeStudent);
					temp.setPrev(nodeStudent);
				//	System.out.println(temp.toString());
					size++;
					break;
				} 
				temp = temp.getNext();
		/*		else if (nodeStudent.compareTo(temp) < 0) {
					nodeStudent.setPrev(temp);
					nodeStudent.setNext(temp.getNext());
					temp.getNext().setPrev(nodeStudent);
					temp.setNext(nodeStudent);
					System.out.println(temp.toString());
					size++;
					temp = temp.getNext();
					break;
				}
				else {
					nodeStudent.setPrev(temp);
					nodeStudent.setNext(temp.getNext());
					temp.getNext().setPrev(nodeStudent);
					temp.setNext(nodeStudent);
					System.out.println(temp.toString());
					size++;
					temp = temp.getNext();
					break;
				} */
			} 
		}
		}
	// Declare the base value of size;
	public boolean sizeIsEmpty() {
		return size == 0;
	}
	
	// Method for the --print flag 
	public void printArgs(String printFlag) {
		int enrolledStudent = course.getEnrollCapacity();
		System.out.println(course.getCourseName() + " Lottery: " + printFlag);
		if (printFlag.equals("enrolled")) {
			StudentNode current = head.getNext();
			for (int i = 0; i < enrolledStudent; i++) {
				System.out.println("E" + (i+1) + ". " + current.getStudentName() + " " + current.getClassYear() 
				+ " " + current.getPoint());
				current = current.getNext();
			}	
		} else if (printFlag.equals("waitlist")) {
			StudentNode current = head.getNext();
			for (int i = 0; i < enrolledStudent; i++) {
				current = current.getNext();
			}
			for (int i = 0; i < course.getWaitlistCapacity(); i++) {
				System.out.println("W" + (i+1) + ". " + current.getStudentName() + " " + current.getClassYear() 
				+ " " + current.getPoint());
				current = current.getNext();
			}
		} else if (printFlag.equals("all")) {
			StudentNode current = head.getNext();
			for (int i = 0; i < enrolledStudent; i++) {
				System.out.println("E" + (i+1) + ". " + current.getStudentName() + " " + current.getClassYear() 
				+ " " + current.getPoint());
				current = current.getNext();
			}
			for (int i = 0; i < course.getWaitlistCapacity(); i++) {
				System.out.println("W" + (i+1) + ". " + current.getStudentName() + " " + current.getClassYear() 
				+ " " + current.getPoint());
				current = current.getNext();
		}
	}
	}
	
	// Method to get the order of students
	public int studentOrder(String studentInitials) {
		int position = 1;
		StudentNode current = head.getNext();
		while (current != null) {
			if (current.getStudentName().equals(studentInitials)) {
				return position;
			}
			current = current.getNext();
			position++;
		}
		return -1;
	}
	
	// Method for the --find flag 
	public void findArgs(String studentInitials) {
		 StudentNode current = head;
		 for (int i = 0; i < size; i++) {
			int position = studentOrder(studentInitials);
			if (position <= course.getEnrollCapacity() && position != -1) {
				System.out.println(studentInitials + "'s position in " + course.getCourseName() + " lottery is " + "E" + (i+1) + ".");
				break;
			}
			else if (position > course.getEnrollCapacity() && position <= course.getEnrollCapacity() + course.getWaitlistCapacity()) {
				System.out.println(studentInitials + "'s position in " + course.getCourseName() + " lottery is "
						 + "W" + (i+1) + ".");
				break;
			}
			else {
				System.out.println(studentInitials + " is not on the lottery for " + course.getCourseName() + ".");
				break;
			}
		 } 
	}
	// Getter method to get Size
	public int getSize() { return size; }
}
