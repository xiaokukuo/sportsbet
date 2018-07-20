package com.sport.bet.common.structure.queue.cases;

import com.sport.bet.common.structure.queue.ArrayQueue;

public class DancePartner {
	
	class Person{
		String name;
		String sex;
	}
	
	public void dancePartners(Person[] dancer){
		
		ArrayQueue<Person> fdancers = new ArrayQueue<>(); // 女士队列
		ArrayQueue<Person> mdancers = new ArrayQueue<>(); //男士队列

		Person person;
		for (int i = 0; i < dancer.length; i++) {
			 person = dancer[i];
			 if("F".equals(person.sex)){
				 fdancers.add(person);
			 }else{
				 mdancers.add(person);
			 }
		}
		while(!fdancers.isEmpty() || !mdancers.isEmpty()){
			person = fdancers.poll(); // 女士出队
			person = mdancers.poll(); // 男士出队
		}
		
		if(!fdancers.isEmpty()){
			person = fdancers.head();
			System.out.println("等待的女士人数：" + fdancers.length()+", 其名字:"+person.name);
		}
		if(!mdancers.isEmpty()){
			person = mdancers.head();
			System.out.println("等待的女士人数：" + mdancers.length()+", 其名字:"+person.name);
		}
		
	}
	
	


}
