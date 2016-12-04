package Interface;

import App.FileChooser;
import DataBase.DataBaseUsersSingleton;
import DataBase.PlayListManager;
import DataBase.SongsManager;
import DataBase.UsersManager;
import Exceptions.BancoVazioException;
import Exceptions.UsuarioNaoExisteException;
import MediaPlayer.MediaPlayer;
import Users.Usuario;
import Users.UsuarioComum;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class TelaComum extends javax.swing.JDialog
{

    private MediaPlayer player;
    private boolean pause;
    private boolean playing;
    private UsuarioComum user;
    private Thread t;

    public TelaComum(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
    }

    public TelaComum(java.awt.Frame parent, boolean modal, Usuario user)
    {
        super(parent, modal);
        initComponents();

        this.player = new MediaPlayer();
        this.pause = false;
        this.playing = false;
        this.user = (UsuarioComum) user;
        atualizarListaMusicas();

        this.setTitle(user.getNome());
    }

    private void atualizarListaMusicas()
    {
        try
        {
            String musicas = DataBase.DataBaseSongsSingleton.getInstance().gerarRegistro();
            if (musicas != null)
            {
                StringBuilder sb = new StringBuilder();
                for (String str : musicas.split("\n"))
                {
                    sb.append(str);
                    //sb.append(str.substring(str.lastIndexOf("\\") + 1, str.lastIndexOf(".")));
                    sb.append("\n");
                }
                String[] list = sb.toString().split("\n");
                atualizarJList(list, this.listMusicas);
            }
        } catch (BancoVazioException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void atualizarJList(String[] list, JList<String> jlist)
    {
        jlist.setModel(new javax.swing.AbstractListModel<String>()
        {
            @Override
            public int getSize()
            {
                return list.length;
            }

            @Override
            public String getElementAt(int i)
            {
                return list[i];
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        panelPlayer = new javax.swing.JPanel();
        botaoMusica = new javax.swing.JButton();
        campoMusica = new javax.swing.JTextField();
        botaoPlay = new javax.swing.JButton();
        botaoPause = new javax.swing.JButton();
        botaoStop = new javax.swing.JButton();
        labelPlayer = new javax.swing.JLabel();
        panelListMusicas = new javax.swing.JScrollPane();
        listMusicas = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPlayer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelPlayer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoMusica.setText("Buscar Musica");
        botaoMusica.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoMusicaActionPerformed(evt);
            }
        });
        panelPlayer.add(botaoMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        campoMusica.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                campoMusicaFocusGained(evt);
            }
        });
        campoMusica.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                campoMusicaActionPerformed(evt);
            }
        });
        campoMusica.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                campoMusicaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                campoMusicaKeyTyped(evt);
            }
        });
        panelPlayer.add(campoMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 270, -1));

        botaoPlay.setText("Play");
        botaoPlay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoPlayActionPerformed(evt);
            }
        });
        panelPlayer.add(botaoPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        botaoPause.setText("Pause");
        botaoPause.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoPauseActionPerformed(evt);
            }
        });
        panelPlayer.add(botaoPause, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        botaoStop.setText("Stop");
        botaoStop.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoStopActionPerformed(evt);
            }
        });
        panelPlayer.add(botaoStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, -1));

        labelPlayer.setText("Player");
        panelPlayer.add(labelPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        listMusicas.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        panelListMusicas.setViewportView(listMusicas);

        panelPlayer.add(panelListMusicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 270, 150));

        jPanel1.add(panelPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 290, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoMusicaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoMusicaActionPerformed
    {//GEN-HEADEREND:event_botaoMusicaActionPerformed
        FileChooser chooser = new FileChooser();
        String path = chooser.escolherArquivo("Escolha a musica");
        if (!path.equals(""))
        {
            String musica = path;
            DataBase.DataBaseSongsSingleton.getInstance().inserir(musica);
            atualizarListaMusicas();
        }
        this.campoMusica.setText(path);
        this.player.setPath(path);
    }//GEN-LAST:event_botaoMusicaActionPerformed

    private void campoMusicaFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_campoMusicaFocusGained
    {//GEN-HEADEREND:event_campoMusicaFocusGained

    }//GEN-LAST:event_campoMusicaFocusGained

    private void campoMusicaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_campoMusicaActionPerformed
    {//GEN-HEADEREND:event_campoMusicaActionPerformed

    }//GEN-LAST:event_campoMusicaActionPerformed

    private void campoMusicaKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_campoMusicaKeyPressed
    {//GEN-HEADEREND:event_campoMusicaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMusicaKeyPressed

    private void campoMusicaKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_campoMusicaKeyTyped
    {//GEN-HEADEREND:event_campoMusicaKeyTyped

    }//GEN-LAST:event_campoMusicaKeyTyped

    private void botaoPlayActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoPlayActionPerformed
    {//GEN-HEADEREND:event_botaoPlayActionPerformed
        String path;
        if (this.listMusicas.getSelectedValue() != null && !this.listMusicas.getSelectedValue().equals(""))
        {
            path = this.listMusicas.getSelectedValue();
        }
        else
        {
            path = this.campoMusica.getText();
        }
        if (!path.equals(""))
        {
            this.campoMusica.setText(path);
            this.player.setPath(path);
            this.listMusicas.clearSelection();
        }

        if (!this.playing)
        {
            this.playing = true;
            this.pause = false;
            t = new Thread(this.player.createRunnable());
            t.start();
            this.botaoPlay.setText("Play");
            this.listMusicas.clearSelection();
            this.listMusicas.setEnabled(false);
            this.botaoMusica.setEnabled(false);
        }
    }//GEN-LAST:event_botaoPlayActionPerformed

    private void botaoPauseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoPauseActionPerformed
    {//GEN-HEADEREND:event_botaoPauseActionPerformed
        if (this.playing)
        {
            this.pause = true;
            this.playing = false;
            this.player.pause();
            this.botaoPlay.setText("Resume");
            this.setTitle(user.getNome());
            this.listMusicas.setEnabled(false);
            this.botaoMusica.setEnabled(false);
        }
    }//GEN-LAST:event_botaoPauseActionPerformed

    private void botaoStopActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoStopActionPerformed
    {//GEN-HEADEREND:event_botaoStopActionPerformed
        if (this.playing || this.pause)
        {
            t = null;
            this.listMusicas.setEnabled(true);
            this.botaoMusica.setEnabled(true);
            this.botaoPlay.setEnabled(true);
            this.player.stop();
            this.playing = false;
            this.pause = false;
            this.botaoPlay.setText("Play");
            this.campoMusica.setText("");
            this.listMusicas.clearSelection();
        }
    }//GEN-LAST:event_botaoStopActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        try
        {
            DataBaseUsersSingleton.getInstance().remover("admin");
        } catch (UsuarioNaoExisteException ex)
        {

        }
        new UsersManager().gerarDataBase();
        new SongsManager().gerarDataBase();
        dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(TelaComum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TelaComum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TelaComum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TelaComum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                TelaComum dialog = new TelaComum(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoMusica;
    private javax.swing.JButton botaoPause;
    private javax.swing.JButton botaoPlay;
    private javax.swing.JButton botaoStop;
    private javax.swing.JTextField campoMusica;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPlayer;
    private javax.swing.JList<String> listMusicas;
    private javax.swing.JScrollPane panelListMusicas;
    private javax.swing.JPanel panelPlayer;
    // End of variables declaration//GEN-END:variables
}
