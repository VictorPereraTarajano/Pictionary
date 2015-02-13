package view.ui.viewers.interfaces;

import view.ui.dialog.interfaces.CanvasDialog;
import view.ui.display.interfaces.CanvasDisplay;

public interface CanvasPanel {
    public CanvasDisplay getCanvasDisplay();
    public CanvasDialog getCanvasDialog();
}
