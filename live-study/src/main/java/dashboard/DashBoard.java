package dashboard;

import java.util.Set;

public class DashBoard {
	private static final String HEADER_PARTICIPANT = "참여자";
	private static final String HEADER_WEEK = "주차";
	private static final String HEADER_RATE = "참여율";

	private static final String TABLE_LINE = "|";
	private static final String TABLE_SEPARATE_LINE = "|---";

	private static final String CHECKBOX = ":heavy_check_mark:";
	private static final String PERCENTAGE = "%";
	private static final String DECIMAL_POINT = "%.2f";

	private final StringBuilder board;

	public DashBoard(IssueParticipants participants) {
		board = new StringBuilder();

		int issueCount = participants.getIssueCount();
		drawHeader(issueCount);
		drawBody(issueCount, participants.getParticipants());
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

	private void drawBody(int issueCount, Set<Participant> participants) {
		participants.forEach(participant -> {
			board.append(TABLE_LINE)
					.append(participant.getName())
					.append(TABLE_LINE);
			for (int i = 1; i <= issueCount; i++) {
				if (participant.containNumber(i)) {
					board.append(CHECKBOX);
				}
				board.append(TABLE_LINE);
			}
			board.append(String.format(DECIMAL_POINT, participant.getCommentsCount(issueCount)))
					.append(PERCENTAGE)
					.append(TABLE_LINE)
					.append(System.lineSeparator());
		});
	}

	@Override
	public String toString() {
		return board.toString();
	}
}
