import Books.Book;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class MainWindow {
    private JPanel panel;
    private JRadioButton optionList;
    private JRadioButton optionAdd;
    private JRadioButton optionSort;
    private JRadioButton optionSearch;
    private JButton optionButton;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField pagesField;
    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel pagesLabel;
    private JButton addBook;
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JLabel shelf;
    private ArrayList<Book> books;
    private ArrayList<JLabel> listOfBooks;
    private int i;
    private final int MAX_PAGES = 828;
    Font myFont = new Font("Monospaced", Font.PLAIN, 15);
   // Color bgColor = new Color(247, 231, 166);
   Color bgColor = new Color(222, 212, 195);
    //Color fieldColor = new Color(255, 247, 217);
    Color fieldColor = new Color(222, 216, 206);
    Color fontColor = new Color(156, 87, 8);
    //Color buttonColor = new Color(250, 227, 132);
    Color buttonColor = new Color(222, 204, 173);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Books");
        frame.setSize(500, 500);
        MainWindow mainWindow = new MainWindow();
        mainWindow.panel = new JPanel();
        ArrayList<JLabel> label = new ArrayList<>();
        mainWindow.books = new ArrayList<>();
        mainWindow.listOfBooks = new ArrayList<>();
        mainWindow.panel.setBackground(mainWindow.bgColor);

        mainWindow.shelf = new JLabel(new ImageIcon("C:\\Users\\BOGI\\Desktop\\wood.jpg"));
        mainWindow.shelf.setBounds(0, 120, 500, 20);
        mainWindow.shelf.setOpaque(true);

        //buttons
        mainWindow.addBook = new JButton("Add");
        mainWindow.addBook.setBounds(10, 390, 100, 20);
        mainWindow.addBook.setFont(mainWindow.myFont);
        mainWindow.addBook.setBackground(mainWindow.buttonColor);
        mainWindow.addBook.setForeground(mainWindow.fontColor);
        mainWindow.addBook.setBorder(BorderFactory.createEmptyBorder());

        mainWindow.optionButton = new JButton("Choose");
        mainWindow.optionButton.setBounds(10, 270, 100, 20);
        mainWindow.optionButton.setFont(mainWindow.myFont);
        mainWindow.optionButton.setBackground(mainWindow.buttonColor);
        mainWindow.optionButton.setForeground(mainWindow.fontColor);
        mainWindow.optionButton.setBorder(BorderFactory.createEmptyBorder());

        mainWindow.searchButton = new JButton("Search");
        mainWindow.searchButton.setBounds(10, 330, 100, 20);
        mainWindow.searchButton.setFont(mainWindow.myFont);
        mainWindow.searchButton.setBackground(mainWindow.buttonColor);
        mainWindow.searchButton.setForeground(mainWindow.fontColor);
        mainWindow.searchButton.setBorder(BorderFactory.createEmptyBorder());

        ButtonGroup buttonGroup = new ButtonGroup();
        mainWindow.optionList = new JRadioButton(("List your books"));
        mainWindow.optionList.setBounds(10, 180, 500, 20);
        mainWindow.optionList.setFont(mainWindow.myFont);
        mainWindow.optionList.setOpaque(false);
        mainWindow.optionList.setForeground(mainWindow.fontColor);

        mainWindow.optionAdd = new JRadioButton("Add a book to your shelf");
        mainWindow.optionAdd.setBounds(10, 150, 500, 20);
        mainWindow.optionAdd.setFont(mainWindow.myFont);
        mainWindow.optionAdd.setOpaque(false);
        mainWindow.optionAdd.setForeground(mainWindow.fontColor);

        mainWindow.optionSearch = new JRadioButton("Search for a book");
        mainWindow.optionSearch.setBounds(10, 210, 500, 20);
        mainWindow.optionSearch.setFont(mainWindow.myFont);
        mainWindow.optionSearch.setOpaque(false);
        mainWindow.optionSearch.setForeground(mainWindow.fontColor);

        mainWindow.optionSort = new JRadioButton("Sort your books");
        mainWindow.optionSort.setBounds(10, 240, 500, 20);
        mainWindow.optionSort.setFont(mainWindow.myFont);
        mainWindow.optionSort.setOpaque(false);
        mainWindow.optionSort.setForeground(mainWindow.fontColor);

        //labels
        mainWindow.titleLabel = new JLabel("Title:");
        mainWindow.titleLabel.setBounds(10, 300, 100, 20);
        mainWindow.titleLabel.setFont(mainWindow.myFont);
        mainWindow.titleLabel.setForeground(mainWindow.fontColor);

        mainWindow.authorLabel = new JLabel("Author: ");
        mainWindow.authorLabel.setBounds(10, 330, 100, 20);
        mainWindow.authorLabel.setFont(mainWindow.myFont);
        mainWindow.authorLabel.setForeground(mainWindow.fontColor);

        mainWindow.pagesLabel = new JLabel("Number of pages: ");
        mainWindow.pagesLabel.setBounds(10, 360, 200, 20);
        mainWindow.pagesLabel.setFont(mainWindow.myFont);
        mainWindow.pagesLabel.setForeground(mainWindow.fontColor);

        mainWindow.searchLabel = new JLabel("What title are you searching for? ");
        mainWindow.searchLabel.setBounds(10, 300, 300, 20);
        mainWindow.searchLabel.setFont(mainWindow.myFont);
        mainWindow.searchLabel.setForeground(mainWindow.fontColor);

        //fields
        mainWindow.titleField = new JTextField(10);
        mainWindow.titleField.setBounds(155, 300, 150, 20);
        mainWindow.titleField.setFont(mainWindow.myFont);
        mainWindow.titleField.setBackground(mainWindow.fieldColor);

        mainWindow.authorField = new JTextField(10);
        mainWindow.authorField.setBounds(155, 330, 150, 20);
        mainWindow.authorField.setFont(mainWindow.myFont);
        mainWindow.authorField.setBackground(mainWindow.fieldColor);

        mainWindow.pagesField = new JTextField(10);
        mainWindow.pagesField.setBounds(155, 360, 150, 20);
        mainWindow.pagesField.setFont(mainWindow.myFont);
        mainWindow.pagesField.setBackground(mainWindow.fieldColor);

        mainWindow.searchField = new JTextField(10);
        mainWindow.searchField.setBounds(310, 300, 150, 20);
        mainWindow.searchField.setFont(mainWindow.myFont);
        mainWindow.searchField.setBackground(mainWindow.fieldColor);

        mainWindow.authorField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isAlphabetic(c))) {
                    e.consume();
                }
            }
        });

        frame.add(mainWindow.panel);
        mainWindow.optionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainWindow.optionAdd.isSelected()) {
                    addBooks(frame, mainWindow, label);
                }
                if (mainWindow.optionList.isSelected()) {
                    listBooks(frame, mainWindow);
                }
                if (mainWindow.optionSearch.isSelected()) {
                    searchBook(frame, mainWindow);
                }
                if (mainWindow.optionSort.isSelected()) {
                    sortBook(frame, mainWindow, label);
                }
            }
        });

        mainWindow.panel.add(mainWindow.shelf);
        buttonGroup.add(mainWindow.optionAdd);
        buttonGroup.add(mainWindow.optionList);
        buttonGroup.add(mainWindow.optionSearch);
        buttonGroup.add(mainWindow.optionSort);
        mainWindow.panel.add(mainWindow.optionAdd);
        mainWindow.panel.add(mainWindow.optionList);
        mainWindow.panel.add(mainWindow.optionSearch);
        mainWindow.panel.add(mainWindow.optionSort);
        mainWindow.panel.add(mainWindow.optionButton);
        frame.setContentPane(mainWindow.panel);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void removeAdd(MainWindow mainWindow, JFrame frame) {
        mainWindow.panel.remove(mainWindow.titleField);
        mainWindow.panel.remove(mainWindow.titleLabel);
        mainWindow.panel.remove(mainWindow.authorField);
        mainWindow.panel.remove(mainWindow.pagesField);
        mainWindow.panel.remove(mainWindow.authorLabel);
        mainWindow.panel.remove(mainWindow.pagesLabel);
        mainWindow.panel.remove(mainWindow.addBook);
        frame.repaint();
    }

    private static void removeSearch(MainWindow mainWindow, JFrame frame) {
        mainWindow.panel.remove(mainWindow.searchButton);
        mainWindow.panel.remove(mainWindow.searchField);
        mainWindow.panel.remove(mainWindow.searchLabel);
        frame.repaint();
    }

    private static void removeList(MainWindow mainWindow, JFrame frame) {
        for (int k = 0; k < mainWindow.listOfBooks.size(); k++)
            mainWindow.panel.remove(mainWindow.listOfBooks.get(k));
        frame.repaint();
    }

    private static void addThings(MainWindow mainWindow, JFrame frame) {
        mainWindow.panel.add(mainWindow.titleLabel);
        mainWindow.panel.add(mainWindow.titleField);
        mainWindow.panel.add(mainWindow.authorField);
        mainWindow.panel.add(mainWindow.pagesField);
        mainWindow.panel.add(mainWindow.authorLabel);
        mainWindow.panel.add(mainWindow.pagesLabel);
        mainWindow.panel.add(mainWindow.addBook);
        frame.repaint();
    }

    private static void sortBook(JFrame frame, MainWindow mainWindow, ArrayList<JLabel> label) {
        ArrayList<JLabel> sortedBooks = new ArrayList<>();
        Random random = new Random();
        removeAdd(mainWindow, frame);
        removeList(mainWindow, frame);
        removeSearch(mainWindow, frame);
        for (int k = 0; k < mainWindow.books.size(); k++) {
            mainWindow.panel.remove(label.get(k));
        }

        Collections.sort(mainWindow.books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        for (int k = 0; k < mainWindow.books.size(); k++) {
            sortedBooks.add(new JLabel("<html>" + mainWindow.books.get(k).getTitle() + " by " + mainWindow.books.get(k).getAuthor() + "</html>"));
            sortedBooks.get(k).setBounds(k * 47 + 3, 10, random.nextInt(40, 47), 110);
            sortedBooks.get(k).setForeground(Color.white);
            sortedBooks.get(k).setFont(new Font("Serif", Font.PLAIN, 16));
            sortedBooks.get(k).setBackground(new Color(250, random.nextInt(138, 210), 57));
            sortedBooks.get(k).setOpaque(true);
            mainWindow.panel.add(sortedBooks.get(k));
            frame.repaint();
        }
    }

    private static void searchBook(JFrame frame, MainWindow mainWindow) {
        removeAdd(mainWindow, frame);
        removeList(mainWindow, frame);
        mainWindow.panel.add(mainWindow.searchField);
        mainWindow.panel.add(mainWindow.searchLabel);
        mainWindow.panel.add(mainWindow.searchButton);
        mainWindow.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int foundPosition = -1;
                for (int k = 0; k < mainWindow.books.size(); k++) {
                    if (mainWindow.searchField.getText().equals(mainWindow.books.get(k).getTitle())) {
                        foundPosition = k;
                    }
                }
                if (foundPosition != -1) {
                    JOptionPane.showMessageDialog(frame, "The book was found at position " + (foundPosition + 1));
                    return;
                }
                JOptionPane.showMessageDialog(frame, "The book was not found!");
                mainWindow.searchField.setText("");
            }
        });
    }

    private static void listBooks(JFrame frame, MainWindow mainWindow) {
        removeAdd(mainWindow, frame);
        removeSearch(mainWindow, frame);
        mainWindow.listOfBooks = new ArrayList<>();
        for (int j = 0; j < mainWindow.books.size(); j++) {
            mainWindow.listOfBooks.add(new JLabel(mainWindow.books.get(j).toString()));
            mainWindow.listOfBooks.get(j).setBounds(10, 300 + 20 * j, 500, 20);
            mainWindow.listOfBooks.get(j).setForeground(mainWindow.fontColor);
            mainWindow.listOfBooks.get(j).setFont(mainWindow.myFont);
            mainWindow.listOfBooks.get(j).setOpaque(false);
            mainWindow.panel.add(mainWindow.listOfBooks.get(j));
            frame.repaint();
        }
    }

    private static void addBooks(JFrame frame, MainWindow mainWindow, ArrayList<JLabel> label) {
        addThings(mainWindow, frame);
        removeList(mainWindow, frame);
        removeSearch(mainWindow, frame);
        Random random = new Random();
        mainWindow.addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if ((Integer.parseInt(mainWindow.pagesField.getText()) > mainWindow.MAX_PAGES) &&
                            (!mainWindow.pagesField.getText().equals("")) &&
                            (!mainWindow.authorField.getText().equals("")) &&
                            (!mainWindow.titleField.getText().equals(""))) {
                        System.out.println("Invalid input");
                        mainWindow.titleField.setText("");
                        mainWindow.authorField.setText("");
                        mainWindow.pagesField.setText("");
                    } else {
                        mainWindow.books.add(new Book(mainWindow.titleField.getText(), mainWindow.authorField.getText(), Integer.parseInt(mainWindow.pagesField.getText())));
                        mainWindow.books.get(mainWindow.i).setTitle(mainWindow.titleField.getText());
                        mainWindow.books.get(mainWindow.i).setAuthor(mainWindow.authorField.getText());
                        mainWindow.books.get(mainWindow.i).setPages(Integer.parseInt(mainWindow.pagesField.getText()));
                        label.add(new JLabel("<html>" + mainWindow.books.get(mainWindow.books.size() - 1).getTitle() + " by " + mainWindow.books.get(mainWindow.books.size() - 1).getAuthor() + "</html>"));
                        label.get(mainWindow.i).setBounds(mainWindow.i * 47 + 3, 10, random.nextInt(40, 47), 110);
                        label.get(mainWindow.i).setForeground(Color.white);
                        label.get(mainWindow.i).setFont(new Font("Serif", Font.PLAIN, 16));
                        label.get(mainWindow.i).setBackground(new Color(250, random.nextInt(138, 210), 57));
                        label.get(mainWindow.i).setOpaque(true);
                        mainWindow.panel.add(label.get(mainWindow.i));
                        mainWindow.i++;
                        mainWindow.titleField.setText("");
                        mainWindow.authorField.setText("");
                        mainWindow.pagesField.setText("");
                        frame.repaint();
                    }
                } catch (NumberFormatException d) {
                    System.out.println("NumberFormat Exception");
                }
            }
        });
    }
}
