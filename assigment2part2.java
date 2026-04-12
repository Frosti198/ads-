import java.util.ArrayList;

public class assigment2part2 {
    public static void main(String[] args) {
        int[] students = {1, 1, 1, 0, 0, 1};
        int[] samsas = {1, 0, 0, 0, 1, 1};
        System.out.println(countStudents(students, samsas));
    }

    public static int countStudents(int[] students, int[] samsas) {
        ArrayList<Integer> studentQueue = new ArrayList<>();
        for (int s : students) {
            studentQueue.add(s);
        }
        
        int foodIndex = 0;
        int rejections = 0;
        
        while (studentQueue.size() > 0 && rejections < studentQueue.size()) {
            if (studentQueue.get(0) == samsas[foodIndex]) {
                studentQueue.remove(0); 
                foodIndex++;            
                rejections = 0;         
            } else {
                studentQueue.add(studentQueue.remove(0));
                rejections++;
            }
        }
        
        return studentQueue.size();
    }
}
