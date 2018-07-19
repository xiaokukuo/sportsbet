package com.sport.bet.common.structure.stack.utils;

import com.sport.bet.common.structure.stack.LinkStack;

public class ExpressionStack2<E> {

	LinkStack<E> operandStack = new LinkStack<E>(); // 存放操作数的栈
	LinkStack<Character> operatorStack = new LinkStack<Character>();// 存放运算符的栈

	public String evaluateExpression(String expression) {
		// 将算术表达式转换为后缀表达式的函数，结果一字符串的形式返回
		String postfix = new String(); // 用于储存后缀表达式
		for (int i = 0; expression != null && i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (' ' != c) {
				// 为左括号
				if (isOpenParenthesis(c)) {
					operatorStack.push(c);
				} else if (isCloseParenthesis(c)) {  // 为右括号
					char ac = operatorStack.pop();
					while (!isOpenParenthesis(ac)) {
						postfix = postfix.concat(String.valueOf(ac));
						ac = operatorStack.pop();
					}
				} else if (isOperator(c)) {  // 为运算符
					// 运算栈非空，取出栈顶优先级高的运算符送完后缀表达式
					if (!operatorStack.isEmpty()) {
						char ac = operatorStack.pop();
						// 栈取出的字符优先级比c高
						while (!operatorStack.isEmpty() && priority(ac) >= priority(c)) {
							postfix = postfix.concat(String.valueOf(ac));
							ac = operatorStack.pop();
						} // 栈取出的字符优先级比c低，则将取出的字符重新入栈
						if (ac != ' ') {
							operatorStack.push(ac);
						}
					}
					operatorStack.push(c); // 将c入栈
				} else { // 为操作数，直接串联到postfix内
					postfix = postfix.concat(String.valueOf(c));
				}
			}
		} // 当表达式读完就将算术栈pop出加入postfix
		while (!operatorStack.isEmpty()) {
			postfix = postfix.concat(String.valueOf(operatorStack.pop()));

		}
		return postfix;

	}

	/**
	 * 对操作符栈顶的一个操作符进行计算
	 * 
	 * @param operandStack
	 * @param operatorStack
	 */
	@SuppressWarnings("unchecked")
	public void processOneOperator() {
		char op = operatorStack.pop(); // 取操作符的栈顶元素
		E op1 = operandStack.pop(); // 取操作数的栈顶元素
		E op2 = operandStack.pop(); // 取操作数的栈顶元素
		if (op1 instanceof Integer) {
			Integer result;
			if (op == '+') { // 如果操作数为+，则执行两个操作数的求和操作，并将结果压入操作数栈中
				result = (int) op1 + (int) op2;
				operandStack.push((E) result);
			} else if (op == '-') {
				result = (int) op2 - (int) op1;
				operandStack.push((E) result);
			} else if (op == '*') {
				result = (int) op2 * (int) op1;
				operandStack.push((E) result);
			} else if (op == '/') {
				result = (int) op2 / (int) op1;
				operandStack.push((E) result);
			}
		}
	}

	// 判断字符为运算符
	public boolean isOperator(char c) {
		if ('+' == c || '-' == c || '/' == c || '*' == c || '%' == c || '^' == c) {
			return true;
		} else {
			return false;
		}
	}

	// 判断字符为左括号
	public boolean isOpenParenthesis(char c) {
		return c == '(';
	}

	// 判断字符为右括号
	public boolean isCloseParenthesis(char c) {
		return c == ')';
	}

	// 判断算法的优先级
	public int priority(char c) {
		if (c == '^') {
			return 3;
		}
		if (c == '/' || c == '*' || c == '%') {
			return 2;
		}
		if (c == '-' || c == '+') {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {

		ExpressionStack2<Double> a = new ExpressionStack2<Double>();
		System.out.println("7+(1+1)*2 = " + a.evaluateExpression("7+(1+1)*2"));
	}

}
