package com.sport.bet.common.structure.stack.utils;

import com.sport.bet.common.structure.stack.LinkStack;

public class ExpressionStack<E> {

	LinkStack<E> operandStack = new LinkStack<E>(); // 存放操作数的栈
	LinkStack<Character> operatorStack = new LinkStack<Character>();// 存放运算符的栈

	@SuppressWarnings("unchecked")
	public E evaluateExpression(String expression) {
		char[] charArr = expression.toCharArray(); // 将字符串分割成单个字符

		for (char c : charArr) {
			if (c == ' ') { // 如果字符串为空，则跳过此次循环
				continue;
			}else if(c == '+' || c == '-'){
                //如果字符串为"+"或者"-"，则执行栈中已存数据的加减乘除计算
                while(!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                        operatorStack.peek() == '-' ||
                        operatorStack.peek() == '*' ||
                        operatorStack.peek() == '/')){
                    processOneOperator();
                }
                operatorStack.push(c);//将操作符压入操作符栈中
            }else if(c == '*' || c == '/'){
                //如果字符串为"*"或者"/"，则执行栈中已存数据的乘除计算
                while(!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' ||
                        operatorStack.peek() == '/')){
                    processOneOperator();
                }
                operatorStack.push(c);
            }else if(c == '('){
                //如果遇到左括号，则将左括号压入操作符栈中
                operatorStack.push('(');
            }else if(c == ')'){
                //如果遇到右括号，则计算栈中的数据，直到遇到左括号为止
                while(operatorStack.peek() != '('){
                    processOneOperator();
                }
                operatorStack.pop();//将进行过计算的左括号弹出
            }else{
            	Integer inte = Integer.parseInt(Character.toString(c));
                operandStack.push((E)inte);
            	
            }
        }
        //对栈中数据进行计算，知道栈为空为止
        while(!operatorStack.isEmpty()){
            processOneOperator();
        }
        //此时操作数栈中的栈顶元素也就是计算结果
        return operandStack.pop();
	}
	
	/**
     * 对操作符栈顶的一个操作符进行计算
     * @param operandStack
     * @param operatorStack
     */
    @SuppressWarnings("unchecked")
	public void processOneOperator(){
        char op = operatorStack.pop();     //取操作符的栈顶元素
        E op1 = operandStack.pop();    //取操作数的栈顶元素
        E op2 = operandStack.pop();    //取操作数的栈顶元素
        if( op1 instanceof Integer){
        	Integer result;
    		if(op == '+'){                    //如果操作数为+，则执行两个操作数的求和操作，并将结果压入操作数栈中
    			result = (int) op1 + (int) op2;
    			operandStack.push((E)result);
            }else if(op == '-'){
            	result = (int) op2 - (int) op1;
                operandStack.push((E)result);
            }else if(op == '*'){
            	result = (int) op2 * (int) op1;
                operandStack.push((E)result);
            }else if(op == '/'){
            	result = (int) op2 / (int) op1;
                operandStack.push((E)result);
            }else if(op == '^'){
            	result = (int) op2 / (int) op1;
                operandStack.push((E)result);
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
		
		ExpressionStack<Double> a = new ExpressionStack<Double>();
		System.out.println("7+(1+1)*2 = " + a.evaluateExpression("7+(1+1)*2"));
	}

}
