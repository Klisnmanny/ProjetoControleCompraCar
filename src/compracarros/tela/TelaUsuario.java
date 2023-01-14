/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package compracarros.tela;
import java.sql.*;
import compracarros.acesso.conexao;
import javax.swing.JOptionPane;
/**
 *
 * @author Klisnmanny
 */
public class TelaUsuario extends javax.swing.JInternalFrame {
    
    Connection ligar =null;
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaUsuario() {
        initComponents();
        
        ligar = conexao.conectar();
    }
       private void pesquisar(){
        String sql = "select * from tbusuario where login=? ";
        try {
            pst = ligar.prepareStatement(sql);
            pst.setString(1,LoginUsu.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                IdUsu.setText(rs.getString(1));
                NomeUsu.setText(rs.getString(2));
                SenhaUsu.setText(rs.getString(3));
                EmailUsu.setText(rs.getString(4));
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuário não existe!");
                IdUsu.setText(null);
                NomeUsu.setText(null);
                SenhaUsu.setText(null);
                LoginUsu.setText(null);
                EmailUsu.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        }
       
       
       private void atualizar(){
            if((IdUsu.getText().isEmpty()) || (NomeUsu.getText().isEmpty()) || (SenhaUsu.getText().isEmpty()) || (LoginUsu.getText().isEmpty() )){
                JOptionPane.showMessageDialog(null,"Preecha os campos obrigatórios!");
        }   
            else{
        String sql = "update tbusuario set nome=?,senha=?,email=?,login=? where idusuario=?; ";
        try {
            pst = ligar.prepareStatement(sql);
            
            pst.setString(1,NomeUsu.getText());
            pst.setString(2,SenhaUsu.getText());
            pst.setString(3,EmailUsu.getText());
            pst.setString(4,LoginUsu.getText());
            pst.setString(5,IdUsu.getText());
            
            int add = pst.executeUpdate();
           
            
            if(add>0){
                JOptionPane.showMessageDialog(null,"Usuário atualizado com sucesso!");
                IdUsu.setText(null);
                NomeUsu.setText(null);
                SenhaUsu.setText(null);
                LoginUsu.setText(null);
                EmailUsu.setText(null);
            }
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        }}
            
            
        private void criar(){
            if((IdUsu.getText().isEmpty()) || (NomeUsu.getText().isEmpty()) || (SenhaUsu.getText().isEmpty()) || (LoginUsu.getText().isEmpty() )){
                JOptionPane.showMessageDialog(null,"Preecha os campos obrigatórios!");
        }   else{
        String sql = "insert into tbusuario(idusuario,nome,senha,email,login) values(?,?,?,?,?)";
        try {
            pst = ligar.prepareStatement(sql);
            pst.setString(1,IdUsu.getText());
            pst.setString(2,NomeUsu.getText());
            pst.setString(3,SenhaUsu.getText());
            pst.setString(4,EmailUsu.getText());
            pst.setString(5,LoginUsu.getText());
            
            int add = pst.executeUpdate();
           
            if(add>0){
                JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso!");
                IdUsu.setText(null);
                NomeUsu.setText(null);
                SenhaUsu.setText(null);
                LoginUsu.setText(null);
                EmailUsu.setText(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
            }}
            
       private void  deletar(){
           int yorn = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja excluir?","Atenção",JOptionPane.YES_NO_OPTION);
           if (yorn == JOptionPane.YES_OPTION){
               String sql = "delete from tbusuario where idusuario=? ";
               try {
                     pst = ligar.prepareStatement(sql);
                     pst.setString(1,IdUsu.getText());
                     int add = pst.executeUpdate();
           
            if(add>0){
                JOptionPane.showMessageDialog(null,"Usuário excluido com sucesso!");
                IdUsu.setText(null);
                NomeUsu.setText(null);
                SenhaUsu.setText(null);
                LoginUsu.setText(null);
                EmailUsu.setText(null);
            }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null,e);
               }
           }
       }
            
            
    /**}
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IdUsu = new javax.swing.JTextField();
        EmailUsu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        LoginUsu = new javax.swing.JTextField();
        SenhaUsu = new javax.swing.JPasswordField();
        BtnCriar = new javax.swing.JButton();
        BtnPesquisar = new javax.swing.JButton();
        BtnAtualizar = new javax.swing.JButton();
        BtnDeletar = new javax.swing.JButton();
        NomeUsu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Usuário");

        jLabel1.setText("*Id:");

        jLabel2.setText("*Nome:");

        jLabel3.setText("*Senha:");

        jLabel4.setText("Email:");

        jLabel5.setText("*Login:");

        BtnCriar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compracarros/icones/create.png"))); // NOI18N
        BtnCriar.setToolTipText("Adicionar");
        BtnCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCriar.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCriarActionPerformed(evt);
            }
        });

        BtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compracarros/icones/pesquisar.png"))); // NOI18N
        BtnPesquisar.setToolTipText("Pesquisar");
        BtnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPesquisar.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPesquisarActionPerformed(evt);
            }
        });

        BtnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compracarros/icones/atualizar.png"))); // NOI18N
        BtnAtualizar.setToolTipText("Atualizar");
        BtnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAtualizar.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtualizarActionPerformed(evt);
            }
        });

        BtnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compracarros/icones/delete.png"))); // NOI18N
        BtnDeletar.setToolTipText("Deletar");
        BtnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDeletar.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeletarActionPerformed(evt);
            }
        });

        jLabel6.setText("* Preecha os campos obrigatórios. ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Cadastrar Usuário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NomeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LoginUsu)
                                    .addComponent(SenhaUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(EmailUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(BtnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(BtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(BtnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(IdUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(238, 238, 238))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IdUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NomeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LoginUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SenhaUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addComponent(jLabel6)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        setBounds(0, 0, 720, 740);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
       pesquisar();
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void BtnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCriarActionPerformed
        criar();
    }//GEN-LAST:event_BtnCriarActionPerformed

    private void BtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_BtnAtualizarActionPerformed

    private void BtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeletarActionPerformed
       deletar();
    }//GEN-LAST:event_BtnDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtualizar;
    private javax.swing.JButton BtnCriar;
    private javax.swing.JButton BtnDeletar;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JTextField EmailUsu;
    private javax.swing.JTextField IdUsu;
    private javax.swing.JTextField LoginUsu;
    private javax.swing.JTextField NomeUsu;
    private javax.swing.JPasswordField SenhaUsu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
