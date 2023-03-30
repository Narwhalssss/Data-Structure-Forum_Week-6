import java.util.Stack;

public class TowerOfHanoiIteration {
    public static void main(String[] args) {
        int numDisks = 3;
        char sourceRod = 'A', auxiliaryRod = 'B', destinationRod = 'C';
        towerOfHanoi(numDisks, sourceRod, auxiliaryRod, destinationRod);
    }

    public static void towerOfHanoi(int numDisks, char source, char auxiliary, char destination) {
        Stack<Integer> sourceStack = new Stack<>();
        Stack<Integer> auxiliaryStack = new Stack<>();
        Stack<Integer> destinationStack = new Stack<>();

        for (int i = numDisks; i >= 1; i--) {
            sourceStack.push(i);
        }

        int totalMoves = (int) Math.pow(2, numDisks) - 1;

        if (numDisks % 2 == 0) {
            char temp = auxiliary;
            auxiliary = destination;
            destination = temp;
        }

        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                moveDisk(sourceStack, destinationStack, source, destination);
            } else if (i % 3 == 2) {
                moveDisk(sourceStack, auxiliaryStack, source, auxiliary);
            } else if (i % 3 == 0) {
                moveDisk(auxiliaryStack, destinationStack, auxiliary, destination);
            }
        }
    }

    private static void moveDisk(Stack<Integer> source, Stack<Integer> destination, char sourceRod, char destinationRod) {
        if (source.isEmpty()) {
            source.push(destination.pop());
            System.out.println("Move disk from " + destinationRod + " to " + sourceRod);
        } else if (destination.isEmpty()) {
            destination.push(source.pop());
            System.out.println("Move disk from " + sourceRod + " to " + destinationRod);
        } else if (source.peek() < destination.peek()) {
            destination.push(source.pop());
            System.out.println("Move disk from " + sourceRod + " to " + destinationRod);
        } else {
            source.push(destination.pop());
            System.out.println("Move disk from " + destinationRod + " to " + sourceRod);
        }
    }
}