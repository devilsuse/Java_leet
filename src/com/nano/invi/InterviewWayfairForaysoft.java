package com.nano.invi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
input : [{Account{AccountId, AccountDetails{ AccountName, [PhoneNumbers]}]
outPut [AccountId, PhoneNumber]
{ 1 , { “Finance”, [1, 2, 3 ]}}

[ [ 1, 1 ]. [1.2]. [1,3]]

 */
public class InterviewWayfairForaysoft {

    public static void main(String[] args) {
        List<Integer> p1 = new ArrayList<>(3);
        p1.add(1);
        p1.add(2);
        p1.add(3);

        AccountDetails ad1 = new AccountDetails("Finance", p1);

        Account account = new Account(1, ad1);
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        //List<IntStream> idToPhoneArr  = mapIdToPhone(accountList);
        //System.out.println(idToPhoneArr);
        //Arrays.
    }

    private static List<OutputResponse> mapIdToPhone(List<Account> accountList){
        List<OutputResponse> idToPhoneList = new ArrayList<>();
        //List<IntStream> idToPhoneList = new ArrayList<>();
       /* accountList.stream().forEach({ a -> new OutputResponse(a){

        }

        });*/
       /* for(Account a : accountList) {
            int id = a.getAccountId();
            if (a.getAccountDetails() != null) {

                int[][] arr = new int[a.getAccountDetails().getPhoneNumbers().size()][];
                int i=0;
                for (int p : a.getAccountDetails().getPhoneNumbers()){
                    arr[i++]= new int[]{id,p};
                }
                idToPhoneList.add(arr);
                //IntStream stream = Arrays.stream(arr).flatMapToInt(l->Arrays.stream(l));
            }
        }*/
        return idToPhoneList;
    }

}

class OutputResponse {
    private int accountId;
    private int ph;
    public int getAccountId(){
        return getAccountId();
    }
}
class Account{
    private int accountId;
    private AccountDetails accountDetails;
    public Account(int accountId, AccountDetails accountDetails){
        this.accountDetails=accountDetails;
        this.accountId=accountId;
    }

    public int getAccountId(){
        return accountId;
    }
    public AccountDetails getAccountDetails(){
        return accountDetails;
    }

   // @Override

}

class AccountDetails{
    private String accountName;
    private List<Integer> phoneNumbers;
    public AccountDetails(String accountName, List<Integer> phoneNumbers){
        this.accountName=accountName;
        this.phoneNumbers = phoneNumbers;
    }

    public String getAccountName(){
        return accountName;
    }

    public List<Integer> getPhoneNumbers(){
        return phoneNumbers;
    }
}
