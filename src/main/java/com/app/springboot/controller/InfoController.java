/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.springboot.controller;

import com.app.springboot.helper.Dbhelper;
import com.app.springboot.pojo.Info;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mulyadi
 */
@Controller
public class InfoController {
    
    Dbhelper dbh=new Dbhelper();

    @GetMapping("/info")
    public String infoForm(Model model) {
        model.addAttribute("info", new Info());
        try {
            dbh.connect();
            ResultSet res=dbh.read("SELECT * FROM orang").executeQuery();
            while (res.next()) {                
                new Info(res.getString("nama"), res.getString("alamat"));
            }
            dbh.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(InfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "info";
    }

    @PostMapping("/info")
    public String infosubmit(@ModelAttribute Info info) {
        try {
            dbh.connect();
            Object[] o=new Object[2];
            o[0]=info.nama;
            o[1]=info.alamat;
            dbh.insert("INSERT INTO orang(nama,alamat) VALUES (?,?)", 2, o);
            dbh.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(InfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "hasilinfo";
    }

}
