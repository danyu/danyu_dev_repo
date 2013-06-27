package danyu.problem;

public class StringReverse {

	static void reverse(String str) {
		doReverse(str);
	}

	static String doReverse(String str) {
		if (str.length() == 1)
			return str;
		return doReverse(str.substring(1, str.length())).concat(
				str.substring(0, 1));
	}

	/*
	 * "Today is sunny" ---partial reverse---> "yadoT si ynnus"
	 */

	static String doPartialReverse(String str) {

		int indexOfSpace = str.indexOf(32);
		if (str.length() == 1)
			return str;
		if (indexOfSpace == -1)
			return doReverse(str.substring(0, str.length()));
		return (str.substring(0, indexOfSpace + 1).concat(" "))
				.concat(doPartialReverse(str.substring(indexOfSpace + 1,
						str.length())));
	}

	public static void main(String[] args) {
		System.out.println(StringReverse.doReverse(new String("Hello")));
		System.out.println(StringReverse.doPartialReverse(new String(
				"Today is sunny")));
	}

}
