import java.util.*;

class Solution {
    
    class Music {
        int id;
        String name;
        int playTime;

        Music(int id, String name, int playTime) {
            this.id = id;
            this.name = name;
            this.playTime = playTime;
        }
    }
    
    // A A#, B, C, C#, D, D#, E, F, F#, G, G#
    public String solution(String m, String[] musicinfos) {
        List<Music> result = new ArrayList<>();
        int id = 0;
    
        for (String mi : musicinfos) {
            String[] splits = mi.split(",");
            String[] startTime = splits[0].trim().split(":");
            int startH = Integer.valueOf(startTime[0]);
            int startM = Integer.valueOf(startTime[1]);
            String[] endTime = splits[1].trim().split(":");
            int endH = Integer.valueOf(endTime[0]);
            int endM = Integer.valueOf(endTime[1]);
            int playTime = endH * 60 + endM - (startH * 60 + startM);
            
            String musicName = splits[2].trim();
            String musicInfo = splits[3].trim();
            StringBuilder totalMusic = new StringBuilder();
            int time = 0;
            int oneCycleTime = 0;
            for (int i = 0; i < musicInfo.length(); i++) {
                if (musicInfo.charAt(i) == '#') continue;
                oneCycleTime++;
            }

            if (playTime >= oneCycleTime) {
                for (int i = 0; i < playTime / oneCycleTime; i++) {
                    totalMusic.append(musicInfo);
                }

                for (int i = 0, pos = 0; pos < playTime % oneCycleTime; i++) {
                    totalMusic.append(musicInfo.charAt(i));
                    if (musicInfo.charAt(i) == '#') continue;
                    pos++;
                    if (pos == playTime % oneCycleTime) {
                        if (musicInfo.charAt(i + 1) == '#') {
                            totalMusic.append(musicInfo.charAt(i + 1));
                        }
                    }
                }
            } else {
                for (int i = 0, pos = 0; pos < playTime; i++) {
                    totalMusic.append(musicInfo.charAt(i));
                    if (musicInfo.charAt(i) == '#') continue;
                    pos++;
                }
            }
System.out.println(totalMusic.toString());
            boolean ok = false;
            for (int i = 0; i <= totalMusic.toString().length() - m.length(); i++) {
                int pos = 0;
                for (int j = i; j < i + m.length(); j++) {
                    if (m.charAt(pos++) != totalMusic.toString().charAt(j)) break;
                    if (j == i + m.length() - 1) {
                       if (i == totalMusic.toString().length() - m.length()) {
                            result.add(new Music(id++, musicName, playTime));
                            ok = true;
                            break;
                       } else {
                           if (totalMusic.toString().charAt(j + 1) != '#') {
                                result.add(new Music(id++, musicName, playTime));
                                ok = true;
                                break;
                            }
                       }
                    }                
                    if (ok) break;
                }                    
                if (ok) break;
            }
        }
        
        Collections.sort(result, (i, j) -> {
            if (i.playTime == j.playTime) {
                return Integer.compare(i.id, j.id);
            }
            
            return Integer.compare(j.playTime, i.playTime);
        });
        
        if (result.isEmpty()) return "(None)";
        return result.get(0).name;
    }
}