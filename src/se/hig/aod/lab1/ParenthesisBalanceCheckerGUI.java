package se.hig.aod.lab1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * @author Viktor Hanstorp (ndi14vhp@student.hig.se)
 */
@SuppressWarnings("serial")
public class ParenthesisBalanceCheckerGUI extends JFrame
{
    private JPanel contentPane;
    private JTextField textField;
    private JTextPane textPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    ParenthesisBalanceCheckerGUI frame = new ParenthesisBalanceCheckerGUI();
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ParenthesisBalanceCheckerGUI()
    {
        setTitle("Parenthesis balance checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 690, 124);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JButton btnCheck = new JButton("Check");
        btnCheck.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                ParenthesisBalanceChecker.Result result = ParenthesisBalanceChecker.checkBalance(textField.getText());

                // Inspiration from:
                // http://stackoverflow.com/a/5857747

                textPane.setText(textField.getText());
                textPane.setCaretPosition(0);
                textPane.moveCaretPosition(textField.getText().length());
                textPane.setCharacterAttributes(getColor(Color.BLACK), true);

                if (!result.balanced)
                {
                    for (int i : result.errorAt)
                    {
                        textPane.setCaretPosition(i);
                        textPane.moveCaretPosition(i + 1);
                        textPane.setCharacterAttributes(getColor(Color.RED), true);
                    }

                    textPane.setCaretPosition(result.errorAt[result.errorAt.length - 1]);
                    textPane.moveCaretPosition(textField.getText().length());
                    textPane.setCharacterAttributes(getColor(Color.RED), true);
                }

                for (int i = 0; i < textPane.getText().length() - 1; i++)
                    if (textPane.getText().charAt(i) == '\\' && (textPane.getText().charAt(i + 1) == '(' || textPane.getText().charAt(i + 1) == ')'))
                    {
                        textPane.setCaretPosition(i);
                        textPane.moveCaretPosition(i + 2);
                        textPane.setCharacterAttributes(getColor(Color.BLUE), true);
                    }

                if (result.balanced)
                    JOptionPane.showMessageDialog(ParenthesisBalanceCheckerGUI.this, "This string have balanced parenthesis", "Result", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(ParenthesisBalanceCheckerGUI.this, "This string have unbalanced parenthesis", "Result", JOptionPane.WARNING_MESSAGE);

            }
        });
        contentPane.add(btnCheck, BorderLayout.CENTER);

        textField = new JTextField();
        contentPane.add(textField, BorderLayout.NORTH);
        textField.setColumns(10);

        textPane = new JTextPane();
        textPane.setEditable(false);
        contentPane.add(textPane, BorderLayout.SOUTH);
    }

    HashMap<Color, AttributeSet> attributes = new HashMap<Color, AttributeSet>();

    AttributeSet getColor(Color color)
    {
        if (attributes.containsKey(color))
            return attributes.get(color);

        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet result = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        result = sc.addAttribute(result, StyleConstants.FontFamily, "TIMES NEW ROMAN");

        attributes.put(color, result);

        return result;
    }
}
