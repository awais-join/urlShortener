package com.application.urlShortener.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class IDBaseConverter {
	public static final IDBaseConverter INSTANCE = new IDBaseConverter();

	private IDBaseConverter() {
	    charToIndexMapInitialize();
	    indexToCharTableInitialize();
	}

	private static HashMap<Character, Integer> charToIndexMap;
	private static List<Character> indexToCharMap;

	private void charToIndexMapInitialize() {
	    charToIndexMap = new HashMap<>();
	    for (int i = 0; i < 26; ++i) {
	        char c = 'a';
	        c += i;	
	        charToIndexMap.put(c, i);
	    }
	    for (int i = 26; i < 52; ++i) {
	        char c = 'A';
	        c += (i-26);
	        charToIndexMap.put(c, i);
	    }
	    for (int i = 52; i < 62; ++i) {
	        char c = '0';
	        c += (i - 52);
	        charToIndexMap.put(c, i);
	    }
	}
	
	private void indexToCharTableInitialize() {
	    indexToCharMap = new ArrayList<>();
	    for (int i = 0; i < 26; ++i) {
	        char c = 'a';
	        c += i;
	        indexToCharMap.add(c);
	    }
	    for (int i = 26; i < 52; ++i) {
	        char c = 'A';
	        c += (i-26);
	        indexToCharMap.add(c);
	    }
	    for (int i = 52; i < 62; ++i) {
	        char c = '0';
	        c += (i - 52);
	        indexToCharMap.add(c);
	    }
	}
	
	public String createUniqueID(Long id) {
	    List<Integer> base62ID = convertBase10ToBase62ID(id);
	    StringBuilder uniqueURLID = new StringBuilder();
	    for (int digit: base62ID) {
	        uniqueURLID.append(indexToCharMap.get(digit));
	    }
	    return uniqueURLID.toString();
	}
	
	private List<Integer> convertBase10ToBase62ID(Long id) {
	    List<Integer> digits = new LinkedList<>();
        int remainder = (int)(id % 62);
        ((LinkedList<Integer>) digits).addFirst(remainder);
        id /= 62;
	    return digits;
	}
	
	public Long getDictionaryKeyFromUniqueID(String uniqueID) {
	    List<Character> base62Number = new ArrayList<>();
	    for (int i = 0; i < uniqueID.length(); ++i) {
	        base62Number.add(uniqueID.charAt(i));
	    }
	    Long dictionaryKey = convertBase62ToBase10ID(base62Number);
	    return dictionaryKey;
	}

	private Long convertBase62ToBase10ID(List<Character> ids) {
	    long id = 0L;
	    int exp = ids.size() - 1;
	    for (int i = 0; i < ids.size(); ++i, --exp) {
	        int base10 = charToIndexMap.get(ids.get(i));
	        id += (base10 * Math.pow(62.0, exp));
	    }
	    return id;
	}
}
