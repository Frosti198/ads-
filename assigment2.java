import java.util.*;

public class assigment2 {
    // Task 1 
    public static void task1(Scanner scanner) {
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) line.add(scanner.nextInt());
            lines.add(line);
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            try {
                System.out.println(lines.get(x - 1).get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
    }

    // Task 2
    public static void task2(Scanner scanner) {
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(scanner.nextInt());
        
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String op = scanner.next();
            if (op.equals("Insert")) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                list.add(index, value);
            } else if (op.equals("Delete")) {
                int index = scanner.nextInt();
                list.remove(index);
            }
        }
        for (int num : list) System.out.print(num + " ");
        System.out.println();
    }

    // Task 3
    public static void task3(Scanner scanner) {
        int n = scanner.nextInt();
        Deque<Integer> shelf = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int op = scanner.nextInt();
            if (op == 1) shelf.addFirst(scanner.nextInt());
            else if (op == 2) shelf.addLast(scanner.nextInt());
            else if (op == 3) System.out.println(shelf.removeFirst());
            else if (op == 4) System.out.println(shelf.removeLast());
        }
    }

    // Task 4
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }
    
    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, item);
        stack.push(temp);
    }

    // Task 5
    public static int countStudents(int[] students, int[] samsas) {
        Queue<Integer> queue = new LinkedList<>();
        for (int s : students) queue.add(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = samsas.length - 1; i >= 0; i--) stack.push(samsas[i]);
        
        int attempts = 0;
        while (!queue.isEmpty() && attempts < queue.size()) {
            if (queue.peek().equals(stack.peek())) {
                queue.poll(); stack.pop(); attempts = 0;
            } else {
                queue.add(queue.poll()); attempts++;
            }
        }
        return queue.size();
    }

    // Task 6
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int swap = arr[i]; arr[i] = arr[largest]; arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
      
    }
}
