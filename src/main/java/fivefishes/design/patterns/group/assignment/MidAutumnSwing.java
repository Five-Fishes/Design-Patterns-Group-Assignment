package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.components.abstractFactory.*;
import fivefishes.design.patterns.group.assignment.components.decorator.*;
import fivefishes.design.patterns.group.assignment.controllers.abstractFactory.AbstractFactoryController;
import fivefishes.design.patterns.group.assignment.controllers.decorator.HouseController;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.mooncake.LotusSeedMooncake;
import fivefishes.design.patterns.group.assignment.entities.abstractFactory.mooncake.RedBeanMooncake;
import fivefishes.design.patterns.group.assignment.entities.decorator.House;
import fivefishes.design.patterns.group.assignment.entities.memento.ChangErFashion;
import fivefishes.design.patterns.group.assignment.entities.memento.History;
import fivefishes.design.patterns.group.assignment.enumerations.abstractFactory.MooncakeStyle;
import fivefishes.design.patterns.group.assignment.enumerations.memento.Fashion;

import fivefishes.design.patterns.group.assignment.components.observer.ObserverCheckBox;
import fivefishes.design.patterns.group.assignment.components.observer.RabbitGifLabel;
import fivefishes.design.patterns.group.assignment.components.observer.TimerLabel;
import fivefishes.design.patterns.group.assignment.entities.observer.*;
import fivefishes.design.patterns.group.assignment.enumerations.observer.RabbitImage;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.workers.observer.SubjectWorker;
import fivefishes.design.patterns.group.assignment.workers.observer.TimerWorker;

import fivefishes.design.patterns.group.assignment.entities.behaviour.Bright;
import fivefishes.design.patterns.group.assignment.entities.behaviour.Dim;
import fivefishes.design.patterns.group.assignment.entities.behaviour.Lantern;
import fivefishes.design.patterns.group.assignment.entities.behaviour.NoLight;
import fivefishes.design.patterns.group.assignment.entities.behaviour.Normal;

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
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MidAutumnSwing extends JFrame implements ActionListener {

    // Observer
    private RabbitGifLabel dancingRabbitLabel = new RabbitGifLabel(RabbitImage.Dancing);
    private RabbitGifLabel singingRabbitLabel = new RabbitGifLabel(RabbitImage.Singing);
    private Observer audioPlayerObserver = new AudioPlayerObserver();
    private RabbitObserver rabbitObserver = new RabbitObserver(dancingRabbitLabel, singingRabbitLabel);
    private ClockSubject clockSubject = new ClockSubject(
            new HashSet<Observer>() {{
                add(audioPlayerObserver);
                add(rabbitObserver);
            }}
    );
    private JLabel timerLabel = new TimerLabel();
    private ObserverCheckBox rabbitObserverCheckBox = new ObserverCheckBox(clockSubject, rabbitObserver);
    private ObserverCheckBox audioPlayerObserverCheckBox = new ObserverCheckBox(clockSubject, audioPlayerObserver);
    SubjectWorker subjectWorker = new SubjectWorker(clockSubject);
    TimerWorker timerWorker = new TimerWorker(timerLabel);
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    // Decorator
    House house = new House();
    JLayeredPane houseLayeredPanel = new JLayeredPane();
    JLabel houseLabel = house.getImages().get(0);
    HouseController houseController = new HouseController(houseLayeredPanel, house, this);
    DecoratorComboBox decoratorComboBox = new DecoratorComboBox(houseController);
    ApplyDecorationButton applyDecorationButton = new ApplyDecorationButton(houseController);
    ClearDecorationButton clearDecorationButton = new ClearDecorationButton(houseController);
    HouseImagePanel houseImagePanel = new HouseImagePanel();


    // Memento
    ChangErFashion changErFashion = new ChangErFashion();
    History changeErFashionHistory = new History();
    private Fashion[] changeErFashionList = Fashion.values();
    private JComboBox<String> changErFashionOptions = new JComboBox<>();
    private JButton undoButton;
    private JButton redoButton;
    private BufferedImage changErImage;
    private int changErImageXaxis;
    private int changErImageYaxis;

    //Panels
    private JPanel titlePanel, backgroundImagePanel, buttonPanel, infoPanel;

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

    //Abstract Factory
    private BufferedImage tableImage;
    private Image resizedTableImage;
    private JLabel tableLabel;
    private MooncakeDescriptionPanel mooncakeDescriptionPanel = new MooncakeDescriptionPanel();
    private MooncakeLabel mooncakeLabel = new MooncakeLabel(mooncakeDescriptionPanel);
    AbstractFactoryController abstractFactoryController = new AbstractFactoryController(mooncakeDescriptionPanel, mooncakeLabel, this);
    private AddMooncakeButton addMooncakeButton = new AddMooncakeButton(abstractFactoryController);
    private MooncakeStyleComboBox mooncakeStyleComboBox = new MooncakeStyleComboBox(abstractFactoryController);
    private MooncakeFlavorComboBox mooncakeFlavorComboBox = new MooncakeFlavorComboBox(abstractFactoryController);

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
            tableImage = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/abstractFactory/table.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        backgroundImageConfiguration();
        //Adding the image to a label
        backgroundImageLabel = new JLabel(new ImageIcon(resizedImage));
        backgroundImagePanel.add(backgroundImageLabel);
        backgroundImagePanel.setBackground(Color.white);

        houseLabel.setBounds(0, 0, 300, 300);
        houseLayeredPanel.add(houseLabel, JLayeredPane.DEFAULT_LAYER);
        int imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        int imageWidth = (int) screenSize.getWidth();
        houseLayeredPanel.setBounds(0, 0, imageWidth, imageHeight);
        backgroundImagePanel.add(houseImagePanel, JLayeredPane.DEFAULT_LAYER);
        houseLayeredPanel.setBounds(200, 250, 300, 300);
        backgroundImageLabel.add(houseLayeredPanel, JLayeredPane.PALETTE_LAYER);

        //init lantern and setting option for lantern light
        BufferedImage lanternImage = null;
        try {
            lanternImage = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/behaviour/green_lantern.png"));
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

        new Thread(timerWorker).start();
        executorService.scheduleAtFixedRate(subjectWorker, 0, 1, TimeUnit.MINUTES);

        infoPanel = new JPanel();
        infoPanel.add(new JLabel("Only 5 ChangEr will be saved in history"));
        infoPanel.setBackground(Color.white);
        buttonPanel.add(infoPanel);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Dropdown Construct and Config
        for (Fashion changeErFashion : changeErFashionList) {
            changErFashionOptions.addItem(changeErFashion.name());
        }

        changErFashionOptions.addActionListener(this);
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");
        undoButton.setBackground(Color.red);
        redoButton.setBackground(Color.green);
        undoButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        redoButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        undoButton.setForeground(Color.white);
        redoButton.setForeground(Color.white);
        undoButton.addActionListener(this);
        redoButton.addActionListener(this);
        buttonPanel.add(undoButton);
        buttonPanel.add(changErFashionOptions);
        buttonPanel.add(redoButton);
        changErImageXaxis = (int) screenSize.getWidth() - 350;
        changErImageYaxis = 100;
        defaultChangEr();


//Abstract Factory Mooncake
        mooncakeLabel.setBounds(1155, 570, 207, 53);
        mooncakeDescriptionPanel.setBounds(800, 300, 400, 300);
        mooncakeDescriptionPanel.setLayout(new BoxLayout(mooncakeDescriptionPanel, BoxLayout.Y_AXIS));
        backgroundImageLabel.add(mooncakeLabel);
        backgroundImageLabel.add(mooncakeDescriptionPanel);
        mooncakeDescriptionPanel.setVisible(false);

        //Table Image
        resizedTableImage = tableImage.getScaledInstance(260, 178, Image.SCALE_SMOOTH);
        tableLabel = new JLabel(new ImageIcon(resizedTableImage));
        tableLabel.setBounds(1120, 600, 260, 178);
        backgroundImageLabel.add(tableLabel);

        //Add the buttons to the buttonPanel
        buttonPanel.add(mooncakeStyleComboBox);
        buttonPanel.add(mooncakeFlavorComboBox);
        buttonPanel.add(addMooncakeButton);
        //Add the buttons to the buttonPanel
        buttonPanel.add(lanternLightOptions);
        buttonPanel.add(timerLabel);
        buttonPanel.add(rabbitObserverCheckBox);
        buttonPanel.add(audioPlayerObserverCheckBox);
        buttonPanel.add(decoratorComboBox);
        buttonPanel.add(applyDecorationButton);
        buttonPanel.add(clearDecorationButton);


        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(backgroundImagePanel, BorderLayout.CENTER);
        backgroundImageLabel.setLayout(null);
        add(buttonPanel, BorderLayout.SOUTH);

        // set buttonPanel width and height
        buttonPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), buttonPanelHeight));

        dancingRabbitLabel.setBounds(800, 500, 500, 178);
        singingRabbitLabel.setBounds(1100, 500, 500, 178);
        backgroundImageLabel.add(dancingRabbitLabel);
        backgroundImageLabel.add(singingRabbitLabel);

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
        if (lantern != null) {

            //can change this to change the location of lantern
            int lanternImageStartXaxis = 400;
            int lanternImageStartYaxis = 200;

            Image resizedLanternImage = lantern.getBaseImage().getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
            g.drawImage(resizedLanternImage, lanternImageStartXaxis, lanternImageStartYaxis, this);
            int lanternHeight = resizedLanternImage.getHeight(null);
            int lanternWidth = resizedLanternImage.getWidth(null);
            int lanternCenterX = lanternImageStartXaxis + lanternWidth / 2;
            int lanternCenterY = lanternImageStartYaxis + lanternHeight / 2;
            int lanternRadiusRatio = lantern.getLightRadiusRatio();
            float lanternIntensity = lantern.getLightIntensity();
            float[] Fractions = {0.5f, 1.0f};
            Color[] Colors = {new Color(1f, 1f, 1f, lanternIntensity), new Color(1f, 1f, 0f, 0.0f)};
            if (lanternRadiusRatio != 0) { //if dim light no repainting, else it will throw exception
                Paint paint = new RadialGradientPaint(lanternCenterX, lanternCenterY, lanternWidth * lanternRadiusRatio / 2, Fractions, Colors);
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(paint);
                g2.fillOval(lanternCenterX - (lanternHeight * lanternRadiusRatio) / 2, lanternCenterY - (lanternHeight * lanternRadiusRatio) / 2, lanternHeight * lanternRadiusRatio, lanternHeight * lanternRadiusRatio);
            }
        }

        if (changErImage != null) {
            Image resizedChangErImage = changErImage.getScaledInstance(-1, 180, Image.SCALE_SMOOTH);
            g.drawImage(resizedChangErImage, changErImageXaxis, changErImageYaxis, this);
        }
    } //paint

    //Coding the event-handling routine
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == lanternLightOptions) {
            switch (lanternLightOptions.getSelectedItem().toString()) {
                case "No Light":
                    lantern.setLightBehaviour(new NoLight());
                    break;
                case "Dim":
                    lantern.setLightBehaviour(new Dim());
                    break;
                case "Normal":
                    lantern.setLightBehaviour(new Normal());
                    break;
                case "Bright":
                    lantern.setLightBehaviour(new Bright());
                    break;
            }
            repaint();
        } else {
            if (event.getSource() == undoButton) {
                changErFashion.getFromChangErMemento(changeErFashionHistory.undo());
                try {
                    readFashionImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (event.getSource() == redoButton) {
                changErFashion.getFromChangErMemento(changeErFashionHistory.redo());
                try {
                    readFashionImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (event.getSource() == changErFashionOptions) {
                changErFashion.setFashionType((String) changErFashionOptions.getSelectedItem());
                changeErFashionHistory.add(changErFashion.createMemento());
                try {
                    readFashionImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            repaint();
        }//else exit

    } //actionPerformed

    public void readFashionImage() throws IOException {
        changErImage = ImageIO.read(new File(changErFashion.getChangErImageUrl()));
    }

    public void defaultChangEr() {
        changErFashion.setFashionType(changErFashionOptions.getItemAt(0));
        changeErFashionHistory.add(changErFashion.createMemento());
        try {
            readFashionImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void backgroundImageConfiguration() {
        imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        resizedImage = image.getScaledInstance(-1, imageHeight, Image.SCALE_SMOOTH);

        imageStartXaxis = (int) (screenSize.getWidth() - resizedImage.getWidth(null)) / 2;
        imageStartYaxis = 10;
    }
}//class
