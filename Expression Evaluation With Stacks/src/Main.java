

public class Main {
	public static void main(String[] args) {
		String infix = "(18 / 3) + (4 * (5 - 2))";
		String postfix = InfixToPostfixConverter.convert(infix);

		System.out.println("Infix: " + infix);
		System.out.println("Postfix: " + postfix);
		System.out.println("Answer:" + InfixToPostfixConverter.evaluate(postfix));
	}
}