class Solution {
    public int romanToInt(String s) {
        int parinam;
        Map<Character, Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        //craeting a parinam variable having a value that correspond to the last charaacter of the string 
        parinam=map.get(s.charAt(s.length()-1));
        //iterate the string from last second character and comapre with previous one 
        for(int i=s.length()-2;i>=0;i--){
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                parinam-=map.get(s.charAt(i));
            }
            else{
                parinam+=map.get(s.charAt(i));
            }
        }
        return parinam;
    }
}