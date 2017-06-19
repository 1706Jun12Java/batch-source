import java.util.LinkedList;
import java.util.Queue;

public class MyAnswer {

	
		 public int main(String start, String end, String[] arg) {

		        int count = 0;

				

				if(start.length() != end.length()) return -1;

				

				Queue<String> list = new LinkedList<String>();		

				list.add(start);
				while(!list.isEmpty()){
					
					String tmp = list.poll();

					if(tmp.equals(end)) return count;

					
				}
		

	}

}

