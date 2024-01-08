import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
  // Creates edges between courses based on shared students.
  public List<List<Integer>> genGraph(List<List<Integer>> courses) {
    List<List<Integer>> edges = new ArrayList<>();

    for (int i = 0; i < courses.size(); i++) {
      for (int j = i + 1; j < courses.size(); j++) {
        if (share(courses.get(i), courses.get(j))) {
          edges.add(List.of(i, j));
        }
      }
    }

    return edges;
  }

  // Checks if two course rosters share at least one student.
  private boolean share(List<Integer> a, List<Integer> b) {
    Set<Integer> setA = new HashSet<>(a);
    for (Integer student : b) {
      if (setA.contains(student)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Parser p = new Parser();
    List<List<Integer>> courses = p.listOfRosters();

    Graph g = new Graph();
    List<List<Integer>> graphEdges = g.genGraph(courses);

    System.out.println("Edges:");
    for (List<Integer> edge : graphEdges) {
      System.out.println(edge.get(0) + " " + edge.get(1));
    }
  }
}