package com.sport.bet.common.structure.stack.utils;

import com.sport.bet.common.structure.stack.LinkStack;

public class ExpressionStack<E> {
	
	LinkStack<E> operandStack = new LinkStack<E>();        //存放操作数的栈
	LinkStack<Character> operatorStack = new LinkStack<Character>();//存放运算符的栈
	
	public int evaluateExpression(String expression){
		
		String[] charArr = expression.split(""); //将字符串分割成单个字符
		
		String op = "+-*/";
		
		
		for(int i = 0; i < charArr.length; i++){
			charArr[i] = charArr[i].trim();
            if(charArr[i].equals("")){        //如果字符串为空，则跳过此次循环
                continue;
            }
            if(charArr[i].equals("+") || charArr[i].trim().equals("-")){
                //如果字符串为"+"或者"-"，则执行栈中已存数据的加减乘除计算
            }
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		String[] charArr = "7 + (1+1)*2".split("");
		for (int i = 0; i < charArr.length; i++) {
			System.out.println(charArr[i]);
		}
	}

}
