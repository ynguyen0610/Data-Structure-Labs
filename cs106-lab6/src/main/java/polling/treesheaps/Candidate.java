package polling.treesheaps;

public class Candidate implements Comparable<Candidate>{
	private String fullName;
	private String lastName;
	private double percentage;
	public Candidate(String[] str) {
		this.lastName = str[0];
		this.fullName = str[1];
		this.percentage = Double.parseDouble(str[2]);
	}
	public String toString() {
		return fullName + ":" + percentage;
	}
	
	@Override
	public int compareTo(Candidate person) {
		if (this.percentage > person.percentage) {
			return 1;
		}
		else if (this.percentage < person.percentage){
			return -1;
		}
		else {
			if (this.lastName.compareTo(person.lastName) > 0) {
				return 1;
			}
			if (this.lastName.compareTo(person.lastName) < 0) {
				return -1;
			}
			return 0;
		}
	}
}
