package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.components.TableLabel;
import fivefishes.design.patterns.group.assignment.components.abstractFactory.*;
import fivefishes.design.patterns.group.assignment.components.behaviour.LanternLabel;
import fivefishes.design.patterns.group.assignment.components.behaviour.LanternLightComboBox;
import fivefishes.design.patterns.group.assignment.components.decorator.*;
import fivefishes.design.patterns.group.assignment.components.memento.ChangErFashionComboBox;
import fivefishes.design.patterns.group.assignment.components.memento.RedoButton;
import fivefishes.design.patterns.group.assignment.components.memento.UndoButton;
import fivefishes.design.patterns.group.assignment.controllers.abstractFactory.AbstractFactoryController;
import fivefishes.design.patterns.group.assignment.controllers.behaviour.LightBehaviourController;
import fivefishes.design.patterns.group.assignment.controllers.decorator.HouseController;
import fivefishes.design.patterns.group.assignment.controllers.memento.MementoController;
import fivefishes.design.patterns.group.assignment.entities.decorator.House;

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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MidAutumnSwing extends JFrame {

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
    private JLabel changErLabel = new JLabel();
    private MementoController mementoController = new MementoController(changErLabel);
    private UndoButton undoButton = new UndoButton(mementoController);
    private RedoButton redoButton = new RedoButton(mementoController);
    private ChangErFashionComboBox changErFashionComboBox = new ChangErFashionComboBox(mementoController);
    private int changErImageXaxis;
    private int changErImageYaxis;

    //Panels
    private JPanel backgroundImagePanel, buttonPanel, infoPanel;

    //Labels
    private JLabel backgroundImageLabel;

    //Image
    private BufferedImage image;

    //init Lantern variable
    private LanternLabel lanternLabel = new LanternLabel();
    private LightBehaviourController lightBehaviourController = new LightBehaviourController(lanternLabel);
    private LanternLightComboBox lanternLightComboBox = new LanternLightComboBox(lightBehaviourController);

    private int imageHeight;
    private Image resizedImage;

    private final int buttonPanelHeight = 150;
    private int imageStartXaxis;
    private int imageStartYaxis;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    //Abstract Factory
    private TableLabel tableLabel = new TableLabel();
    private MooncakeDescriptionPanel mooncakeDescriptionPanel = new MooncakeDescriptionPanel();
    private MooncakeLabel mooncakeLabel = new MooncakeLabel(mooncakeDescriptionPanel);
    private AbstractFactoryController abstractFactoryController = new AbstractFactoryController(mooncakeDescriptionPanel, mooncakeLabel);
    private AddMooncakeButton addMooncakeButton = new AddMooncakeButton(abstractFactoryController);
    private MooncakeStyleComboBox mooncakeStyleComboBox = new MooncakeStyleComboBox(abstractFactoryController);
    private MooncakeFlavorComboBox mooncakeFlavorComboBox = new MooncakeFlavorComboBox(abstractFactoryController);

    public MidAutumnSwing() {
        //Set title
        setTitle("Decorate the Christmas tree!");

        setLayout(new BorderLayout());


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

        houseLabel.setBounds(0, 0, 300, 300);
        houseLayeredPanel.add(houseLabel, JLayeredPane.DEFAULT_LAYER);
        int imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        int imageWidth = (int) screenSize.getWidth();
        houseLayeredPanel.setBounds(0, 0, imageWidth, imageHeight);
        backgroundImagePanel.add(houseImagePanel, JLayeredPane.DEFAULT_LAYER);
        houseLayeredPanel.setBounds(200, 250, 300, 300);
        backgroundImageLabel.add(houseLayeredPanel, JLayeredPane.PALETTE_LAYER);


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


        buttonPanel.add(undoButton);
        buttonPanel.add(changErFashionComboBox);
        buttonPanel.add(redoButton);
        changErImageXaxis = (int) screenSize.getWidth() - 350;
        changErImageYaxis = 100;
        changErLabel.setBounds(changErImageXaxis, changErImageYaxis, 300, 300);
        backgroundImageLabel.add(changErLabel);


//Abstract Factory Mooncake
        mooncakeLabel.setBounds(1155, 570, 207, 53);
        mooncakeDescriptionPanel.setBounds(800, 300, 400, 300);
        mooncakeDescriptionPanel.setLayout(new BoxLayout(mooncakeDescriptionPanel, BoxLayout.Y_AXIS));
        backgroundImageLabel.add(mooncakeLabel);
        backgroundImageLabel.add(mooncakeDescriptionPanel);
        mooncakeDescriptionPanel.setVisible(false);

        //Table Image
        tableLabel.setBounds(1120, 600, 260, 178);
        backgroundImageLabel.add(tableLabel);

        lanternLabel.setBounds(400, 200, 200, 200);
        backgroundImageLabel.add(lanternLabel);

        //Add the buttons to the buttonPanel
        buttonPanel.add(mooncakeStyleComboBox);
        buttonPanel.add(mooncakeFlavorComboBox);
        buttonPanel.add(addMooncakeButton);
        //Add the buttons to the buttonPanel
        buttonPanel.add(lanternLightComboBox);
        buttonPanel.add(timerLabel);
        buttonPanel.add(rabbitObserverCheckBox);
        buttonPanel.add(audioPlayerObserverCheckBox);
        buttonPanel.add(decoratorComboBox);
        buttonPanel.add(applyDecorationButton);
        buttonPanel.add(clearDecorationButton);


        //Positioning Panels
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


    private void backgroundImageConfiguration() {
        imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        resizedImage = image.getScaledInstance(-1, imageHeight, Image.SCALE_SMOOTH);

        imageStartXaxis = (int) (screenSize.getWidth() - resizedImage.getWidth(null)) / 2;
        imageStartYaxis = 10;
    }
}//class
