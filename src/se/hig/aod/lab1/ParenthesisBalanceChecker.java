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
    /**
     * Checks the parenthesis-balance of provided string
     * 
     * @param uttryck
     *            string to check
     * @return {@link Result} of the check
     */
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

            for (int i = 0; i < charStackLength; i++)
            {
                errors[i] = charStack.pop().position;
            }

            return new Result(errors);
        }

        return new Result(mappings);
    }

    /**
     * Result from parenthesis balance check
     * 
     * @author ndi14vhp
     */
    static class Result
    {
        /**
         * Is it balanced?
         */
        public final boolean balanced;

        /**
         * Mappings for open and close parenthesis
         */
        public final HashMap<Parenthesis, Parenthesis> mappings;
        /**
         * Array with unbalanced parenthesis
         */
        public final int[] errorAt;

        /**
         * Result of balance check (balanced)
         * 
         * @param mappings
         *            between open and close parenthesis
         */
        public Result(HashMap<Parenthesis, Parenthesis> mappings)
        {
            balanced = true;
            errorAt = null;
            this.mappings = mappings;
        }

        /**
         * Result of balance check (unbalanced)
         * 
         * @param errorAt
         *            array of unbalanced parenthesis
         */
        public Result(int[] errorAt)
        {
            this.balanced = false;
            this.errorAt = errorAt;
            this.mappings = new HashMap<Parenthesis, Parenthesis>();
        }
    }

    /**
     * Representation for a parenthesis
     * 
     * @author ndi14vhp
     */
    static class Parenthesis
    {
        /**
         * Open-parenthesis (true) or Close-parenthesis (false)?
         */
        public final boolean open;
        /**
         * The position of this parenthesis
         */
        public final int position;

        /**
         * Representation of a parenthesis
         * @param open Open-parenthesis (true) or Close-parenthesis (false)?
         * @param position The position of this parenthesis
         */
        public Parenthesis(boolean open, int position)
        {
            this.open = open;
            this.position = position;
        }
    }
}
