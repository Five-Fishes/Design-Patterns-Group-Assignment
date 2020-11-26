package fivefishes.design.patterns.group.assignment.entities;

import fivefishes.design.patterns.group.assignment.entities.enumeration.Fashion;

public class ChangErFashion {

    private String fashionType;

    private String changErImageUrl;

    public String getFashionType() {
        return fashionType;
    }

    public void setFashionType(String fashionType) {
        this.fashionType = fashionType;
        this.setChangErImageUrl(Fashion.valueOf(fashionType).getImageUrl());
    }

    public String getChangErImageUrl() {
        return changErImageUrl;
    }

    public void setChangErImageUrl(String changErImageUrl) {
        this.changErImageUrl = changErImageUrl;
    }

    public ChangErMemento createMemento() {
        return new ChangErMemento(this.fashionType, this.changErImageUrl);
    }

    public void getFromChangErMemento(ChangErMemento changErMemento) {
        this.fashionType = changErMemento.getFashionType();
        this.changErImageUrl= changErMemento.getChangErImageUrl();
    }
}
