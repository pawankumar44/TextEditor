import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TextEditor {
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
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

    }
}