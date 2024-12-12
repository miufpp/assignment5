package org.miu.lesson8.prob3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<Marketing> marketingList=new ArrayList<>();
        Marketing marketing1=new Marketing("Yvonne Sarfo","1,2 Free",1119546.78);
        Marketing marketing2=new Marketing("Tony Prah","Super Care",78494433);
        Marketing marketing3=new Marketing("Worlanyo Awuku","Heroes",6719046);
        Marketing marketing4=new Marketing("Cynthia Morrison","Starter Daily",547.78);
        Marketing marketing5=new Marketing("Shirley Kyere","IDD Bundles",12.30);

        marketingList.add(marketing1);
        marketingList.add(marketing2);
        marketingList.add(marketing3);
        marketingList.add(marketing4);
        marketingList.add(marketing5);

        marketingList.remove(marketing3);

        System.out.println(marketingList.size());

        System.out.println(marketingList.get(2));

        marketingList.set(0,new Marketing("Christiana Amuzu","Enterprise HVC",46789443));
        System.out.println(marketingList);

        System.out.println("Marketing List before sorting: \n"+marketingList);
        Collections.sort(marketingList, new Comparator<Marketing>() {
            @Override
            public int compare(Marketing o1, Marketing o2) {
                int result = o1.getEmployeename().compareTo(o2.getEmployeename());
                if (result == 0) {
                    result = o1.getProductname().compareTo(o2.getProductname());
                    if (result == 0) {
                        result = Double.compare(o1.getSalesamount(), o2.getSalesamount());
                    }
                }
                return result;
            }
        });
        System.out.println("Marketing List after sorting: \n"+marketingList);

        List<Marketing> moreThan1000Result=listMoreThan1000(marketingList);
        Collections.sort(moreThan1000Result, (o1, o2) -> o1.getEmployeename().compareTo(o2.getEmployeename()));
        System.out.println("Over 1000 Marketing List: \n"+moreThan1000Result);
    }

    public static List<Marketing> listMoreThan1000(List<Marketing> list){
        if(list==null || list.isEmpty()) throw new IllegalArgumentException("List cannot be null or empty");
        List<Marketing> moreThan1000List=new ArrayList<>();
        for(Marketing item:list){
            if(item!=null){
                if(item.getSalesamount()>1000) moreThan1000List.add(item);
            }
        }
        return moreThan1000List;
    }
}
