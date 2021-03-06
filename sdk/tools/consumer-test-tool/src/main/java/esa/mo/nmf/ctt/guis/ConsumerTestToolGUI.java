/* ----------------------------------------------------------------------------
 * Copyright (C) 2015      European Space Agency
 *                         European Space Operations Centre
 *                         Darmstadt
 *                         Germany
 * ----------------------------------------------------------------------------
 * System                : ESA NanoSat MO Framework
 * ----------------------------------------------------------------------------
 * Licensed under the European Space Agency Public License, Version 2.0
 * You may not use this file except in compliance with the License.
 *
 * Except as expressly set forth in this License, the Software is provided to
 * You on an "as is" basis and without warranties of any kind, including without
 * limitation merchantability, fitness for a particular purpose, absence of
 * defects or errors, accuracy or non-infringement of intellectual property rights.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * ----------------------------------------------------------------------------
 */
package esa.mo.nmf.ctt.guis;

import esa.mo.nmf.ctt.utils.DirectoryConnectionConsumerPanel;
import esa.mo.helpertools.connections.ConnectionConsumer;
import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.ccsds.moims.mo.com.COMHelper;
import org.ccsds.moims.mo.common.CommonHelper;
import org.ccsds.moims.mo.mal.MALContextFactory;
import org.ccsds.moims.mo.mal.MALException;
import org.ccsds.moims.mo.mal.MALHelper;
import org.ccsds.moims.mo.mc.MCHelper;
import org.ccsds.moims.mo.platform.PlatformHelper;
import org.ccsds.moims.mo.softwaremanagement.SoftwareManagementHelper;

/**
 * This class provides a simple form for the control of the consumer.
 */
public class ConsumerTestToolGUI extends javax.swing.JFrame {

    protected ConnectionConsumer connection = new ConnectionConsumer();

    /**
     * Main command line entry point.
     *
     * @param args the command line arguments
     */
    public static void main(final String args[]) {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
            // handle exception
        }

        final String name = System.getProperty("application.name", "CTT: Consumer Test Tool");
        final ConsumerTestToolGUI gui = new ConsumerTestToolGUI(name);
        gui.insertDirectoryServiceTab("");

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.setVisible(true);
            }
        });
    }

    /**
     * Creates new form MOConsumerGUI
     *
     * @param name The name to display on the title bar of the form.
     */
    public ConsumerTestToolGUI(final String name) {
        initComponents();
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mo_pic.png")));

        this.setLocationRelativeTo(null);
        this.setTitle(name);

        try {
            connection.loadURIs();
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "The URIs could not be loaded from the file!", "Error", JOptionPane.PLAIN_MESSAGE);
            Logger.getLogger(ConsumerTestToolGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            MALHelper.init(MALContextFactory.getElementFactoryRegistry());
            COMHelper.deepInit(MALContextFactory.getElementFactoryRegistry());
            MCHelper.deepInit(MALContextFactory.getElementFactoryRegistry());
            CommonHelper.deepInit(MALContextFactory.getElementFactoryRegistry());
            SoftwareManagementHelper.deepInit(MALContextFactory.getElementFactoryRegistry());
            PlatformHelper.deepInit(MALContextFactory.getElementFactoryRegistry());
        } catch (MALException ex) {
            Logger.getLogger(ConsumerTestToolGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void insertDirectoryServiceTab(final String defaultURI) {
        this.insertDirectoryServiceTab(defaultURI, false);
    }
    
    public void insertDirectoryServiceTab(final String defaultURI, final boolean isS2G) {
        final DirectoryConnectionConsumerPanel directoryTab = new DirectoryConnectionConsumerPanel(isS2G, connection, tabs);

        tabs.insertTab("Communication Settings (Directory)", null,
                directoryTab,
                "Communications Tab (Directory)", tabs.getTabCount());

        directoryTab.setURITextbox(defaultURI);
    }
    
    public JTabbedPane getTabs(){
        return tabs;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        homeTab = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1100, 600));
        getContentPane().setLayout(new java.awt.BorderLayout(0, 4));

        tabs.setToolTipText("");
        tabs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabs.setMaximumSize(new java.awt.Dimension(800, 600));
        tabs.setMinimumSize(new java.awt.Dimension(800, 600));
        tabs.setName("tabs"); // NOI18N
        tabs.setPreferredSize(new java.awt.Dimension(800, 600));
        tabs.setRequestFocusEnabled(false);

        homeTab.setName("homeTab"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Welcome!");
        jLabel6.setToolTipText("");
        jLabel6.setName("jLabel6"); // NOI18N
        homeTab.add(jLabel6);

        jPanel8.setName("jPanel8"); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(2510, 25));

        jSeparator6.setName("jSeparator6"); // NOI18N
        jSeparator6.setPreferredSize(new java.awt.Dimension(700, 15));
        jPanel8.add(jSeparator6);

        homeTab.add(jPanel8);

        jLabel3.setName("jLabel3"); // NOI18N
        homeTab.add(jLabel3);

        tabs.addTab("Home", homeTab);

        getContentPane().add(tabs, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel homeTab;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
