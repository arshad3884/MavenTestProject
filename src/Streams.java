import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		streamCollect();
		
	}
	public static void streamFilter() 
	{
		ArrayList <String> names = new ArrayList<String>();
		names.add("Ali");
		names.add("Hassan");
		names.add("Akbar");
		names.add("Raza");
		names.add("Alyan");
		names.add("Arshad");
		
		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		//Create stream with stream package
		long d = Stream.of("Ali","Hassan","Akbar","Raza","Alyan","Arshad").filter(s->
		{
			s.startsWith("A"); //user {} if more then one condition statements
			return true;
		}).count();
		System.out.println(d);
		//To print all names of Arraylist
		names.stream().forEach(s->System.out.println(s));
		//Print all names of Arraylist greater than 4 characters
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		//for printing first two result with length greater than 4
		names.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));
		}
	public static void streamMap()
	{
		//Creating an ArrayList from Arrays using .asList
		List<String> names = Arrays.asList("Ali","Hassan","Akbar","Raza","Alyan","Arshad");
		
		//Print names which have last letter is "n" in UpperCase (Mapping is use)
		names.stream().filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Print names which first last letter is "a" in UpperCase and in sorted order (Mapping is use)
		names.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		//2nd Array List
		List<String> student = Arrays.asList("Ranveer","Ram", "Tarun", "Bhopal");
		
		//Concatenate two arrays in a single stream
		Stream<String>  newStream = Stream.concat(names.stream(), student.stream());
		//newStream.forEach(s->System.out.println(s));
		//To check that a particular string is present in the arraylist
		boolean flag =	newStream.anyMatch(s->s.equalsIgnoreCase("Raza"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	public static void streamCollect()
	{
		//Converting the stream back to arraylist
		List <String> ls = Stream.of("Ali","Hassan","Akbar","Raza","Alyan","Arshad").sorted()
		.filter(s->s.endsWith("n")).map(s->s.toUpperCase()).collect(Collectors.toList());
		//print first item of the array
		System.out.println(ls.get(0));
		
		//Example
		List<Integer> numbers=  Arrays.asList(9,2,2,5,6,9,7,4);
		//print unique numbers and sort the array
		List<Integer> uniqueNumbers = numbers.stream().distinct().sorted().collect(Collectors.toList());;
		System.out.println(uniqueNumbers);
	}
	}


