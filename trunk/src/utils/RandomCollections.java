package utils;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class RandomCollections<T>
{
	/**
	 * Obtains a list sublist with random elements.
	 * @param list -- List from which get the sublist.
	 * @param elementCount -- Number of random elements to get.
	 * @return The sublist.
	 * @exception NullPointerException -- if list or elementCount is null.
	 * @exception IllegalArgumentException -- if list size if less than elementCount.
	 */
	public List<T> getRandomSublist(List<T> list, Integer elementCount)
	{
		if (list == null) throw new NullPointerException("'list' can not be null");
		if (elementCount == null) throw new NullPointerException("'elementCount' can not be null");
		if (list.size() < elementCount) throw new IllegalArgumentException("'list' has less elements than 'elementCount'");
		
		List<T> listCopy = new LinkedList<T>(list);
		List<T> sublist = new ArrayList<T>(elementCount);	
		
		for (int i = 0; i < elementCount; i++)
		{
			Random numberGenerator = new Random();
			Integer randomIndex = numberGenerator.nextInt(listCopy.size());
			T randomElement = listCopy.get(randomIndex);
			sublist.add(randomElement);
			listCopy.remove(randomElement);
		}
		
		return sublist;
	}
}