class TopVotedCandidate {
    int[] persons;
    int[] times;
    HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int max = 0;
        int result = 0;

        for (int i = 0; i < persons.length; i++) {
            if (!map.containsKey(persons[i])) {
                map.put(persons[i], 0);
            }

            map.put(persons[i], map.get(persons[i]) + 1);

            if (map.get(persons[i]) >= max) {
                max = map.get(persons[i]);
                result = persons[i];
            }

            tmp.put(times[i], result);
        }

    }

    public int q(int t) {
        int i = 0;
        int index = Arrays.binarySearch(times, t);
        if (index >= 0) {
            return tmp.get(times[index]);
        } else {
            int correctIndex = -(index + 1);
            return tmp.get(times[correctIndex - 1]);
        }
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
