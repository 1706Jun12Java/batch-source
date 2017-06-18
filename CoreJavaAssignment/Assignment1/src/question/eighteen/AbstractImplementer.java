package question.eighteen;

public class AbstractImplementer extends AbstractHolder {

	@Override
	public boolean checkUpperCase(String s) {
		for(int i=0; i<s.length(); i++){
			if (Character.isUpperCase(s.charAt(i))){
				return true;
			}
		}
		return false;
		
	}

	@Override
	public String convertToUpperCase(String s) {
		String upperS = s.toUpperCase();
		return upperS;			
		}

	@Override
	public Integer convertStringToInteger(String s) {
		int result = Integer.parseInt(s);
		int newResult = result + 10;
		return newResult;
	}

}
