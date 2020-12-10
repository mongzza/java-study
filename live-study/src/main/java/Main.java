import dashboard.DashBoard;
import dashboard.IssueParticipants;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class Main {
	private static final String PATH = "live-study/src/main/resources/properties/accounts.properties";
	private static final String REPOSITORY = "mongzza/java-study";

	public static void main(String[] args) {
		try {
			GitHub gitHub = GitHubBuilder.fromPropertyFile(PATH).build();
			GHRepository repository = gitHub.getRepository(REPOSITORY);

			IssueParticipants participants = IssueParticipants.of(repository);
			DashBoard dashBoard = new DashBoard(participants);

			System.out.println(dashBoard.toString());

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
