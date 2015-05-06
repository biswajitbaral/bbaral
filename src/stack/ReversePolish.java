package stack;

import java.util.Stack;

public class ReversePolish
{

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, /. Each
     * operand may be an integer or another expression. For example: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public static int docalculation(String[] input, String operators)
    {
        int totCount = 0;
        Stack<String> data = new Stack<String>();

        for (String str : input)
        {
            if (!operators.contains(str))
            {
                data.push(str);
            }
            else
            {
                int a = Integer.valueOf(data.pop());
                int b = Integer.valueOf(data.pop());

                switch (str)
                {
                case "+":
                    data.push(String.valueOf(b + a));
                    break;
                case "-":
                    data.push(String.valueOf(b - a));
                    break;
                case "*":
                    data.push(String.valueOf(b * a));
                    break;
                case "/":
                    data.push(String.valueOf(b / a));
                    break;

                }
            }

        }

        totCount = Integer.valueOf(data.pop());
        return totCount;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String[] input =
        { "2", "1", "+", "3", "*" };
        String operators = "+-*/";
        System.out.println(docalculation(input, operators));

    }

}
