import java.util.*;
import java.io.InputStream;

public class Parser {
  String fileName = "input.txt";
  InputStream file;

  public Parser() {
    file = Parser.class.getResourceAsStream(fileName);
  }

  /**
   * Parses the input text file. This returns a list of "roster lists".
   * courses.get(0) will be a list of the student IDs in course 0
   * course.get(1) will be a list of student IDs in course 1
   * etc.
   *
   * You then need to turn this "list of rosters" into a graph!
   * 
   * @return
   */
  public List<List<Integer>> listOfRosters() {
    Scanner sc = new Scanner(file);

    List<List<Integer>> courseToStudentList = new ArrayList<>();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      ArrayList<Integer> list = new ArrayList<>();

      Scanner lineScanner = new Scanner(line);
      while (lineScanner.hasNextInt()) {
        list.add(lineScanner.nextInt());
      }
      courseToStudentList.add(list);
    }
    sc.close();

    return courseToStudentList;
  }

  public static void main(String[] args) {
    Parser p = new Parser();
    List<List<Integer>> courses = p.listOfRosters();

    System.out.println(courses);
  }
}