import java.util.Stack;



public class calculator {

	// define instances
	// infix expression
	private String infix;
	// postFix expression
	private String postFix;
	// keeps track of whether infix is converted to postFix or not
	private boolean converted = false;

	// constructor initializing the class
	public calculator(String infix) {
		this.infix = infix;
		this.postFix = "";
	}

	// toString method returning the value of infix expression
	@Override
	public String toString() {
		return this.infix;
	}

	// converts infix to post-fix
	// if conversion is successful returns true
	// else returns false
	public boolean convertPostFix() {
		postFix = "";

		try {
			// will hold the characters in a stack
			Stack<Character> charactersStack = new Stack<>();

			// check each character in the infix expression
			for (int i = 0; i < infix.length(); i++) {
				// take out the character from infix string at given index
				char character = infix.charAt(i);

				// if it is digit just add to the post-fix expression
				if (Character.isDigit(character)) {
					postFix += character;
				}
				// if character is opening bracket, add it to the stack
				else if (character == '(') {
					charactersStack.push(character);
				} else if (character == ')') {
					// if closing bracket appears, then take everything from the stack
					// add to the output result until opening bracket in stack appears
					while (!charactersStack.isEmpty() && charactersStack.peek() != '(')
						postFix += charactersStack.pop();

					// remove the opening bracket too from stack
					charactersStack.pop();
				}
				// else if the character is not space
				// which means it will be our operators +, - , /, *
				else if (character != ' ') {

					// add space
					postFix = postFix.trim() + " ";

					// take the characters from the top of the stack
					// until the current character has low precedence than the current top character
					// on stack
					while (!charactersStack.isEmpty() && precedence(character) <= precedence(charactersStack.peek())) {

						// add to the result
						postFix += charactersStack.pop();
					}
					// at the end add this operator to the stack too
					charactersStack.push(character);
				}

			}

			// pop all the operators from the stack
			while (!charactersStack.isEmpty()) {
				// after everything, if there is still opening bracket
				// it means, the conversion if not successful
				if (charactersStack.peek() == '(')
					return false;
				// add to the postFix
				postFix += charactersStack.pop();
			}

			// return true
			converted = true;
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public int evaluate() throws IllegalStateException {
		if (!converted) {
			throw new IllegalStateException("Infix not converted to postfix yet.!");
		}
		// create a stack
		Stack<Integer> stack = new Stack<>();

		// Iterator over each character
		for (int i = 0; i < postFix.length(); i++) {
			char c = postFix.charAt(i);

			if (c == ' ')
				continue;

			// if current character is number
			else if (Character.isDigit(c)) {
				int n = 0;

				// for multiple digits, scan the digits until there is no more digit
				while (Character.isDigit(c)) {
					// this is how convert character to number
					n = n * 10 + (int) (c - '0');
					i++;
					c = postFix.charAt(i);
				}
				i--;

				// push the number in stack
				stack.push(n);
			}

			// if character is not space
			// if character is not digit
			// then this is operator
			else {
				// take top two values from stack
				int val1 = stack.pop();
				int val2 = stack.pop();

				// and perform mathematical operation on this
				// according to the operator
				switch (c) {
				case '+':
					stack.push(val2 + val1);
					break;
				case '-':
					stack.push(val2 - val1);
					break;

				case '/':
					stack.push(val2 / val1);
					break;

				case '*':
					stack.push(val2 * val1);
					break;
				}
			}
		}
		// the result is stored on the top of stack
		// return the result
		return stack.pop();
	}

	// return the postFix result
	// if infix not converted to postFix, return false;
	public String getPostFix() throws IllegalStateException {
		if (!converted) {
			throw new IllegalStateException("Infix not converted to postfix yet.!");
		}
		return this.postFix;
	}

	// returns the precedence of operators
	// on top of stack
	private static int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}
}