package game6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

public class Carnivorous implements ICrosser {

    String lable = "lion";
    double weight = 200;
    ImageView lionview;

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getEatingRank() {
        return 3;
    }

    @Override
    public BufferedImage[] getImages() {
        int x = 50;
        BufferedImage[] bImg = new BufferedImage[x];

        bImg[0] = null;
        try {
            bImg[0] = ImageIO.read(new File("lion.jpeg"));
        } catch (IOException e1) {
        }
        bImg[1] = null;
        try {
            bImg[1] = ImageIO.read(new File("lion.jpeg"));
        } catch (IOException e) {
        }
        return bImg;
    }

    @Override
    public void setLabelToShown(String lable) {
        this.lable = lable;
    }

    @Override
    public String getLabelShown() {
        return lable;
    }

   // @Override
    public ImageView setImage(ImageView imageView) {
        this.lionview = imageView;
        return lionview;

    }

    //@Override
    public ImageView getImageView() {
        return lionview;
    }

   // @Override
    public void setImageView(ImageView lionview) {
        this.lionview = lionview;
    }

    @Override
    public ICrosser makeCopy() {
        return new Carnivorous();
    }

}
