package fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.mooncakeImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ShanghaiMooncakeImage extends MooncakeImage{
    public ShanghaiMooncakeImage(){
        try {
            this.mooncakeImage = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/abstractFactory/shanghai_lotus_mooncake.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
