package lottery.linkedlist;
import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.ArrayList;

/* create CourseInfo object => create LotteryResults object => read each line + 
 * create a StudentNode for that line => add that StudentNode to LotteryResults*/

public class Main {
	public static void main(String[] args){
		// TODO: Output the lottery result based on command line arguments!
		try {
			CSVReader reader = new CSVReader(new FileReader(args[0]));
			ArrayList<String[]> allLines = new ArrayList<String[]> (reader.readAll());			
			reader.close();
			CourseInfo courseObject = new CourseInfo (allLines.get(0));
			LotteryResults linkedList = new LotteryResults(courseObject);
			
			for (int i = 1; i < allLines.size(); i++) {
				StudentNode student = new StudentNode(allLines.get(i));
				linkedList.addStudents(student);
			}
			
			for (int j = 0; j < args.length -1; j++) {
				if (args[j].equals("--print")) {
					linkedList.printArgs(args[j+2]);
				}
				else if (args[j].equals("--find")) {
					linkedList.findArgs(args[j+1]);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid");
		}
	}
}
			
	// TODO: make sure you test your work as you go!

