package fivefishes.design.patterns.group.assignment.entities.abstractFactory.ingredient.mooncakeImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TraditionalMooncakeImage extends MooncakeImage{
    public TraditionalMooncakeImage(){
        try {
            this.mooncakeImage = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/abstractFactory/traditional_lotus_mooncake.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
