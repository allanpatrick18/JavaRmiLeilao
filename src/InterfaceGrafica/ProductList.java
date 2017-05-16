/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import cliente.Main;

import static cliente.Main.controle;
import static cliente.Main.id;
import static cliente.Main.list;

import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servidor.Clientes;
import servidor.Produto;

/**
 *
 * @author Jessica
 */
public class ProductList extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    //  InicialMenu inicialMenu = null;
    AuctionRegister auctionRegister = null;
    BidRegister bidRegister = null;

    public ProductList() {
        //   this.inicialMenu = inicialMenu;
        
        this.auctionRegister = new AuctionRegister(this);
        this.bidRegister = new BidRegister(this);
        initComponents();
        
        nomeCli.setText(Main.nome);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        meusProdutos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        notificacao = new java.awt.Label();
        label2 = new java.awt.Label();
        jButton2 = new javax.swing.JButton();
        updateList = new javax.swing.JButton();
        registraLance = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nomeCli = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        meusProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Produto", "Descrição", "Preço Atual", "Lance por", "Leiloeiro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(meusProdutos);

        notificacao.setText("Nenhuma mensagem.");

        label2.setText("Notificações:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(notificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton2.setText("Registra Leilão");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        updateList.setText("Atualiza Lista");
        updateList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateListActionPerformed(evt);
            }
        });

        registraLance.setText("Registra Lance");
        registraLance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registraLanceActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do processo dessa janela:");

        nomeCli.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registraLance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomeCli)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registraLance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateList)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        auctionRegister.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void updateListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateListActionPerformed
        //  DefaultTableModel yourModel = (DefaultTableModel) meusProdutos.getModel();
        try {
            atualiza();
        } catch (RemoteException ex) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateListActionPerformed

    private void registraLanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registraLanceActionPerformed

        try {
            //Para saber a linha selecionada:
       Integer linha = meusProdutos.getSelectedRow(); //retorna um inteiro
            
      if(linha>=0){
         bidRegister.setDados(list.get(linha));
         bidRegister.setVisible(true);
         this.setVisible(false);
      }else{
          JOptionPane.showMessageDialog(rootPane, "Selecione um produto para dar o lance");
      
      }
            
//        int column = meusProdutos.getColumnCount();
//        //Para pegar um valor da linha:
//
//        Object column1;
//        String nameProd = "";
//        String descriProd = "";
//        Integer ultimoPreco = 0;
//        String lancador = "";
//        String leiloeiro = "";
//        
//        Produto produto;
//        if (linha >=0) {
//
//          
//                column1 = meusProdutos.getValueAt(linha, 0);
//                if (column1 instanceof String) {
//                    nameProd = (String) column1;
//                    
//                    System.out.println(nameProd);
//                }
//
//        
//                column1 = meusProdutos.getValueAt(linha,1);
//                if (column1 instanceof String) {
//                    descriProd =  (String) column1;
//                       System.out.println(descriProd);
//                }
//
//                
//                column1 = meusProdutos.getValueAt(linha,2);
//                if (column1 instanceof Integer) {
//                    ultimoPreco =   (Integer)column1;
//                       System.out.println(ultimoPreco);
//                }
//                
//                column1 = meusProdutos.getValueAt(linha,3);
//                if (column1 instanceof String) {
//                    lancador =  (String) column1;
//                       System.out.println(lancador);
//                }
//                
//                   column1 = meusProdutos.getValueAt(linha,4);
//                if (column1 instanceof String) {
//                    leiloeiro =  (String) column1;
//                       System.out.println(leiloeiro);
//                }
//         
//                bidRegister.setVisible(true);
//                this.setVisible(false);
//
//
//            
//            produto = new Produto(nameProd, descriProd, ultimoPreco, lancador, leiloeiro);
//            
//            bidRegister.adicionaValoresSobreProduto(nameProd, descriProd, ultimoPreco, lancador, leiloeiro);
//
//        
//        }else{
//            JOptionPane.showConfirmDialog(rootPane, "Selecione um produto para dar o lance!");
//        }
        } catch (RemoteException ex) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_registraLanceActionPerformed

    public void atualiza() throws RemoteException {
//        List<Produto> p = controle.listarProdutos();
        list = controle.listarProdutos();

        DefaultTableModel yourModel = (DefaultTableModel) meusProdutos.getModel();
        
        yourModel.getDataVector().removeAllElements();
        for (Produto pro : list) {
            if( pro.getUltimoLancador() == null  ){
          
            yourModel.addRow(new Object[]{pro.getName(), pro.getDescricao(), 
                pro.getPrecoFinal(), "Nenhum Lance",
               pro.getLeiloador().getNome()});
            }else{
                
                 yourModel.addRow(new Object[]{pro.getName(), pro.getDescricao(), pro.getPrecoFinal(),
                     pro.getUltimoLancador().getNome(),
                pro.getLeiloador().getNome() });
            }
        }

        

    }

    public void notificaCliente(String notificacao) {
        
        this.notificacao.setText(notificacao);
    }

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
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ProductList().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label2;
    private javax.swing.JTable meusProdutos;
    private javax.swing.JLabel nomeCli;
    private java.awt.Label notificacao;
    private javax.swing.JButton registraLance;
    private javax.swing.JButton updateList;
    // End of variables declaration//GEN-END:variables
}
