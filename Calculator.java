import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator implements ActionListener {
    StringBuilder expression; 
    JFrame f;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
    JPanel p;
    JTextField tf;
    GridLayout g;

    Calculator() {
        expression = new StringBuilder();  
        f = new JFrame("Calculator");
        f.setLayout(new BorderLayout());
        p = new JPanel();
        tf = new JTextField(20);
        tf.setBounds(3, 3, 300, 200);
        f.add(tf, BorderLayout.NORTH);
        g = new GridLayout(4, 4, 5, 5);
        p.setLayout(g);

        b1 = new JButton("0");
        b1.addActionListener(this);
        p.add(b1);
        b2 = new JButton("1");
        b2.addActionListener(this);
        p.add(b2);
        b3 = new JButton("2");
        b3.addActionListener(this);
        p.add(b3);
        b4 = new JButton("3");
        b4.addActionListener(this);
        p.add(b4);
        b5 = new JButton("4");
        b5.addActionListener(this);
        p.add(b5);
        b6 = new JButton("5");
        b6.addActionListener(this);
        p.add(b6);
        b7 = new JButton("6");
        b7.addActionListener(this);
        p.add(b7);
        b8 = new JButton("7");
        b8.addActionListener(this);
        p.add(b8);
        b9 = new JButton("8");
        b9.addActionListener(this);
        p.add(b9);
        b10 = new JButton("9");
        b10.addActionListener(this);
        p.add(b10);
        b11 = new JButton("+");
        b11.addActionListener(this);
        p.add(b11);
        b12 = new JButton("-");
        b12.addActionListener(this);
        p.add(b12);
        b13 = new JButton("*");
        b13.addActionListener(this);
        p.add(b13);
        b14 = new JButton("/");
        b14.addActionListener(this);
        p.add(b14);
        b15 = new JButton("C");
        b15.addActionListener(this);
        p.add(b15);
        b16 = new JButton("=");
        b16.addActionListener(this);
        p.add(b16);

        f.add(p);
        f.setSize(300, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            expression.append(command);
            tf.setText(expression.toString());
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            expression.append(" ").append(command).append(" ");
            tf.setText(expression.toString());
        } else if (command.equals("=")) {
            try {
                int result = evaluate(expression.toString());
                tf.setText(String.valueOf(result));
                expression.setLength(0);  
                expression.append(result); 
            } catch (Exception ex) {
                tf.setText("Error");
                expression.setLength(0);  
            }
        } else if (command.equals("C")) {
            expression.setLength(0);
            tf.setText("");
        }
    }

    // Method to evaluate the arithmetic expression
    private int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    result /= operand;
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
