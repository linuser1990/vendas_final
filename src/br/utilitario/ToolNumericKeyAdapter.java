/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utilitario;

/**
 *
 * @author linux
 */
import java.text.*;

import java.awt.event.*;
import javax.swing.text.*;
import javax.swing.JTable;


/**
 *  Controls the text being entered into a text field. Only numbers are accepted.
 *  Intended to be used with "textField.addKeyListener(new KeyAdapter())";
 *
 *@author     wferreira
 */
public final class ToolNumericKeyAdapter extends KeyAdapter {
    private int _maxLength = Integer.MAX_VALUE;
    private boolean _allowPoint = false;
    public static final int INTEGER = 1;
    public static final int FLOATING_POINT = 2;

    private Double _upperLimit;
    private Double _lowerLimit;
    private NumberFormat doubleFormat = NumberFormat.getInstance();

    public ToolNumericKeyAdapter(int maxLength) {
        _maxLength = maxLength;
        _allowPoint = true;
    }

    public ToolNumericKeyAdapter(int maxLength, boolean allowPoint) {
        _maxLength = maxLength;
        _allowPoint = allowPoint;
    }


    public void setUpperValueLimit(double limit) {
        _upperLimit = new Double(limit);
    }


    public void setLowerValueLimit(double limit) {
        _lowerLimit = new Double(limit);
    }


  public void keyTyped(KeyEvent e) {
    char typedChar = e.getKeyChar();
    if (!Character.isISOControl(typedChar)) {
      JTextComponent source = (JTextComponent) e.getSource();
      String text = source.getText().trim();
      if ( typedChar != ',' && typedChar !='.' && !Character.isDigit(typedChar) || (text.length() >= _maxLength)) {
        java.awt.Toolkit.getDefaultToolkit().beep();
        e.consume();
        return;
      }
      StringBuffer buffer = new StringBuffer(text);
      if(typedChar == ','){
        try {
          source.getDocument().insertString(
              source.getCaretPosition(), ".", null);
        } catch (BadLocationException ex1) {
        }
        e.consume();
      }else {
        buffer.append(typedChar);
      }
      text = buffer.toString();
      if (text.length() != 0) {
        double val = 0.0;
        try {
          val = doubleFormat.parse(text).doubleValue();
        } catch (ParseException ex) {
          throw new IllegalArgumentException(
              "Should never allow invalid numbers to enter: " + text);
        }
        if ((_upperLimit != null && _upperLimit.doubleValue() < val) ||
            (_lowerLimit != null && _lowerLimit.doubleValue() > val)) {
          java.awt.Toolkit.getDefaultToolkit().beep();
          e.consume();
          return;
        }
      }
    }
  }
}