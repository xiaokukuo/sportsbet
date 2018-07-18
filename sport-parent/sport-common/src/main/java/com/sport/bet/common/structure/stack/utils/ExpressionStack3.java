package com.sport.bet.common.structure.stack.utils;

import com.sport.bet.common.structure.stack.LinkStack;

public class ExpressionStack3<E> {
	
	volatile Class<E> clazz;

	LinkStack<String> operandStack = new LinkStack<String>(); // 存放操作数的栈
	LinkStack<Character> operatorStack = new LinkStack<Character>();// 存放运算符的栈

	public String evaluateExpression(String expression) {
		char[] charArr = expression.toCharArray(); // 将字符串分割成单个字符

		for (char c : charArr) {
			if (' ' == c) {
				continue;
			}
			if (isOperator(c)) {  // 为运算符
				if (operatorStack.isEmpty()) {
					operatorStack.push(c);
				}else{
					char ac = operatorStack.pop();
					if(priority(c) > priority(ac)){
						operatorStack.push(c);
					}else{
						processOneOperator();
						operatorStack.push(c);
					}
					
				}
				System.err.println(operatorStack.toString());
				
			}else{
				operandStack.push(String.valueOf(c));
				System.err.println(operandStack.toString());
			}
		}
        
        return operandStack.pop();
	}
	
	
    
	public void processOneOperator(){
        char op = operatorStack.pop();     //取操作符的栈顶元素
        int op1 = Integer.parseInt(operandStack.pop());    //取操作数的栈顶元素
        int op2 = Integer.parseInt(operandStack.pop());    //取操作数的栈顶元素
    	Integer result = null;
		if(op == '+'){                    //如果操作数为+，则执行两个操作数的求和操作，并将结果压入操作数栈中
			result =  op1 + op2;
        }else if(op == '-'){
        	result = op2 - op1;
        }else if(op == '*'){
        	result =  op2 * op1;
        }else if(op == '/'){
        	result = (int) op2 / (int) op1;
        }
		operandStack.push(result.toString());
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
	
	public void test(){
		E e = null;
		e.getClass();
		//System.out.println(clazz.getName());
		//System.out.println(clazz.equals(Integer.class));
	}

	public static void main(String[] args) {
		
		ExpressionStack3<Integer> a = new ExpressionStack3<Integer>();
		
		String str = a.evaluateExpression("2+3*5");
		
		System.out.println("7+(1+1)*2 = " + str);
		
	}

}
