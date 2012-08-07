package objects;

public class A {
	int a1,a2;
	public A(int a1, int a2) {
		super();
		this.a1 = a1;
		this.a2 = a2;
	}
	public int getA1() {
		return a1;
	}
	public void setA1(int a1) {
		this.a1 = a1;
	}
	public int getA2() {
		return a2;
	}
	public void setA2(int a2) {
		this.a2 = a2;
	}
	public String toString() {
		return "A [a1=" + a1 + ", a2=" + a2 + "]";
	}
}
