package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.entities.observer.*;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Subject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MidAutumnSwing extends JFrame implements ActionListener {

    private Observer audioPlayerObserver = new AudioPlayerObserver();
    private RabbitObserver rabbitObserver = new RabbitObserver(this);
    private ClockSubject clockSubject = new ClockSubject(
            new HashSet<Observer>() {{
                add(audioPlayerObserver);
                add(rabbitObserver);
            }}
    );
    private JLabel clockLabel = new JLabel("A song will be played every 1 minute");
    private ObserverCheckBox rabbitObserverCheckBox = new ObserverCheckBox(clockSubject, rabbitObserver);
    private ObserverCheckBox audioPlayerObserverCheckBox = new ObserverCheckBox(clockSubject, audioPlayerObserver);
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);


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

    private Image dancingRabbitImg, singingRabbitImg;

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

        //Creating a new JPanel for the buttons to go
        buttonPanel = new JPanel();

        //Setting colour of button panel
        buttonPanel.setBackground(Color.white);

        SubjectWorker subjectWorker = new SubjectWorker(clockSubject);
        executorService.scheduleAtFixedRate(subjectWorker, 0, 1, TimeUnit.MINUTES);

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
        buttonPanel.add(rabbitObserverCheckBox);
        buttonPanel.add(audioPlayerObserverCheckBox);

        //Enable buttons to listen for a mouse-click
        lightButton.addActionListener(this);
        exitButton.addActionListener(this);

        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(backgroundImagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // set buttonPanel width and height
        buttonPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), buttonPanelHeight));

        try {
            dancingRabbitImg = ImageIO.read(new File(RabbitImage.Dancing.getImageUrl()));
            singingRabbitImg = ImageIO.read(new File(RabbitImage.Singing.getImageUrl()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dancingRabbitImg = dancingRabbitImg.getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
        singingRabbitImg = singingRabbitImg.getScaledInstance(-1, 100, Image.SCALE_SMOOTH);

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
        if (rabbitObserver.isShowRabbit()) {
            g.drawImage(dancingRabbitImg, 800, 500, null);
            g.drawImage(singingRabbitImg, 1100, 500, null);
        }

    } //paint

    //Coding the event-handling routine
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == lightButton) {

        }//if light

        else {
            System.exit(0);

        }//else exit

    } //actionPerformed

    private void backgroundImageConfiguration() {
        imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        resizedImage = image.getScaledInstance(-1, imageHeight, Image.SCALE_SMOOTH);

        imageStartXaxis = (int) (screenSize.getWidth() - resizedImage.getWidth(null)) / 2;
        imageStartYaxis = 10;
    }

}//class
