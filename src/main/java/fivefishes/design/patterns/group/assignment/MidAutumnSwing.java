package fivefishes.design.patterns.group.assignment;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Component;

import fivefishes.design.patterns.group.assignment.controllers.houseController;
import fivefishes.design.patterns.group.assignment.entities.background;
import fivefishes.design.patterns.group.assignment.entities.house;
import fivefishes.design.patterns.group.assignment.entities.houseBase;
import fivefishes.design.patterns.group.assignment.entities.image;

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
    private JPanel titlePanel, buttonPanel;
    private JLayeredPane backgroundImagePanel;

    //Labels
    private JLabel title, backgroundImageLabel;

    //Image
    private BufferedImage image;


    private boolean lights = false;

    private int imageHeight;
    private Image resizedImage;

    private final int buttonPanelHeight = 150;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private String testImageUrl;
    private Image testImage;
    private String staticTestImageUrl = "src/main/java/fivefishes/design/patterns/group/assignment/resources/lanternsdecorator.png";
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

        house defaultHouse = new house();
        houseBase house_base = new houseBase();

        JLabel defaultJLabel = defaultHouse.getImages().get(0);
        defaultJLabel.setBounds(0,0,300,300);
        house_base.add(defaultJLabel,JLayeredPane.DEFAULT_LAYER);

        image tempimage = new image();
        int imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        int imageWidth = (int) screenSize.getWidth();
        
        house_base.setBounds(200, 250, 300, 300);
        tempimage.setBounds(0, 0, imageWidth, imageHeight);
        

        // pass reference of this frame and the area to update to houseController
        houseController house_controller = new houseController(this, house_base.getBounds(), house_base);
        house_controller.house = defaultHouse;
        backgroundImagePanel = new JLayeredPane();

        //Retrieving image from the file
        try {
            image = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/background.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        backgroundImageConfiguration();
        //Adding the image to a label
        // backgroundImageLabel = new JLabel(new ImageIcon(resizedImage));

        // backgroundImagePanel.add(backgroundImageLabel);
        backgroundImagePanel.setBackground(Color.white);
        backgroundImagePanel.add(tempimage, JLayeredPane.DEFAULT_LAYER);
        backgroundImagePanel.add(house_base, JLayeredPane.PALETTE_LAYER);

        //Creating a new JPanel for the buttons to go
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        //Setting colour of button panel
        buttonPanel.setBackground(Color.white);

        //Naming buttons
        lightButton = new JButton("Lights");
        exitButton = new JButton("Exit");
        JButton ApplyDecorationButton = new JButton("Apply Decorations");
        JButton ClearDecorationButton = new JButton("Clear Decorations");

        //Setting colour of buttons
        lightButton.setBackground(Color.red);
        exitButton.setBackground(Color.red);
        ApplyDecorationButton.setBackground(new Color(51,153,255));
        ClearDecorationButton.setBackground(new Color(51,153,255));

        //Setting font on buttons
        lightButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        exitButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        ApplyDecorationButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        ClearDecorationButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));

        //Setting font colour on buttons
        lightButton.setForeground(Color.white);
        exitButton.setForeground(Color.white);
        ApplyDecorationButton.setForeground(Color.white);
        ClearDecorationButton.setForeground(Color.white);

        // Setup Combobox
        String[] decoratorOptions = {"lantern decorator", "firework decorator", "candles decorator", "flags decorator"};
        JComboBox<String> decoratorCombobox = new JComboBox<String>(decoratorOptions);
        decoratorCombobox.setSelectedIndex(0);
        decoratorCombobox.setMaximumSize(new Dimension(300,30));
        decoratorCombobox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cb = (JComboBox<String>)e.getSource();
                String decoratorName = (String)cb.getSelectedItem();
                house_controller.onDecorationSelected(decoratorName.replace(" ", ""));
            }

        });

        //Create a group of components for Decorator DP
        JPanel decoratorControlJPanel = new JPanel();
        decoratorControlJPanel.setLayout(new BoxLayout(decoratorControlJPanel, BoxLayout.Y_AXIS));
        decoratorControlJPanel.add(ClearDecorationButton);
        decoratorControlJPanel.add(Box.createRigidArea(new Dimension(0,5)));
        decoratorControlJPanel.add(ApplyDecorationButton);
        decoratorControlJPanel.add(Box.createRigidArea(new Dimension(0,5)));
        decoratorControlJPanel.setBorder(BorderFactory.createTitledBorder("Decorator Pattern"));
        decoratorControlJPanel.add(decoratorCombobox);

        //Add the buttons to the buttonPanel
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(lightButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(5,0)));
        buttonPanel.add(exitButton);

        // Add the custome decorator controller group to ButtonPanel
        buttonPanel.add(Box.createRigidArea(new Dimension(5,0)));
        buttonPanel.add(decoratorControlJPanel);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(Box.createVerticalGlue());
        
        // Set alignment to left
        ClearDecorationButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        ApplyDecorationButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        decoratorCombobox.setAlignmentX(Component.LEFT_ALIGNMENT);

        //set alignment to top
        lightButton.setAlignmentY(Component.TOP_ALIGNMENT);
        exitButton.setAlignmentY(Component.TOP_ALIGNMENT);
        decoratorControlJPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        //Enable buttons to listen for a mouse-click
        lightButton.addActionListener(this);
        exitButton.addActionListener(this);
        ApplyDecorationButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                house_controller.onApplyDecoratorClicked();
            }

        });
        ClearDecorationButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                house_controller.onClearDecorationsClicked();

            }
            
        });

        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(backgroundImagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        // middlePanel.add(infoPanel, BorderLayout.NORTH);

        // set buttonPanel width and height
        buttonPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), buttonPanelHeight));

        testImageUrl = "src/main/java/fivefishes/design/patterns/group/assignment/resources/lanternsdecorator.png";
        try {
            testImage = ImageIO.read(new File(testImageUrl));
            staticTestImage = ImageIO.read(new File(staticTestImageUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
        testImage = testImage.getScaledInstance(-1, 100, Image. SCALE_SMOOTH);
        staticTestImage = staticTestImage.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);

        //Configure the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenSize);
        setLocation(0, 0);
        setVisible(true);

    }//Constructor

    //Coding the event-handling routine
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == lightButton) {
            lights = true;
            testImageUrl = "src/main/java/fivefishes/design/patterns/group/assignment/resources/ChangEr/lightgreen.png";
            try {
                testImage = ImageIO.read(new File(testImageUrl));
            } catch (IOException e) {
                e.printStackTrace();
            }
            testImage = testImage.getScaledInstance(-1, 100, Image. SCALE_SMOOTH);
            repaint();

        }//if light

        else {
            System.exit(0);

        }//else exit

    } //actionPerformed

    private void backgroundImageConfiguration() {
        imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        resizedImage = image.getScaledInstance(-1, imageHeight, Image. SCALE_SMOOTH);

        int imageStartXaxis = (int) (screenSize.getWidth() - resizedImage.getWidth(null)) / 2;
        int imageStartYaxis = 10;
    }

}//class
