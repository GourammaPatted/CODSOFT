package com;

public class Carr {
	String brand;
	String id;

	static int count=101;
	public Carr(String brand) {
		this.brand=brand;
		this.id="A"+count;
		count++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carr c1=new Carr("Honda");
		System.out.println(c1.brand+" "+c1.id);
		Carr c2=new Carr("Suzuki");
		System.out.println(c2.brand+" "+c2.id);
		Carr c3=new Carr("Toyota");
		System.out.println(c3.brand+" "+c3.id);
		Carr c4=new Carr("Ambassidor");
		System.out.println(c4.brand+" "+c4.id);
		Carr c5=new Carr("Lamborgini");
		System.out.println(c5.brand+" "+c5.id);
	}

}
