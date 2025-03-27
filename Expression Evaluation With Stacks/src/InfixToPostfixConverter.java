import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfixConverter {
	private static final Map<String,Integer> type = new HashMap<>();
	private static final Map<String,Integer> precedence = new HashMap<>();

	static {
		type.put("+",1);
		type.put("-",1);
		type.put("*",1);
		type.put("/",1);
		type.put("(",2);
		type.put(")",3);

		precedence.put("(",0);
		precedence.put("+",1);
		precedence.put("-",1);
		precedence.put("*",2);
		precedence.put("/",2);
	}

	public static String convert(String infixExpression){
		Stack<String> stack = new Stack<String>();
		Stack<String> output = new Stack<String>();

		Pattern pattern = Pattern.compile("(\\d*\\.?\\d+|\\S)");
		Matcher matcher = pattern.matcher(infixExpression);
		while (matcher.find()){
			String token = matcher.group();

			int token_type = 0;
			if (type.containsKey(token)){
				token_type = type.get(token);
			}

			switch (token_type){
				default: // is number
					output.push(token);
					break;
				case 1: // is operator
					while(!stack.isEmpty() && precedence.get(stack.peek()) > precedence.get(token)){
						output.push(stack.pop());
					}
					stack.push(token);
					break;
				case 2: // left bracket
					stack.push(token);
					break;
				case 3: // right bracket
					while(!stack.isEmpty() && type.get(stack.peek()) != 2){
						output.push(stack.pop());
					}
					stack.pop(); // discard left parenthesis
					break;
			}
		}
		while (!stack.isEmpty()){
			output.push(stack.pop());
		}

		String finalOutput = "";
		while (!output.isEmpty()){
			finalOutput = output.pop() + " " + finalOutput;
		}
		return finalOutput;
	}

	public static double evaluate(String infixExpression){
		Stack<String> stack = new Stack<String>();
		// convert to tokens
		Pattern pattern = Pattern.compile("(\\d*\\.?\\d+|\\S)");
		Matcher matcher = pattern.matcher(infixExpression);

		while (matcher.find()){
			String token = matcher.group();
			if (!precedence.containsKey(token)){ // is number
				stack.push(token);
			}else{// is operator
				double b = Double.parseDouble(stack.pop());
				double a = Double.parseDouble(stack.pop());
				double result = 0;
				switch (token){
					case "+":
						result = a + b;
						break;
					case "-":
						result = a - b;
						break;
					case "*":
						result = a * b;
						break;
					case "/":
						result = a / b;
						break;

				}
				stack.push(String.valueOf(result));
			}
		}
		return Double.parseDouble(stack.pop());
	}
}
