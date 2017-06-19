package question18;

public class Circle extends Shapes {
private String cir = "I am a circle.";
	public Circle() {
		princt();
	}
	@Override
	String uppercase(String a) {
		return super.uppercase(a);
	}
	@Override
	String lowercase(String b) {
		return super.lowercase(b);
	}
	@Override
	int add10(int a) {
		// TODO Auto-generated method stub
		return super.add10(a);
	}
	@Override
	public String getShape() {
		// TODO Auto-generated method stub
		return super.getShape();
	}
	@Override
	public void setShape(String shape) {
		// TODO Auto-generated method stub
		super.setShape(shape);
	}
	
	public void princt() {
		System.out.println(cir);
	}

}
