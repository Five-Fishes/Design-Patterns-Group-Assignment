package fivefishes.design.patterns.group.assignment.entities.memento;

public class ChangErMemento {
    private String fashionType;

    private String changErImageUrl;

    public ChangErMemento (String fashionType, String changErImageUrl) {
        this.fashionType = fashionType;
        this.changErImageUrl = changErImageUrl;
    }

    public String getFashionType() {
        return fashionType;
    }

    public void setFashionType(String fashionType) {
        this.fashionType = fashionType;
    }

    public String getChangErImageUrl() {
        return changErImageUrl;
    }

    public void setChangErImageUrl(String changErImageUrl) {
        this.changErImageUrl = changErImageUrl;
    }
}
