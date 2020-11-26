package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.entities.ChangErFashion;
import fivefishes.design.patterns.group.assignment.entities.History;
import fivefishes.design.patterns.group.assignment.entities.enumeration.Fashion;

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

        // Dropdown Construct and Config
        for (Fashion changeErFashion: changeErFashionList) {
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
        buttonPanel.add(redoButton);
        changErImageXaxis = (int) screenSize.getWidth() - 350;
        changErImageYaxis = 100;
        defaultChangEr();


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
        buttonPanel.add(changErFashionOptions);
        buttonPanel.add(exitButton);

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
        if (changErImage != null) {
            Image resizedChangErImage = changErImage.getScaledInstance(-1, 180, Image.SCALE_SMOOTH);
            g.drawImage(resizedChangErImage, changErImageXaxis, changErImageYaxis, this);
        }

    } //paint

    //Coding the event-handling routine
    public void actionPerformed(ActionEvent event){
        System.out.println(event.getSource());
        if (event.getSource() == exitButton) {
            System.exit(0);
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
        }

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

}//class
