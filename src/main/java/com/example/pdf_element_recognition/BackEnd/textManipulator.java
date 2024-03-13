package com.example.pdf_element_recognition.BackEnd;

public class textManipulator {
    private String text;
    private String[] listMonthShort;
    private String[] listMonthLong;
    public textManipulator(String text){
        this.text = text;
        this.listMonthShort = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Sept",
                                                "Oct","Nov","Dec"};
        this.listMonthLong = new String[]{"January","February","March","April","May","June","July",
                                            "August","September","October","November","December"};
    }

    public String findDate(){
        //format of date is dd mm yyyy
        String date;
        String month = null;
        String year;
        String day;

        //This part is to find the month
        //to indicate whether the string is found
        int checkifgot = -1;
        //index of array
        int i=0;
        //iterate through short form of month's name to find the index
        while(checkifgot == -1 && i < listMonthShort.length) {
            checkifgot = text.indexOf(listMonthShort[i++]);
        }
        //if the index is found, set the value of month to the match string
        if(checkifgot != -1) month = listMonthShort[i];
        //reset the index
        i = 0;
        //iterate through long form of month's name to find the index
        while (checkifgot == -1 && i < listMonthLong.length){
            checkifgot = text.indexOf(listMonthLong[i++]);
        }
        //check whether string was not found
        //if not, return
        //TODO: Might need to make a new exception to handle wrong date format
        if(checkifgot ==-1) return "Date not found";
        else{
            //if there is matching string and its not from listMonthShort list, do this
            if(month != null)month=listMonthLong[checkifgot];
        }

        //this part is to obtain the day
        //if there is no space between day and month
        if(text.charAt(checkifgot - 1) != ' '){
            //check whether the thing behind month is number or not
            //TODO: might need to rework this as this will definitely break if the date is example: 21-June-2024
            // as the char '-' will count as not a digit
            //possible solution might be to find some new condition or add more condition for if statement above
            if(text.substring(checkifgot - 1, checkifgot).chars().allMatch( Character :: isDigit)){
                //check whether it's a double-digit number
                if(text.substring(checkifgot - 2, checkifgot - 1).chars().allMatch( Character :: isDigit)){
                    day = text.substring(checkifgot - 2, checkifgot);
                }
                //else it's a single digit day
                else{
                    day = text.substring(checkifgot - 1, checkifgot);
                }
            }
            //meaning date format is wrong
            //TODO: need an exception to handle this
            else{
                System.out.println("Date format is wrong");
            }
            //if there is a space before month
            //TODO: do this!!!
        }

        //process to obtain
        return date;
    }

}
