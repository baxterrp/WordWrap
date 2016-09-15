
public class Wrapper {

	public static String wrap(String input, int maxColumns) {

		StringBuilder newString = new StringBuilder("");
		int len = input.length();
		int count = 1;

		for (int i = 0; i < len; i++) {

			// if we hit column length
			if (count == maxColumns) {
				// check for space - replace with newline
				if (input.charAt(i) == ' ') {
					newString.append('\n');
					count = 1;
				} else {
					// find last space if word extends past column length
					// replace with newline - add character
					int lastSpace = input.lastIndexOf(' ', i);
					newString.setCharAt(lastSpace, '\n');
					newString.append(input.charAt(i));

					// because new line starts with random length word, start
					// count at word length
					count = i - lastSpace;
				}
			} else {
				newString.append(input.charAt(i));
				count++;
			}
		}

		String returnString = newString.toString();
		return returnString;

	}

}
