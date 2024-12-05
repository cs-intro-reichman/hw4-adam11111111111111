public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = { "aaaaaaaaa",
                "Our product will transform the market",
                "Programming is both painful and engaging",
                "This has nothing to do with machine learning",
                "We need to leverage our core competencies",
                "Let's talk about data and algorithms",
                "Chatbots are great but must be used carefully",
                "This blockchain-based solution will disrupt the industry",
                "The team showed great Synergy in the last project",
                "Use simple words without hype and fluff",
                "Our new technology presents a significant paradigm shift",
                "Effective presentations must be clear, concise, and humble"
        };

        // Some keywords that typically signal bullshit contents in business
        // presentations
        String[] keywords = { "synergy", "disrupt", "leverage", "Paradigm",
                "transform" };
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0; i < keywords.length; i++) {
            keywords[i] = keywords[i].toLowerCase();            
        }
        for (int i = 0; i < sentences.length; i++) {
            String[] temp = breakDownToWords(sentences[i]);
            for (int j = 0; j < keywords.length; j++) {
                for (int k = 0; k < temp.length; k++) {                   
                    if (temp[k].equals(keywords[j])) {
                        System.out.println(sentences[i]);
                        k = temp.length;
                        j = keywords.length;
                        break;
                    }
                }
            }
        }
    }

    // gets a string and returns a string array of the words in the given string in
    // lowercase
    public static String[] breakDownToWords(String sentence) {
        sentence = sentence.toLowerCase();
        String[] temp = new String[sentence.length()];
        String[] ans;
        int beginIndex = 0;
        int ansLength = 0;
        int count = 0;
        while (count < sentence.length()) {
            if (sentence.charAt(count) == ' ') {
                temp[ansLength] = sentence.substring(beginIndex, count);
                beginIndex = count + 1;
                ansLength++;
            }
            count++;
        }
        if (count - beginIndex > 0) {
            temp[ansLength] = sentence.substring(beginIndex, count);
            ansLength++;
        }
        ans = new String[ansLength];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = temp[i];
        }

        return ans;
    }

}
