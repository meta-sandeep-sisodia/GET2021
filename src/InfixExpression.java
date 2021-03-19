
public class InfixExpression
{
    public int evaluate(String expression)
    {
    	if(expression==null)
    	{
    		throw new AssertionError("Null String passed");
    	}
        NumberStack numbers = new NumberStack();
        OperatorStack operations = new OperatorStack();
        for(int i=0; i<expression.length();i++)
        {
            char c = expression.charAt(i);
            if(Character.isDigit(c))
            {
                int num = 0;
                while (Character.isDigit(c))
                {
                    num = num*10 + (c-'0');
                    i++;
                    if(i < expression.length())
                    {
                        c = expression.charAt(i);
                    }
                    else
                    {
                        break;
                    }
                }
                i--;
                numbers.push(num);
            }
            else if(c=='(')
            {
                operations.push(c);
            }
            else if(c==')')
            {
                while(operations.peek()!='(')
                {
                    int output = performOperation(numbers, operations);
                    numbers.push(output);
                }
                operations.pop();
            }
            else if(isOperator(c))
            {
                while(!operations.isEmpty() && precedence(c)<=precedence(operations.peek()))
                {
                    int output = performOperation(numbers, operations);
                    numbers.push(output);
                }
                operations.push(c);
            }
        }

        while(!operations.isEmpty())
        {
            int output = performOperation(numbers, operations);
            numbers.push(output);
        }
        return numbers.pop();
    }

    static int precedence(char c)
    {
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public int performOperation(NumberStack numbers, OperatorStack operations)
    {
        int a = numbers.pop();
        int b = numbers.pop();
        char operation = operations.pop();
        switch (operation)
        {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                {
                    throw new AssertionError("Cannot divide by zero");
                }
                return b / a;
        }
        return 0;
    }

    public boolean isOperator(char c)
    {
        return (c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
    }
}