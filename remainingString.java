class Solution {
    public String printString(String s, char ch, int count) {
        // code here - 17/07/2024 @ 11:38pm.
        
        //Initialise the variable to store len of string ,
        // trace of count , iterator , pos of char
          int sl = s.length() , cnt = 0 , i , strpos;
          String str = "";
          strpos = s.indexOf(ch);
          
        //return "" char is not present or at last index
        if((strpos==-1 || strpos==sl-1)){
            return str;
        }   
        
        //loop until the the third occurence of char is found ,
        // add the remaining substring to the initialised empty string and break.
        for(i = 0; i < sl ; i++){
            if(s.charAt(i)==ch){
                cnt++;
            }
            if(cnt==count){
            str += s.substring(i+1);

                break;
            }
        }
        
        //finally return the substring
        return str;
    }
}
