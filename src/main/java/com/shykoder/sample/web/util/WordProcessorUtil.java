package com.shykoder.sample.web.util;

import java.util.*;

/*
 * @auther shykoder
 * @created 3/15/20
 */
public class WordProcessorUtil {

    public static WordProcessorUtil getInstance() {
        return WordProcInstance.instance;
    }

    public boolean checkIfPyramidWord(String word) {
        if(word == null || word.isEmpty()) {
           throw new IllegalArgumentException("Invalid word input");
        }
        Map<Character, Integer> wordFreq = new HashMap<>();
        for(int i=0; i<word.length(); i++) {
            wordFreq.put(word.charAt(i),wordFreq.getOrDefault(word.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> chlist = new ArrayList<>(wordFreq.entrySet());
        Collections.sort(chlist, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        boolean isPyramid = true;
       for(int i=0; i<chlist.size();i++) {
            if(chlist.get(i).getValue() != i+1){
                isPyramid = false;
                break;
            }
       }
        return isPyramid;
    }

    private static class WordProcInstance {
        private static final WordProcessorUtil instance = new WordProcessorUtil();
    }
    private WordProcessorUtil() {
    }
}
