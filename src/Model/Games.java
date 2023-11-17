/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Devid L Manurung
 */
public class Games {
    private int id;
    private String name;
    private String genre;
    private int price;
    private ArrayList<Transactions> listTransactions;

    public Games(int id, String name, String genre, int price, ArrayList<Transactions> listTransactions) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.listTransactions = listTransactions;
    }

    public Games() {
     
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Transactions> getListTransactions() {
        return listTransactions;
    }

    public void setListTransactions(ArrayList<Transactions> listTransactions) {
        this.listTransactions = listTransactions;
    }
}
