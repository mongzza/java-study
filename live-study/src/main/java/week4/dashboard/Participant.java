package week4.dashboard;

import java.util.*;

public class Participant {
	private final String name;
	private final Set<Integer> participationIssueNumbers;

	private Participant(String name) {
		this.name = name;
		this.participationIssueNumbers = new HashSet<>();
	}

	public static Participant of(String name) {
		return new Participant(name);
	}

	public boolean isUser(String name) {
		return this.name.equals(name);
	}

	public void addIssueNumber(int number) {
		participationIssueNumbers.add(number);
	}

	public String getName() {
		return this.name;
	}

	public boolean containNumber(int number) {
		return participationIssueNumbers.contains(number);
	}

	public double getCommentsCount(int issueCount) {
		return (1.00 * participationIssueNumbers.size() / issueCount) * 100.00;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Participant that = (Participant) o;

		return name != null ? name.equals(that.name) : that.name == null;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}
}
