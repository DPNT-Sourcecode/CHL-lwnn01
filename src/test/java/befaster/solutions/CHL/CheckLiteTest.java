package befaster.solutions.CHL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class CheckLiteTest {
    private CheckliteSolution checkliteSolution;
    private String sku;
    private Integer result;

    @Before
    public void setUp() {
        //Populate Inventory
        StockKeepingUnit skuA = new StockKeepingUnit("A", 50,  new SpecialOffer(3, 130));
        StockKeepingUnit skuB = new StockKeepingUnit("B", 30,  new SpecialOffer(2, 45));
        StockKeepingUnit skuC = new StockKeepingUnit("C", 20,  null);
        StockKeepingUnit skuD = new StockKeepingUnit("D", 15,  null);

        Map<String, StockKeepingUnit> inventory = new HashMap<>();
        inventory.put(skuA.getId(), skuA);
        inventory.put(skuB.getId(), skuB);
        inventory.put(skuC.getId(), skuC);
        inventory.put(skuD.getId(), skuD);
        checkliteSolution = new CheckliteSolution(inventory);
    }

    public CheckLiteTest(String sku, Integer result) {
        this.sku = sku;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object [][] {
                                                {"", 0},
                                                {"a",-1},
                                              //  {"aA",50}, //hmm - let's try this. This invalidates the
                                                {"aA",-1}, //It should "Fail-Hard"
                                                {"-", -1},
                                                { "AAA" , 130},
                                                { "AA" , 100},
                                                {"ABC", 100},
                                                {"ABCDCBAABCABBAAA",505}
                                             });

    }


    @Test
    public void getCost(){
        assertThat(checkliteSolution.checklite(sku), equalTo(result));
    }
}
