package Interface;

import App.FileChooser;
import DataBase.DataBaseSongsSingleton;
import DataBase.DataBaseUsersSingleton;
import DataBase.PlayListManager;
import DataBase.SongsManager;
import DataBase.UsersManager;
import Exceptions.BancoVazioException;
import Exceptions.LoginIndisponivelException;
import Exceptions.UsuarioNaoExisteException;
import MediaPlayer.MediaPlayer;
import Structs.PlayList;
import Users.Usuario;
import Users.UsuarioAdm;
import Users.UsuarioComum;
import Users.UsuarioVip;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class TelaVip extends javax.swing.JDialog
{

    private final MediaPlayer player;
    private boolean pause;
    private boolean playing;
    private final java.awt.Frame parent;
    private UsuarioVip user;
    private final String[] vazio =
    {
    };
    private Thread t;

    public TelaVip(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();

        this.player = new MediaPlayer();
        this.pause = false;
        this.playing = false;
        this.parent = parent;
        this.configComboBox();

        limparJLists();
        atualizarListaMusicas();
        carregarPlaylists();

        this.setTitle(user.getNome());
    }

    public TelaVip(java.awt.Frame parent, boolean modal, Usuario user)
    {
        super(parent, modal);
        initComponents();

        this.player = new MediaPlayer();
        this.pause = false;
        this.playing = false;
        this.parent = parent;
        this.user = (UsuarioVip) user;
        this.configComboBox();

        limparJLists();
        atualizarListaMusicas();
        carregarPlaylists();

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

    private void carregarPlaylists()
    {
        for (PlayList p : this.user.getPlayLists())
        {
            this.comboBoxPlayList.addItem(p.getNome());
        }
    }

    private void limparJLists()
    {
        atualizarJList(vazio, this.listMusicas);
        atualizarJList(vazio, this.listPlayListMusicas);
    }

    private void autoComplete()
    {
        try
        {
            if (!this.campoMusica.getText().equals(""))
            {
                String[] list = DataBaseSongsSingleton.getInstance().buscarPalavra(this.campoMusica.getText());
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

    private void configComboBox()
    {
        this.comboBoxPlayList.removeAllItems();
        this.comboBoxTipoUser.removeAllItems();
        this.comboBoxTipoUser.addItem("Comum");
    }

    private void addUsuarioComum(String nome, String login, String senha)
    {
        try
        {
            DataBase.DataBaseUsersSingleton.getInstance().inserir(new UsuarioComum(nome, login, senha));
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        } catch (LoginIndisponivelException e)
        {
            JOptionPane.showMessageDialog(null, login + " ja existe");
        } finally
        {
            this.campoLogin.setText("");
            this.campoNome.setText("");
            this.campoSenha.setText("");
        }
    }

    private void addUsuarioVip(String nome, String login, String senha)
    {
        try
        {
            DataBase.DataBaseUsersSingleton.getInstance().inserir(new UsuarioVip(nome, login, senha));
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        } catch (LoginIndisponivelException e)
        {
            JOptionPane.showMessageDialog(null, login + " ja existe");
        } finally
        {
            this.campoLogin.setText("");
            this.campoNome.setText("");
            this.campoSenha.setText("");
        }
    }

    private void addUsuarioAdm(String nome, String login, String senha)
    {
        try
        {
            DataBase.DataBaseUsersSingleton.getInstance().inserir(new UsuarioAdm(nome, login, senha));
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        } catch (LoginIndisponivelException e)
        {
            JOptionPane.showMessageDialog(null, login + " ja existe");
        } finally
        {
            this.campoLogin.setText("");
            this.campoNome.setText("");
            this.campoSenha.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        panelCadastrar = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        comboBoxTipoUser = new javax.swing.JComboBox<>();
        campoNome = new javax.swing.JTextField();
        campoLogin = new javax.swing.JTextField();
        botaoAdd = new javax.swing.JButton();
        labelCadastrar = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        panelPlayer = new javax.swing.JPanel();
        botaoMusica = new javax.swing.JButton();
        campoMusica = new javax.swing.JTextField();
        botaoPlay = new javax.swing.JButton();
        botaoPause = new javax.swing.JButton();
        botaoStop = new javax.swing.JButton();
        labelPlayer = new javax.swing.JLabel();
        panelListMusicas = new javax.swing.JScrollPane();
        listMusicas = new javax.swing.JList<>();
        panelPlayList = new javax.swing.JPanel();
        labelPlayLists = new javax.swing.JLabel();
        comboBoxPlayList = new javax.swing.JComboBox<>();
        panelListPlayListMusicas = new javax.swing.JScrollPane();
        listPlayListMusicas = new javax.swing.JList<>();
        botaoCriarPlaylist = new javax.swing.JButton();
        botaoPlayList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCadastrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setText("Nome:");
        panelCadastrar.add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        labelLogin.setText("Login:");
        panelCadastrar.add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        labelSenha.setText("Senha:");
        panelCadastrar.add(labelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        comboBoxTipoUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxTipoUser.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comboBoxTipoUserActionPerformed(evt);
            }
        });
        panelCadastrar.add(comboBoxTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));
        panelCadastrar.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 120, -1));
        panelCadastrar.add(campoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 120, -1));

        botaoAdd.setText("Adicionar");
        botaoAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoAddActionPerformed(evt);
            }
        });
        panelCadastrar.add(botaoAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        labelCadastrar.setText("Cadastrar Usuario");
        panelCadastrar.add(labelCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));
        panelCadastrar.add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 120, -1));

        jPanel1.add(panelCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 250));

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

        jPanel1.add(panelPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 290, 320));

        panelPlayList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelPlayList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPlayLists.setText("PlayList");
        panelPlayList.add(labelPlayLists, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        comboBoxPlayList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxPlayList.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                comboBoxPlayListItemStateChanged(evt);
            }
        });
        comboBoxPlayList.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseMoved(java.awt.event.MouseEvent evt)
            {
                comboBoxPlayListMouseMoved(evt);
            }
        });
        comboBoxPlayList.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                comboBoxPlayListFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                comboBoxPlayListFocusLost(evt);
            }
        });
        comboBoxPlayList.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                comboBoxPlayListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                comboBoxPlayListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                comboBoxPlayListMouseExited(evt);
            }
        });
        comboBoxPlayList.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comboBoxPlayListActionPerformed(evt);
            }
        });
        panelPlayList.add(comboBoxPlayList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, -1));

        listPlayListMusicas.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        panelListPlayListMusicas.setViewportView(listPlayListMusicas);

        panelPlayList.add(panelListPlayListMusicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 230));

        botaoCriarPlaylist.setText("Criar Playlist");
        botaoCriarPlaylist.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoCriarPlaylistActionPerformed(evt);
            }
        });
        panelPlayList.add(botaoCriarPlaylist, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        botaoPlayList.setText("Reproduzir playlist");
        botaoPlayList.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoPlayListActionPerformed(evt);
            }
        });
        panelPlayList.add(botaoPlayList, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        jPanel1.add(panelPlayList, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 250, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxTipoUserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_comboBoxTipoUserActionPerformed
    {//GEN-HEADEREND:event_comboBoxTipoUserActionPerformed

    }//GEN-LAST:event_comboBoxTipoUserActionPerformed

    private void botaoAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoAddActionPerformed
    {//GEN-HEADEREND:event_botaoAddActionPerformed
        if (!this.campoLogin.getText().equals("") && !this.campoNome.getText().equals("") && !this.campoSenha.getText().equals(""))
        {
            switch (this.comboBoxTipoUser.getSelectedIndex())
            {
                case (0):
                    this.addUsuarioComum(this.campoNome.getText(), this.campoLogin.getText(), this.campoSenha.getText());
                    break;
                case (1):
                    this.addUsuarioVip(this.campoNome.getText(), this.campoLogin.getText(), this.campoSenha.getText());
                    break;
                case (2):
                    this.addUsuarioAdm(this.campoNome.getText(), this.campoLogin.getText(), this.campoSenha.getText());
                    break;
                default:
                    this.campoLogin.setText("");
                    this.campoNome.setText("");
                    this.campoSenha.setText("");
                    JOptionPane.showMessageDialog(null, "Selecione algum tipo de usuario e tente novamente");
                    break;
            }
        }
        else
        {
            this.campoLogin.setText("");
            this.campoNome.setText("");
            this.campoSenha.setText("");
            JOptionPane.showMessageDialog(null, "Preencha todos os campos e tente novamente");
        }
    }//GEN-LAST:event_botaoAddActionPerformed

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
            this.botaoPlayList.setEnabled(false);
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
            this.botaoPlayList.setEnabled(false);
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
            this.botaoPlayList.setEnabled(true);
            this.player.stop();
            this.playing = false;
            this.pause = false;
            this.botaoPlay.setText("Play");
            this.campoMusica.setText("");
            this.listMusicas.clearSelection();
        }
    }//GEN-LAST:event_botaoStopActionPerformed

    private void comboBoxPlayListItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_comboBoxPlayListItemStateChanged
    {//GEN-HEADEREND:event_comboBoxPlayListItemStateChanged

    }//GEN-LAST:event_comboBoxPlayListItemStateChanged

    private void comboBoxPlayListMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_comboBoxPlayListMouseMoved
    {//GEN-HEADEREND:event_comboBoxPlayListMouseMoved

    }//GEN-LAST:event_comboBoxPlayListMouseMoved

    private void comboBoxPlayListFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_comboBoxPlayListFocusGained
    {//GEN-HEADEREND:event_comboBoxPlayListFocusGained
        atualizarJList(vazio, this.listPlayListMusicas);

        StringBuilder sb = new StringBuilder();
        for (String str : this.user.getPlayList(this.comboBoxPlayList.getSelectedIndex()).getMusicas())
        {
            sb.append(str);
            //sb.append(str.substring(str.lastIndexOf("\\") + 1, str.lastIndexOf(".")));
            sb.append("\n");
        }
        atualizarJList(sb.toString().split("\n"), this.listPlayListMusicas);
    }//GEN-LAST:event_comboBoxPlayListFocusGained

    private void comboBoxPlayListFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_comboBoxPlayListFocusLost
    {//GEN-HEADEREND:event_comboBoxPlayListFocusLost
        atualizarJList(vazio, this.listPlayListMusicas);

        StringBuilder sb = new StringBuilder();
        for (String str : this.user.getPlayList(this.comboBoxPlayList.getSelectedIndex()).getMusicas())
        {
            sb.append(str);
            //sb.append(str.substring(str.lastIndexOf("\\") + 1, str.lastIndexOf(".")));
            sb.append("\n");
        }

        atualizarJList(sb.toString().split("\n"), this.listPlayListMusicas);
    }//GEN-LAST:event_comboBoxPlayListFocusLost

    private void comboBoxPlayListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_comboBoxPlayListMouseClicked
    {//GEN-HEADEREND:event_comboBoxPlayListMouseClicked

    }//GEN-LAST:event_comboBoxPlayListMouseClicked

    private void comboBoxPlayListMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_comboBoxPlayListMouseEntered
    {//GEN-HEADEREND:event_comboBoxPlayListMouseEntered

    }//GEN-LAST:event_comboBoxPlayListMouseEntered

    private void comboBoxPlayListMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_comboBoxPlayListMouseExited
    {//GEN-HEADEREND:event_comboBoxPlayListMouseExited

    }//GEN-LAST:event_comboBoxPlayListMouseExited

    private void comboBoxPlayListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_comboBoxPlayListActionPerformed
    {//GEN-HEADEREND:event_comboBoxPlayListActionPerformed

    }//GEN-LAST:event_comboBoxPlayListActionPerformed

    private void botaoCriarPlaylistActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoCriarPlaylistActionPerformed
    {//GEN-HEADEREND:event_botaoCriarPlaylistActionPerformed
        TelaCriarPlayList tela = new TelaCriarPlayList(parent, true);
        tela.setVisible(true);
        while (tela.isVisible())
        {

        }
        this.user.addPlayList(tela.getPlayList());
        this.comboBoxPlayList.addItem(tela.getPlayList().getNome());

        StringBuilder sb = new StringBuilder();
        for (String str : tela.getPlayList().getMusicas())
        {
            sb.append(str);
            //sb.append(str.substring(str.lastIndexOf("\\") + 1, str.lastIndexOf(".")));
            sb.append("\n");
        }
        String[] list = sb.toString().split("\n");
        atualizarJList(list, this.listPlayListMusicas);
    }//GEN-LAST:event_botaoCriarPlaylistActionPerformed

    private void botaoPlayListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoPlayListActionPerformed
    {//GEN-HEADEREND:event_botaoPlayListActionPerformed
        StringBuilder musicas = new StringBuilder();

        for (int i = 0; i < this.listPlayListMusicas.getModel().getSize(); i++)
        {
            musicas.append(this.listPlayListMusicas.getModel().getElementAt(i));
            musicas.append("\n");
        }

        if (!this.playing)
        {
            this.playing = true;
            this.pause = false;
            t = new Thread(this.player.createRunnable(musicas.toString().split("\n")));
            t.start();
            this.botaoPlay.setText("Play");
            this.listMusicas.clearSelection();
            this.listMusicas.setEnabled(false);
            this.botaoMusica.setEnabled(false);
            this.botaoPlay.setEnabled(false);
        }
    }//GEN-LAST:event_botaoPlayListActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosed
    {//GEN-HEADEREND:event_formWindowClosed
        new PlayListManager().gerarPlayLists();
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
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(TelaVip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TelaVip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TelaVip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TelaVip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                TelaVip dialog = new TelaVip(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botaoAdd;
    private javax.swing.JButton botaoCriarPlaylist;
    private javax.swing.JButton botaoMusica;
    private javax.swing.JButton botaoPause;
    private javax.swing.JButton botaoPlay;
    private javax.swing.JButton botaoPlayList;
    private javax.swing.JButton botaoStop;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JTextField campoMusica;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JComboBox<String> comboBoxPlayList;
    private javax.swing.JComboBox<String> comboBoxTipoUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCadastrar;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPlayLists;
    private javax.swing.JLabel labelPlayer;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JList<String> listMusicas;
    private javax.swing.JList<String> listPlayListMusicas;
    private javax.swing.JPanel panelCadastrar;
    private javax.swing.JScrollPane panelListMusicas;
    private javax.swing.JScrollPane panelListPlayListMusicas;
    private javax.swing.JPanel panelPlayList;
    private javax.swing.JPanel panelPlayer;
    // End of variables declaration//GEN-END:variables
}
