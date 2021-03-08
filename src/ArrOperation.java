public class ArrOperation
{
    private int array[];
    // Parameterized constructor
    public ArrOperation(int array[])
    {
        if(array.length>0)
        {
            this.array = array;
        }
        else
        {
            System.out.println("Can not perform operations on null array");
            System.exit(-1);
        }
    }

    // Getter
    public int[] getArray()
    {
        return array;
    }

    // Setter
    public void setArray(int[] array)
    {
        this.array = array;
    }

    // Main function
    public static void main(String[] args)
    {
        getHelp();
    }

    public static void getHelp()
    {
        System.out.printf("%-20s%s\n","printArray()","- Print array");
        System.out.printf("%-20s%s\n","maxMirror()","- Return the size of the largest mirror section found in the input array.");
        System.out.printf("%-20s%s\n","countClumps()","- Return the number of clumps in the input array.");
        System.out.printf("%-20s%s\n%22s%s\n","fixXY(int x, int y)","- Return an array that contains exactly the same numbers as the input array,","","but rearranged so that every X is immediately followed by a Y.");
        System.out.printf("%-20s%s\n%22s%s\n","splitArray()","- Return the index if there is a place to split the input array so that","","the sum of the numbers on one side is equal to the sum of the numbers on the other side else return -1");
    }

    void printArray()
    {
        for (int value:array)
        {
            System.out.print(value+", ");
        }
        System.out.println();
    }
    int maxMirror()
    {
        int max = 0;

        for(int loop_var = 0; loop_var < array.length; loop_var++)
        {
            int count = 0;
            for(int inner_loop_var = array.length - 1; inner_loop_var >= 0 && loop_var + count < array.length; inner_loop_var--)
            {
                if(array[loop_var + count] == array[inner_loop_var])
                {
                    count++;
                }
               else
                {
                    max = max>count?max:count;
                    count = 0;
                }
            }

            max = max>count?max:count;
        }

        return max;
    }

    int countClumps()
    {
        int clumps_count = 0;
        boolean flag = false;
        for (int loop_var = 1; loop_var < array.length; loop_var++)
        {
            if (array[loop_var] == array[loop_var-1])
            {
                clumps_count += (loop_var== array.length-1 ? 1 : 0);
                flag = true;
            }
            else
            {
                clumps_count += flag ? 1 : 0;
                flag=false;
            }
        }
        //clumps_count += flag ? 1 : 0;
        return clumps_count;
    }

    void fixXY(int x, int y)
    {
        int index_of_y=0;
        for(int loop_var=0;loop_var<array.length-1;loop_var++)
        {
            if(array[loop_var]==x)
            {
                boolean found_y=false;
                for(int inner_loop_var=index_of_y;inner_loop_var< array.length;inner_loop_var++)
                {
                    if(array[inner_loop_var]==y)
                    {
                        found_y=true;
                        index_of_y=inner_loop_var;
                        inner_loop_var=array.length+1; //break inner loop as soon as y if found
                    }
                }
                if(found_y)
                {
                    // Swap
                    array[loop_var + 1] += array[index_of_y];
                    array[index_of_y] = array[loop_var + 1] - array[index_of_y];
                    array[loop_var + 1] -= array[index_of_y];
                    index_of_y=loop_var+2;
                }
                else
                {
                    return;
                }
            }
        }
    }

    int splitArray()
    {
        int right_sum=0;
        int left_sum=0;
        for(int value:array)
        {
            right_sum+=value;
        }
        for(int loop_var=0;loop_var< array.length;loop_var++)
        {
            left_sum+=array[loop_var];
            right_sum-=array[loop_var];
            if(left_sum==right_sum)
            {
                return loop_var+1;
            }
        }
        return -1;
    }
}