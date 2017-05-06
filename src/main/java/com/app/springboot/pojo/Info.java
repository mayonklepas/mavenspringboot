/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.springboot.pojo;

/**
 *
 * @author Mulyadi
 */
public class Info {
    
    public String nama;
    public String alamat;

    public Info() {
    }

    public Info(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }
    
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
}
