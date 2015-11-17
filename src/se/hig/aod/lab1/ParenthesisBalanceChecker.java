package se.hig.aod.lab1;

import java.util.HashMap;

/**
 * En klass som använder sig av en stack för att kontrollera parentesuttryck.
 * 
 * @author Viktor Hanstorp (ndi14vhp@student.hig.se) <br>
 * <br>
 *         Based on work by: Magnus Blom, Peter Jenke
 */
public class ParenthesisBalanceChecker
{
    public static Result checkBalance(String uttryck)
    {
        Stack<Parenthesis> charStack = new ListStack<Parenthesis>();
        int charStackLength = 0;

        HashMap<Parenthesis, Parenthesis> mappings = new HashMap<Parenthesis, Parenthesis>();

        for (int i = 0; i < uttryck.length(); i++)
        {
            char c = uttryck.charAt(i);
            switch (c)
            {
            case '(':
                charStack.push(new Parenthesis(true, i));
                charStackLength++;
                break;
            case ')':
                if (charStack.isEmpty())
                    return new Result(new int[] { i });

                Parenthesis from = charStack.pop();
                charStackLength--;

                if (!from.open)
                    return new Result(new int[] { i });

                mappings.put(from, new Parenthesis(false, i));

                break;
            }
        }
        
        if (!charStack.isEmpty())
        {
            
            int[] errors = new int[charStackLength];
            
            for(int i = 0;i < charStackLength;i++)
            {
                errors[i] = charStack.pop().position;
            }
            
            return new Result(errors);
        }

        return new Result(mappings);
    }

    static class Result
    {
        public final boolean balanced;

        public final HashMap<Parenthesis, Parenthesis> mappings;
        public final int[] errorAt;

        public Result(HashMap<Parenthesis, Parenthesis> mappings)
        {
            balanced = true;
            errorAt = null;
            this.mappings = mappings;
        }

        public Result(int[] errorAt)
        {
            this.balanced = false;
            this.errorAt = errorAt;
            this.mappings = new HashMap<Parenthesis, Parenthesis>();
        }
    }

    static class Parenthesis
    {
        public final boolean open;
        public final int position;

        public Parenthesis(boolean open, int position)
        {
            this.open = open;
            this.position = position;
        }
    }
}
