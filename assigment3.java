import java.util.Scanner;

public class assigment3 {

    // Task 1
    public static void checkIfAnagrams(Scanner inputScanner) {
        String firstWord = inputScanner.next();
        String secondWord = inputScanner.next();
        
        char[] firstWordArray = firstWord.toCharArray();
        char[] secondWordArray = secondWord.toCharArray();
        
        bubbleSortCharacters(firstWordArray);
        bubbleSortCharacters(secondWordArray);
        
        boolean areAnagrams = true;
        if (firstWordArray.length != secondWordArray.length) {
            areAnagrams = false;
        } else {
            for (int index = 0; index < firstWordArray.length; index++) {
                if (firstWordArray[index] != secondWordArray[index]) {
                    areAnagrams = false;
                    break;
                }
            }
        }
        
        System.out.println(areAnagrams ? "YES" : "NO");
    }

    // Task 2
    public static void findKthSmallest(Scanner inputScanner) {
        if (!inputScanner.hasNextInt()) return;
        
        int arraySize = inputScanner.nextInt();
        int[] numbersArray = new int[arraySize];
        for (int index = 0; index < arraySize; index++) {
            numbersArray[index] = inputScanner.nextInt();
        }
        
        int targetPosition = inputScanner.nextInt();
        
        // Ручная сортировка пузырьком
        bubbleSortIntegers(numbersArray);
        
        System.out.println(numbersArray[targetPosition - 1]);
    }

    // Task 3
    public static void findMedianValue(Scanner inputScanner) {
        if (!inputScanner.hasNextInt()) return;
        
        int arraySize = inputScanner.nextInt();
        int[] numbersArray = new int[arraySize];
        for (int index = 0; index < arraySize; index++) {
            numbersArray[index] = inputScanner.nextInt();
        }
        
        bubbleSortIntegers(numbersArray);
        
        System.out.println(numbersArray[arraySize / 2]);
    }

    // Task 4
    public static void calculateOptimalCapacity(Scanner inputScanner) {
        if (!inputScanner.hasNextInt()) return;
        
        int numberOfPackages = inputScanner.nextInt();
        int[] packageWeights = new int[numberOfPackages];
        int maxSingleWeight = 0;
        int totalWeightSum = 0;
        
        for (int index = 0; index < numberOfPackages; index++) {
            int currentWeight = inputScanner.nextInt();
            packageWeights[index] = currentWeight;
            
            if (currentWeight > maxSingleWeight) {
                maxSingleWeight = currentWeight;
            }
            totalWeightSum += currentWeight;
        }
        
        int daysLimit = inputScanner.nextInt();
        
        int leftBoundary = maxSingleWeight;
        int rightBoundary = totalWeightSum;
        int optimalCapacityResult = totalWeightSum;
        
        while (leftBoundary <= rightBoundary) {
            int middleCapacity = leftBoundary + (rightBoundary - leftBoundary) / 2;
            
            if (canShipAllPackages(packageWeights, daysLimit, middleCapacity)) {
                optimalCapacityResult = middleCapacity;
                rightBoundary = middleCapacity - 1; 
            } else {
                leftBoundary = middleCapacity + 1; 
            }
        }
        
        System.out.println(optimalCapacityResult);
    }
    
    
    private static boolean canShipAllPackages(int[] packageWeights, int daysLimit, int capacityLimit) {
        int daysUsed = 1;
        int currentDayWeight = 0;
        
        for (int currentWeight : packageWeights) {
            if (currentDayWeight + currentWeight > capacityLimit) {
                daysUsed++;
                currentDayWeight = 0;
            }
            currentDayWeight += currentWeight;
        }
        
        return daysUsed <= daysLimit;
    }


    private static void bubbleSortCharacters(char[] array) {
        int length = array.length;
        for (int step = 0; step < length - 1; step++) {
            for (int index = 0; index < length - step - 1; index++) {
                if (array[index] > array[index + 1]) {
                    char temporary = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temporary;
                }
            }
        }
    }

    private static void bubbleSortIntegers(int[] array) {
        int length = array.length;
        for (int step = 0; step < length - 1; step++) {
            for (int index = 0; index < length - step - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int temporary = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temporary;
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
