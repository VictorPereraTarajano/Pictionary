package view.display.interfaces;

import model.message.messagedata.impl.statedata.impl.SendChatStateData;

public interface ChatDisplay {
    public void display();
    public void setChatData(SendChatStateData chatData);
}
