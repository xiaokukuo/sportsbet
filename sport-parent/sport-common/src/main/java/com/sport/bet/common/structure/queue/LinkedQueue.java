package com.sport.bet.common.structure.queue;

/**
 * 链队列 
 * @author Yao
 *
 * @param <E>
 */
public class LinkedQueue<E> implements IQueue<E>{
	
	class QueueNode{
		
		E data;
		QueueNode next;
		
		public QueueNode(){}
		
		public QueueNode(E data, QueueNode next){
			this.data = data;
			this.next = next;
		}
	}
	
	private QueueNode front;
	
	private QueueNode rear;
	
	public LinkedQueue(){
		front = new QueueNode();
		front.next = null;
		rear = front;
	}

	@Override
	public boolean add(E e) {
		//在链队列中，插入x为新的队尾元素
		QueueNode s = new QueueNode();
		s.data = e;
		s.next = null;
		
		rear.next = s;
		rear = s;
		return true;
	}

	@Override
	public boolean offer(E e) {
		//在链队列中，插入x为新的队尾元素
		QueueNode s = new QueueNode(e, null);
		rear.next = s;
		rear = s;
		s = null;
		return true;
	}

	@Override
	public E poll() {
		if(isEmpty()){
			return null;
		}
		// 若链队不为空, 则删除对头元素并返回元素的值
		QueueNode p = front.next;
		front.next = p.next;
		if(p.next == null){
			rear = front; //当链队列仅有一个结点时，出队时还需要修改队尾指针
		}
		E e = p.data;
		p = null;
		return e;
	}
	
	@Override
	public E remove() {
		if(isEmpty()){
			throw new NullPointerException();
		}
		// 若链队不为空, 则删除对头元素并返回元素的值
		QueueNode p;
		E e;
		p = front.next;
		front.next = p.next;
		if(p.next == null){
			rear = front; //当链队列仅有一个结点时，出队时还需要修改队尾指针
		}
		e = p.data;
		p = null;
		return e;
	}


	@Override
	public E head() {
		if(isEmpty()){
			return null;
		}
		return front.next.data;
	}
	
	@Override
	public E element() {
		if(isEmpty()){
			throw new NullPointerException();
		}
		return front.next.data;
	}

	@Override
	public int length() {
		int i = 0;
		QueueNode p = front.next;
		while(p != null){
			i++;
			p = p.next;
		}
		return i;
	}

	@Override
	public boolean isEmpty() {
		return rear == front ? true :false;
	}

	@Override
	public void clear() {
		front.next = null;
		rear = front;
	}
	
	public String toString(){
		if(isEmpty()){
			return "[]";
		}
		QueueNode p = front.next;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while(p != null){
			sb.append(p.data.toString() + ", ");
			p = p.next;
		}
		int len = sb.length();
		return sb.delete(len - 2, len).append("]").toString();
	}
	
	public static void main(String[] args) {
		LinkedQueue<String> ql = new LinkedQueue<String>();
		for (int i = 0; i < 2; i++) {
			ql.add(i+"");
		}
		System.out.println(ql.toString());
		for (int i = 0; i < 1; i++) {
			System.out.println(ql.poll());
		}
		System.out.println(ql.toString());
		
	}

}
