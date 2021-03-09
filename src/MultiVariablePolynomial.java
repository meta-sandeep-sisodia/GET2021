import java.util.LinkedList;
public class MultiVariablePolynomial
{
    String str;
    LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();

    MultiVariablePolynomial(String str)
    {
        this.str = str;
    }

    int calculateMaxDegree()
    {
        int max = Integer.MIN_VALUE;
        processLinkedList();
        for (LinkedList<Integer> term : list)
        {
            int sum = 0;
            for (int value : term)
            {
                sum += value;
            }
            max = sum > max? sum: max;
        }
        return max;
    }

    void processLinkedList()
    {
        String[] str1 = str.split("[+-]"); //Regular expression
        for (String value : str1)
        {
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int loop_var = 0; loop_var < value.length(); loop_var++)
            {
                if (value.charAt(loop_var) == 'x' || value.charAt(loop_var) == 'y')
                {
                    if (loop_var == value.length() - 1 || value.charAt(loop_var + 1) == 'x' || value.charAt(loop_var + 1) == 'y')
                    {
                        list.add(1);
                    } else
                    {
                        list.add(Integer.parseInt("" + value.charAt(loop_var + 1)));
                    }
                }
            }
            this.list.add(list);
        }
    }

    public static void main(String[] args)
    {
        String polynomial="9x-4+2x";
        MultiVariablePolynomial poly =new MultiVariablePolynomial(polynomial);
        System.out.println("Maximum degree = "+poly.calculateMaxDegree());
    }
}