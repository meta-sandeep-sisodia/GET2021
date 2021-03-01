/*
	Implement the immutable class Poly using an array to represent single variable polynomial.
	Note that you should be storing only those terms of polynomial that have non zero coefficient.
	You can assume that the coefficients are integers
	It should support methods like - 
	1- evaluate(float) - return the value of the polynomial for the given value of the variable
	2- degree() - return the degree of the polynomial
	3- addPoly(Poly p1, Poly p2) - return the sum of the polynomials p1 and p2
	4- multiplyPoly(Poly p1, Poly p2) - return the product of polynomials p1 and p2
	
	You may use private helper methods. addPoly() and multiplyPoly()
	can make assumptions about size of the resulting polynomial to decide about the size of the array to be created.
 */

/**
 * @author sandeep.sisodia_meta
 * // Commenting in draft
 */
public class Poly
{
	final int equation[][];
	
	public static void main(String[] args)
	{
		getHelp();
	}
	
	/**
	 * @param equation
	 */
	public Poly(int[][] equation)
	{
		if(validateInput(equation)==false)
		{
			System.out.println("Invalid Input : Should not contain 0");
			this.equation=null;
			System.exit(-1);
		}
		else
		{
			this.equation=equation;
		}
	}
	
	
	/**
	 * @param equation
	 */
	public Poly(int[] equation)
	{
		int arr[][]=to2DArray(equation);
		if(validateInput(arr)==false)
		{
			System.out.println("Invalid Input : Should not contain 0");
			this.equation=null;
			System.exit(-1);
		}
		else
		{
			this.equation=arr;
		}
	}
	
	
	/**
	 * @param equation
	 */
	public void printPoly(int[][] equation)
	{
		for(int loop_var=0;loop_var<equation.length;loop_var++)
		{
			System.out.print((loop_var==0?"":getSymbol(equation[loop_var][0]))+Math.abs(equation[loop_var][0])+"x"+getSuperEquivalent(equation[loop_var][1]));
		}
	}
	
	
	/**
	 * @param i
	 * @return
	 */
	
	
	/**
	 * 
	 */
	public static void getHelp()
	{
		System.out.println("Polynomial Operation Avaliable");
		System.out.println("Poly obj.evaluate(float)");
		System.out.println("Poly obj.degree()");
		System.out.println("Poly.addPoly(Poly p1, Poly p2)  --static method");
		System.out.println("Poly.multiplyPoly(Poly p1, Poly p2) --static method");
		System.out.println("Poly obj.printPoly(int[][] equation)\n\n\n");
	}
	
	
	
	/**
	 * @param i
	 * @return
	 */
	private String getSymbol(int i)
	{
		return i>0?" + ":" - ";
	}
	

	/**
	 * @param value
	 * @return
	 */
	private String getSuperEquivalent(int value)
	{
		switch(value)
		{
		case 2:return "\u00b2";
		case 3:return "\u00b3";
		default:return "^"+String.valueOf(value);
		}
	}
	
	
	/**
	 * @param equation
	 * @return
	 */
	private boolean validateInput(int[][] equation)
	{
		for(int loop_var=0;loop_var<equation.length;loop_var++)
		{	
			//System.out.println(equation[loop_var][0]+", "+equation[loop_var][1]);
			if(equation[loop_var][0]==0||equation[loop_var][1]==0)
			{
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * @param equation
	 * @return
	 */
	public int[][] to2DArray(int[] equation)
	{
		int arr[][]=new int[equation.length/2][2];
		for(int loop_var=0;loop_var<arr.length;)
		{
			arr[loop_var][0]=equation[(loop_var*2)];
			arr[loop_var][1]=equation[(loop_var*2)+1];
		}
		return arr;
	}
	
	
	/**
	 * @param variable
	 * @return
	 */
	public float evaluate(float variable)
	{
		float value=0;
		for(int loop_var=0;loop_var<equation.length;loop_var++)
		{
			value+=equation[loop_var][0]*(Math.pow(variable, equation[loop_var][1]));
		}
		return value;
	}
	
	
	/**
	 * @return
	 */
	public int degree()
	{
		int max=0;
		for(int loop_var=0;loop_var<equation.length;loop_var++)
		{
			max=equation[loop_var][1]>max?equation[loop_var][1]:max;
		}
		return max;
	}
	
	
	/**
	 * @param p1 object reference polynomial 1
	 * @param p2 object reference polynomial 2
	 * @param variable variable in polynomial
	 * @return addition of polynomial 1 and polynomial 2
	 */
	public static float addPoly(Poly p1, Poly p2, float variable)
	{
		return p1.evaluate(variable)+p2.evaluate(variable);
	}
	
	
	/**
	 * @param p1
	 * @param p2
	 * @return 
	 */
	public static Poly addPoly(Poly p1, Poly p2)
	{
		int result[][]=new int[p1.equation.length+p2.equation.length][2];
		result=condensePoly(result,p1);
		result=condensePoly(result,p2);
		return new Poly(trimArray(result));
	}
	
	
	/**
	 * @param p1 object reference polynomial 1
	 * @param p2 object reference polynomial 2
	 * @param variable value of polynomial for which it need to be evaluated and multiplied
	 * @return multiplication of polynomial 1 and polynomial 2
	 */
	public static float multiplyPoly(Poly p1, Poly p2, float variable)
	{
		return p1.evaluate(variable)+p2.evaluate(variable);
	}
	
	
	/**
	 * @param p1 object reference polynomial 1
	 * @param p2 object reference polynomial 2
	 * @return object reference to result
	 */
	public static Poly multiplyPoly(Poly p1, Poly p2)
	{
		int index=0;
		int result[][]=new int[p1.equation.length*p2.equation.length][2];
		for(int loop_var=0;loop_var<p1.equation.length;loop_var++)
		{
			for(int inner_loop_var=0;inner_loop_var<p2.equation.length;inner_loop_var++)
			{
				result[index][0]=p1.equation[loop_var][0]*p2.equation[inner_loop_var][0];
				result[index][1]=p1.equation[loop_var][1]+p2.equation[inner_loop_var][1];
				index++;
			}
			
		}
		result=condensePoly(new int[result.length][2],new Poly(result));
		return new Poly(trimArray(result));
	}
	
	
	/**
	 * @param result array in which condensing is done
	 * @param poly object reference of array which need to be condensed
	 * @return result after condensing/merging poly equation to it
	 */
	private static int[][] condensePoly(int result[][],Poly poly)
	{
		for(int loop_var=0;loop_var<poly.equation.length;loop_var++)
		{
			int index=0;
			for(int temp=0;temp<result.length;temp++)
			{
				if(poly.equation[loop_var][1]==result[temp][1]||result[temp][0]==0)
				{
					index=temp;
					temp=result.length+1;
				}
			}
			result[index][0]=result[index][0]+poly.equation[loop_var][0];
			result[index][1]=poly.equation[loop_var][1];
		}
		return result;
	}
	
	
	/**
	 * @param array which needs to be trimmed
	 * @return trimmed array
	 */
	private static int[][] trimArray(int array[][])
	{
		int index;
		for(index=0;index<array.length;index++)
		{
			if(array[index][0]==0||array[index][0]==0)
			{
				break;
			}
		}
		int result[][]=new int[index][2];
		for(int loop_var=0;loop_var<index;loop_var++)
		{
			result[loop_var][0]=array[loop_var][0];
			result[loop_var][1]=array[loop_var][1];
		}
		return result;
	}
}
