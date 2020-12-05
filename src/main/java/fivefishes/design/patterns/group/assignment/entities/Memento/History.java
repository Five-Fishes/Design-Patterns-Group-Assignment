package fivefishes.design.patterns.group.assignment.entities.Memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<ChangErMemento> history = new ArrayList<>();
    private int currentIndex = -1;
    private final int HISTORY_MAX_SIZE = 5;

    public void add(ChangErMemento changErMemento) {
        if (history.size() >= HISTORY_MAX_SIZE) {
            history.remove(0);
        } else if (currentIndex < history.size()-1) {
            history.subList(currentIndex + 1, history.size()).clear();
        }
        this.history.add(changErMemento);
        currentIndex = history.indexOf(changErMemento);
    }

    public ChangErMemento undo() {
        if (currentIndex <= 0) {
            System.out.println("Undo action is not available");
            return history.get(0);
        }
        currentIndex--;
        return history.get(currentIndex);
    }

    public ChangErMemento redo() {
        if (currentIndex >= history.size()-1) {
            System.out.println("Redo action is not available");
            return history.get(currentIndex);
        }
        currentIndex++;
        return history.get(currentIndex);
    }

    @Override
    public String toString() {
        return "History Size: " + history.size() + " " +
                "Current Showing Index of History: " + currentIndex;
    }
}
