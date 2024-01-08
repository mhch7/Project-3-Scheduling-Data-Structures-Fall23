import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Schedule {
  // Creates a schedule.
  public List<List<Integer>> genSchedule(List<List<Integer>> edges) {
    int numCourses = edges.size();
    int[] slots = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      slots[i] = -1;
    }

    for (int course = 0; course < numCourses; course++) {
      Set<Integer> slotsSet = new HashSet<>();
      for (int adjacent : edges.get(course)) {
        if (slots[adjacent] != -1) {
          slotsSet.add(slots[adjacent]);
        }
      }

      int slot = 0;
      while (slotsSet.contains(slot)) {
        slot++;
      }

      slots[course] = slot;
    }

    List<List<Integer>> schedule = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      int slot = slots[i];
      while (slot >= schedule.size()) {
        schedule.add(new ArrayList<>());
      }
      schedule.get(slot).add(i);
    }
    return schedule;
  }

  public static void main(String[] args) {
    Parser p = new Parser();
    List<List<Integer>> courses = p.listOfRosters();

    Graph g = new Graph();
    List<List<Integer>> graphEdges = g.genGraph(courses);

    Schedule s = new Schedule();
    List<List<Integer>> schedule = s.genSchedule(graphEdges);

    System.out.println("Schedule:");
    for (int i = 0; i < schedule.size(); i++) {
      System.out.println("Slot " + i + ": " + schedule.get(i));
    }
  }
}