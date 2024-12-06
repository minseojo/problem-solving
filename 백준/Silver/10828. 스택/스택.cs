class Program
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        Stack<int> stack = new Stack<int>();
        for (int i = 0; i < n; i++)
        {
           String[] input = Console.ReadLine().Split();
           String command = input[0];
           switch (command)
           {
               case "push":
                   int value = int.Parse(input[1]);
                   stack.Push(value);
                   break;
               case "pop":
                   Console.WriteLine(stack.Count > 0 ? stack.Pop() : "-1");
                   break;
               case "size":
                   Console.WriteLine(stack.Count());
                   break;
               case "empty":
                   Console.WriteLine(stack.Count > 0 ? "0" : "1");
                   break;
               case "top":
                   Console.WriteLine(stack.Count > 0 ? stack.Peek() : "-1");
                   break;
               default:
                   break;
           }
        }
    }      
}
