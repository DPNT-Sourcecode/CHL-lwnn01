package befaster.solutions.CHL;

import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class CheckliteSolution {
    Map<String, StockKeepingUnit> inventory;

    public CheckliteSolution(Map<String, StockKeepingUnit> inventory){
        if (inventory == null) {
            intialiase();
        } else {
            this.inventory = inventory;
        }

    }

    public Integer checklite(String skus) {
        if (MapUtils.isEmpty(this.inventory)) return -1;

        //Step 1 - parse SKUs into occurrence Map
        Map<String, Integer> basket = parseBasket(skus);
        if(MapUtils.isEmpty(basket)) {
            return 0;
        }
        //Step 2 - calculate cost
        return totaliseBasket(basket);
    }

    private Map<String, Integer> parseBasket(String skus){
        Map<String, Integer> skuCount = new HashMap<>();
        for (int i = 0; i < skus.length(); i++){
            String sku = String.valueOf(skus.charAt(i));
            if (!skuCount.containsKey(sku)){
                skuCount.put(sku, 1);
            } else {
                skuCount.put(sku, Integer.valueOf(skuCount.get(sku) + 1));
            }
        }
        return skuCount;
    }

    private Integer totaliseBasket(Map<String, Integer> basket){
        Integer overallTotal = 0;

        for(Map.Entry<String, Integer> entry : basket.entrySet()){
            if(inventory.containsKey(entry.getKey())){
                overallTotal += getCost(entry.getValue(), inventory.get(entry.getKey()));
            } else {
                //Fail - Hard
                return -1;
            }
        }
        return overallTotal;
    }

    private Integer getCost(Integer quantity, StockKeepingUnit sku){
        if(quantity == null || quantity.equals(0)) return 0;

        if (sku.getOffers() == null){
            return quantity * sku.getCost();
        } else {
            SpecialOffer offer = sku.getOffers();
            int cost = (quantity / offer.getQuantity()) * offer.getBulkCost();
            //Use Modulus to determine cost of units at normal price
            cost += (quantity % offer.getQuantity()) * sku.getCost();
            return cost;
        }
    }

    private void intialiase(){
        this.inventory = new HashMap<>();
        StockKeepingUnit skuA = new StockKeepingUnit("A", 50,  new SpecialOffer(3, 130));
        StockKeepingUnit skuB = new StockKeepingUnit("B", 30,  new SpecialOffer(2, 45));
        StockKeepingUnit skuC = new StockKeepingUnit("C", 20,  null);
        StockKeepingUnit skuD = new StockKeepingUnit("D", 15,  null);
        this.inventory.put(skuA.getId(), skuA);
        this.inventory.put(skuB.getId(), skuB);
        this.inventory.put(skuC.getId(), skuC);
        this.inventory.put(skuD.getId(), skuD);
    }
}

