package Interface;

import DataBase.DataBaseUsersSingleton;
import DataBase.PlayListManager;
import DataBase.SongsManager;
import DataBase.UsersManager;
import Exceptions.LoginIndisponivelException;
import Exceptions.UsuarioInvalidoException;
import Exceptions.UsuarioNaoExisteException;
import Structs.Abb;
import Users.Usuario;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame
{

    public TelaLogin() throws LoginIndisponivelException
    {
        initComponents();
        new UsersManager().carregarDataBase();
        new PlayListManager().carregarPlayLists();
        Abb a = DataBaseUsersSingleton.getInstance();
        new SongsManager().carregarDataBase();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        labelSenha = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();
        botaoLogar = new javax.swing.JButton();
        labelPlayer = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        labelLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSenha.setText("Senha");
        jPanel1.add(labelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));
        jPanel1.add(campoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, -1));

        botaoLogar.setText("Login");
        botaoLogar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoLogarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoLogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        labelPlayer.setText("Player de Música");
        jPanel1.add(labelPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));
        jPanel1.add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 150, -1));

        labelLogin.setText("Login");
        jPanel1.add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLogarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoLogarActionPerformed
    {//GEN-HEADEREND:event_botaoLogarActionPerformed
        String login = this.campoLogin.getText();
        String senha = this.campoSenha.getText();

        if (!"".equals(login) && !"".equals(senha))
        {
            Usuario user;
            try
            {
                user = DataBaseUsersSingleton.autenticarUsuario(login, senha);
                this.setVisible(false);
                user.getLoginMode().gerarTela(this, true, user);
            } catch (UsuarioNaoExisteException | UsuarioInvalidoException ex)
            {
                JOptionPane.showMessageDialog(null, "Usuario nao existe ou senha incorreta");
            } 
            finally
            {
                this.campoLogin.setText("");
                this.campoSenha.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos e tente novamente");
            this.campoLogin.setText("");
            this.campoSenha.setText("");
        }
    }//GEN-LAST:event_botaoLogarActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    new TelaLogin().setVisible(true);
                } catch (LoginIndisponivelException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLogar;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelPlayer;
    private javax.swing.JLabel labelSenha;
    // End of variables declaration//GEN-END:variables
}
