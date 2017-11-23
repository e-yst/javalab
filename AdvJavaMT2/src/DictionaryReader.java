import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DictionaryReader extends JFrame {

    private JTextField userInput;
    private JButton buttonSearch;
    private JTextArea dataLog;
    private HashMap dictionary = new HashMap();

    public DictionaryReader() {
        createView();
        setTitle("Dictionary Reader");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false);

        loadDictionary();
    }

    private void loadDictionary() {
        try {
            FileReader fr = new FileReader(getClass().getResource("Dictionary.txt").getFile());
            BufferedReader br = new BufferedReader(fr);

            String line = null;


            while ((line = br.readLine()) != null) {
                StringBuilder data = new StringBuilder();
                data.append(line);
                String[] lineArr = data.toString().split("-");
                String key = lineArr[0];
                String value = lineArr[1];
//                System.out.printf("%s: %s%n", key, value);
                dictionary.put(key, value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createView() {
        JPanel panelMain = new JPanel(new BorderLayout());
        getContentPane().add(panelMain);

        //North
        JPanel panelNorth = new JPanel(new BorderLayout());
        userInput = new JTextField();
        userInput.setPreferredSize(new Dimension(400, 0));
        panelNorth.add(userInput, BorderLayout.WEST);
        buttonSearch = new JButton("Search");
        buttonSearch.addActionListener((ActionEvent e) -> {
            String s = userInput.getText();
            dataLog.setText("");

            if (s.equals("*")) {
                ArrayList<String> entries = new ArrayList<>();
                Iterator it = dictionary.entrySet().iterator();

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    entries.add(String.format(
                            "%s: %s%n%n", pair.getKey(), pair.getValue()));
                }

                Collections.sort(entries);
                for (String txt: entries) {
                    dataLog.append(txt);
                }

            } else if (!dictionary.containsKey(s)) {
                dataLog.setText("No descriptions about this.");
            } else {
                dataLog.setText((String) dictionary.get(s));
            }
            userInput.setText("");
        });
        panelNorth.add(buttonSearch, BorderLayout.EAST);
        panelMain.add(panelNorth, BorderLayout.NORTH);
        //

        dataLog = new JTextArea();
        dataLog.setEditable(false);
        dataLog.setLineWrap(true);
        JScrollPane dataLogSP = new JScrollPane(dataLog);
        panelMain.add(dataLogSP);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DictionaryReader().setVisible(true));
    }
}
