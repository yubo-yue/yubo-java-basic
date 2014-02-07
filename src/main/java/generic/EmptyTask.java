package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EmptyTask extends Task {

	public EmptyTask() {
	}

	public String toString() {
		return "";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		Collections.addAll(tuesdayTasks, databaseCode, interfaceCode, paulPhone);

		System.out.println(tuesdayTasks.toString());
		//Collection<Task> tuesdayNonphoneTasks = new ArrayList<Task>(tuesdayTasks);
		//tuesdayNonphoneTasks.removeAll(phoneTasks);
		//System.out.println(tuesdayNonphoneTasks.toString());
		
		for (Task t : tuesdayTasks)
		{
			if (t instanceof PhoneTask)
				tuesdayTasks.remove(t);
		}
	}

}
