package Tools;

import java.util.LinkedList;

import EV3.BrickButtons;
import EV3.Buttons;
import EV3.Display;

public class SelectMenu implements Runnable{

	SelectListener selectListener;
	LinkedList<String> labels = new LinkedList<>();
	int startLine = 0;
	int selected = 0;
	Thread t = new Thread(this);
	boolean run = true;
	
	/**
	 * @param selectListener
	 */
	public void addSelectListener(SelectListener selectListener) {
		this.selectListener = selectListener;
	}
	
	/**
	 * Add a new label.
	 * @param label
	 */
	public void addLabel(String label) {
		labels.add(label);		
	}
	
	/**
	 * Show the menu.
	 */
	public void show() {
		run = true;
		t.start();
	}
	
	/**
	 * Hide the menu.
	 */
	public void hide() {
		run = false;
	}
	
	/**
	 * Displays the menu.
	 */
	private void display() {
		Display.resetScreen();
		if(selected > 4) {
			startLine = (-1)*(selected-4);
		}
		for(int i = 0; i<labels.size(); i++) {
			if (i != selected)
				Display.text("   " + labels.get(i), 0, (i+startLine)*30);
			else
				Display.text(" > " + labels.get(i), 0, (i+startLine)*30);
		}
	}

	@Override
	public void run() {
		display();
		while(run) {
			BrickButtons.waitForAnyPress();
			if(BrickButtons.isPressed(Buttons.UP)) {
				selected--;
				if(selected < 0)
					selected = 0;
			}
			else if(BrickButtons.isPressed(Buttons.DOWN)) {
				selected++;
				if(selected == labels.size())
					selected = 0;
			}
			else if(BrickButtons.isPressed(Buttons.CENTER)) {
				selectListener.onSelect(labels.get(selected));
			}
		display();
		}
	}
	
	/**
	 * @return - The currently selected label.
	 */
	public String getSelectedLabel() {
		return labels.get(selected);
	}
	
	/**
	 * @return - The currently selected label index.
	 */
	public int getSelectedIndex() {
		return selected;
	}

}
