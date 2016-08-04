package in.cakemporos.logistics.cakemporoslogistics.models;

/**
 * Created by maitr on 31-Jul-16.
 */
public class Order {
    private String _id,status,cakeType,address,pickUpDate,dropDate,weight;
    private int cost;
    private long altPhone,dropAltPhone;
    private Locality locality;
    private Customer customer;

    public long getDropAltPhone() {
        return dropAltPhone;
    }

    public void setDropAltPhone(long dropAltPhone) {
        this.dropAltPhone = dropAltPhone;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCakeType() {
        return cakeType;
    }

    public void setCakeType(String cakeType) {
        this.cakeType = cakeType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDropDate() {
        return dropDate;
    }

    public void setDropDate(String dropDate) {
        this.dropDate = dropDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public long getAltPhone() {
        return altPhone;
    }

    public void setAltPhone(long altPhone) {
        this.altPhone = altPhone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
