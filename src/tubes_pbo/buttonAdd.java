/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_pbo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static tubes_pbo.GUI.hargaText;
import static tubes_pbo.GUI.jumlahText;
import static tubes_pbo.GUI.makananText1;
import static tubes_pbo.GUI.minumanText1;
import static tubes_pbo.GUI.tabelMakanan;
import static tubes_pbo.GUI.tabelMinuman;

/**
 *
 * @author Pepita Neysa
 */
public class buttonAdd {

    DefaultTableModel mknTabel;
    DefaultTableModel mnmTabel;
    DefaultTableModel troli;
    String alamatStokmkn, alamatStokmnm;
    File fileStok1, fileStok2;
    BufferedWriter tulisStokmkn, tulisStokmnm;

    public void buttonAddmkn(JTable tabelMakanan, JTable tabelPesan, int a) {
        mknTabel = (DefaultTableModel) tabelMakanan.getModel();
        String kb = mknTabel.getValueAt(a, 0).toString();
        String nb = mknTabel.getValueAt(a, 1).toString();
        String hb = jumlahText.getText();
        //kurangi stok
        String strstok = mknTabel.getValueAt(a, 3).toString();
        int hrg = Integer.parseInt(nb);
        int stok = Integer.parseInt(strstok) - 1;
        int subtxt = Integer.parseInt(hb);
        int sub = subtxt * hrg;
        if (stok < 0) {
            JOptionPane.showMessageDialog(null, "Stok Habis");
        } else {
            mknTabel.setValueAt(Integer.toString(stok), a, 3);
            List data = new ArrayList<>();
            data.add(kb);
            data.add(nb);
            data.add(hb);
            data.add(sub);

            //masuk keranjang
            DefaultTableModel mdl = (DefaultTableModel) tabelPesan.getModel();
            mdl.addRow(data.toArray());

            makananText1.setText("");
            hargaText.setText("");
            jumlahText.setText("");
        }
    }

    public void buttonAddmnm(JTable tabelMinuman, JTable tabelPesan, int a) {
        mnmTabel = (DefaultTableModel) tabelMinuman.getModel();
        String kb = mnmTabel.getValueAt(a, 0).toString();
        String nb = mnmTabel.getValueAt(a, 1).toString();
        String hb = jumlahText.getText();
        //kurangi stok
        String strstok = mnmTabel.getValueAt(a, 3).toString();
        int hrg = Integer.parseInt(nb);
        int stok = Integer.parseInt(strstok) - 1;
        int subtxt = Integer.parseInt(hb);
        int sub = subtxt * hrg;
        if (stok < 0) {
            JOptionPane.showMessageDialog(null, "Stok Habis");
        } else {
            mnmTabel.setValueAt(Integer.toString(stok), a, 3);
            List data1 = new ArrayList<>();
            data1.add(kb);
            data1.add(nb);
            data1.add(hb);
            data1.add(sub);

            //masuk keranjang
            DefaultTableModel md2 = (DefaultTableModel) tabelPesan.getModel();
            md2.addRow(data1.toArray());

            minumanText1.setText("");
            hargaText.setText("");
            jumlahText.setText("");
        }
    }
}