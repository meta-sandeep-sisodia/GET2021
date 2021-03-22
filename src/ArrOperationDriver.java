public class ArrOperationDriver
{
    public static void main(String[] args)
    {
        //ArrOperation.getHelp();
        ArrOperation a1=new ArrOperation(new int[]{5, 4, 1, 5, 5, 4, 1});
        System.out.printf("%-20s%s%d\n","Max Mirror"," : ",a1.maxMirror());
        System.out.printf("%-20s%s%d\n","Clumps found"," : ",a1.countClumps());
        System.out.printf("%-20s%s","Array Before fixXy"," : ");
        a1.printArray();
        a1.fixXY(4,5);
        System.out.printf("%-20s%s","Array After fixXy"," : ");
        a1.printArray();
        System.out.printf("%-20s%s%d\n","Split index"," : ",a1.splitArray());
    }
}