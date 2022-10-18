package fc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class GestionnaireImage {
    private static GestionnaireImage instance;

    private final ArrayList<BufferedImage> images;
    private int pointeur;
    private final Random r;
    private boolean boucle;

    private GestionnaireImage(){
        images = new ArrayList<>();
        pointeur = 0;
        r = new Random();
        boucle = false;
    }

    public static GestionnaireImage getInstance(){
        if (instance == null) instance = new GestionnaireImage();
        return instance;
    }

    public void clean(){
        images.clear();
        pointeur = 0;
        boucle = false;
    }

    public void setBoucle(boolean boucle) {
        this.boucle = boucle;
    }

    public BufferedImage getImage(){
        if (images.isEmpty()) return null;
        return images.get(pointeur);
    }

    public void shuffle(){
        BufferedImage tmp;
        for (int i = 0; i < images.size(); i++){
            int move = r.nextInt(images.size() - i - 1);
            tmp = images.get(i);
            images.set(i, images.get(move));
            images.set(move, tmp);
        }
    }

    public void add(String path){
        File obj = new File(path);
        if (obj.isDirectory()){
            addDir(obj);
            return;
        }
        if (isPicture(path)){
            addImage(obj);
            return;
        }
    }

    private void addImage(File f){
        try {
            images.add(ImageIO.read(f));
        } catch (Exception ignored){}
    }

    private void addDir(File f){
        for (File fils : Objects.requireNonNull(f.listFiles())) add(fils.getPath());
    }

    private boolean isPicture(String path){
        if (path.endsWith("png")) return true;
        if (path.endsWith("jpg")) return true;
        return false;
    }

    public void next(){
        pointeur++;
        if (pointeur >= images.size()){
            pointeur--;
            if (boucle) pointeur = 0;
        }
    }

    public void before(){
        pointeur--;
        if (pointeur<0){
            pointeur++;
            if (boucle) pointeur = images.size()-1;
        }
    }
}
