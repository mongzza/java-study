package dashboard;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class IssueParticipants {
	private final long issueCount;
	private final HashMap<String, Integer> commentCounts;

	private IssueParticipants(List<GHIssue> issues) {
		this.issueCount = issues.size();
		this.commentCounts = new HashMap<>();
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
				commentCounts.put(
						comment.getUser().getName(),
						commentCounts.getOrDefault(comment.getUser().getName(), 0) + 1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long getIssueCount() {
		return issueCount;
	}

	public HashMap<String, Double> calculateAllParticipationRate() {
		// (1.0 * 참여 개수 / issueCount) * 100.0
		HashMap<String, Double> rateMap = new HashMap<>();
		commentCounts.keySet().forEach(key -> {
			rateMap.put(key, (1.0 * commentCounts.get(key) / issueCount) * 100.0);
		});
		return rateMap;
	}
}
