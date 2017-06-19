package Question18;

public class Methods extends AbstractClass {

	//override abstract methods from parent class
	@Override
	public boolean containsUpper(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String convertToUpper(String str) {
		return str.toUpperCase();
	}

	@Override
	public void stringToInt(String str) {
		int x = Integer.parseInt(str);
		System.out.println(x + 10);
	}

}
