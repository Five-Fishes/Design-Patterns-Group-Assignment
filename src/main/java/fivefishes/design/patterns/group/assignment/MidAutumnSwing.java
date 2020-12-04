package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.factorymethod.*;
import sun.security.krb5.internal.crypto.Des;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MidAutumnSwing extends JFrame implements ActionListener {
    //Buttons
    private JButton lightButton;
    private JButton exitButton;

    //Panels
    private JPanel titlePanel, imagePanel, buttonPanel,primaryButtonPanel, secondaryButtonPanel, infoPanel;

    //Labels
    private JLabel title, imageLabel, buttonLabel;

    //Image
    private BufferedImage image;


    private boolean lights = false;

    private final int buttonPanelHeight = 150;
    private int imageStartXaxis;
    private int imageStartYaxis;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    //Abstract Factory
    private MooncakeFactory mooncakeFactory;
    private Mooncake mooncake;
    private ImageIcon mooncakeImage = new ImageIcon();
    private JLabel mooncakeLabel = new JLabel();
    private ArrayList<JButton> mooncakeTypBtnList = new ArrayList<JButton>();
    private ArrayList<JButton> mooncakeFlavorBtnList = new ArrayList<JButton>();
    private BufferedImage table;
    private int tableImageXaxis;
    private int tableImageYaxis;
    private int mooncakeImageXaxis;
    private int mooncakeImageYaxis;
    private MooncakeDescriptionPanel descriptionPanel= new MooncakeDescriptionPanel();


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
        imagePanel = new JPanel();

        //Retrieving image from the file
        try {
            image = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/background.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        lotusSeedButton = new JButton ("Lotus Seed");
//        redBeanButton = new JButton("Red Bean");

        // resize image to Panel size
//        Image resizeImage = image.getScaledInstance(1050, 525, Image.SCALE_SMOOTH);

        //Adding the image to a label
//        imageLabel = new JLabel(new ImageIcon(image));

        //Adding image label to the image panel
//        imagePanel.add(imageLabel);

        //Setting colour of image panel
        imagePanel.setBackground(Color.white);

        //Creating a new JPanel for the buttons to go
        buttonPanel = new JPanel();
        primaryButtonPanel = new JPanel();
        secondaryButtonPanel = new JPanel();

        //Setting colour of button panel
        buttonPanel.setBackground(Color.white);

        //Button Label
        // buttonLabel = new JLabel("Click on the button to add the item to the tree.");
        buttonLabel = new JLabel("");
        buttonLabel.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        buttonLabel.setForeground(Color.red);
        buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonLabel.setBackground(Color.white);

        //Info panel
        infoPanel = new JPanel();
        infoPanel.add(buttonLabel);
        infoPanel.setBackground(Color.white);

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

        //Enable buttons to listen for a mouse-click
        lightButton.addActionListener(this);
        exitButton.addActionListener(this);

        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
//        imagePanel.add(infoPanel, BorderLayout.NORTH);
        imagePanel.setLayout(null);
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(primaryButtonPanel, BorderLayout.NORTH);
        buttonPanel.add(secondaryButtonPanel, BorderLayout.CENTER);

        // set buttonPanel width and height
        buttonPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), buttonPanelHeight));

        //Abstract Factory Mooncake
        try {
            table = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/table.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        tableImageXaxis = (int) screenSize.getWidth() - 800;
        tableImageYaxis = 550;
        mooncakeImageXaxis = (int) screenSize.getWidth() - 770;
        mooncakeImageYaxis = 450;
        mooncakeLabel.setBounds(mooncakeImageXaxis, mooncakeImageYaxis, 311, 80);
        descriptionPanel.setBounds(500,200, 500, 500);
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel,  BoxLayout.Y_AXIS));
        imagePanel.add(mooncakeLabel);
//        imagePanel.add(descriptionPanel);
//        descriptionPanel.setVisible(false);
        mooncakeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!descriptionPanel.isShowing()){
//                    descriptionPanel.setVisible(false);
                    imagePanel.add(descriptionPanel);
                    imagePanel.revalidate();
                    imagePanel.repaint();
                } else {
//                    descriptionPanel.setVisible(true);
                    imagePanel.remove(descriptionPanel);
                    imagePanel.revalidate();
                    imagePanel.repaint();
                }
            }
        });

        //Abstract Factory Mooncake TYPE Button
        mooncakeTypBtnList.add(new JButton("Cantonese Style"));
        mooncakeTypBtnList.add(new JButton("Shanghai Style"));
        mooncakeTypBtnList.add(new JButton("Kluang Style"));
        for(JButton button: mooncakeTypBtnList){
            button.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
            button.setBackground(Color.red);
            button.setForeground(Color.white);
            button.addActionListener(this);
            primaryButtonPanel.add(button);
        }

        //Abstract Factory Mooncake Flavor Button
        mooncakeFlavorBtnList.add(new JButton("Lotus Seed"));
        mooncakeFlavorBtnList.add(new JButton("Red Bean"));
        for(JButton button: mooncakeFlavorBtnList){
            button.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
            button.setBackground(Color.red);
            button.setForeground(Color.white);
            button.addActionListener(this);
            secondaryButtonPanel.add(button);
            button.setVisible(false);
        }

        //Add the buttons to the buttonPanel
        primaryButtonPanel.add(lightButton);
        primaryButtonPanel.add(exitButton);

        //Configure the frame
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenSize);
        setLocation(0, 0);
        setVisible(true);

    }//Constructor

    public void paint(Graphics g) {
        //Call the paint method of the superclass
        super.paint(g);

        int imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        Image resizedImage = image.getScaledInstance(-1, imageHeight, Image.SCALE_SMOOTH);

        imageStartXaxis = (int) (screenSize.getWidth() - resizedImage.getWidth(null)) / 2;
        imageStartYaxis = 10;
        g.drawImage(resizedImage, imageStartXaxis, imageStartYaxis, this);
        g.drawImage(table, tableImageXaxis, tableImageYaxis, this);
    } //paint

    public Image resizeMooncakeImage(BufferedImage mooncakeBufferedImage) {
        return mooncakeBufferedImage.getScaledInstance(311,80,Image.SCALE_SMOOTH);
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
        if (event.getSource() == mooncakeTypBtnList.get(0)) {
            mooncakeTypBtnList.get(0).setBackground(new Color(168,50,50));
            mooncakeTypBtnList.get(1).setBackground(Color.red);
            mooncakeTypBtnList.get(2).setBackground(Color.red);
            mooncakeFactory = new CantoneseMooncakeFactory();
            for(JButton button: mooncakeFlavorBtnList){
                button.setVisible(true);
            }
        } else if (event.getSource() == mooncakeTypBtnList.get(1)){
            mooncakeTypBtnList.get(0).setBackground(Color.red);
            mooncakeTypBtnList.get(1).setBackground(new Color(168,50,50));
            mooncakeTypBtnList.get(2).setBackground(Color.red);
            mooncakeFactory = new ShanghaiMooncakeFactory();
            for(JButton button: mooncakeFlavorBtnList){
                button.setVisible(true);
            }
        } else if (event.getSource() == mooncakeTypBtnList.get(2)){
            mooncakeTypBtnList.get(0).setBackground(Color.red);
            mooncakeTypBtnList.get(1).setBackground(Color.red);
            mooncakeTypBtnList.get(2).setBackground(new Color(168,50,50));
            mooncakeFactory = new KluangMooncakeFactory();
            for(JButton button: mooncakeFlavorBtnList){
                button.setVisible(true);
            }
        } else if (event.getSource() == mooncakeFlavorBtnList.get(0)){
            mooncake = new LotusSeedMooncake(mooncakeFactory);
            createMooncake(mooncake);

        } else if (event.getSource() == mooncakeFlavorBtnList.get(1)){
            mooncake = new RedBeanMooncake(mooncakeFactory);
            createMooncake(mooncake);
        } else {
            System.exit(0);
        }//else exit

    } //actionPerformed

}//class
