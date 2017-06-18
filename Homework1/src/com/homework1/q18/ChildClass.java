package com.homework1.q18;

public class ChildClass extends AbstractClass{

	@Override
	public boolean checkUpper(String s) {
		// TODO Auto-generated method stub
		for(int i=0;i<s.length();i++){
			if(Character.isUpperCase(s.charAt(i))){
				return true;
			}
		}
		return false;
	}

	@Override
	public String convertToUpper(String s) {
		// TODO Auto-generated method stub
		return s.toUpperCase();
	}

	@Override
	public void toInt(String s) {
		// TODO Auto-generated method stub
		System.out.println(Integer.parseInt(s)+10);
	}

}
