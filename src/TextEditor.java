import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TextEditor implements ActionListener {
    //Declaring the properties of text editor
    //JFrame is starting window in which we will create application
    JFrame frame;
    JMenuBar menuBar;
    JMenu file, edit;
    //file menu items
    JMenuItem newFile, openFile, saveFile;
    //edit menu items
    JMenuItem cut,copy,paste, selectAll, close;

    JTextArea textArea;
    TextEditor(){
        //initialize a frame
        frame = new JFrame();

        menuBar = new JMenuBar();
        //set menubar to frame
        frame.setJMenuBar(menuBar);

        textArea = new JTextArea();
//        frame.add(textArea);//we don't add directly, we implement scroll
        //create Content Pane
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        //add text area to the panel
        panel.add(textArea,BorderLayout.CENTER);
        //Create Scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //add scroll pane to panel
        panel.add(scrollPane);
        //add panel to frame
        frame.add(scrollPane);
        //initialize menus
        file = new JMenu("File");
        edit = new JMenu("Edit");
        //add menus to menu bar
        menuBar.add(file);
        menuBar.add(edit);

        //menu items
        newFile = new JMenuItem("New Window");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("save File");

        //before adding to the file menu we need to add action listener
        //Add action Listeners to file menu items
        //this -> is object of TextEditor class and TextEditor class acting as ActionListener because it implements it
        //so here object of current TextEditor is listening to the newFile
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        //do the above with all menu item before adding to the menu

        //add menu items
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        //edit menu items
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");

        //repeating the above for edit menu
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        //set dimensions of frame
        frame.setBounds(50,75,400,400);
        frame.setTitle("Text Editor");
        frame.setVisible(true);//not hide frame
        frame.setLayout(null);

    }

    //using ActionListener
    @Override
    public  void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == cut){
            textArea.cut();
        }
        if(actionEvent.getSource() == copy){
            textArea.copy();
        }
        if(actionEvent.getSource() == paste){
            textArea.paste();
        }
        if(actionEvent.getSource() == selectAll){
            textArea.selectAll();
        }
        if(actionEvent.getSource() == close){
            System.exit(0);
        }

        if(actionEvent.getSource()==openFile){
            //open file chooser with starting directory path C:
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showOpenDialog(null);
            //if we have clicked on open button
            if(chooseOption == JFileChooser.APPROVE_OPTION){
                //Getting selected file
                File file = fileChooser.getSelectedFile();
                //get the path of selected file
                String filePath = file.getPath();
                try{
                    //Initialize file reader
                    FileReader fileReader = new FileReader(filePath);
                    //Initialize the buffer reader
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    //create the contents of the file from the file
                    //Intermediate string holding the content of the current line
                    //output holds the complete string
                    String intermediate = "", output = "";
                    //Read contents of file line by line
                    while ((intermediate = bufferedReader.readLine())!=null){
                        output+=intermediate+"\n";
                    }
                    //set the output string to text area
                    textArea.setText(output);
                }
                catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
        if(actionEvent.getSource()==saveFile){
            //Initialize file picker
            JFileChooser fileChooser = new JFileChooser("C:");
            //Get choose option from file chooser
            int chooseOption = fileChooser.showSaveDialog(null);
            //check if we clicked on save button
            if(chooseOption == JFileChooser.APPROVE_OPTION){
                //Create a new file with chosen directory path and file name
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                try{
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    //Write contents of text area to file
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                }
                catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
        //new window
        if(actionEvent.getSource() == newFile){
            TextEditor textEditor = new TextEditor();
        }
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

    }
}