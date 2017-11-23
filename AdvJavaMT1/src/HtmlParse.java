import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class HtmlParse {
    private Document doc;
    private String url;

    public HtmlParse(String url) {
        this.url = url;
        getSource();
    }

    public String getSource() {
        try {
            if (url.contains("http://")) {
                this.doc = Jsoup.connect(url).get();
            } else {
                File fin = new File(url);
                this.doc = Jsoup.parse(fin, "UTF-8", url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc.toString();
    }

    public String getWeatherReport() {
        String report = "";

        String title = doc.select("channel > description").text();
        report += title + "\n";

        String pubDate = doc.select("channel > pubDate").text();
        report += pubDate + "\n\n";

        Element elementContent = doc.selectFirst("channel > item");
        String content = elementContent.selectFirst("title").text();
        content = content.substring(9, content.length() - 3) + "\n";
        content += elementContent.selectFirst("description").text();
        report += content;

        return report;
    }

    public String[] getNewsList() {
        List newsList = new ArrayList<String>();
        for (Element e: doc.select("div.article_list li a")) {
            newsList.add(e.text());
        }

        return (String[]) newsList.toArray(new String[0]);
    }




}
