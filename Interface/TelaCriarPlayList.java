package Interface;

import Exceptions.BancoVazioException;
import Structs.PlayList;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class TelaCriarPlayList extends javax.swing.JDialog
{

    private final StringBuilder listDisponiveis;
    private StringBuilder listSelecionadas;
    private PlayList playList;

    public TelaCriarPlayList(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        
        this.listDisponiveis = new StringBuilder();
        this.listSelecionadas = new StringBuilder();
        this.playList = new PlayList();
        
        limparJLists();
        carregarMusicas();
    }
    
    public PlayList getPlayList()
    {
        return this.playList;
    }
    
    private void limparJLists()
    {
        String[] vazio = {};
        atualizarListMusicas(vazio, this.listMusicas);
        atualizarListMusicas(vazio, this.listPlayList);
    }
    
    private void atualizarListMusicas(String[] list, JList<String> jlist)
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

    private void carregarMusicas()
    {
        try
        {
            String str = DataBase.DataBaseSongsSingleton.getInstance().gerarRegistro();
            listDisponiveis.append(str);
            if (listDisponiveis != null)
            {
                String[] list = listDisponiveis.toString().split("\n");
                this.listMusicas.setModel(new javax.swing.AbstractListModel<String>()
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
        } catch (BancoVazioException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void atualizarSelecionadas()
    {
        String[] list = this.listSelecionadas.toString().split("\n");
        this.listPlayList.setModel(new javax.swing.AbstractListModel<String>()
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

        labelMusicas = new javax.swing.JLabel();
        listaDisponiveis = new javax.swing.JScrollPane();
        listMusicas = new javax.swing.JList<>();
        labelPlayList = new javax.swing.JLabel();
        listaSelecionadas = new javax.swing.JScrollPane();
        listPlayList = new javax.swing.JList<>();
        botaoAdd = new javax.swing.JButton();
        BotaoFinalizar = new javax.swing.JButton();
        BotaoCancelar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMusicas.setText("Musicas");
        getContentPane().add(labelMusicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        listMusicas.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaDisponiveis.setViewportView(listMusicas);

        getContentPane().add(listaDisponiveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 190, 220));

        labelPlayList.setText("PlayList");
        getContentPane().add(labelPlayList, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        listPlayList.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaSelecionadas.setViewportView(listPlayList);

        getContentPane().add(listaSelecionadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 190, 220));

        botaoAdd.setText("Adicionar");
        botaoAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoAddActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        BotaoFinalizar.setText("Finalizar");
        BotaoFinalizar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BotaoFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BotaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botaoRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(botaoRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoAddActionPerformed
    {//GEN-HEADEREND:event_botaoAddActionPerformed
        if (!this.listMusicas.getSelectedValue().equals(""))
        {
            this.listSelecionadas.append(this.listMusicas.getSelectedValue());
            this.listSelecionadas.append("\n");
            atualizarSelecionadas();
        }
    }//GEN-LAST:event_botaoAddActionPerformed

    private void BotaoFinalizarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BotaoFinalizarActionPerformed
    {//GEN-HEADEREND:event_BotaoFinalizarActionPerformed
        if (!this.listSelecionadas.toString().equals(""))
        {
            String musicas = this.listSelecionadas.toString();
            this.playList = this.playList.criarPlayList(musicas);
            JOptionPane.showMessageDialog(null, "PlayList criada com sucesso");
        }
        this.setVisible(false);
    }//GEN-LAST:event_BotaoFinalizarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botaoRemoverActionPerformed
    {//GEN-HEADEREND:event_botaoRemoverActionPerformed
        if (!this.listPlayList.getSelectedValue().equals(""))
        {
            String sb = this.listSelecionadas.toString().replace(this.listPlayList.getSelectedValue(), "");
            this.listSelecionadas = new StringBuilder();
            this.listSelecionadas.append(sb);
            atualizarSelecionadas();
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BotaoCancelarActionPerformed
    {//GEN-HEADEREND:event_BotaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BotaoCancelarActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                TelaCriarPlayList dialog = new TelaCriarPlayList(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotaoCancelar;
    private javax.swing.JButton BotaoFinalizar;
    private javax.swing.JButton botaoAdd;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JLabel labelMusicas;
    private javax.swing.JLabel labelPlayList;
    private javax.swing.JList<String> listMusicas;
    private javax.swing.JList<String> listPlayList;
    private javax.swing.JScrollPane listaDisponiveis;
    private javax.swing.JScrollPane listaSelecionadas;
    // End of variables declaration//GEN-END:variables
}
