class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0){
            return new ArrayList();
        }
        List<List<Integer>> parinam=new ArrayList();
        //i denote the number of rows
        for(int i=1;i<=numRows;i++){
            List<Integer> row=new ArrayList();
            //j denote the index which is less than i always
            for(int j=0;j<i;j++){
               if(j==0 || j==(i-1)){
                   row.add(1);
               }
               else{
                   //their are total 5 rows so index values of rows are  (1->0)(2->1)(3->2)(4->3)(5->4)
 
                   row.add(parinam.get(i-2).get(j) +  parinam.get(i-2).get(j-1));
               }
            }
            parinam.add(row);
        }
         return parinam;
}
}