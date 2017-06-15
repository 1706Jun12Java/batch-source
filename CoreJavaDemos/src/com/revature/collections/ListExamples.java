package com.revature.collections;

import java.util.*;

public class ListExamples {

	public static void main(String[] args) {
		
		List<Number> arrayList = new ArrayList<Number>();
		arrayList.add(5);
		arrayList.add(8);
		arrayList.add(0);
		arrayList.add(13);
		System.out.println("ArrayList: "+arrayList);
		System.out.println("ArrayList value at index 2: "+arrayList.get(2));
		
		//LinkedList implements List, Deque, and Queue
		List<Integer> listLinkedList = new LinkedList<>(); //List methods only
		Deque<Integer> dequeLinkedList = new LinkedList<>(); //deque methods only
		Queue<Integer> queueLinkedList = new LinkedList<>(); //queue methods only
		LinkedList<Integer> normal = new LinkedList<>(); //all methods 
		
		//instanceOf operator: compares type
		System.out.println(listLinkedList instanceof LinkedList);
		System.out.println(listLinkedList instanceof Deque);
		
		//queue example
		System.out.println("Queue: FIFO");
		System.out.println("Queue: "+queueLinkedList);
		queueLinkedList.add(7);
		System.out.println("Queue: "+queueLinkedList);
		queueLinkedList.add(62);
		System.out.println("Queue: "+queueLinkedList);
		queueLinkedList.add(3);
		System.out.println("Queue: "+queueLinkedList);
		queueLinkedList.remove();
		System.out.println("Queue: "+queueLinkedList);
		queueLinkedList.remove();
		System.out.println("Queue: "+queueLinkedList);
		queueLinkedList.remove();
		System.out.println("Queue: "+queueLinkedList);
		//queueLinkedList.remove(); NoSuchElementException
		
		System.out.println(arrayList);
		filter(arrayList);
		System.out.println(arrayList);
		
		
		
	}
	
	static void filter(Collection<Number> c){
		/*	
		for (Iterator<Number> it = c.iterator();it.hasNext();){
			if (it.next().intValue()>3){
				it.remove();
			}
		}
		*/
		Iterator<Number> it  = c.iterator();
		while (it.hasNext()){
			if (it.next().intValue()>3){
				it.remove();
			}
		}
		
	}

}
