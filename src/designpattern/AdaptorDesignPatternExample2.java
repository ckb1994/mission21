package designpattern;

public class AdaptorDesignPatternExample2 {

	public static void main(String[] args) {
		PilotPen ppen= new PilotPen();
		Pen pp = new PenAdapter(ppen);
		AssignmentWork aw = new AssignmentWork();
		aw.setP(pp);
		aw.writeAssignment("Let me do it");
	}
}


interface Pen{
	public void write(String str);
}

//use this with adaptor
class PilotPen{
	public void mark(String str) {
		System.out.println(str);
	}
}

class AssignmentWork{
	private Pen p;
	public Pen getP() {
		return p;
	}
	public void setP(Pen p) {
		this.p = p;
	}

	public void writeAssignment(String str) {
		p.write(str);
	}
}

class PenAdapter implements Pen{

	PilotPen pp;
	
	public PenAdapter(PilotPen pp) {
		this.pp =pp;
	}
	
	@Override
	public void write(String str) {
		pp.mark(str);
	}
	
}