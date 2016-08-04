package in.cakemporos.logistics.cakemporoslogistics.models;

/**
 * Created by maitr on 31-Jul-16.
 */
public class Baker {
    private User user;
    private Locality locality;
    private String address,_id;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
