package com.study.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		final Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13),
				new Task(Status.CLOSED, 8));
		final long totalPointsOfOpenTasks = tasks.stream().filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints).sum();

		System.out.println("Total points: " + totalPointsOfOpenTasks);

		final double totalPoints = tasks.stream().parallel().map(task -> task.getPoints()) // or map( Task::getPoints )
				.reduce(0, Integer::sum);

		System.out.println("Total points (all tasks): " + totalPoints);

		// Group tasks by their status
		final Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
		System.out.println(map);

		// Calculate the weight of each tasks (as percent of total points)
		final Collection<String> result = tasks.stream() // Stream< String >
				.mapToInt(Task::getPoints) // IntStream
				.asLongStream() // LongStream
				.mapToDouble(points -> points / totalPoints) // DoubleStream
				.boxed() // Stream< Double >
				.mapToLong(weigth -> (long) (weigth * 100)) // LongStream
				.mapToObj(percentage -> percentage + "%") // Stream< String>
				.collect(Collectors.toList()); // List< String >

		System.out.println(result);
		
		
	}
}
