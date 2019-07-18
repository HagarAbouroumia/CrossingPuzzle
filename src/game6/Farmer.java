package game6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

public class Farmer implements ICrosser {

    String lable = "Farmer";
    double weight = 100.2;
    ImageView farmerview;

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int getEatingRank() {
        return 4;
    }

    @Override
    public BufferedImage[] getImages() {
        int x = 4;
        BufferedImage[] bImg = new BufferedImage[x];

        bImg[0] = null;
        try {
            bImg[0] = ImageIO.read(new File("farmer.jpg"));
        } catch (IOException e1) {
        }
        bImg[1] = null;
        try {
            bImg[1] = ImageIO.read(new File("farmer2.jpg"));
        } catch (IOException e) {
        }
        bImg[2] = null;
        try {
            bImg[2] = ImageIO.read(new File("farmer3.jpg"));
        } catch (IOException e) {
        }
        bImg[3] = null;
        try {
            bImg[3] = ImageIO.read(new File("farmer4.jpg"));
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
        this.farmerview = imageView;
        return farmerview;
    }

    //  @Override
    public ImageView getImageView() {
        return farmerview;
    }

    // @Override
    public void setImageView(ImageView farmerview) {
        this.farmerview = farmerview;
    }

    @Override
    public ICrosser makeCopy() {
        return new Farmer();
    }

}
