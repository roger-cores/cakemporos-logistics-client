package in.cakemporos.logistics.cakemporoslogistics.models;

import java.math.BigInteger;

/**
 * Created by maitr on 31-Jul-16.
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String address;
    private String _id;
    private long phone;
    private Locality locality;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long number) {
        this.phone = number;
    }

}
