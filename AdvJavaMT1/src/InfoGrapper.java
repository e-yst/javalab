import javax.swing.*;
import java.awt.*;


public class InfoGrapper extends JFrame {

    private JButton buttonGo;
    private JTextArea display;
    private JList news;

    public InfoGrapper() {
        createView();
        setTitle("Info Grapper");
        setSize(800, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createView() {
        JPanel panelMain = new JPanel(new BorderLayout());
        getContentPane().add(panelMain);

        //North
        buttonGo = new JButton("Click here to grap from www.cwb.gov.tw");
        buttonGo.addActionListener(e -> {
//            String url = "D:\\Users\\eason\\Documents\\Codes\\ntust\\javalab\\AdvJavaMT2\\36_01.xml";
            String url = "http://www.cwb.gov.tw/rss/forecast/36_01.xml";
            HtmlParse parser = new HtmlParse(url);
            String report = parser.getWeatherReport();
            display.setText(report);
        });
        panelMain.add(buttonGo, BorderLayout.NORTH);
        //

        //East
        display = new JTextArea();
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        display.setEditable(false);
        display.setText("Hello World");
        display.setBorder(BorderFactory.createTitledBorder("Weather Forecast from cwb.gov.tw"));
        JScrollPane displaySP = new JScrollPane(display);
        panelMain.add(displaySP, BorderLayout.CENTER);
        //


        //West
        String[] newsList = grapCna();
        news = new JList(newsList);
        news.setBorder(BorderFactory.createTitledBorder("News from cna.com.tw"));
        JScrollPane newsSP = new JScrollPane(news);
        panelMain.add(newsSP, BorderLayout.WEST);
        //
    }

    private String[] grapCna() {
        String url = "http://www.cna.com.tw/list/firstnews-1.aspx";
        HtmlParse parser = new HtmlParse(url);
        String[] result = parser.getNewsList();
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InfoGrapper().setVisible(true));
    }
}
