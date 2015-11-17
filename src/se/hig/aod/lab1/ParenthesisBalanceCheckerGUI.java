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

/**
 * @author ndi14vhp
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
                System.out.println(result.balanced);
                if (result.balanced)
                {
                    textPane.setText(textField.getText());
                    JOptionPane.showMessageDialog(ParenthesisBalanceCheckerGUI.this, "This string have balanced parenthesis", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    textPane.setText(textField.getText());
                    
                    System.out.println(result.errorAt.length);

                    StyleContext sc = StyleContext.getDefaultStyleContext();
                    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED);
                    aset = sc.addAttribute(aset, StyleConstants.FontFamily, "TIMES NEW ROMAN");

                    for (int i : result.errorAt)
                    {
                        textPane.setCaretPosition(i);
                        textPane.moveCaretPosition(i + 1);
                        textPane.setCharacterAttributes(aset, true);
                    }
                    
                    JOptionPane.showMessageDialog(ParenthesisBalanceCheckerGUI.this, "This string have unbalanced parenthesis", "Result", JOptionPane.WARNING_MESSAGE);
                }
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

}
