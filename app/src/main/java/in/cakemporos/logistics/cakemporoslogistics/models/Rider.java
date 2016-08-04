package in.cakemporos.logistics.cakemporoslogistics.models;

/**
 * Created by maitr on 31-Jul-16.
 */
public class Rider {
    private String _id,status;
    private User user;
    private Order order1,order2;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder1() {
        return order1;
    }

    public void setOrder1(Order order1) {
        this.order1 = order1;
    }

    public Order getOrder2() {
        return order2;
    }

    public void setOrder2(Order order2) {
        this.order2 = order2;
    }
}
