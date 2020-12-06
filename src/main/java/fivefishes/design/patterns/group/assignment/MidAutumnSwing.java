package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.factorymethod.*;
import fivefishes.design.patterns.group.assignment.factorymethod.factory.MooncakeFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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


    private boolean lights = false;

    private int imageHeight;
    private Image resizedImage;


    private final int buttonPanelHeight = 150;
    private int imageStartXaxis;
    private int imageStartYaxis;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    //Abstract Factory
    private MooncakeFactory mooncakeFactory;
    private Mooncake mooncake;
    private ImageIcon mooncakeImage = new ImageIcon();
    private JLabel mooncakeLabel = new JLabel();
    private BufferedImage tableImage;
    private Image resizedTableImage;
    private JLabel tableLabel;
    private String mooncakeStyle;
    private JButton addMooncakeButton;

//    private MooncakeStyle[] mooncakeStyles = MooncakeStyle.values();
    private JComboBox mooncakeStyleCombo = new JComboBox();


    private String[] mooncakeFlavorList = {"Lotus Seed","Red Bean"};
    private JComboBox<String> mooncakeFlavorCombo = new JComboBox<>(mooncakeFlavorList);
    private MooncakeDescriptionPanel descriptionPanel= new MooncakeDescriptionPanel();

    //Test Image
    private String testImageUrl;
    private Image testImage;
    private String staticTestImageUrl = "src/main/java/fivefishes/design/patterns/group/assignment/resources/ChangEr/redblue.png";
    private Image staticTestImage;

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
            tableImage = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/table.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        backgroundImageConfiguration();
        //Adding the image to a label
        backgroundImageLabel = new JLabel(new ImageIcon(resizedImage));
        backgroundImagePanel.add(backgroundImageLabel);
        backgroundImagePanel.setBackground(Color.white);

        //Creating a new JPanel for the buttons to go
        buttonPanel = new JPanel();

        //Setting colour of button panel
        buttonPanel.setBackground(Color.white);

        //Naming buttons
        lightButton = new JButton("Lights");
        exitButton = new JButton("Exit");
        addMooncakeButton = new JButton("Create Mooncake");

        //Setting colour of buttons
        lightButton.setBackground(Color.red);
        exitButton.setBackground(Color.red);
        addMooncakeButton.setBackground(Color.red);

        //Setting font on buttons
        lightButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        exitButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        addMooncakeButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));

        //Setting font colour on buttons
        lightButton.setForeground(Color.white);
        exitButton.setForeground(Color.white);
        addMooncakeButton.setForeground(Color.white);

        //Enable buttons to listen for a mouse-click
        lightButton.addActionListener(this);
        exitButton.addActionListener(this);
        addMooncakeButton.addActionListener(this);
        mooncakeStyleCombo.addActionListener(this);
        mooncakeFlavorCombo.addActionListener(this);


        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(backgroundImagePanel, BorderLayout.CENTER);
        backgroundImageLabel.setLayout(null);
        add(buttonPanel, BorderLayout.SOUTH);

        // set buttonPanel width and height
        buttonPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), buttonPanelHeight));

        //Abstract Factory Mooncake
        mooncakeLabel.setBounds(1155, 570, 207, 53);
        descriptionPanel.setBounds(800,300, 400, 300);
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel,  BoxLayout.Y_AXIS));
        backgroundImageLabel.add(mooncakeLabel);
        backgroundImageLabel.add(descriptionPanel);
        descriptionPanel.setVisible(false);
        mooncakeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (descriptionPanel.isShowing()){
                    descriptionPanel.setVisible(false);
                } else {
                    descriptionPanel.setVisible(true);
                }
            }
        });
        for(MooncakeStyle mooncakeStyle: MooncakeStyle.values()) {
            mooncakeStyleCombo.addItem(mooncakeStyle);
        }

        //Table Image
        resizedTableImage = tableImage.getScaledInstance(260, 178, Image.SCALE_SMOOTH);
        tableLabel = new JLabel(new ImageIcon(resizedTableImage));
        tableLabel.setBounds( 1120, 600, 260, 178);
        backgroundImageLabel.add(tableLabel);

        //Add the buttons to the buttonPanel
        buttonPanel.add(mooncakeStyleCombo);
        buttonPanel.add(mooncakeFlavorCombo);
        buttonPanel.add(addMooncakeButton);
        buttonPanel.add(lightButton);
        buttonPanel.add(exitButton);

        //Test Image
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

        // Perform drawing here using g.drawImage()
//        g.drawImage(testImage, 100, 100, null);
//        g.drawImage(staticTestImage, 500, 500, null);


    } //paint

    public Image resizeMooncakeImage(BufferedImage mooncakeBufferedImage) {
        return mooncakeBufferedImage.getScaledInstance(207,53,Image.SCALE_SMOOTH);
    }

    public void createMooncake(Mooncake mooncake) {
        mooncake.prepare();
        mooncakeImage.setImage(resizeMooncakeImage(mooncake.getImage()));
        mooncakeLabel.setIcon(mooncakeImage);
        descriptionPanel.setLabel(mooncake);
        repaint();
    }

    //Coding the event-handling routine
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == mooncakeStyleCombo) {
            MooncakeStyle selectedStyle = (MooncakeStyle) mooncakeStyleCombo.getSelectedItem();
            mooncakeStyle =  selectedStyle.name();
            mooncakeFactory = selectedStyle.getMooncakeFactory();
        } else if (event.getSource() == mooncakeFlavorCombo) {
            if(mooncakeFlavorCombo.getSelectedItem().equals("Lotus Seed")) {
                mooncake = new LotusSeedMooncake();
                mooncake.setName(mooncakeStyle + " Lotus Seed Mooncake");
            }
            if(mooncakeFlavorCombo.getSelectedItem().equals("Red Bean")) {
                mooncake = new RedBeanMooncake();
                mooncake.setName(mooncakeStyle + " Red Bean Mooncake");
            }
        } else if(event.getSource() == addMooncakeButton){
            mooncake.setFactory(mooncakeFactory);
            createMooncake(mooncake);
        } else {
            System.exit(0);
        }

    } //actionPerformed

    private void backgroundImageConfiguration() {
        imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        resizedImage = image.getScaledInstance(-1, imageHeight, Image. SCALE_SMOOTH);

        imageStartXaxis = (int) (screenSize.getWidth() - resizedImage.getWidth(null)) / 2;
        imageStartYaxis = 10;
    }
}//class
