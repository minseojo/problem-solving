class Solution {
    static class IPO implements Comparable<IPO> {
        int capital;
        int profits;

        IPO(int profits, int capital) {
            this.profits = profits;
            this.capital = capital;
        }

        @Override
        public int compareTo(IPO ipo) {
            if(this.capital == ipo.capital) return this.profits-ipo.profits;
            else return this.capital-ipo.capital;
        }

        @Override
        public String toString() {
            return profits + " " + capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<IPO> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            IPO ipo = new IPO(profits[i], capital[i]);
            list.add(ipo);
        }
        
        Collections.sort(list, (IPO o1, IPO o2) -> o1.capital-o2.capital);

        int j=0;
        for(int i=0; i<k; i++) {
            while(j<n && list.get(j).capital <= w) {
                pq.offer(list.get(j).profits);
                j++;
            }
            if(pq.isEmpty()) break;
            w += pq.poll();
        }
        return w;
    }
}

/*
시간초과 코드 (이분탐색)
class Solution {
    static class IPO implements Comparable<IPO> {
        int index;
        int capital;
        int profits;
        IPO(int index, int profits, int capital) {
            this.index = index;
            this.profits = profits;
            this.capital = capital;
        }
        @Override
        public int compareTo(IPO ipo) {
            if(this.capital == ipo.capital) return this.profits-ipo.profits;
            else return this.capital-ipo.capital;
        }
        @Override
        public String toString() {
            return profits + " " + capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Queue<IPO> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            pq.add(new IPO(i, profits[i], capital[i]));
        }
        List<IPO> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            IPO ipo = pq.poll();
            list.add(ipo);
        }
        for(IPO i : list) {
            System.out.println(i.profits + " " + i.capital);
        }
        for(int i=0; i<k; i++) {
            IPO ipo = capitalBinarySearch(w, list);
            if(ipo == null) break;
            w += ipo.profits;
            list.remove(ipo);            
        }
        
        return w;
    }
    public IPO capitalBinarySearch(int w, List<IPO> list) {
        IPO result = null;
        int l=0, r=list.size()-1, m=-1;
        // capital순으로 정렬 후
        // w보다 낮은 capital범위 찾기
        while(l<=r) {
            m = l + (r-l)/2;
            IPO ipo = list.get(m);
            if(ipo.capital <= w) {
                result = ipo;
                l = m+1;
            }
            else r = m-1;
        }
        if(r==-1) return null;
        if(r==0) return result;
        else {
            List<IPO> possibleCapitalList = new ArrayList<>();
            for(int i=0; i<=r; i++) {
                IPO ipo = list.get(i);
                possibleCapitalList.add(ipo);
            }
            // 가능한 capital리스트에서 가장 높은 profits 찾기
            Collections.sort(possibleCapitalList, new Comparator<IPO>() {
                @Override
                public int compare(IPO o1, IPO o2) {
                    return o1.profits-o2.profits;
                }
            });
            result = possibleCapitalList.get(r);
            return result;
        }
    }
}
*/