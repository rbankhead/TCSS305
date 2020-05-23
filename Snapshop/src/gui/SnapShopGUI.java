package gui;
import filters.*;
import image.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

/**
 * TODO:
 * Project plan, proposed technical solution, testing plan
 * JUnit tests
 * 
 * @author Richard Bankhead
 * @version 1.0
 */
public class SnapShopGUI {

    /**
     * frame which holds all other GUI elements
     */
    private JFrame frame = new JFrame();
    
    /**
     * array of filter objects, used to create the buttons and their action listeneres in the filterButtons array and the filterPanel
     * if additional filters are added they must be hardcoded into this array
     */
    private Filter[] filters = new Filter[] {new EdgeDetectFilter(),new EdgeHighlightFilter(),new FlipHorizontalFilter(),new FlipVerticalFilter(),new GrayscaleFilter(),new SharpenFilter(),new SoftenFilter()};
    
    /**
     * array of buttons made from the filters array
     * new filter buttons will automatically be created if they are added to the filters array
     */
    private JButton[] filterButtons = new JButton[filters.length];
    
    /**
     * array of buttons for the menu panel
     */
    private JButton[] menuButtons = new JButton[] {new JButton("Open..."),new JButton("Save As..."),new JButton("Close Image")}; 
    
    /**
     * the main panel which will be displayed in frame, will hold the other 3 panels
     */
    private JPanel mainPanel = new JPanel(new BorderLayout());
    
    /**
     * panel containing the filter buttons on the top row
     */
    private JPanel filterPanel = new JPanel(new GridLayout(1,filters.length));
    
    /**
     * panel containing the menu buttons on the bottom row
     */
    private JPanel menuPanel = new JPanel();
    
    /**
     * j file chooser for the open and save buttons
     */
    private JFileChooser chooser = new JFileChooser();
    
    /**
     * default directory
     */
    private File directory = new File("sample_images");
    
    /**
     * pixelImage object will be the shown image when one is loaded
     * this object will be what the filters are applied to
     */
    private PixelImage pixelImage;
    
    /**
     * the jlabel that will host the pixel image
     */
    private JLabel image = new JLabel(new ImageIcon());
    
    
    
    /**
     * @return the pixelImage
     */
    public PixelImage getPixelImage() {
        return pixelImage;
    }

    /**
     * @return the menuButtons
     */
    public JButton[] getMenuButtons() {
        return menuButtons;
    }

    /**
     * @return the filterButtons
     */
    public JButton[] getFilterButtons() {
        return filterButtons;
    }

    /**
     * sets the enabled status of all buttons in the frame excluding "open"
     * "open" button is not included as it is always enabled
     * #Req 1.3
     * @param enabledStatus false for disabled, true for enabled
     */
    public void setButtonEnable(Boolean enabledStatus) {
        for(JButton b : getFilterButtons()) {
            b.setEnabled(enabledStatus);
        }
        getMenuButtons()[1].setEnabled(enabledStatus);
        getMenuButtons()[2].setEnabled(enabledStatus);
    }
    
    /**
     * loops over myFilterButtons and creates a new JButton in each for each filter in myFilters
     * add each of the created buttons to myFilterPanel
     * #Req1.2, 4, 4.1, 5
     */
    public void makeFilterButtons() {
        for(int i=0;i<filters.length;i++) {
            getFilterButtons()[i] = new JButton(filters[i].getDescription());
            filterPanel.add(getFilterButtons()[i]);
            getFilterButtons()[i].addActionListener(e ->{
                int index = -1;
                for(int j=0;j<filters.length;j++) { //linear search to identify which filter should be active on each button, inside of lambda is not able to reference the for loops i variable
                    if(filters[j].getDescription().equals(e.getActionCommand())){
                        index=j;
                    }
                    
                }
                filters[index].filter(getPixelImage());
                image.setIcon(new ImageIcon(getPixelImage()));
            });
        }
    }
    
    /**
     * creates menu buttons and adds them to the menu panel
     * creates action listeners for each button
     * new menu buttons must be added manually, these are hard coded not looped over
     * #Req 1.2, 2.1, 2.2, 2.3, 3, 3.2, 6, 6.1, 7, 8
     */
    public void makeMenuButtons() {
        //Open button
        getMenuButtons()[0].addActionListener(e -> {
            chooser.setCurrentDirectory(directory); //updates the default directory to whichever the user has chosen
        int result = chooser.showOpenDialog(getFrame());
            if(result == chooser.APPROVE_OPTION) {
                directory = chooser.getCurrentDirectory();
                try {
                    pixelImage = getPixelImage().load(chooser.getSelectedFile());
                    image.setIcon(new ImageIcon(getPixelImage()));
                    getFrame().pack(); //3.2
                    setButtonEnable(true); //enable buttons
                }
                catch (IOException e1) {
                    JOptionPane.showMessageDialog(getFrame(),"The selected file did not contain an image!\n" + chooser.getSelectedFile()); //displays error window
                }
            }
        });
        
        //Save button
        getMenuButtons()[1].addActionListener(e -> {
            chooser.setCurrentDirectory(directory);
            int result = chooser.showSaveDialog(getFrame());
            File saveFile = chooser.getSelectedFile();
            if(result == chooser.APPROVE_OPTION) {
                try {
                    getPixelImage().save(saveFile);
                }
                catch (IOException e1) {
                    JOptionPane.showMessageDialog(getFrame(),"Something went wrong"); //displays error window
                }
            }
        });
        
        //Close image button
        getMenuButtons()[2].addActionListener(e -> {
            pixelImage = null; //may not be necessary
            image.setIcon(new ImageIcon()); //blank image
            setButtonEnable(false); //sets buttons back to disabled
            getFrame().pack();
        });
        
        //adds the buttons to the menu panel
        menuPanel.add(getMenuButtons()[0]);
        menuPanel.add(getMenuButtons()[1]);
        menuPanel.add(getMenuButtons()[2]);
    }
    
    /**
     * creates the main panel
     * #Req 1.2
     */
    public void makeMainPanel() {
        makeFilterButtons();
        makeMenuButtons();
        mainPanel.add(filterPanel, BorderLayout.NORTH);
        mainPanel.add(image,BorderLayout.CENTER);
        mainPanel.add(menuPanel, BorderLayout.SOUTH);
    }
    
    /**
     * kicks off GUI
     * sets properties for frame
     * #Req 1.1, 1.3, 3.2, 9
     */
    public void start() {
        makeMainPanel();
        setButtonEnable(false);
        getFrame().add(mainPanel);
        getFrame().setTitle("TCSS 305 - Assignment 4 (rbank)");
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //#Req 9
        getFrame().pack();
        getFrame().setResizable(true);
        getFrame().setVisible(true);
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }
}