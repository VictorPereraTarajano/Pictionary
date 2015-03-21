package view.ui.display.impl.swing;

import model.chat.ChatMessage;
import model.manager.ManagerLobby;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.io.IOException;

public class ChatDisplay extends JPanel implements view.ui.display.interfaces.ChatDisplay {

    private JTextPane textArea;

    public ChatDisplay(){
        super();
        setLayout(new BorderLayout());
        createWidgets();
    }

    private void createWidgets() {
        add(createChatLabel(), BorderLayout.NORTH);
        add(createTextArea(), BorderLayout.CENTER);
        add(createScrollPane());
    }


    private Component createChatLabel() {
        return new JLabel(" Chat"){

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, getSize().width, getSize().height);
                g2d.setColor(new Color(225,218,89));
                g2d.fillRoundRect(0, 0, getSize().width, getSize().height, 10, 10);
                g2d.setColor(new Color(178,172,64));
                g2d.drawRoundRect(0, 0, getSize().width, getSize().height, 10, 10);
                super.paintComponent(g2d);
            }
        };
    }

    private Component createScrollPane() {
        return new JScrollPane(textArea) {
            {
                setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                setBorder(null);
            }

        };
    }

    private Component createTextArea() {
        return textArea=new JTextPane() {
            {
                setAutoscrolls(true);
                DefaultCaret caret = (DefaultCaret)getCaret();
                caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                setEditable(false);
                setContentType("text/html");
                HTMLDocument doc = new HTMLDocument();
                HTMLEditorKit kit = new HTMLEditorKit();
                setEditorKit(kit);
                setDocument(doc);
            }
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, getSize().width, getSize().height);
                super.paintComponent(g2d);
            }

        };
    }

    public void clear () {
        textArea.setText("");
    }

    @Override
    public void display(ChatMessage message) {
        if (ManagerLobby.myLobby.getChat().isEmpty())
            textArea.setText("");
        else {
            try {
                ((HTMLEditorKit)textArea.getEditorKit()).insertHTML((HTMLDocument)textArea.getDocument(), textArea.getDocument().getLength(), "<font color="+getHexadecimalColor(message.getPlayer().getColor())+">"+message.getPlayer()+"</font> : "+message.getMessage(), 0, 0, null);
            } catch (BadLocationException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getHexadecimalColor (Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

}
