package befaster.solutions.CHL;

import com.sun.istack.internal.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to model special offers
 */
public class StockKeepingUnit {

    /**
     * The unique identifier for the Stock Item (e.g. A)
     */
    private final String id;

    /**
     * The cost of individual units
     */
    private final Integer cost;

    /**
        Any Special offers (if any)
     */
    @Nullable
    private SpecialOffer offers;

    public StockKeepingUnit(String id, Integer cost, SpecialOffer offers) {
        this.id = id;
        this.cost = cost;
        this.offers = offers;
    }

    public String getId() {
        return id;
    }

    public Integer getCost() {
        return cost;
    }

    public SpecialOffer getOffers() {
        return offers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof StockKeepingUnit)) return false;

        StockKeepingUnit that = (StockKeepingUnit) o;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getCost(), that.getCost())
                .append(getOffers(), that.getOffers())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "StockKeepingUnit{" +
                "id='" + id + '\'' +
                ", cost=" + cost +
                ", offers=" + offers +
                '}';
    }
}

