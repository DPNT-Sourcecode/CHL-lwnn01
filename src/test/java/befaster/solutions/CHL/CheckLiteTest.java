package befaster.solutions.CHL;

import org.junit.Before;

import java.util.HashMap;
import java.util.Map;


public class CheckLiteTest {
    private CheckliteSolution checkliteSolution;

    @Before
    public void setUp() {
        //Populate Inventory
        StockKeepingUnit skuA = new StockKeepingUnit("A", 50,  new SpecialOffer(3, 130));
        StockKeepingUnit skuB = new StockKeepingUnit("B", 30,  new SpecialOffer(2, 45));
        StockKeepingUnit skuC = new StockKeepingUnit("A", 50,  null);
        StockKeepingUnit skuD = new StockKeepingUnit("A", 50,  null);

        Map<String, StockKeepingUnit> inventory = new HashMap<>();
        inventory.put(skuA.getId(), skuA);
        inventory.put(skuB.getId(), skuB);
        inventory.put(skuC.getId(), skuC);
        inventory.put(skuD.getId(), skuD);
        checkliteSolution = new CheckliteSolution(inventory);
    }

}
