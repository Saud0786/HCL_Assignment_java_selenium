import java.util.Scanner;

public class ArrayMenuProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[50];
        int n, choice, i, pos, element, key;
        int temp;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        System.out.println("Enter elements:");
        for (i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Insert Element");
            System.out.println("2. Delete Element");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even & Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // 1. Insert
                case 1:
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();

                    System.out.print("Enter element: ");
                    element = sc.nextInt();

                    for (i = n; i > pos - 1; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[pos - 1] = element;
                    n++;
                    System.out.println("Element inserted.");
                    break;

                // 2. Delete
                case 2:
                    System.out.print("Enter position to delete: ");
                    pos = sc.nextInt();

                    for (i = pos - 1; i < n - 1; i++) {
                        arr[i] = arr[i + 1];
                    }
                    n--;
                    System.out.println("Element deleted.");
                    break;

                // 3. Linear Search
                case 3:
                    System.out.print("Enter element to search: ");
                    key = sc.nextInt();
                    int found = 0;

                    for (i = 0; i < n; i++) {
                        if (arr[i] == key) {
                            System.out.println("Found at position " + (i + 1));
                            found = 1;
                            break;
                        }
                    }
                    if (found == 0)
                        System.out.println("Element not found");
                    break;

                // 4. Binary Search (array must be sorted)
                case 4:
                    System.out.print("Enter element to search: ");
                    key = sc.nextInt();

                    int low = 0, high = n - 1, mid;
                    found = 0;

                    while (low <= high) {
                        mid = (low + high) / 2;

                        if (arr[mid] == key) {
                            System.out.println("Found at position " + (mid + 1));
                            found = 1;
                            break;
                        } else if (arr[mid] < key)
                            low = mid + 1;
                        else
                            high = mid - 1;
                    }

                    if (found == 0)
                        System.out.println("Element not found");
                    break;

                // 5. Find Maximum
                case 5:
                    int max = arr[0];
                    for (i = 1; i < n; i++) {
                        if (arr[i] > max)
                            max = arr[i];
                    }
                    System.out.println("Maximum value = " + max);
                    break;

                // 6. Count Even & Odd
                case 6:
                    int even = 0, odd = 0;
                    for (i = 0; i < n; i++) {
                        if (arr[i] % 2 == 0)
                            even++;
                        else
                            odd++;
                    }
                    System.out.println("Even count = " + even);
                    System.out.println("Odd count = " + odd);
                    break;

                // 7. Insertion Sort
                case 7:
                    for (i = 1; i < n; i++) {
                        temp = arr[i];
                        int j = i - 1;

                        while (j >= 0 && arr[j] > temp) {
                            arr[j + 1] = arr[j];
                            j--;
                        }
                        arr[j + 1] = temp;
                    }
                    System.out.println("Array sorted using Insertion Sort.");
                    break;

                // 8. Display
                case 8:
                    System.out.println("Array elements:");
                    for (i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 9:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);

        sc.close();
    }
}
