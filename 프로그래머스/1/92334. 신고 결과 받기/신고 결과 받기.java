import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;

        // 1. 각 ID의 신고당한 횟수 저장할 맵
        Map<String, Integer> reportCount = new HashMap<>();

        // 2. 자신이 신고한 유저 리스트 저장 (중복 방지)
        Map<String, HashSet<String>> reportMap = new HashMap<>();

        // 초기화
        for (String id : id_list) {
            reportCount.put(id, 0);
            reportMap.put(id, new HashSet<>());
        }

        // 3. 신고 기록 처리
        for (String r : report) {
            String[] parts = r.split(" ");
            String from = parts[0]; // 신고자
            String to = parts[1];   // 신고당한 사람

            // 중복 신고 방지
            if (!reportMap.get(from).contains(to)) {
                reportMap.get(from).add(to);
                reportCount.put(to, reportCount.get(to) + 1);
            }
        }

        // 4. 결과 메일 수 계산
        int[] answer = new int[n];

        // id_list 순서 기준으로!!
        for (int i = 0; i < n; i++) {
            String user = id_list[i];
            int mailCount = 0;

            // 내가 신고한 모든 유저 중에서
            for (String reportedUser : reportMap.get(user)) {
                if (reportCount.get(reportedUser) >= k) {
                    mailCount++;
                }
            }
            answer[i] = mailCount;
        }

        return answer;
    }
}
