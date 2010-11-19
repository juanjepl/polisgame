package utils;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class RandomCollections<T>
{
	public List<T> getRandomSublist(List<T> list, Integer elementCount)
	{
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