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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class Formulario_II extends JPanel implements ActionListener{
  private static String cadenas[] = {"First Name", "Last Name", "Address","Salary"};
  private static String cadenas_b[] = {"Insert", "Update", "Delete","Clear"};
  private JTextField campos_t[] = new JTextField[cadenas.length];
  private JLabel etiquetas[] = new JLabel[cadenas.length];
  private JButton botones[] = new JButton[4];
  private GridBagConstraints constraints = new GridBagConstraints();	
    
  private JPanel crearPanel(int campos, boolean label){
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    for ( int i = 0; i< campos; i++ ){
      JLabel etiqueta = new JLabel(cadenas[i]+":");  
      setNewConstraints(0, i, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
      panel.add(etiqueta, constraints);
      setNewConstraints(2, i, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
      if (label){
		etiquetas[i] = new JLabel();     
        panel.add(etiquetas[i], constraints);
      }
	  else{
        campos_t[i] = new JTextField();		  
	    panel.add(campos_t[i], constraints);
      }		 		  
    }
	return panel;	
  }
  
  public void actionPerformed( ActionEvent evt ){
    JButton boton = (JButton) evt.getSource();
	String aux = boton.getText();
	if (aux.equals("Insert")){
      for (int i=0; i<4; i++)
        etiquetas[i].setText(campos_t[i].getText()); 	  
	}else if(aux.equals("Delete")){
      for (int i=0; i<4; i++)
        etiquetas[i].setText(""); 	
    }else if(aux.equals("Clear")){
      for (int i=0; i<4; i++)
        campos_t[i].setText(""); 	
    }    
  }
  
  private JPanel crearPanel(){
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	for (int i = 0; i<cadenas_b.length; i++){
	  botones[i] = new JButton(cadenas_b[i]);
      botones[i].setPreferredSize(new Dimension(80, 25));
	  switch (i){
	    case 0: botones[i].addActionListener(this);break;	  
		case 2: botones[i].addActionListener(this);break;	    
		case 3: botones[i].addActionListener(this);	  
	  }
      panel.add(botones[i]);   
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
    add(crearPanel(cadenas.length, false));
	add(crearPanel());
	add(crearPanel(cadenas.length, true));	
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
