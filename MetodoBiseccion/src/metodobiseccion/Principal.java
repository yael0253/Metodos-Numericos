
package metodobiseccion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;



 //* @author Yael

public class Principal extends javax.swing.JFrame implements Runnable{
    String hora, minutos;
    Thread hilo;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        
         this.setLocationRelativeTo(null);
        Fecha.setText(fecha());
        
        hilo= new Thread(this);
        hilo.start();
        setVisible(true);
    }
    
    public void hora(){
        Calendar calendario = new GregorianCalendar();
        Date horaactual=new Date();
        calendario.setTime(horaactual);
        hora=calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
        minutos= calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
    }
     public void run(){
         Thread current= Thread.currentThread();
         while(current== hilo){
             hora();
             Hora.setText(hora+":"+minutos);
}
         
     }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        BtnSalida = new javax.swing.JButton();
        BtnBiseccion = new javax.swing.JButton();
        Hora = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 153, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(1000, 562));
        jPanel3.setMinimumSize(new java.awt.Dimension(1000, 562));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("M??todos Num??ricos");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.add(jLabel2);
        jLabel2.setBounds(310, 60, 340, 50);

        Fecha.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        Fecha.setText("DD / MM / YYYY");
        Fecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(Fecha);
        Fecha.setBounds(780, 40, 210, 60);

        BtnSalida.setBackground(new java.awt.Color(0, 153, 153));
        BtnSalida.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 14)); // NOI18N
        BtnSalida.setText("Salir");
        BtnSalida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalidaActionPerformed(evt);
            }
        });
        jPanel3.add(BtnSalida);
        BtnSalida.setBounds(30, 492, 150, 50);

        BtnBiseccion.setBackground(new java.awt.Color(250, 135, 168));
        BtnBiseccion.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 14)); // NOI18N
        BtnBiseccion.setText("Metodo de Biseccion");
        BtnBiseccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBiseccionActionPerformed(evt);
            }
        });
        jPanel3.add(BtnBiseccion);
        BtnBiseccion.setBounds(320, 170, 310, 50);

        Hora.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        Hora.setText("00:00");
        jPanel3.add(Hora);
        Hora.setBounds(70, 40, 210, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalidaActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnSalidaActionPerformed

    private void BtnBiseccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBiseccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBiseccionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static String fecha(){
        Date fecha= new Date();
        SimpleDateFormat formatofecha= new SimpleDateFormat("dd / MMM / YYYY");
      
        return formatofecha.format(fecha);
        
    }
    

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
        
    }

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBiseccion;
    private javax.swing.JButton BtnSalida;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel Hora;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
