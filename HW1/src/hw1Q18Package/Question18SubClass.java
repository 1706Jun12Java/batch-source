package hw1Q18Package;

public class Question18SubClass extends Question18SuperClass{
	public static void main(String[] args) {
	}

	@Override
	void checkCase(String str) {
		for(int i = 0; i<str.length();i++){
			if(str.charAt(i) == str.toUpperCase().charAt(i)){
				System.out.println("True. Has uppercase.");
			}else{
				System.out.println("False. No uppercase.");
			}
		}
	}

	@Override
	void toLower(String str) {
		System.out.println(str.toLowerCase());
	}

	@Override
	void toIntPlusTen(String str) {
		int num = Integer.parseInt(str)+10;
		System.out.println(num);
	}

}
