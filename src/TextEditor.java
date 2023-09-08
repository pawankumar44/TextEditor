import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        frame.add(textArea);

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
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

    }
}