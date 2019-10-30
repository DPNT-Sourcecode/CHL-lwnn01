package befaster.solutions.CHL;

import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class CheckliteSolution {
    Map<String, StockKeepingUnit> inventory;

    public CheckliteSolution(Map<String, StockKeepingUnit> inventory){
        this.inventory = inventory;
    }

    public Integer checklite(String skus) {
        if (MapUtils.isEmpty(this.inventory)) return -1;;

        //Step 1 - parse SKUs into occurrence Map
        Map<String, Integer> basket = parseBasket(skus);
        if(MapUtils.isEmpty(basket)) {
            return -1;
        }
        //Step 2 - calculate cost


        return 0;
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
            if
        }

        return 0;
    }

}


