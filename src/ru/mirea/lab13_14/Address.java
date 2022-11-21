package ru.mirea.lab13_14;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String building;
    private String part;
    private String apt;

    public Address(String address) {
        String[] s_a = address.split(",");
        country = s_a[0].trim();
        region = s_a[1].trim();
        city = s_a[2].trim();
        street = s_a[3].trim();
        building = s_a[4].trim();
        part = s_a[5].trim();
        apt = s_a[6].trim();
    }

    public String toString() {
        return (country + " " + region + " " + city + " " + street + " " + building + " " + part + " " + apt);
    }
}