package Interface;

import DataBase.UsersManager;
import Exceptions.LoginIndisponivelException;
import Exceptions.UsuarioNaoExisteException;
import Users.UsuarioComum;
import Users.UsuarioVip;
import javax.swing.JOptionPane;

public class TelaAdm extends javax.swing.JFrame
{

    public TelaAdm()
    {
        initComponents();

        this.hiddenAll();
    }

    private void hiddenAll()
    {
        this.labelLogin.setVisible(false);
        this.labelNome.setVisible(false);
        this.labelSenha.setVisible(false);

        this.campoLogin.setVisible(false);
        this.campoNome.setVisible(false);
        this.campoSenha.setVisible(false);

        this.botaoUserComum.setVisible(false);
        this.botaoUserVip.setVisible(false);
        this.botaoRemover.setVisible(false);
    }

    private void showInserir()
    {
        this.labelLogin.setVisible(true);
        this.labelNome.setVisible(true);
        this.labelSenha.setVisible(true);

        this.campoLogin.setVisible(true);
        this.campoNome.setVisible(true);
        this.campoSenha.setVisible(true);

        this.botaoUserComum.setVisible(true);
        this.botaoUserVip.setVisible(true);
    }

    private void showRemover()
    {
        this.labelLogin.setVisible(true);
        this.campoLogin.setVisible(true);
        this.botaoRemover.setVisible(true);
    }
    
    private void showUpdate()
    {
        this.labelLogin.setVisible(true);
        this.campoLogin.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        labelLogin = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();
        campoSenha = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        botaoUserComum = new javax.swing.JButton();
        botaoUserVip = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuControle = new javax.swing.JMenu();
        menuItemCadastro = new javax.swing.JMenuItem();
        menuItemRemocao = new javax.swing.JMenuItem();
        menuPlayer = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLogin.setText("Login");
        getContentPane().add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        labelSenha.setText("Senha");
        getContentPane().add(labelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        labelNome.setText("Nome");
        getContentPane().add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));
        getContentPane().add(campoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 180, -1));
        getContentPane().add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 180, -1));
        getContentPane().add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 180, -1));

        botaoUserComum.setText("Adicionar Usuario Comum");
        botaoUserComum.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoUserComumActionPerformed(evt);
            }
        });
        getContentPane().add(botaoUserComum, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        botaoUserVip.setText("Adicionar Usuario Vip");
        botaoUserVip.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoUserVipActionPerformed(evt);
            }
        });
        getContentPane().add(botaoUserVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(botaoRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        menuControle.setText("Controle de Usuarios");

        menuItemCadastro.setText("Cadastrar Usuario");
        menuItemCadastro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuItemCadastroActionPerformed(evt);
            }
        });
        menuControle.add(menuItemCadastro);

        menuItemRemocao.setText("Remover Usuario");
        menuItemRemocao.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuItemRemocaoActionPerformed(evt);
            }
        });
        menuControle.add(menuItemRemocao);

        jMenuBar1.add(menuControle);

        menuPlayer.setText("Player");
        jMenuBar1.add(menuPlayer);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuSairMouseClicked(evt);
            }
        });
        menuSair.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoUserComumActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoUserComumActionPerformed
    {//GEN-HEADEREND:event_botaoUserComumActionPerformed
        String login = this.campoLogin.getText();
        String senha = this.campoSenha.getText();
        String nome = this.campoNome.getText();

        if (login != "" && senha != "" && nome != "")
        {
            try
            {
                DataBase.DataBaseSingleton.getInstance().inserir(new UsuarioComum(nome, login, senha));
                JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
            } catch (LoginIndisponivelException ex)
            {
                JOptionPane.showMessageDialog(null, "Usuario ja existe");
            }
            finally
            {
                this.campoLogin.setText("");
                this.campoNome.setText("");
                this.campoSenha.setText("");
            }
        }
        else
        {
            this.campoLogin.setText("");
            this.campoNome.setText("");
            this.campoSenha.setText("");
            JOptionPane.showMessageDialog(null, "Preencha todos os campos e tente novamente");
        }
    }//GEN-LAST:event_botaoUserComumActionPerformed

    private void botaoUserVipActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoUserVipActionPerformed
    {//GEN-HEADEREND:event_botaoUserVipActionPerformed
        String login = this.campoLogin.getText();
        String senha = this.campoSenha.getText();
        String nome = this.campoNome.getText();

        if (login != "" && senha != "" && nome != "")
        {
            try
            {
                DataBase.DataBaseSingleton.getInstance().inserir(new UsuarioVip(nome, login, senha));
                JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
            } catch (LoginIndisponivelException ex)
            {
                JOptionPane.showMessageDialog(null, "Usuario ja existe");
            }
            finally
            {
                this.campoLogin.setText("");
                this.campoNome.setText("");
                this.campoSenha.setText("");
            }
        }
        else
        {
            this.campoLogin.setText("");
            this.campoNome.setText("");
            this.campoSenha.setText("");
            JOptionPane.showMessageDialog(null, "Preencha todos os campos e tente novamente");
        }
    }//GEN-LAST:event_botaoUserVipActionPerformed

    private void menuItemCadastroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuItemCadastroActionPerformed
    {//GEN-HEADEREND:event_menuItemCadastroActionPerformed
        this.hiddenAll();
        this.showInserir();
    }//GEN-LAST:event_menuItemCadastroActionPerformed

    private void menuItemRemocaoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuItemRemocaoActionPerformed
    {//GEN-HEADEREND:event_menuItemRemocaoActionPerformed
        this.hiddenAll();
        this.showRemover();
    }//GEN-LAST:event_menuItemRemocaoActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoRemoverActionPerformed
    {//GEN-HEADEREND:event_botaoRemoverActionPerformed
        if (!"".equals(this.campoLogin.getText()))
        {
            try
            {
                DataBase.DataBaseSingleton.getInstance().remover(this.campoLogin.getText());
                JOptionPane.showMessageDialog(null, "Usuario removido com sucesso, login disponivel novamente para cadastro");
            } catch (UsuarioNaoExisteException ex)
            {
                JOptionPane.showMessageDialog(null, "Login invalido");
            }
            finally
            {
                this.campoLogin.setText("");
            }
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuSairActionPerformed
    {//GEN-HEADEREND:event_menuSairActionPerformed
        
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuSairMouseClicked
    {//GEN-HEADEREND:event_menuSairMouseClicked
        new UsersManager().gerarDataBase();
        System.exit(0);
    }//GEN-LAST:event_menuSairMouseClicked

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new TelaAdm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoUserComum;
    private javax.swing.JButton botaoUserVip;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoSenha;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JMenu menuControle;
    private javax.swing.JMenuItem menuItemCadastro;
    private javax.swing.JMenuItem menuItemRemocao;
    private javax.swing.JMenu menuPlayer;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
