package game6;

import java.awt.image.BufferedImage;
import javafx.scene.image.ImageView;

public interface ICrosser {

    public ImageView getImageView();

    public void setImageView(ImageView imageView);

    public boolean canSail();

    public double getWeight();

    public int getEatingRank();

    public BufferedImage[] getImages();

    public void setLabelToShown(String label);

    public String getLabelShown();

    public ImageView setImage(ImageView imageView);

    public ICrosser makeCopy();

}
