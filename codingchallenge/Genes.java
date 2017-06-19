package codingchallenge;

public class Genes {
	

    public int minMutation(String start, String end, String[] myBank)
    {
        if (start.equals(end))
            return 0;

        int mutation = 0;

        for (String fBank : myBank)
        {
            if (end.compareTo(fBank) != 0)
                mutation++;
        }

        return mutation;
    }
}
