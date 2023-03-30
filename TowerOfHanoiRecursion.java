public class TowerOfHanoiRecursion {
    public static void main(String[] args) {
        int numDisks = 3;
        char sourceRod = 'A', auxiliaryRod = 'B', destinationRod = 'C';
        towerOfHanoi(numDisks, sourceRod, auxiliaryRod, destinationRod);
    }

    public static void towerOfHanoi(int numDisks, char sourceRod, char auxiliaryRod, char destinationRod) {
        if (numDisks == 1) {
            System.out.println("Move disk 1 from rod " + sourceRod + " to rod " + destinationRod);
            return;
        }
        towerOfHanoi(numDisks - 1, sourceRod, destinationRod, auxiliaryRod);
        System.out.println("Move disk " + numDisks + " from rod " + sourceRod + " to rod " + destinationRod);
        towerOfHanoi(numDisks - 1, auxiliaryRod, sourceRod, destinationRod);
    }
}