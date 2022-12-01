package se.umu.cs.emli;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * View to take input from user in form of a string. Also contains
 * a button to let user iterate over the given input.
 * @author Emmy Lindgren, id19eln.
 */
public class View {
    private final JFrame frame;
    private JTextField inputText;
    private JButton addToListButton;
    private JButton iterateButton;
    private JTextArea outputText;

    public View(){
        this.frame = new JFrame("Iteratortester");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setMinimumSize(new Dimension(400, 300));

        JPanel inputPanel = this.buildInputPanel();
        JPanel outputPanel = this.buildOutPutPanel();

        this.frame.add(inputPanel,BorderLayout.PAGE_START);
        this.frame.add(outputPanel,BorderLayout.CENTER);

        this.frame.pack();
    }

    public void show(){this.frame.setVisible(true);}

    private JPanel buildInputPanel(){
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Fill doublelinked list")
                ,new EmptyBorder(5,5,5,5)));
        inputPanel.setLayout(new BorderLayout(5,5));

        inputText = new JTextField();
        addToListButton = new JButton("Add to list");
        iterateButton = new JButton("Iterate over list");

        inputPanel.add(inputText, BorderLayout.CENTER);
        inputPanel.add(addToListButton,BorderLayout.LINE_END);
        inputPanel.add(iterateButton,BorderLayout.PAGE_END);

        return inputPanel;
    }

    private JPanel buildOutPutPanel(){
        JPanel outputPanel = new JPanel();
        outputText = new JTextArea("");
        outputText.setEditable(false);
        outputText.setLineWrap(true);
        outputText.setBorder(new EmptyBorder(5,5,5,5));
        outputPanel.setLayout(new BorderLayout());

        JScrollPane outputTextScroll = new JScrollPane(outputText);
        outputPanel.add(outputTextScroll,BorderLayout.CENTER);

        return outputPanel;
    }

    public void setInputListener(ActionListener actionListener){
        addToListButton.addActionListener(actionListener);
    }
    public void setIterateListener(ActionListener actionListener){
        iterateButton.addActionListener(actionListener);
    }
    public String getInput(){
        return inputText.getText();
    }
    public void clearInput(){
        inputText.setText("");
    }
    public void clearOutPut(){
        outputText.setText("");
    }
    public void lockButtons(){
        addToListButton.setEnabled(false);
        iterateButton.setEnabled(false);
    }
    public void unlockButtons(){
        addToListButton.setEnabled(true);
        iterateButton.setEnabled(true);
    }

    public void updateOutput(String string){
        outputText.append(string);
    }
}
