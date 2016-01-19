/*Elaborado por Rafael Guevara
Ejemplo pestañas swing
*/
package com.rd.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class Formulario_II extends JPanel {
  private static String cadenas[] = {"First Name", "Last Name", "Address","Salary"};
  private static String cadenas_b[] = {"Insert", "Update", "Delete","Clear"};
  private GridBagConstraints constraints = new GridBagConstraints();	
    
  private JPanel crearPanel(int campos){
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
	int k = 0,l = 0;
    for ( int i = 0; i< campos; i++ ){
      JLabel etiqueta = new JLabel(cadenas[i]+":");  
      setNewConstraints(0, l, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
      panel.add(etiqueta, constraints);
      setNewConstraints(2, l, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
      panel.add(new JTextField(), constraints);
      l++;  		  
    }
	return panel;	
  }
  
  private JPanel crearPanel(){
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	for (int i = 0; i<cadenas_b.length; i++){
      JButton button = new JButton(cadenas_b[i]);
      button.setPreferredSize(new Dimension(80, 25));
      panel.add(button);   
    }	
	return panel;	
  }

  private JPanel crearPanelInf(){
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    JButton button = new JButton("<<");
    button.setPreferredSize(new Dimension(165, 25));
    panel.add(button);   
    JButton button_2 = new JButton(">>");
    button_2.setPreferredSize(new Dimension(165, 25));
    panel.add(button_2);  
	return panel;	
  }  
 
  private void setNewConstraints(int gridx, int gridy, int gridwidth,
                           int gridheight, int weightx, int anchor, 
				           int fill){
    constraints.gridx = gridx;				
    constraints.gridy = gridy;
    constraints.gridwidth = gridwidth;
    constraints.gridheight = gridheight;
    constraints.weightx = (double) weightx;
    constraints.anchor = anchor;
    constraints.fill = fill; 
  }
  
  public Formulario_II() {
    setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
    add(crearPanel(cadenas.length));
	add(crearPanel());
	add(crearPanel(cadenas.length));	
	add(crearPanelInf());    
  }

  public static void main( String args[] ) {
    JFrame frame = new JFrame("JDBC All in One");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new Formulario_II(), BorderLayout.CENTER);
    frame.setSize(350,255);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
} 
