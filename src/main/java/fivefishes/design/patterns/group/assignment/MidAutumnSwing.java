package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.entities.lantern.Bright;
import fivefishes.design.patterns.group.assignment.entities.lantern.Dim;
import fivefishes.design.patterns.group.assignment.entities.lantern.Lantern;
import fivefishes.design.patterns.group.assignment.entities.lantern.NoLight;
import fivefishes.design.patterns.group.assignment.entities.lantern.Normal;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MidAutumnSwing extends JFrame implements ActionListener {
    //Buttons
    private JButton lightButton;
    private JButton exitButton;

    //Panels
    private JPanel titlePanel, backgroundImagePanel, buttonPanel;

    //Labels
    private JLabel title, backgroundImageLabel;

    //Image
    private BufferedImage image;

    //init Lantern variable
    private JComboBox<String> lanternLightOptions = new JComboBox<>();
    private Lantern lantern;
    
    private boolean lights = false;

    private int imageHeight;
    private Image resizedImage;

    private final int buttonPanelHeight = 150;
    private int imageStartXaxis;
    private int imageStartYaxis;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

//    private String testImageUrl;
//    private Image testImage;
//    private String staticTestImageUrl = "src/main/java/fivefishes/design/patterns/group/assignment/resources/ChangEr/redblue.png";
//    private Image staticTestImage;

    public MidAutumnSwing() {
        //Set title
        setTitle("Decorate the Christmas tree!");

        setLayout(new BorderLayout());

        //Setting the title of the JLabel
        title = new JLabel("Creative Designed By 30000007333 From <a href=\"https://lovepik.com/image-400492940/mid-autumn-festival-background.html\">LovePik.com</a>");

        //Setting the font
        title.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 15));

        //Setting the text colour to red and positioning it to the centre
        title.setForeground(Color.red);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        //Creating a new JPanel and adding the title label to it
        titlePanel = new JPanel();
        titlePanel.add(title);

        //Setting colour of title panel
        titlePanel.setBackground(Color.white);

        //Creating a new JPanel for the image to go
        backgroundImagePanel = new JPanel();

        //Retrieving image from the file
        try {
            image = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/background.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        backgroundImageConfiguration();
        //Adding the image to a label
        backgroundImageLabel = new JLabel(new ImageIcon(resizedImage));

        backgroundImagePanel.add(backgroundImageLabel);
        backgroundImagePanel.setBackground(Color.white);

        //init lantern and setting option for lantern light
        BufferedImage lanternImage = null;
        try {
            lanternImage = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/lantern/green_lantern.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        lantern = new Lantern(lanternImage, new NoLight());
        lanternLightOptions.addItem("No Light");
        lanternLightOptions.addItem("Dim");
        lanternLightOptions.addItem("Normal");
        lanternLightOptions.addItem("Bright");
        lanternLightOptions.addActionListener(this);
        
        //Creating a new JPanel for the buttons to go
        buttonPanel = new JPanel();

        //Setting colour of button panel
        buttonPanel.setBackground(Color.white);

        //Naming buttons
        lightButton = new JButton("Lights");
        exitButton = new JButton("Exit");

        //Setting colour of buttons
        lightButton.setBackground(Color.red);
        exitButton.setBackground(Color.red);

        //Setting font on buttons
        lightButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        exitButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));

        //Setting font colour on buttons
        lightButton.setForeground(Color.white);
        exitButton.setForeground(Color.white);

        //Add the buttons to the buttonPanel
        buttonPanel.add(lanternLightOptions);
        buttonPanel.add(lightButton);
        buttonPanel.add(exitButton);

        //Enable buttons to listen for a mouse-click
        lightButton.addActionListener(this);
        exitButton.addActionListener(this);

        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(backgroundImagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // set buttonPanel width and height
        buttonPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), buttonPanelHeight));

//        testImageUrl = "src/main/java/fivefishes/design/patterns/group/assignment/resources/ChangEr/redblue.png";
//        try {
//            testImage = ImageIO.read(new File(testImageUrl));
//            staticTestImage = ImageIO.read(new File(staticTestImageUrl));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        testImage = testImage.getScaledInstance(-1, 100, Image. SCALE_SMOOTH);
//        staticTestImage = staticTestImage.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);

        //Configure the frame
//        getContentPane().setBackground(Color.white);
//        getContentPane().add(panelContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenSize);
        setLocation(0, 0);
        setVisible(true);

    }//Constructor

    public void paint(Graphics g) {
        //Call the paint method of the superclass
        super.paint(g);
        if(lantern != null){
            
            //can change this to change the location of lantern
            int lanternImageStartXaxis = 400;
            int lanternImageStartYaxis = 200;
            
            Image resizedLanternImage = lantern.getBaseImage().getScaledInstance(-1, 100, Image. SCALE_SMOOTH);
            g.drawImage(resizedLanternImage, lanternImageStartXaxis, lanternImageStartYaxis, this);
            int lanternHeight = resizedLanternImage.getHeight(null);
            int lanternWidth = resizedLanternImage.getWidth(null);
            int lanternCenterX = lanternImageStartXaxis + lanternWidth/2;
            int lanternCenterY = lanternImageStartYaxis + lanternHeight/2;
            int lanternRadiusRatio = lantern.getLightRadiusRatio();
            float lanternIntensity = lantern.getLightIntensity();
            float[] Fractions = {0.5f, 1.0f};
            Color[] Colors = {new Color(1f, 1f, 1f, lanternIntensity), new Color(1f, 1f, 0f, 0.0f) };
            if(lanternRadiusRatio != 0){ //if dim light no repainting, else it will throw exception
                Paint paint = new RadialGradientPaint(lanternCenterX, lanternCenterY, lanternWidth*lanternRadiusRatio/2, Fractions, Colors);
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(paint);
                g2.fillOval(lanternCenterX - (lanternHeight*lanternRadiusRatio)/2, lanternCenterY - (lanternHeight*lanternRadiusRatio)/2, lanternHeight*lanternRadiusRatio, lanternHeight*lanternRadiusRatio);
            }
        }
        // Perform drawing here using g.drawImage()
//        g.drawImage(testImage, 100, 100, null);
//        g.drawImage(staticTestImage, 500, 500, null);
    } //paint

    //Coding the event-handling routine
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == lightButton) {
            lights = true;
//            testImageUrl = "src/main/java/fivefishes/design/patterns/group/assignment/resources/ChangEr/lightgreen.png";
//            try {
//                testImage = ImageIO.read(new File(testImageUrl));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            testImage = testImage.getScaledInstance(-1, 100, Image. SCALE_SMOOTH);
            repaint();

        }//if light
        else if(event.getSource() == lanternLightOptions){
            switch(lanternLightOptions.getSelectedItem().toString()){
                case "No Light": lantern.setLightBehaviour(new NoLight());
                break;
                case "Dim": lantern.setLightBehaviour(new Dim());
                break;
                case "Normal": lantern.setLightBehaviour(new Normal());
                break;
                case "Bright": lantern.setLightBehaviour(new Bright());
                break;
            }
            repaint();
        }
        else {
            System.exit(0);

        }//else exit

    } //actionPerformed

    private void backgroundImageConfiguration() {
        imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        resizedImage = image.getScaledInstance(-1, imageHeight, Image. SCALE_SMOOTH);

        imageStartXaxis = (int) (screenSize.getWidth() - resizedImage.getWidth(null)) / 2;
        imageStartYaxis = 10;
    }

}//class
