package fivefishes.design.patterns.group.assignment.factorymethod.ingredient.mooncakeImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class KluangMooncakeImage extends MooncakeImage{

    public KluangMooncakeImage(){
        try {
            this.mooncakeImage = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/kluang_lotus_mooncake.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
