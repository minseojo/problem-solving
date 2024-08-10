class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> wordLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                wordLogs.add(log);
            }
        }

        wordLogs.sort((l1, l2) -> {
            String[] l1Split = l1.split(" ", 2);
            String[] l2Split = l2.split(" ", 2);

            int compared = l1Split[1].compareTo(l2Split[1]);
            if (compared == 0) {
                return l1Split[0].compareTo(l2Split[0]);
            } else {
                return compared;
            }
        });

        wordLogs.addAll(digitLogs);

        return wordLogs.toArray(new String[0]);
    }
}