package com.study.date;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;

public class Test {
	public static void main(String[] args) {
		// Get the system clock as UTC offset
		final Clock clock = Clock.systemUTC();
		System.out.println(clock.instant());
		System.out.println(clock.millis());

		// Get the local date and local time
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now(clock);
		System.out.println(date);
		System.out.println(dateFromClock);

		// Get the local date and local time
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now(clock);
		System.out.println(time);
		System.out.println(timeFromClock);

		final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
		final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);

		final Duration duration = Duration.between(from, to);
		System.out.println("Duration in days: " + duration.toDays());
		System.out.println("Duration in hours: " + duration.toHours());
		
	}
}
