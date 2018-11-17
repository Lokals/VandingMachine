package pl.sdacademy.vending;

public enum UserMenySelection {

    BUY_PRODUCTS(1, "Buy products"),
    EXIT(9, "Exit");

    private final Integer optionNumber;
    private final String optionText;



    UserMenySelection(Integer optionNumber, String optionText) {
        this.optionNumber = optionNumber;
        this.optionText = optionText;
    }

    public static UserMenySelection selectionForOptionNumber(
            Integer requestedOptionNumber) {
        for (UserMenySelection menuSelection : values()) {
            if (menuSelection.getOptionNumber().equals(requestedOptionNumber)) {
                return menuSelection;
            }
        }
        throw new IllegalArgumentException("Unknown option number: " + requestedOptionNumber + " please select the correct number");
    }

    public Integer getOptionNumber() {
        return optionNumber;
    }

    public String getOptionText() {
        return optionText;
    }
}
