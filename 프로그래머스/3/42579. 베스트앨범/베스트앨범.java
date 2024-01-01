import java.util.*;

class Solution {

    class Song {
        public int firstPlays;
        public int firstIdx;
        public int secondPlays;
        public int secondIdx;
        public int total;
        
        Song() {
            this.firstPlays = 0;
            this.firstIdx = -1;
            this.secondPlays = 0;
            this.secondIdx = -1;
            this.total = 0;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Song> songs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if (!songs.containsKey(genre)) {
                songs.put(genre, new Song());
            }
            
            Song song = songs.get(genre);
            song.total += play;
            
            int firstPlays = song.firstPlays;
            int secondPlays = song.secondPlays;
            
            if (firstPlays != 0 && firstPlays == secondPlays) {
                continue;
            }
            
            if (firstPlays < play) {
                song.secondPlays = song.firstPlays;
                song.secondIdx = song.firstIdx;
                song.firstPlays = play;
                song.firstIdx = i;
            } else if (firstPlays == play) {
                song.secondPlays = play;
                song.secondIdx = i;
            } else if(firstPlays > 0 && song.secondPlays < play) {
                song.secondPlays = play;
                song.secondIdx = i;
            }
        }
        
        List<Song> sortedSongs = new ArrayList<>();  
        for (String s : songs.keySet()) {
            sortedSongs.add(songs.get(s));
        }
        
        Collections.sort(sortedSongs, (Song a, Song b) -> {
            if (a.total != b.total) {
                return Integer.compare(b.total, a.total);
            } else {
                return Integer.compare(a.firstIdx, b.firstIdx);
            }
        });

        for (Song s : sortedSongs) {
            if (s.firstIdx != -1) {
                answer.add(s.firstIdx);
            }
            if (s.secondIdx != -1) {
                answer.add(s.secondIdx);
            }
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}