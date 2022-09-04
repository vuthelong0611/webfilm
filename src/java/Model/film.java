/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hp
 */
public class film {
    private int id;
    private String name,img,video;
    private int view;

    public film() {
    }

    public film(int id, String name, String img, String video) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.video = video;
       
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

  

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public film(int id, String name, String img, String video, int view) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.video = video;

        this.view = view;
    }

    public film(String name, String img, String video) {
        this.name = name;
        this.img = img;
        this.video = video;
 
    }
   
}
