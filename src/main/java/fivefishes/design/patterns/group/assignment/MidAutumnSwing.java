package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.entities.AudioPlayerObserver;
import fivefishes.design.patterns.group.assignment.entities.ClockSubject;
import fivefishes.design.patterns.group.assignment.entities.ClockWorker;
import fivefishes.design.patterns.group.assignment.interfaces.Observer;
import fivefishes.design.patterns.group.assignment.interfaces.Subject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MidAutumnSwing extends JFrame implements ActionListener {

    private Observer audioPlayerObserver = new AudioPlayerObserver();
    private Subject clockSubject = new ClockSubject();
    private JLabel clockLabel = new JLabel();
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);


    //Buttons
    private JButton lightButton;
    private JButton exitButton;

    //Panels
    private JPanel titlePanel, imagePanel, buttonPanel, infoPanel;

    //Labels
    private JLabel title, imageLabel, buttonLabel;

    //Image
    private BufferedImage image;


    private boolean lights = false;

    private final int buttonPanelHeight = 150;
    private int imageStartXaxis;
    private int imageStartYaxis;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

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

        clockSubject.register(audioPlayerObserver);
        Runnable runnable = () -> clockSubject.notifyObserver();
        executorService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.MINUTES);

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
        buttonPanel.add(lightButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(clockLabel, BorderLayout.SOUTH);

        //Enable buttons to listen for a mouse-click
        lightButton.addActionListener(this);
        exitButton.addActionListener(this);

        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        imagePanel.add(infoPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // set buttonPanel width and height
        buttonPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), buttonPanelHeight));

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
        Image resizedImage = image.getScaledInstance(-1, imageHeight, Image. SCALE_SMOOTH);

        imageStartXaxis = (int) (screenSize.getWidth() - resizedImage.getWidth(null)) / 2;
        imageStartYaxis = 10;
        g.drawImage(resizedImage, imageStartXaxis, imageStartYaxis, this);

    } //paint

    //Coding the event-handling routine
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == lightButton) {
            lights = true;
            repaint();

        }//if light

        else {
            System.exit(0);

        }//else exit

    } //actionPerformed

}//class
