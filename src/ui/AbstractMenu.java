package ui;

import java.util.List;

public abstract class AbstractMenu implements IMenu {
	public abstract String getHeaderMessage() {
	}

	public abstract List<String> getMenuOptionList() {
	}
	
	public abstract void execute() {
	}

	public abstract Integer requestPlayerChoice() {
	}
	
	public abstract IMenu getNextMenu() {
	}
	
	public void convertChoose(Integer choose) {
		//TODO
	}
}