
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;




public class form_login extends javax.swing.JFrame {
    ConfigFile save = new ConfigFile();
    private static final char[] USERNAME = "enfldsgbnlsngdlksdsgm".toCharArray();
    private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgmenfldsgbnlsngdlksdsgmenfldsgbnlsngdlksdsgm".toCharArray();
    private static final byte[] SALT = { (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12, (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12, };
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;
    PreparedStatement pst3 = null;
    ResultSet rs3 = null;
    String URL = "https://snk.extremeits.biz/";
   
    
    public form_login() {
        this.setLocationRelativeTo(null);
        con = JConnection.ConnectorDB();
        initComponents();
        setIcon();
        //con = JConnection.ConnectorDB();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Extremeits.biz");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Username");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Save password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(username)
                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!jCheckBox1.isSelected()){
                   try{
                        save.SaveProp("xmlread", "");
                        save.SaveProp("xmlwrite", "");
                       }catch(Exception e){

                        }
                   }
        System.exit(0);   

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String client_code = null;
        String agent_code = null;
        String user = null;
        String fullname = null;
        String Sql = "Select * from login where username=? and password=?";
        
        try{
            pst = con.prepareStatement(Sql);
            pst.setString(1, username.getText());
            pst.setString(2, getMD5Hash(password.getText()));
            rs = pst.executeQuery();
            if(rs.next()){
               client_code = rs.getString("client_code");
               agent_code = rs.getString("agent_code");
               user = rs.getString("username");
               fullname = rs.getString("fullname");
       
               MainFrame mf = new MainFrame();
               mf.setClientCode(client_code);
               mf.setAgentCode(agent_code);
               mf.setUserName(user);
               mf.setFullName(fullname);
               
               String Sql2 = "SELECT * FROM logo_clients WHERE client_code = ? OR client_code=?";
               try{
                   pst2 = con.prepareStatement(Sql2);
                   pst2.setString(1, agent_code);
                   pst2.setString(2, client_code);
                   rs2 = pst2.executeQuery();
                   if(rs2.next()){
                        String access = rs2.getString("access");
                        String [] split = access.split(",");
                        if(split[4].equals("1")){
                            String Sql3 = "SELECT * FROM logo_list WHERE ID = ?";
                            try{
                                pst3 = con.prepareStatement(Sql3);
                                pst3.setString(1, rs2.getString("logo_id"));
                                rs3 = pst3.executeQuery();
                                if(rs3.next()){
                                   mf.setImagePath(URL + "pictures/" + rs3.getString("img_path"));
                                }else{
                                    //JOptionPane.showMessageDialog(null, "no image");
                                }
                            }catch(SQLException e){
                                JOptionPane.showMessageDialog(null, "Unable to get the Company logo");
                            }
                        }else{
                            mf.setImagePath(URL + "css/company.png");
                        }
                   }else{
                       JOptionPane.showMessageDialog(null, "Unable to find the Company Logo");
                   }
               }catch(HeadlessException | SQLException e){
                   JOptionPane.showMessageDialog(null, "Unable to find the Company Logo");
               }
               
               if(jCheckBox1.isSelected()){
                   try{
                        save.SaveProp("xmlread", encrypt(username.getText()));
                        save.SaveProp("xmlwrite", encryptPassword(password.getText()));
                       }catch(Exception e){

                        }
                   }else{
                   try{
                        save.SaveProp("xmlread", "");
                        save.SaveProp("xmlwrite", "");
                       }catch(Exception e){

                        }
               }
               mf.setVisible(true);
               this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Invalid username or password","AccessDenied",JOptionPane.ERROR_MESSAGE);
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
        String new_username = save.GetProp("xmlread");
        String new_password = save.GetProp("xmlwrite");
        new_username = decrypt(new_username);
        new_password = decryptPassword(new_password);
        username.setText(new_username);
        password.setText(new_password);
        if(!new_username.equals("")){
            jCheckBox1.setSelected(rootPaneCheckingEnabled);
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(form_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
          setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("home-icon.png")));
    }

    private String md5(String input) {
        String md5 = null;
		
		if(null == input) return null;
		
		try {
			
		//Create MessageDigest object for MD5
		MessageDigest digest = MessageDigest.getInstance("MD5");
		
		//Update input string in message digest
		digest.update(input.getBytes(), 0, input.length());

		//Converts message digest value in base 16 (hex) 
		md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
                        
		}
		return md5;
    }

public static String getMD5Hash(String s) throws NoSuchAlgorithmException {

String result = s;
if (s != null) {
    MessageDigest md = MessageDigest.getInstance("MD5"); // or "SHA-1"
    md.update(s.getBytes());
    BigInteger hash = new BigInteger(1, md.digest());
    result = hash.toString(16);
    while (result.length() < 32) { // 40 for SHA-1
        result = "0" + result;
    }
}
return result; }
 

public boolean isValidMD5(String s) {
    return s.matches("[a-fA-F0-9]{32}");
}

 private static String encrypt(String property) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(USERNAME));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
    }

    private static String base64Encode(byte[] bytes) {
        // NB: This class is internal, and you probably should use another impl
        return new BASE64Encoder().encode(bytes);
    }

    private static String decrypt(String property) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(USERNAME));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }

    private static byte[] base64Decode(String property) throws IOException {
        // NB: This class is internal, and you probably should use another impl
        return new BASE64Decoder().decodeBuffer(property);
    }
    private static String encryptPassword(String property) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
    }
    private static String decryptPassword(String property) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }
}
