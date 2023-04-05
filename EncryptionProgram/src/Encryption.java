import java.util.*;

public class Encryption {
	//declare all value in this class
	private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList <Character> shuffledList;
	private String line;
	private char character;
	private char [] letter;
	
	Encryption() {
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' ';
		question();
		newKey();
	}
	private void question() {
		while (true) {
			System.out.println("----------------------------");
			System.out.println("Please enter your choice");
			System.out.println("(N)ewKey - (G)etKey - (E)ncrypted - (D)ecrypted - (Q)uit");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			switch(response) {
				case 'N': newKey();
				break;
				case 'G': getKey();
				break;
				case 'E': encrypted();
				break;
				case 'D':decrypted();
				break;
				case 'Q': quit();
				break;
			default: System.out.println("Invalid value!!");
			}
		}
	}
	private void newKey() {
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for (int i = 32; i <= 127; i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList);
		System.out.println("The keys have been generated");
	}
	private void getKey() {
		System.out.println("Key: ");
		for (char x: list) {
			System.out.print(x);
		}
		System.out.println();
		for (char x: shuffledList) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void encrypted() {
		System.out.println("Enter the message to encrypted: ");
		String message = scanner.nextLine();
		letter = message.toCharArray();
		
		for (int i = 0; i < letter.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (letter[i] == list.get(j)) {
					letter[i] = shuffledList.get(j);
					break;
				}
			}
		}
		System.out.println("Encrypted: ");
		for (char x: letter) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void decrypted() {
		System.out.println("Enter the message to decrypted: ");
		String message = scanner.nextLine();
		letter = message.toCharArray();
		for (int i = 0; i < letter.length; i++) {
			for (int j = 0; j < shuffledList.size(); j++) {
				if (letter[i] == shuffledList.get(j)) {
					letter[i] = list.get(j);
					break;
				}
				
			}
		}
		System.out.println("Decripted: ");
		for (char x: letter) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void quit() {
		System.exit(0);
	}
}
