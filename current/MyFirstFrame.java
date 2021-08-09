package current;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MyFirstFrame {

    private final JFrame mainFrame;
    private JTextField textField;

    public MyFirstFrame(String title) {
        this.mainFrame = new JFrame(title);
        initMainFrame();

        mainFrame.setLayout(new BorderLayout());

        mainFrame.add(createTop(), BorderLayout.NORTH);
        mainFrame.add(createBottom(), BorderLayout.CENTER);

        mainFrame.setVisible(true);


    }

    public void Calc() {
        String tmp = textField.getText();
        char[] array = tmp.toCharArray();
        String var1 = "";
        String var2 = "";
        String oper = "";

        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (!Character.isDigit(array[i])) {
                oper += array[i];
            } else {
                if (oper.equals("")) {
                    var1 += array[i];
                } else {
                    var2 += array[i];
                }
            }
        }
            
            int varInt1 = Integer.parseInt(var1);
            int varInt2 = Integer.parseInt(var2);
            int result = 0;

            switch (oper) {
                case "+":
                    result = varInt1 + varInt2;
                    break;
                case "-":
                    result = varInt1 - varInt2;
                    break;

                case "*":
                    result = varInt1 * varInt2;
                    break;

                case "/":
                    result = varInt1 / varInt2;
                    break;
            }
            textField.setText(textField.getText() + "=" + result);
        }


    private JPanel createTop(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        textField = new JTextField();
        textField.setEditable(false);
        panel.add(textField);

        return panel;
    }

    private JPanel createBottom(){
        JPanel panel=  new JPanel();
        DigitButton digitButton = new DigitButton(textField);
        panel.setLayout(new GridLayout(4,4));
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(digitButton);
            panel.add(btn);
        }

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        panel.add(clearButton);
        JButton Equals = new JButton("=");
        Equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calc();
            }
        });
        panel.add(Equals);

        JButton buttonSum = new JButton("+");
        buttonSum.addActionListener(digitButton);
        panel.add(buttonSum);
        JButton buttonMin = new JButton("-");
        buttonMin.addActionListener(digitButton);
        panel.add(buttonMin);
        JButton buttonUmn = new JButton("*");
        buttonUmn.addActionListener(digitButton);
        panel.add(buttonUmn);
        JButton buttonDel = new JButton("/");
        buttonDel.addActionListener(digitButton);
        panel.add(buttonDel);

        return panel;

    }

    private  void initMainFrame(){
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // mainFrame.setBounds(50, 50, 300, 500);
        Rectangle rectangle = new Rectangle(300, 500);
        mainFrame.setBounds(rectangle);

    }


    public MyFirstFrame() {
        this("My First Desktop Application v1.0");

    }
}
