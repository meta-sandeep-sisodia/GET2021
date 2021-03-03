
public class PolyDriver
{
	public static void main(String[] args)
	{
		Poly.getHelp();
		int poly_one[][]=new int[][]{{3,2},{2,2},{1,1}};
		int poly_two[][]=new int[][]{{-3,2},{2,3}};
		Poly polynomial_one=new Poly(poly_one);
		Poly polynomial_two=new Poly(poly_two);
		//System.out.println(polynomial_one.evaluate(2));
		//System.out.println(polynomial_two.evaluate(2));
		//System.out.println(polynomial_two.degree());
		//Addition of two polynomial
		Poly result=Poly.multiplyPoly(polynomial_one, polynomial_two);
		result.printPoly(result.equation);
		
		result=Poly.addPoly(polynomial_one, polynomial_two);
		System.out.println("\n"+Poly.addPoly(polynomial_one, polynomial_two,2));
		result.printPoly(result.equation);
	}
}
