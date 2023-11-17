package View;

import Controller.Controller;
import Model.Users;
import Model.Games;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

/**
 *
 * @author Devid L Manurung
 */
public class MenuGameList extends JFrame {

    public MenuGameList(Users loggedInUser) {
        Controller control = new Controller();
        JFrame jframe = new JFrame();
        jframe.setTitle("Menu Game");
        jframe.setSize(500, 550);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);

        JButton bTransactions = new JButton("Transactions");
        bTransactions.setBounds(125, 20, 80, 20);
        bTransactions.setEnabled(true);
        jframe.add(bTransactions);

        bTransactions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuTransactions();
            }
        });

        JLabel labelNamaGame = new JLabel("Nama Game : ");
        labelNamaGame.setBounds(10, 70, 80, 20);
        jframe.add(labelNamaGame);

        JTextField fieldNamaGame = new JTextField(20);
        fieldNamaGame.setBounds(100, 70, 180, 20);
        jframe.add(fieldNamaGame);

        JLabel labelGenreGame = new JLabel("Genre Game : ");
        labelGenreGame.setBounds(10, 120, 80, 20);
        jframe.add(labelGenreGame);

        JTextField fieldGenreGame = new JTextField(20);
        fieldGenreGame.setBounds(100, 120, 180, 20);
        jframe.add(fieldGenreGame);

        JLabel labelPriceGame = new JLabel("Price Game : ");
        labelPriceGame.setBounds(10, 170, 80, 20);
        jframe.add(labelPriceGame);

        JTextField fieldPriceGame = new JTextField(20);
        fieldPriceGame.setBounds(100, 170, 180, 20);
        jframe.add(fieldPriceGame);

        JButton buyGame = new JButton("Buy Game");
        buyGame.setBounds(50, 250, 80, 20);
        buyGame.setEnabled(true);
        jframe.add(buyGame);

        buyGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namaGame = fieldNamaGame.getText();
                String genreGame = fieldGenreGame.getText();
                int priceGame = fieldPriceGame.getColumns();

                
                Games newGame = new Games();
                newGame.setName(namaGame);
                newGame.setGenre(genreGame);
                newGame.setPrice(priceGame);
                

                boolean inserted = control.insertNewGames(newGame);

                if (inserted) {
                    JOptionPane.showMessageDialog(null, "Registrasi Berhasil!");
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal melakukan registrasi.");
                }

            }
        });
    }

    public void setVisible(boolean b) {

    }
   
    
}
