package game6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

public class Herbivorous implements ICrosser {

    String label = "Herbivorous";
    ImageView goatview;

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public double getWeight() {
        return 20;
    }

    @Override
    public int getEatingRank() {
        return 2;
    }

    @Override
    public BufferedImage[] getImages() {
        int x = 50;
        BufferedImage[] bImg = new BufferedImage[x];

        bImg[0] = null;
        try {
            bImg[0] = ImageIO.read(new File("goat.jpg"));
        } catch (IOException e1) {
        }
        bImg[1] = null;
        try {
            bImg[1] = ImageIO.read(new File("goat.jpg"));
        } catch (IOException e) {
        }
        return bImg;
    }

    @Override
    public String getLabelShown() {
        return label;
    }

    @Override
    public void setLabelToShown(String label) {
        this.label = label;
    }

    //@Override
    public ImageView setImage(ImageView imageView) {
        this.goatview = imageView;
        return goatview;
    }


   // @Override
    public ImageView getImageView() {
        return goatview;
    }

  //  @Override
    public void setImageView(ImageView goatview) {
        this.goatview = goatview;
    }

    @Override
    public ICrosser makeCopy() {
        return new Herbivorous();
    }
  

}
