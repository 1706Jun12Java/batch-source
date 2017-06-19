package question18;

public class triangle extends Shapes {
private String tri= "I am a triangle";
	public triangle() {
		printb();
	}

	@Override
	String uppercase(String a) {
		// TODO Auto-generated method stub
		super.uppercase(a);
		System.out.println(a);
		return a;
	}

	@Override
	String lowercase(String b) {
		// TODO Auto-generated method stub
		super.lowercase(b);
		System.out.println(b);
		return b;
	}

	@Override
	int add10(int a) {
		// TODO Auto-generated method stub
		return super.add10(a);
	}

	public void printb() {
		// TODO Auto-generated method stub
		System.out.println(tri);
	}
	

}
