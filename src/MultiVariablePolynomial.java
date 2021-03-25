import java.util.ArrayList;
import java.util.LinkedList;
public class MultiVariablePolynomial
{
    String str;
    LinkedList<LinkedList<String>> list = new LinkedList<LinkedList<String>>();

    MultiVariablePolynomial(String str)
    {
        this.str = str;
        processLinkedList();
    }
    
    void printPolynomial()
    {
    	for (LinkedList<String> term : list)
        {
            for (String value : term)
            {
            	System.out.print(value);
            }
            System.out.print(" ");
        }
    }

    int calculateMaxDegree()
    {
        int max = Integer.MIN_VALUE;
        for (LinkedList<String> term : list)
        {
            int sum = 0;
            int index=0;
            for (String value : term)
            {
            	if(index!=0 && index%2==0)
            	{
            		sum += Integer.parseInt(value);
            	}
            	index++;
            }
            max = sum > max? sum: max;
        }
        return max;
    }

    

	void processLinkedList()
    {
        //String[] str1 = str.split("[+-]"); //Regular expression
        ArrayList<String> str1=new ArrayList<String>();
        String temp="";
        for(int x=0;x<str.length();x++)
        {
        	
        	if(str.charAt(x)!='-' && str.charAt(x)!='+')
        	{
        		temp+=str.charAt(x);
        	}
        	else
        	{
        		if(str!=""||str!="-"||str!="+")
        		str1.add(temp);
        		temp=Character.toString(str.charAt(x));
        	}
        }
        str1.add(temp);
        
        
        for (String value : str1)
        {
        	String constant="";
        	int loop_var = 0;
            LinkedList<String> list = new LinkedList<String>();
            
            
            // For constant
            while(loop_var<value.length() && isVar(value.charAt(loop_var))==false )
            {
            	constant+=value.charAt(loop_var);
            	loop_var++;
            }
            
            if(constant==""||constant=="-"||constant=="+")
            {
            	list.add("1");
            }
            else
            {
            	list.add(constant);
            }
            
            
            // For rest of expression
            for (; loop_var < value.length()-1; loop_var++)
            {
                if (isVar(value.charAt(loop_var)))
                {
                	list.add(Character.toString(value.charAt(loop_var)));
                    if(isVar(value.charAt(loop_var+1)))
                    {
                    	list.add("1");
                    }
                    else
                    {
                    	list.add(Character.toString(value.charAt(loop_var+1)));
                    }
                }
            }
            
            
            
            // Taking care of last value if left
            if(loop_var<value.length())
            {   	
            	if(isVar(value.charAt(loop_var)))
            	{
            		list.add(Character.toString(value.charAt(loop_var)));
            		list.add("1");
            	}
            }
            this.list.add(list);
        }
    }

    boolean isVar(char ch)
    {
    	return (ch >='a' && ch <= 'z');
    }
    
    public static void main(String[] args)
    {
        //String polynomial="9x-4xy2+2x+40zr4";
        String polynomial="3x2y4-5z5+x-y+20";
        MultiVariablePolynomial poly =new MultiVariablePolynomial(polynomial);
        System.out.println("Maximum degree = "+poly.calculateMaxDegree());
        //poly.printPolynomial();
    }
}