package week4.dashboard;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.*;

public class IssueParticipants {
	private final int issueCount;
	private final Set<Participant> participants;

	private IssueParticipants(List<GHIssue> issues) {
		this.issueCount = issues.size();
		this.participants = new HashSet<>();
		for (GHIssue issue : issues) {
			putAllParticipants(issue);
		}
	}

	public static IssueParticipants of(GHRepository repository) throws IOException {
		return new IssueParticipants(repository.getIssues(GHIssueState.ALL));
	}

	private void putAllParticipants(GHIssue issue) {
		try {
			for (GHIssueComment comment : issue.getComments()) {
				Participant participant = this.getUserOrDefault(
						comment.getUser().getLogin(),
						Participant.of(comment.getUser().getLogin()));
				participant.addIssueNumber(issue.getNumber());
				participants.add(participant);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Participant getUserOrDefault(String name, Participant other) {
		return participants.stream()
				.filter(participant -> participant.isUser(name))
				.findFirst()
				.orElse(other);
	}

	public int getIssueCount() {
		return issueCount;
	}

	public Set<Participant> getParticipants() {
		return Collections.unmodifiableSet(participants);
	}

}
