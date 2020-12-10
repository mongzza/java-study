package dashboard;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.Map;

public class DashBoard {
	private static final String HEADER_PARTICIPANT = "참여자";
	private static final String HEADER_WEEK = "주차";
	private static final String HEADER_RATE = "참여율";
	private static final String TABLE_LINE = "|";
	private static final String TABLE_SEPARATE_LINE = "|---";
	private final StringBuilder board;

	public DashBoard(IssueParticipants participants) {
		board = new StringBuilder();

		long issueCount = participants.getIssueCount();
		drawHeader(issueCount);
		drawBody(issueCount, participants.calculateAllParticipationRate());
	}

	private void drawHeader(long issueCount) {
		board.append(TABLE_LINE)
				.append(HEADER_PARTICIPANT)
				.append(TABLE_LINE);
		for (int i = 1; i <= issueCount; i++) {
			board.append(i)
					.append(HEADER_WEEK)
					.append(TABLE_LINE);
		}
		board.append(HEADER_RATE)
				.append(TABLE_LINE)
				.append(System.lineSeparator());

		for (int i = 0; i < issueCount + 2; i++) {
			board.append(TABLE_SEPARATE_LINE);
		}
		board.append(TABLE_LINE)
				.append(System.lineSeparator());
	}

	private void drawBody(long issueCount, Map<String, Double> rate) {
		rate.keySet().forEach(key -> {

		});
	}

	@Override
	public String toString() {
		return board.toString();
	}
}
