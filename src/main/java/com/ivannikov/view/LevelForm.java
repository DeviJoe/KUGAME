package com.ivannikov.view;

import com.ivannikov.controller.GameController;
import com.ivannikov.util.SwingUtils;

import javax.swing.*;
import java.awt.event.*;

public class LevelForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea levelTextArea;
    private JTextField levelField;

    public LevelForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        try {
            int level = Integer.parseInt(levelField.getText());
            GameController.getInstance().createSession(level);
        } catch (Exception e) {
            SwingUtils.showErrorMessageBox("Ошибка, уровень не существует :(", e);
        }

        dispose();
    }

    private void onCancel() {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        GameController.getInstance().createSession(1);
        dispose();
    }

    public static void main(String[] args) {
        LevelForm dialog = new LevelForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
