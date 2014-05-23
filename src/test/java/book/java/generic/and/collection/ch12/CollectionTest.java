package book.java.generic.and.collection.ch12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

import org.junit.Before;
import org.junit.Test;

import yubo.java.generics.and.collections.CodingTask;
import yubo.java.generics.and.collections.EmptyTask;
import yubo.java.generics.and.collections.PhoneTask;
import yubo.java.generics.and.collections.Priority;
import yubo.java.generics.and.collections.PriorityTask;
import yubo.java.generics.and.collections.Task;

public class CollectionTest {

	@Before
	public void before() {

	}

	@Test
	public void test() {
		PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
		PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
		CodingTask databaseCode = new CodingTask("db");
		CodingTask interfaceCode = new CodingTask("gui");
		CodingTask logicCode = new CodingTask("logic");

		Collection<PhoneTask> phoneTasks = new ArrayList<PhoneTask>();
		Collection<CodingTask> codingTasks = new ArrayList<CodingTask>();
		Collection<Task> mondayTasks = new ArrayList<Task>();
		Collection<Task> tuesdayTasks = new ArrayList<Task>();

		Collections.addAll(phoneTasks, mikePhone, paulPhone);
		Collections.addAll(codingTasks, databaseCode, interfaceCode, logicCode);
		Collections.addAll(mondayTasks, logicCode, mikePhone);
		Collections
				.addAll(tuesdayTasks, databaseCode, interfaceCode, paulPhone);
		assertEquals(2, phoneTasks.size());
		assertEquals(3, codingTasks.size());
		assertEquals(2, mondayTasks.size());
		assertEquals(3, tuesdayTasks.size());

		assertEquals("[phone Mike, phone Paul]", phoneTasks.toString());

		Set<Task> natruallyOrderedTasks = new TreeSet<Task>(mondayTasks);
		natruallyOrderedTasks.addAll(tuesdayTasks);
		assertEquals("[code db, code gui, code logic, phone Mike, phone Paul]",
				natruallyOrderedTasks.toString());
	}

	@Test
	public void testSortedSet() {
		PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
		PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
		CodingTask databaseCode = new CodingTask("db");
		CodingTask interfaceCode = new CodingTask("gui");
		CodingTask logicCode = new CodingTask("logic");
		NavigableSet<PriorityTask> priorityTasks = new TreeSet<PriorityTask>();
		priorityTasks.add(new PriorityTask(mikePhone, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(paulPhone, Priority.HIGH));
		priorityTasks.add(new PriorityTask(databaseCode, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(interfaceCode, Priority.LOW));

		assertEquals(
				"[phone Paul: HIGH, code db: MEDIUM, phone Mike: MEDIUM, code gui: LOW]",
				priorityTasks.toString());

		assertNull(priorityTasks.comparator());

		PriorityTask firstLowPriorityTask = new PriorityTask(new EmptyTask(),
				Priority.LOW);
		SortedSet<PriorityTask> highAndMediumPriorityTasks = priorityTasks
				.headSet(firstLowPriorityTask);
		assertEquals("[phone Paul: HIGH, code db: MEDIUM, phone Mike: MEDIUM]",
				highAndMediumPriorityTasks.toString());

		PriorityTask firstMediumPriorityTask = new PriorityTask(
				new EmptyTask(), Priority.MEDIUM);
		SortedSet<PriorityTask> mediumPriorityTasks = priorityTasks.subSet(
				firstMediumPriorityTask, firstLowPriorityTask);
		assertEquals("[code db: MEDIUM, phone Mike: MEDIUM]",
				mediumPriorityTasks.toString());
	}

	@Test
	public void testConcurrentSkipListSet() {
		ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<Integer>();
		List<Integer> iList = Arrays.asList(1, 2, 4, 8, 10, 23);
		set.addAll(iList);
		assertEquals(6, set.size());
	}
}
