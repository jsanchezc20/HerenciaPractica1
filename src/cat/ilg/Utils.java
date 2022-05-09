package cat.ilg;

import java.util.Scanner;
import static java.lang.System.out;
import java.util.concurrent.TimeUnit;
import static cat.ilg.Main.SECONDS_WAITING;

public class Utils {
	public static String comprovaDada(String value) {
		return (value == null || "".equals(value)) ? "No informat" : value;
	}

	public static Double comprovaDada(Double value) {
		return value == null ? 0d : value;
	}

	public static int keybInputInt() {
		int inputInt;
		Scanner inputConsole = new Scanner(System.in);

		inputInt = inputConsole.nextInt();

		return inputInt;
	}

	public static String keybInputString() {
		String inputString = "";
		Scanner inputConsole = new Scanner(System.in);

		inputString += inputConsole.nextLine();

		if (inputString.trim().length() < 3) {
			out.println("Introdueix un nom més llarg.\n");
			keybInputString();
		}

		return inputString;
	}

	public static void clearConsole() throws InterruptedException {
		try{
			String operatingSystem = System.getProperty("os.name"); //Check the current operating system

			if (operatingSystem.contains("Windows")) {
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
				Process startProcess = pb.inheritIO().start();
				startProcess.waitFor();
			} else {
				ProcessBuilder pb = new ProcessBuilder("clear");
				Process startProcess = pb.inheritIO().start();

				startProcess.waitFor();
			}
		} catch(Exception e) {
			out.println(e);
		}
		TimeUnit.SECONDS.sleep(SECONDS_WAITING);
	}
}
