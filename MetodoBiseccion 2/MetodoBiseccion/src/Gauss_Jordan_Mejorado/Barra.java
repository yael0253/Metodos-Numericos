
package Gauss_Jordan_Mejorado;

import Componentes.Determinante;
import Componentes.Matrices;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class Barra extends JMenuBar {

    
    ButtonGroup grupo = new ButtonGroup();
    
    JPanel panelCentral;
    
    MatrizInput matrizInput;
    
    JPanel panelSuperior;
    
    public Barra(JPanel panelCentral, JPanel panelSuperior){
        
        this.panelCentral = panelCentral;
        
        this.panelSuperior = panelSuperior;
        
        JToggleButton Matriz = boton("Matriz");
        JToggleButton Traspuesta = boton("Traspuesta");
        JToggleButton Cofactores = boton("Cofactores");
        JToggleButton Adjunta = boton("Adjunta");
        JToggleButton Inversa = boton("Inversa");
        JToggleButton Determinante = boton("Determinante");
        
        Matriz.setSelected(true);
        
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        panel.add(Matriz);  panel.add(Traspuesta);  panel.add(Cofactores);
        panel.add(Adjunta); panel.add(Inversa);     panel.add(Determinante);
        
        this.add(panel);
    }
    
    private JToggleButton boton(String name){
        
        JToggleButton boton = new JToggleButton();
        
        boton.setText(name);
        boton.setName(name);
        
        boton.setBackground(Color.GRAY.lightGray);
        
        
        boton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                JToggleButton target = (JToggleButton)e.getSource();
                
                panelCentral.removeAll();
                
                if(target.getName() == "Matriz"){
                    
                    panelSuperior.setVisible(true);
                    
                    panelCentral.add(matrizInput);
                }
                else {
                    panelSuperior.setVisible(false);
                    
                   JComponent panel = calcular( target.getName() );
                   
                   if(panel != null) panelCentral.add(panel);   
                }
 
                panelCentral.setVisible(false); panelCentral.setVisible(true);
            }
        });
        //*/
        
        grupo.add(boton);
        
        return boton;
    }
    
    private JComponent calcular(String n){
        
        JComponent AUX = null;
        
        double[][] Matriz = matrizInput.obtenerMatriz();
            
        if(Matriz != null){
            
            if(n == "Traspuesta"){
                
                AUX = new MatrizVista( Matrices.traspuesta(Matriz) );
            }
            else {
                
                if( Determinante.puedeCalcularse(Matriz) ){
                    
                    switch( n ){

                        case "Cofactores":
                            AUX = new MatrizVista( Matrices.cofactores(Matriz) );
                            break;

                        case "Adjunta":
                            AUX = new MatrizVista( Matrices.adjunta(Matriz) );
                            break;

                        case "Inversa":
                            try {
                                AUX = new MatrizVista( Matrices.inversa(Matriz) );
                            } 
                            catch (Exception ex){
                               JOptionPane.showMessageDialog(panelCentral, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
                            }
                            break;


                        case "Determinante":
                            
                            AUX = determinante(Matriz);
                            break;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(panelCentral, "La matriz no es Cuadrada", "Error", JOptionPane.ERROR_MESSAGE);
                }    
            }
        }    
            
        return AUX;
    }
    
    public void setMatrizInput(MatrizInput input){
        
        this.matrizInput = input;
    }
    
    private JComponent determinante(double matriz[][]){
        
        double Det = Determinante.detLaplace(matriz);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        JLabel det = new JLabel("Determinante: " + Det);
        det.setHorizontalAlignment(JLabel.CENTER);
        det.setFont(new Font("Consolas", Font.PLAIN, 20));
        det.setPreferredSize(new Dimension(150, 50));
        
        
        JComponent triagular = new MatrizVista( Matrices.triangularSup(matriz) );
        
        panel.add(triagular, BorderLayout.CENTER);
        
        panel.add(det, BorderLayout.SOUTH);
        
        return panel;
    }
}