import java.util.*;

public class Ramirez_ArrayA {
	public static Scanner scanner = new Scanner(System.in);

	// Parses an integer and checks if its valid, will not stop until a valid integer is given
	static int requestInt(String message) {
		String answer = "";
		boolean valid = false;
		while (!valid) { // keep requesting until its a valid integer
			System.out.print(message + ": ");
			answer = scanner.nextLine();
			if (answer == "") {// empty inputs will be -1
				return -1;
			}
			valid = answer.matches("-?\\d+");
			if (!valid) {
				System.out.println("[!] Invalid Integer Given, try again.");
			}
		}
		return Integer.parseInt(answer);
	}

	static void pause() {
		System.out.println("Press [Enter] to continue");
		scanner.nextLine();
	}

	static void displayArray(int[] array) {
		System.out.println("========[Your Array]========");
		System.out.println(Arrays.toString(array));
		System.out.println("size: " + array.length);
		System.out.println("----------------------------");
	}

	;

	public static void main(String[] args) {

		int[] array = {1, 3, 3, 2, 2, 5, 4};
		boolean active = true;
		while (active) {
			System.out.println("======[Array Exercise]======");
			displayArray(array);
			System.out.println("[0] Edit Array");
			System.out.println("----------------------------");
			System.out.println("[1] Sum of N number in an array");
			System.out.println("[2] Maximum and Minimum number");
			System.out.println("[3] Distinct Number");
			System.out.println("[4] Exit");
			System.out.println("----------------------------");
			int option = requestInt("Enter an option [1..4]");
			System.out.println();


			switch (option) {
				default: // Edit Array
					int[] unsavedArray = array.clone();
					boolean editingArray = true;
					while (editingArray) {
						System.out.println();
						displayArray(unsavedArray);
						System.out.println("[1] Set SIZE");
						System.out.println("[2] Set VALUE");
						System.out.println("");
						System.out.println("[3] Save and Exit");
						System.out.println("[0] Discard and Exit");
						System.out.println("----------------------------");
						int editOption = requestInt("Enter an option [1..3]: ");
						switch (editOption) {
							default: // [0] Discard and Return to Main Menu
								System.out.println("Discarded array");
								System.out.println();
								editingArray = false;
								break;
							case 1: // [1] Set Array Size
								int newSize = requestInt("Enter an array size");
								int[] newArray = new int[newSize];

								// transfer data from old array to new array
								for (int i = 0; i < Math.min(newSize, unsavedArray.length); i++) {
									newArray[i] = unsavedArray[i];
								}
								unsavedArray = newArray;
								break;
							case 2:
								boolean settingArray = true;
								while (settingArray) {
									displayArray(unsavedArray);
									System.out.println("[Enter] to Exit edit mode");
									System.out.println("[n] to set an index");
									int newIndex = requestInt("Set index");

									if (newIndex == -1) {
										settingArray = false;
									} else {
										int newValue = requestInt("to value");
										if (newIndex >= 0 && newIndex < unsavedArray.length) {
											unsavedArray[newIndex] = newValue;
										} else {
											System.out.println("Index out of bounds");
										}
									}

								}
								break;
							case 3:
								System.out.println("Saving Array");
								array = unsavedArray;
								editingArray = false;
								System.out.println();
								break;
						}
					}
					break;
				case 1: // Sum of N number in an array
					System.out.println("Sum of N number in an array: ");
					String speech = "";
					int sum = 0;
					for (int i = 0; i < array.length; i++) {
						sum += array[i];

						speech += array[i];
						if (i != array.length - 1) {
							speech += " + ";
						}
					}
					System.out.println(speech);
					System.out.println("= " + sum);
					pause();
					break;
				case 2: // Find the Maximum and Minimum of N numbers in an array
					System.out.println("Maximum and Minimum number");

					int min = Integer.MAX_VALUE;
					int max = Integer.MIN_VALUE;
					for (int i = 0; i < array.length; i++) {
						min = Math.min(min, array[i]);
						max = Math.max(max, array[i]);
					}
					System.out.println("Minimum: " + min);
					System.out.println("Maximum: " + max);
					pause();
					break;
				case 3:
					System.out.println("Delete duplicate values in an array");
					LinkedList<Integer> list = new LinkedList();
					HashMap<Integer, Boolean> exists = new HashMap();

					for (int i = 0; i < array.length; i++) {
						int item = array[i];
						if (!exists.containsKey(item)) {
							exists.put(item, true);
							list.add(item);
						}
					}

					System.out.println(list.toString());
					pause();
					break;
				case 4:
					System.out.println("Hasta la vista");
					active = false;
					break;
			}
		}
	}
}
