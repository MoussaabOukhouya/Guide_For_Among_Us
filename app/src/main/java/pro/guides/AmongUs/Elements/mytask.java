package pro.guides.AmongUs.Elements;


import java.io.Serializable;

public class mytask implements Serializable {
    private String name;
    private String type;
    private String gameplay;
    private String maps;
    private int img;

    public mytask(String name, String type, String gameplay, String maps, int img) {
        this.name = name;
        this.type = type;
        this.gameplay = gameplay;
        this.maps = maps;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGameplay() {
        return gameplay;
    }

    public void setGameplay(String gameplay) {
        this.gameplay = gameplay;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
