package com.nano.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NestedForLoopReplace {

    public static void main(String[] args) {
        Address a1 = new Address(1, "primary");
        Address a2 = new Address(2, "secondary");
        Address a3 = new Address(3, "primary");
        List<Address> list1 = List.of(a1, a2);
        List<Address> list2 = List.of(a2, a3);
        List<Address> list3 = List.of(a2, a3);

        Location l1 = new Location(1, list1, null, null);
        Location l2 = new Location(2, list2, null, null);
        Location l3 = new Location(3, list3, null, null);

        List<Location> locations = List.of(l1, l2, l3);
        System.out.println(extractLocation(locations));
        System.out.println("==========================================");
        System.out.println(extractLocationStream(locations));
    }

    private static List<Location> extractLocation(List<Location> locations){
        List<Location> locationList = new ArrayList<>();
        for(Location l : locations){
            if(l!=null){
                final Location location = Location.builder()
                        .id(l.getId())
                        .build();
                for(Address address: l.getAddresses()){
                    if(address.getType().equals("primary")){
                        location.setPrimaryAddress(address);
                    }
                    else{
                        location.setBillingAddress(address);
                    }
                }
                locationList.add(location);
            }
        }
        return locationList;
    }

    private static List<Location> extractLocationStream(List<Location> locations){
        return locations.stream()
                .filter(location -> location!=null)
                .map(location ->
                {
                    Location l = Location.builder()
                        .id(location.getId()).build();
                   /* Map<String, Address> map = location.getAddresses()
                            .stream()
                            .collect(Collectors.toMap(Address::getType, address->address));*/
                    for(Address a : location.getAddresses()) {
                        if(a.getType().equals("primary"))
                            l.setPrimaryAddress(a);
                        else
                            l.setBillingAddress(a);
                    }
                    return l;
                })
                .collect(Collectors.toList());
    }
}

@Data
@AllArgsConstructor
class Address{
    private int id;
    private String type;
}

@Data
@AllArgsConstructor
@Builder
class Location{
    private int id;
    private List<Address> addresses;
    private Address primaryAddress;
    private Address billingAddress;

}