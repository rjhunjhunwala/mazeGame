/**
	* NOTE THIS IS AUTOGENERATED CODE FROM NETBEANS 
	* TOUCHING THIS IS DANGEROUS!
	*/
package zombieMaze;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author rohan
 */
public class IOSTRING extends javax.swing.JFrame {

	/**
	 * Creates new form in order to get a string
	 */
	public IOSTRING() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
 // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
 private void initComponents() {

  jDialog1 = new javax.swing.JDialog();
  jDialog2 = new javax.swing.JDialog();
  jOptionPane1 = new javax.swing.JOptionPane();

  javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
  jDialog1.getContentPane().setLayout(jDialog1Layout);
  jDialog1Layout.setHorizontalGroup(
   jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGap(0, 400, Short.MAX_VALUE)
  );
  jDialog1Layout.setVerticalGroup(
   jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGap(0, 300, Short.MAX_VALUE)
  );

  javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
  jDialog2.getContentPane().setLayout(jDialog2Layout);
  jDialog2Layout.setHorizontalGroup(
   jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGap(0, 400, Short.MAX_VALUE)
  );
  jDialog2Layout.setVerticalGroup(
   jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGap(0, 300, Short.MAX_VALUE)
  );

  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

  jOptionPane1.setMessage("");

  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
  getContentPane().setLayout(layout);
  layout.setHorizontalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addContainerGap())
  );
  layout.setVerticalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
    .addGap(0, 0, Short.MAX_VALUE)
    .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
  );

  pack();
 }// </editor-fold>                        

	/**
	 * @param args the command line arguments
	 */
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
			java.util.logging.Logger.getLogger(IOSTRING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(IOSTRING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(IOSTRING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(IOSTRING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new IOSTRING().setVisible(true);
			}
		});
		
	}
	/**
		* puts up a pop up dialog asking for a string taken from stack overflow 
		* @param prompt for the user
		* @return a string from the user
		*/
	public String getStringFromPopUp(String prompt){
	try {
		Thread.sleep(10);
	} catch (InterruptedException ex) {
	}
		JTextArea textArea = new JTextArea();       
		textArea.setEditable(true);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.requestFocus();
            textArea.requestFocusInWindow();
            scrollPane.setPreferredSize(new Dimension(400, 100));

												JOptionPane.showMessageDialog(
                   this.jOptionPane1, scrollPane,
                    prompt, JOptionPane.PLAIN_MESSAGE);
												return textArea.getText();
	}
 // Variables declaration - do not modify                     
 private javax.swing.JDialog jDialog1;
 private javax.swing.JDialog jDialog2;
 private javax.swing.JOptionPane jOptionPane1;
 // End of variables declaration                   
}
