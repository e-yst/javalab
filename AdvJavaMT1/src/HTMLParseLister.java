import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

public class HTMLParseLister extends HTMLEditorKit.ParserCallback
{
    int indentSize = 0;
    protected void indent() {
        indentSize += 3;
    }
    protected void unIndent() {
        indentSize -= 3;
        if (indentSize < 0) indentSize = 0;
    }

    protected void printIndent() {
        for(int i = 0; i < indentSize; i++) System.out.print(" ");
    }

    public void handleText(char[] data, int pos) {
        //printIndent();
        //System.out.println("Text(" + data.length + " chars)");
        //System.out.println(data);
    }

    public void handleComment(char[] data, int pos) {
        //printIndent();
        //System.out.println("Comment(" + data.length + " chars)");
    }

    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        //printIndent();

        // �M�� <a href=....> .... </a>, �L�X�Hhttp�_�l���쵲
        if(t == HTML.Tag.A) {
            String ref = (String)a.getAttribute(HTML.Attribute.HREF);
            if(ref.length() >= 4 && ref.substring(0, 4).equals("http")) {
                System.out.print("Tag start(<" + t.toString() + ">, " +
                        a.getAttributeCount() + " attrs) -> ");
                System.out.println(ref);
            }
        }

        //indent();
    }

    public void handleEndTag(HTML.Tag t,int pos) {
        //unIndent();
        //printIndent();
        //System.out.println("Tag end(<" + t.toString() + ">)");
    }

    public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        printIndent();
        //System.out.println("Tag(<" + t.toString() + ">, " +
        //	a.getAttributeCount() + " attrs)");
    }

    public void handleError(String errorMsg, int pos){
        //System.out.println("Parsing error: " + errorMsg + " at " + pos);
    }
}