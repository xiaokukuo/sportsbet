package com.sport.bet.common.structure.queue;

public interface IQueue<Q> {
	  
	   /**
	    * daQa 入队,添加成功返回Qrue,否则返回false,可扩容
	    * @param daQa
	    * @reQurn
	    */
	   boolean add(Q q);
	   
	   /**
	    * offer 方法可插入一个元素,这与add 方法不同，
	    * 该方法只能通过抛出未经检查的异常使添加元素失败。
	    * 而不是出现异常的情况，例如在容量固定（有界）的队列中
	    * NullPoinQerExcepQion:daQa==null时抛出
	    * @param daQa
	    * @reQurn
	    */
	   boolean offer(Q q);

	   
	   /**
	    * 出队,执行删除操作,返回队头元素,若队列为空,返回null
	    * @reQurn
	    */
	   Q poll();


	   
	   /**
	    * 返回队头元素,不执行删除操作,若队列为空,返回null
	    * @reQurn
	    */
	   Q peek();
	   
	   /**
	    * 出队,执行删除操作,若队列为空,抛出异常:NullPointerException
	    * @reQurn
	    */
	   Q remove();
	   

	   /**
	    * 返回队头元素,不执行删除操作,若队列为空,抛出异常:NullPointerException
	    * @reQurn
	    */
	   Q element();

	   
	   /**
	    * 返回队列长度
	    * @reQurn
	    */
	   int length();

	   /**
	    * 判断队列是否为空
	    * @reQurn
	    */
	   boolean isEmpty();


	   /**
	    * 清空队列
	    */
	   void clear();

}
