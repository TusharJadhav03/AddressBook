package org.example.addressbook;

public class UserData {

        private String first_name;
        private String last_name;
        private String address;
        private String city;
        private String state;
        private String zipcode;
        private String phone_number;
        private String email_id;

        public UserData(String first_name,String last_name,String address,String city,String state,String zipcode,String phone_number,String email_id){

            this.first_name = first_name;
            this.last_name = last_name;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zipcode = zipcode;
            this.phone_number = phone_number;
            this.email_id = email_id;
        }

        public void setFirstName(String first_name){
            this.first_name = first_name;
        }
        public String getFirstName(){
            return first_name;
        }

        public void setLastName(String last_name){
            this.last_name = last_name;
        }
        public String getLastName(){
            return last_name;
        }

        public void setAddress(String address){
            this.address = address;
        }
        public String getAddress(){
            return address;
        }

        public void setCity(String city){
            this.city = city;
        }
        public String getCity(){
            return city;
        }

        public void setState(String state){
            this.state = state;
        }
        public String getState(){
            return state;
        }

        public void setZipcode(String zipcode){
            this.zipcode = zipcode;
        }
        public String getZipcode(){
            return zipcode;
        }

        public void setPhonenumber(String phone_number){
            this.phone_number = phone_number;
        }
        public String getPhonenumber(){
            return phone_number;
        }

        public void setEmailid(String email_id){
            this.email_id = email_id;
        }
        public String getEmailid(){
            return email_id;
        }

        @Override
        public String toString(){

            return "***===== Address Book =====***"+
                    " \n First Name : "+first_name+
                    " \n Last Name : "+last_name+
                    " \n Address : "+address+
                    " \n City : "+city+
                    " \n State : "+state+
                    " \n ZipCode : "+zipcode+
                    " \n Phone Number : "+phone_number+
                    " \n Email Id : "+email_id + "\n";
        }

    }





