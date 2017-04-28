package model;

/**
 * Created by everduin on 12/12/2016.
 */
public enum EmploymentCategory {
    employed("employed"),
    selfEmployed("self employed"),
    unemployed("unemployed"),
    other("other"); //Should be caps, but refactoring would be a pain with bad data

    private String text;

    private EmploymentCategory (String text) {
     this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
