package befaster.solutions.CHL;

public class SpecialOffer {
     private final Integer quantity;
     private final Integer bulkCost;

    public SpecialOffer(Integer quantity, Integer bulkCost) {
        this.quantity = quantity;
        this.bulkCost = bulkCost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getBulkCost() {
        return bulkCost;
    }
}

