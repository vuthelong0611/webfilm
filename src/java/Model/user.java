/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hp
 */
public class user {
    private String name,pass,nickname;
    private int role,id;

    public user() {
    }

    public user(String name, String pass, int role, String nickname) {
        this.name = name;
        this.pass = pass;
        this.role = role;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public user(String name, String pass, String nickname, int role, int id) {
        this.name = name;
        this.pass = pass;
        this.nickname = nickname;
        this.role = role;
        this.id = id;
    }

    public user(String name, String pass, String nickname) {
        this.name = name;
        this.pass = pass;
        this.nickname = nickname;
    }
    
    
    
}
