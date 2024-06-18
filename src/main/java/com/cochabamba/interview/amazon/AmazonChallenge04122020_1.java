package com.cochabamba.interview.amazon;

import java.util.*;

/**
 * @author ariel.alcocer
 */
public class AmazonChallenge04122020_1 {
    public static void main(String[] args) {
        AmazonChallenge04122020_1 test1 = new AmazonChallenge04122020_1();
        ArrayList<String> result1 = test1.popularNFeatures(5, 2,
                Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell"),
                3,
                Arrays.asList("Best services provided by anacell",
                        "betacellular has great services",
                        "anacell provides much better services than all other")
                );
        System.out.println(result1);

        AmazonChallenge04122020_1 test2 = new AmazonChallenge04122020_1();
        ArrayList<String> result2 = test2.popularNFeatures(5, 2,
                Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell"),
                5,
                Arrays.asList("I love anacell Best services provided by anacell in the town",
                        "betacellularhas great services",
                        "deltacellular provides much better services than betacellular",
                        "cetracular is worse than eurocell",
                        "betacellular is better than deltacellular")
                );
        System.out.println(result2);
    }

    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        ArrayList<String> rankingOfTopFeatures = new ArrayList<>(topFeatures);
        Map<String, Integer> rankingMap = new HashMap<>();

        //Solution sent
        possibleFeatures.stream().forEach(
                pf -> rankingMap.put(pf,(int)featureRequests.stream()
                        .filter(s -> s.toLowerCase().contains(pf.toLowerCase()))
                        .count())
        );

//        for (String pf:possibleFeatures )   {
//            rankingMap.put(pf,(int)featureRequests.stream()
//                    .filter(s -> s.toLowerCase().contains(pf.toLowerCase()))
//                    .count());
//        }

//        for (String pf:possibleFeatures )   {
//            for(String fr:featureRequests)  {
//                if(fr.toLowerCase().contains(pf.toLowerCase())) {
//                    if(rankingMap.get(pf)!=null)
//                        rankingMap.put(pf, rankingMap.get(pf)+1);
//                    else
//                        rankingMap.put(pf, 1);
//                }
//            }
//        }
        System.out.println(rankingMap);
        List<Map.Entry<String, Integer> > tmpList =
                new LinkedList<Map.Entry<String, Integer> >(rankingMap.entrySet());
        Collections.sort(tmpList, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        System.out.println(tmpList);
        if(topFeatures>numFeatures)
            topFeatures=numFeatures;
        for(int i=0;i<topFeatures;i++)  {
            rankingOfTopFeatures.add(i, tmpList.get(i).getKey());
        }
        return rankingOfTopFeatures;
    }
}
