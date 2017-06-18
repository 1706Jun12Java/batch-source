package com.homework1.q19;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i=1;i<11;i++){
			l.add(i);
		}
		//display ArrayList
		System.out.println(l.toString());
		int odds = 0;
		int evens = 0;
		
		for(int i: l){
			if(i%2==0){
				evens+=i;
			} else {
				odds+=i;
			}
		}
		
		System.out.println(evens);
		System.out.println(odds);
		
		// example using predicate
//		Predicate<Integer> pred = p->isPrime(p);
//		l.removeIf(pred);
		
		
		for(Iterator<Integer> i=l.iterator();i.hasNext();){
			if(isPrime(i.next())){
				i.remove();
			}
		}
		
		System.out.println(l.toString());
		
	}
	
	public static boolean isPrime(int n){
		if(n<2){
			return false;
		}
		if((n==2) || (n==3)){
			return true;
		}else{
			for(int i=2; i<=n/2; i++){
				if(n%i==0){
					return false;
				}
			}
		}
		return true;
	}

}
