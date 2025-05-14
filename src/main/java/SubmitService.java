import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SubmitService {

    public Map<String, Object> submitTask(String studentId, String taskId, String submissionFile) {
        Map<String, Object> response = new HashMap<>();

        if (studentId == null || taskId == null || submissionFile == null ||
                studentId.isEmpty() || taskId.isEmpty() || submissionFile.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Missing input data");
            return response;
        }

        response.put("status", "success");
        response.put("studentId", studentId);
        response.put("taskId", taskId);
        response.put("fileName", submissionFile);
        response.put("submittedAt", LocalDateTime.now().toString());

        return response;
    }
}
