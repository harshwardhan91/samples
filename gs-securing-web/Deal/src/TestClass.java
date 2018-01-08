/**
 * Created by harsh on 10/22/16.
 */
import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class TestClass {

    static HashMap<Integer,Integer> categoryRankMap = new HashMap<>();
    static class DealCat{
        int catNumber;
        int rankNumber;
        int dealNumber;

        public DealCat(int catNumber, int rankNumber, int dealNumber) {
            this.catNumber = catNumber;
            this.rankNumber = rankNumber;
            this.dealNumber = dealNumber;
        }

        public DealCat() {

        }

        public int getCatNumber() {
            return catNumber;
        }

        public void setCatNumber(int catNumber) {
            this.catNumber = catNumber;
        }

        public int getRankNumber() {
            return rankNumber;
        }

        public void setRankNumber(int rankNumber) {
            this.rankNumber = rankNumber;
        }

        public int getDealNumber() {
            return dealNumber;
        }

        public void setDealNumber(int dealNumber) {
            this.dealNumber = dealNumber;
        }
    }

    static class DealComparator implements java.util.Comparator<DealCat> {

        @Override
        public int compare(DealCat o1, DealCat o2) {
            Integer o1catrank = categoryRankMap.get(o1.catNumber);
            Integer o2catRank = categoryRankMap.get(o2.catNumber);
            if(o2.catNumber==-1 && o1.catNumber!=-1){
                return 1;
            }
            else if(o1.catNumber==-1 && o2.catNumber!=-1){
                return -1;
            }else if(o2.catNumber==-1 && o1.rankNumber==-1){
                if(o2.rankNumber==-1 && o1.rankNumber!=-1){
                    return 1;
                }
                else if(o1.rankNumber==-1 && o2.rankNumber!=-1){
                    return -1;
                }else if(o2.rankNumber==-1 && o1.rankNumber==-1){
                    return 0;
                }
            }
            if(o1catrank > o2catRank){
                return 1;
            }else if(o2catRank>o1catrank){
                return -1;
            }else{
                if(o1.rankNumber>o2.rankNumber){
                    return 1;
                }else if(o2.rankNumber > o1.rankNumber){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }

    static class DealRankComparator implements java.util.Comparator<DealCat> {

        @Override
        public int compare(DealCat o1, DealCat o2) {
            if(o1.rankNumber==-1&& o2.rankNumber!=-1){
                return -1;
            }else if(o1.rankNumber!=-1 && o2.rankNumber==-1){
                return 1;
            }
            else if(o1.rankNumber>o2.rankNumber){
                return 1;
            }else if(o2.rankNumber > o1.rankNumber){
                return -1;
            }else{
                if(o2.catNumber==-1 && o1.catNumber!=-1){
                    return 1;
                }
                else if(o1.catNumber==-1 && o2.catNumber!=-1){
                    return -1;
                }else if(o2.catNumber==-1 && o1.rankNumber==-1){
                    Integer o1catrank = categoryRankMap.get(o1.catNumber);
                    Integer o2catRank = categoryRankMap.get(o2.catNumber);
                    if(o1catrank>o2catRank){
                        return 1;
                    }else if(o2catRank>o1catrank){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            }

            return 0;
        }
    }
    public static void main(String args[] ) throws Exception {
        final int MAX_CAT = 100;
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
		*/
       // BufferedReader
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String s = line;
*/
        //Scanner
        /*Scanner s = new Scanner(System.in);
        String[] n = new String[2];
        ArrayList<String> strings = new ArrayList<>();
        int i = 0;
        while(s.hasNextLine()){
            strings.add(s.nextLine());
        }*/
        String categoryRank = new String("C1R1,C5R3, C4R2, C6R4, C3R7");
        String arr[] = categoryRank.split(",");
        ArrayList<String> categoryList = new ArrayList<>();
        for (String s : arr) {
            categoryList.add(s.trim());
        }
        String dealRank = new String("D1R3C3, D12R1C2, D3R5C1, D4C2R9, D6, D7C5R5, D8R8");
        String arr1[] =  dealRank.split(",");
        ArrayList<String> dealList = new ArrayList<>();

        for (String s : arr1) {
            dealList.add((s.trim()));
        }

        HashMap<Integer,Integer> dealRankMap = new HashMap<>();
        HashMap<Integer,Integer> dealCategoryMap = new HashMap<>();

        PriorityQueue<DealCat> priorityQueue1 = new PriorityQueue<>(new DealComparator());
        PriorityQueue<DealCat> priorityQueueDealComparator = new PriorityQueue<>(new DealRankComparator());

        for (int i = 0; i < categoryList.size(); i++) {
            String s = categoryList.get(i);
            int cIndex=-1;
            int rIndex=-1;
            if(s.indexOf('C')!=-1){
                cIndex = s.indexOf('C');
            }
            if(s.indexOf('R')!=-1){
                rIndex = s.indexOf('R');
            }
            String catName="";
            String rank="";
            if(cIndex!=-1&& rIndex!=-1) {
                catName = s.substring(cIndex + 1, rIndex);
                rank = s.substring(s.indexOf('R') + 1, s.length());
            }
            if(!catName.equalsIgnoreCase("")) {
                int catNameIndex = Integer.parseInt(catName);
                int rankIndex=-1;
                if(!rank.equalsIgnoreCase("")) {
                    rankIndex = Integer.parseInt(rank);
                }
                categoryRankMap.put(catNameIndex,rankIndex);
            }

            //System.out.println("catName = " + catName + " rank " + rank);
        }
        categoryRankMap.put(categoryList.size(),-1);

        for (int i = 0; i < dealList.size(); i++) {
            String s = dealList.get(i);
         /*   String catName = s.substring(s.indexOf('C')+1,s.indexOf('R'));
            String rank = s.substring(s.indexOf('R')+1,s.length());
            int catNameIndex = Integer.parseInt(catName);
            int rankIndex = Integer.parseInt(rank);
            categoryRankMap.put(catNameIndex,rankIndex);
            System.out.println("catName = " + catName + " rank " + rank);*/
            String catName="";
            String rank ="";
            int cIndex=-1;
            int rIndex=-1;
            int dIndex=-1;
            if(s.indexOf('D')!=-1){
                dIndex = s.indexOf('D');
            }
            if(s.indexOf('R')!=-1){
                rIndex = s.indexOf('R');
            }

            if(s.indexOf('C')!=-1){
                cIndex = s.indexOf('C');
            }
            String catName1="";
            String rank1="";
            String dealName1 = "";
            DealCat dealCat = new DealCat();
            if(cIndex==-1){
                dealCat.catNumber=-1;
            }
            if(rIndex==-1){
                dealCat.rankNumber=-1;
            }
            if(cIndex!=-1&& rIndex!=-1) {
                //catName = s.substring(cIndex + 1, rIndex);
                int catNumber = -1;

                if(cIndex>rIndex){
                    catName = s.substring(s.indexOf('C') + 1, s.length());
                    rank = s.substring(s.indexOf('R') + 1, cIndex);
                    dealName1 = s.substring(1,rIndex);
                }else{
                    catName = s.substring(s.indexOf('C') + 1, rIndex);
                    rank = s.substring(s.indexOf('R') + 1, s.length());
                    dealName1 = s.substring(1,cIndex);
                }
                int rankNumer = -1;
                if(rank!=null) {
                    rankNumer = Integer.parseInt(rank);
                }
                if(catName!=null) {
                    catNumber = Integer.parseInt(catName);
                }
               // dealName1 = s.substring(0,dIndex);
                int dealNameNumber = Integer.parseInt(dealName1);
                dealRankMap.put(dealNameNumber,rankNumer);
                dealCategoryMap.put(dealNameNumber,catNumber);
                //DealCat dealCat = new DealCat(catNumber, rankNumer, dealNameNumber);
                dealCat.dealNumber = dealNameNumber;
                priorityQueue1.add(dealCat);
                priorityQueueDealComparator.add(dealCat);
            }else{
                dealName1 = s.substring(0,dIndex);
                int dealNameNumber = Integer.parseInt(dealName1);
                //DealCat dealCat = new DealCat(-1, -1, dealNameNumber);
                dealCat.dealNumber = dealNameNumber;
                priorityQueue1.add(dealCat);
                priorityQueueDealComparator.add(dealCat);
            }


        }
        //dealRankMap.put(categoryList.size(),-1);

        System.out.println("D" + priorityQueueDealComparator.peek().dealNumber);
        System.out.println("D" + priorityQueue1.peek().dealNumber);
        String dealWithNoRank = "";
        for (int i = 0; i < priorityQueue1.size(); i++) {
            DealCat peek = priorityQueue1.peek();
            if(i==6) {
                System.out.println("D" + peek.dealNumber);
            }
            if(peek.rankNumber==-1){
                dealWithNoRank = "D" + peek.dealNumber;
            }
        }
        System.out.println(dealWithNoRank);


       /* for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }*/


        System.out.println("Hello World!");
    }
}
