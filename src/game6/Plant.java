package game6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

public class Plant implements ICrosser {

    String label = "Apple";
    ImageView appleview;

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public double getWeight() {
        return 1;
    }

    @Override
    public int getEatingRank() {
        return 1;
    }

    @Override
    public BufferedImage[] getImages() {
        int x = 50;
        BufferedImage[] bImg = new BufferedImage[x];

        bImg[0] = null;
        try {
            bImg[0] = ImageIO.read(new File("apple.jpg"));
        } catch (IOException e1) {
        }
        bImg[1] = null;
        try {
            bImg[1] = ImageIO.read(new File("apple2.jpg"));
        } catch (IOException e1) {
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

    // @Override
    public ImageView setImage(ImageView imageView) {
        this.appleview = imageView;
        return appleview;
    }

    // @Override
    public ImageView getImageView() {
        return appleview;
    }

    // @Override
    public void setImageView(ImageView appleview) {
        this.appleview = appleview;
    }

    @Override
    public ICrosser makeCopy() {
        return new Plant();
    }

}
