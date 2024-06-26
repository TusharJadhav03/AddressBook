package org.example.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class Contact {

    ArrayList<UserData> userdata = new ArrayList<>(); //Single Addressbook
    HashMap<String,ArrayList<UserData>> AddressBook = new HashMap<>();// Multiple Addressbook with name
    Scanner sc = new Scanner(System.in);



    public void addAddressBook(String name){
        if(AddressBook.keySet().equals(name)){
            AddressBook.put(name, userdata);
        }
        else {
            System.out.println("Already exists");
        }
    }

    public void addContacts(String name){
        if(userdata.stream().anyMatch(data->data.getFirstName().equalsIgnoreCase(name))){
            System.out.println("Name already exists");
        }
        else {
        System.out.println("Enter the First Name : ");
        String first_name = sc.next();
        System.out.println("Enter the Last Name : ");
        String last_name = sc.next();
        System.out.println("Enter the Address : ");
        String address = sc.next();
        System.out.println("Enter the City : ");
        String city = sc.next();
        System.out.println("Enter the State : ");
        String state = sc.next();
        System.out.println("Enter the Zip Code : ");
        String zipcode = sc.next();
        System.out.println("Enter the Phone Number : ");
        String phone_number = sc.next();
        System.out.println("Enter the Email Id : ");
        String email_id = sc.next();

        UserData data = new UserData(first_name, last_name, address, city, state, zipcode, phone_number, email_id);
        userdata.add(data);
        }
    }

    public void updateContact(){

        for (UserData userData2 : userdata) {
            System.out.print("Enter the First Name :");
            String username = sc.next();
            if(username.equals(userData2.getFirstName())){
                System.out.println("Enter the value : ");
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Enter the First Name : ");
                        userData2.setFirstName(sc.next());
                        break;

                    case 2:
                        System.out.println("Enter the Last Name : ");
                        userData2.setLastName(sc.next());
                        break;

                    case 3:
                        System.out.println("Enter the Address : ");
                        userData2.setAddress(sc.next());
                        break;

                    case 4:
                        System.out.println("Enter the City : ");
                        userData2.setCity(sc.next());
                        break;

                    case 5:
                        System.out.println("Enter the State : ");
                        userData2.setState(sc.next());
                        break;

                    case 6:
                        System.out.println("Enter the ZipCode : ");
                        userData2.setZipcode(sc.next());
                        break;

                    case 7:
                        System.out.println("Enter the Phone Number : ");
                        userData2.setPhonenumber(sc.next());
                        break;

                    case 8:
                        System.out.println("Enter the Email Id : ");
                        userData2.setEmailid(sc.next());
                        break;

                    case 9:
                        System.out.println("Enter the First Name : ");
                        userData2.setFirstName(sc.next());
                        System.out.println("Enter the Last Name : ");
                        userData2.setLastName(sc.next());
                        System.out.println("Enter the Address : ");
                        userData2.setAddress(sc.next());
                        System.out.println("Enter the City : ");
                        userData2.setCity(sc.next());
                        System.out.println("Enter the State : ");
                        userData2.setState(sc.next());
                        System.out.println("Enter the ZipCode : ");
                        userData2.setZipcode(sc.next());
                        System.out.println("Enter the Phone Number : ");
                        userData2.setPhonenumber(sc.next());
                        System.out.println("Enter the Email Id : ");
                        userData2.setEmailid(sc.next());
                        break;

                    default:
                        break;
                }
            }
            else{
                System.out.println("User not Found!");
            }

        }
    }

    public void deleteContact(){
        for (UserData userData2 : userdata) {
            System.out.print("Enter the UserName :");
            String username = sc.next();
            if(username.equals(userData2.getFirstName())){
                userData2.setFirstName("");
                userData2.setLastName(" ");
                userData2.setAddress(" ");
                userData2.setCity(" ");
                userData2.setState(" ");
                userData2.setZipcode(" ");
                userData2.setPhonenumber(" ");
                userData2.setEmailid(" ");
            }
            else{
                System.out.println("User not Found!");
            }

        }
    }

    public void viewContacts(){

        if(userdata.isEmpty()){
            System.out.println("Address Book is Empty!");
        }
        else{
            for (UserData data1 : userdata) {
                System.out.println(data1);
            }
        }
    }
    ArrayList<UserData> cities = new ArrayList<>();
    public void searchPersonInACity(String city){
        for(UserData data : userdata) {
            if (data.getCity().equalsIgnoreCase(city)) {
                cities = (ArrayList<UserData>) userdata.stream().filter(userData -> userData.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
                System.out.println(cities);
            } else {
                System.out.println("Person not found in that city");
            }
        }

    }
    ArrayList<UserData> states = new ArrayList<>();
    public void searchPersonInAState(String state) {
        for (UserData data : userdata) {
            if (data.getState().equalsIgnoreCase(state)) {
                states = (ArrayList<UserData>) userdata.stream().filter(userData -> userData.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
                System.out.println(states);
            } else {
                System.out.println("Person not found in that state");
            }
        }
    }


    public void countByCity() {
            Map<String,Long> personByCity = userdata.stream().collect(Collectors.groupingBy(UserData::getCity,Collectors.counting()));
            System.out.println(personByCity);
    }

    public void countByState() {
        Map<String,Long> personByState = userdata.stream().collect(Collectors.groupingBy(UserData::getState,Collectors.counting()));
        System.out.println(personByState);
    }

    public void sortEntriesByPersonName(){
         userdata.sort(Comparator.comparing(UserData::getFirstName));
         userdata.forEach(System.out::println);
    }
    public void sortEntriesByCity(){
        userdata.sort(Comparator.comparing(UserData::getCity));
        userdata.forEach(System.out::println);
    }
    public void sortEntriesByState(){
        userdata.sort(Comparator.comparing(UserData::getState));
        userdata.forEach(System.out::println);
    }
    public void sortEntriesByZip(){
        userdata.sort(Comparator.comparing(UserData::getZipcode));
        userdata.forEach(System.out::println);
    }


    public void menuOption(Contact contact){
        while (true){
            System.out.println(" 1.Add Contact " +
                    " 2.Update Contact" +
                    " 3.Delete Contact " +
                    " 4.View Contact  " +
                    " 5.Add AddressBook " +
                    " 6.Search Person in City " +
                    " 7.Search Person in State " +
                    " 8.Count of cities " +
                    " 9.Count of states " +
                    " 10.Sorted List by person names " +
                    " 11.Sorted List by City " +
                    " 12.Sorted List by State " +
                    " 13.Sorted List by Zip " +
                    " 0.Exit");
            System.out.println("Enter a value :");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter how many person u want to add : ");
                    int a = sc.nextInt();
                    for(int i=0;i<a;i++){
                        System.out.println("Enter the name of Person : ");
                        String name = sc.next();
                        contact.addContacts(name);
                        System.out.println("Added Successfully ");
                    }
                    break;

                case 2:
                    System.out.println(" 1.First Name \n 2.Last Name \n 3.Address \n 4.City \n 5.State \n 6.ZipCode \n 7.Phone Number \n 8.Email Id \n 9.Update All");
                    contact.updateContact();
                    System.out.println("Update Successfully ");
                    break;

                case 3:
                    contact.deleteContact();
                    System.out.println("Delete Successfully ");
                    break;

                case 4:
                    contact.viewContacts();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Enter the name of AddressBook");
                    String name = sc.next();
                    contact.addAddressBook(name);
                    break;

                case 6:
                    System.out.println("Enter the city : ");
                    String city = sc.next();
                    contact.searchPersonInACity(city);
                    break;

                case 7:
                    System.out.println("Enter the state : ");
                    String state = sc.next();
                    contact.searchPersonInAState(state);
                    break;

                case 8:
                    System.out.println("Count of cities : ");
                    contact.countByCity();
                    break;

                case 9:
                    System.out.println("Count of states : ");
                    contact.countByState();
                    break;

                case 10:
                    System.out.println("Sorted list : ");
                    contact.sortEntriesByPersonName();
                    break;

                case 11:
                    System.out.println("Sorted List : ");
                    contact.sortEntriesByCity();
                    break;

                case 12:
                    System.out.println("Sorted List : ");
                    contact.sortEntriesByState();
                    break;

                case 13:
                    System.out.println("Sorted List : ");
                    contact.sortEntriesByZip();
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }
}